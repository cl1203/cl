package com.cl.util;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;


/**
 * @ClassName ExcelUtils
 * @Description excel导出工具类（目前只适用无合并单元格的情况）
 * @Author 陈龙
 * @Date 2019/6/25 16:13
 * @Version 1.0
 **/
public class ExcelUtils {

    /**
     * <p>
     * Description: 填充excel内容
     * </p>
     *
     * @param <T>
     *            实体类型
     * @param data
     *            数据
     * @param sheet
     *            sheet页
     * @param style
     *            内容样式
     * @param headerCodes
     *            表头内容代码（确保实体属性和列名一一对应）
     */
    public static <T> void createContentRow(Collection<T> data, Sheet sheet, CellStyle style, String[] headerCodes) {
        Iterator<T> iterator = data.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            index++;
            Row r = sheet.createRow(index);
            r.setHeight((short) (200 * 2.5));
            T t = iterator.next();
            Class<? extends Object> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < headerCodes.length; i++) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    if (headerCodes[i].equals(fieldName)) {
                        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                        // 处理第二个字母大写的属性并且属性名不为一个字母
                        if (fieldName.length() != 1) {
                            char s = fieldName.substring(1, 2).toCharArray()[0];
                            if (s >= 'A' && s <= 'Z') {
                                getMethodName = "get" + fieldName;
                            }
                        }

                        Cell cell = r.createCell(i);
                        cell.setCellStyle(style);
                        try {
                            Method method = clazz.getDeclaredMethod(getMethodName, new Class[] {});
                            Object value = method.invoke(t, new Object[] {});
                            if (value instanceof Date) {
                                Date d = (Date) value;
                                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                cell.setCellValue(sf.format(d));
                            } else if (value instanceof Boolean) {
                                Boolean v = (Boolean) value;
                                if (v) {
                                    cell.setCellValue("是");
                                } else {
                                    cell.setCellValue("否");
                                }
                            } else if (value instanceof BigDecimal) {
                                BigDecimal v = (BigDecimal) value;
                                cell.setCellValue(v.longValue());
                            } else if (null != value) {
                                cell.setCellValue(value.toString());
                            } else {
                                cell.setCellValue("");
                            }
                            break;

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                            return;
                        } catch (SecurityException e) {
                            e.printStackTrace();
                            return;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return;
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                            return;
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            }

        }
    }

    /**
     * <p>
     * Description: 创建表头
     * </p>
     *
     * @param headers
     *            表头内容 格式：中文名(代码)
     * @param sheet
     *            sheet页
     * @param style
     *            表头样式
     * @param headerCodes
     *            表头内容字段代码（确保实体属性和列名一一对应）
     */
    public static void createHeadRow(String[] headers, Sheet sheet, CellStyle style, String[] headerCodes) {
        Row row = sheet.createRow(0);
        row.setHeight((short) (200 * 5));
        for (int i = 0; i < headers.length; i++) {
            sheet.setColumnWidth(i, 300 * 18);
            int x = headers[i].lastIndexOf("(");
            int y = headers[i].lastIndexOf(")");
            String code = headers[i].substring(x + 1, y);
            String name = headers[i].substring(0, x);
            headerCodes[i] = code;
            Cell cell = row.createCell(i);
            cell.setCellValue(name);
            cell.setCellStyle(style);
        }
    }

    /**
     * <p>
     * Description: 导出
     * </p>
     *
     * @param title
     *            表头
     * @param response
     *            .
     * @param wb
     *            工作簿
     */
    public static void export(String title, HttpServletResponse response, Workbook wb) {
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        // response.setContentType("multipart/form-data");
        ServletOutputStream os = null;
        try {
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(title.getBytes("GBK"), "ISO-8859-1"));
            os = response.getOutputStream();
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            if (null != os) {
                try {
                    os.close();
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <p>
     * Description: 导出excel
     * </p>
     *
     * @param <T>
     *            实体类型
     * @param fileName
     *            导出的excel名称（默认不带扩展名时导出为.xlsx）
     * @param headers
     *            表头 格式为：表头列名(实体类中对应的属性) 注：此处为英文状态小括号
     * @param data
     *            数据
     * @param response
     *            .
     */
    public static <T> void exportExcel(String fileName, String[] headers, Collection<T> data,
                                       HttpServletResponse response) {
        Workbook wb = null;
        if (fileName.indexOf(".") < 0) {
            fileName = new StringBuffer(fileName).append(".xlsx").toString();
        }
        String suffix = fileName.substring(fileName.indexOf("."));
        if (".xls".equalsIgnoreCase(suffix)) {
            wb = new HSSFWorkbook();
        } else {
            wb = new SXSSFWorkbook(1000);
        }
        Sheet sheet = wb.createSheet(fileName.substring(0, fileName.indexOf(".")));
        // 表头样式
        CellStyle cellStyle1 = getHeadCellStyle(wb);
        // 内容样式
        CellStyle cellStyle2 = getContentCellStyle(wb);
        String[] headerCodes = new String[headers.length];
        // 表头
        createHeadRow(headers, sheet, cellStyle1, headerCodes);
        // 填充内容
        createContentRow(data, sheet, cellStyle2, headerCodes);
        // 导出
        export(fileName, response, wb);
    }

    /**
     * <p>
     * Description: 设置excel内容样式
     * </p>
     *
     * @param wb
     *            工作簿
     * @return excel内容样式
     */
    public static CellStyle getContentCellStyle(Workbook wb) {
        Font fontStyle = wb.createFont();
        fontStyle.setFontHeightInPoints((short) 12);
        CellStyle cellStyle = wb.createCellStyle();
        // cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // cellStyle.setFillForegroundColor(HSSFColor.LEMON_CHIFFON.index);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);//细边线
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); //垂直居中
        cellStyle.setWrapText(true);
        cellStyle.setFont(fontStyle);
        return cellStyle;
    }

    /**
     * <p>
     * Description: 设置表头样式
     * </p>
     *
     * @param wb
     *            工作簿
     * @return 表头样式
     */
    public static CellStyle getHeadCellStyle(Workbook wb) {
        Font fontStyle = wb.createFont();
        fontStyle.setFontName("宋体");
        fontStyle.setBold(true);
        fontStyle.setFontHeightInPoints((short) 18);
        CellStyle cellStyle = wb.createCellStyle();
        // cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        // cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFont(fontStyle);
        return cellStyle;
    }

    /**
     * <p>
     * Description: 填充excel内容  增加日期格式的输出形式
     * </p>
     *
     * @param <T>
     *            实体类型
     * @param data
     *            数据
     * @param sheet
     *            sheet页
     * @param style
     *            内容样式
     * @param headerCodes
     *            表头内容代码（确保实体属性和列名一一对应）
     * @param dateFormat 日期格式
     */
    private static <T> void createContentRow(Collection<T> data, Sheet sheet, CellStyle style, String[] headerCodes,
                                             String dateFormat) {
        Iterator<T> iterator = data.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            index++;
            Row r = sheet.createRow(index);
            r.setHeight((short) (230 * 2.8));
            T t = iterator.next();
            Class<? extends Object> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < headerCodes.length; i++) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    if (headerCodes[i].equals(fieldName)) {
                        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                        // 处理第二个字母大写的属性并且属性名不为一个字母
                        if (fieldName.length() != 1) {
                            char s = fieldName.substring(1, 2).toCharArray()[0];
                            if (s >= 'A' && s <= 'Z') {
                                getMethodName = "get" + fieldName;
                            }
                        }

                        Cell cell = r.createCell(i);
                        cell.setCellStyle(style);
                        try {
                            Method method = clazz.getDeclaredMethod(getMethodName, new Class[] {});
                            Object value = method.invoke(t, new Object[] {});
                            if (value instanceof Date) {
                                Date d = (Date) value;
                                SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
                                cell.setCellValue(sf.format(d));
                            } else if (value instanceof Boolean) {
                                Boolean v = (Boolean) value;
                                if (v) {
                                    cell.setCellValue("是");
                                } else {
                                    cell.setCellValue("否");
                                }
                            } else if (value instanceof BigDecimal) {
                                BigDecimal v = (BigDecimal) value;
                                cell.setCellValue(v.doubleValue());
                            } else if (null != value) {
                                cell.setCellValue(value.toString());
                            } else {
                                cell.setCellValue("");
                            }
                            break;

                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                            return;
                        } catch (SecurityException e) {
                            e.printStackTrace();
                            return;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return;
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                            return;
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            }

        }
    }

    /**
     * <p>
     * Description: 导出excel
     *  增加日期格式变换
     * </p>
     *
     * @param <T>
     *            实体类型
     * @param fileName
     *            导出的excel名称（默认不带扩展名时导出为.xlsx）
     * @param headers
     *            表头 格式为：表头列名(实体类中对应的属性) 注：此处为英文状态小括号
     * @param data
     *            数据
     * @param response 响应
     *
     * @param dateForamt 日期格式化
     *            .
     */
    public static <T> void exportExcel(String fileName, String[] headers, Collection<T> data,
                                       HttpServletResponse response, String dateForamt) {
        Workbook wb = null;
        if (fileName.indexOf(".") < 0) {
            fileName = new StringBuffer(fileName).append(".xlsx").toString();
        }
        String suffix = fileName.substring(fileName.indexOf("."));
        if (".xls".equalsIgnoreCase(suffix)) {
            wb = new HSSFWorkbook();
        } else {
            wb = new SXSSFWorkbook(1000);
        }
        Sheet sheet = wb.createSheet(fileName.substring(0, fileName.indexOf(".")));
        // 表头样式
        CellStyle cellStyle1 = getHeadCellStyle(wb);
        // 内容样式
        CellStyle cellStyle2 = getContentCellStyle(wb);
        String[] headerCodes = new String[headers.length];
        // 表头
        createHeadRow(headers, sheet, cellStyle1, headerCodes);
        // 填充内容
        createContentRow(data, sheet, cellStyle2, headerCodes, dateForamt);
        // 导出
        export(fileName, response, wb);
    }


}
