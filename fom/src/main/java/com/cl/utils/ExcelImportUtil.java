package com.cl.utils;

import com.cl.comm.excel.ExcelUtil;
import com.cl.comm.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ExcelImportUtil
 * @Description  Excel导入工具类
 * @Author 陈龙
 * @Date 2019/6/25 16:34
 * @Version 1.0
 **/
public class ExcelImportUtil {

    /**
     * <p>
     * Field LOGGER: 日志
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelImportUtil.class);
    /**
     * <p>
     * Description: 关闭资源
     * </p>
     *
     * @param is
     *            输入
     * @param wb
     *            工作簿
     */
    private static void closeStream(InputStream is, Workbook wb) {
        try {
            if (null != is) {
                is.close();
            }
            if (null != wb) {
                wb.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * Description: 数据存放在List集合中
     * </p>
     *
     * @param sheet
     *            表格
     * @param heads
     *            表头
     * @param clazz
     *            clazz
     * @param <T>
     *            泛型
     * @return 返回结果
     * @throws IOException
     */
    public static <T> List<T> excelToBoList(Sheet sheet, String[] heads, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        // Workbook wb = null;
        // InputStream is = null;
        // Sheet sheet = null;
        // wb = new XSSFWorkbook("C:\\Users\\Administrator\\Desktop\\TM_DOMES_DATA_AUTHORITY.xlsx");
        // sheet = wb.getSheetAt(0);
        for (int i = 1; i < sheet.getLastRowNum() - sheet.getFirstRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            if (null == row || !ExcelUtil.isRowEmpty(row)) {
                continue;
            }
            T t;
            try {
                t = clazz.newInstance();
                for (int j = 0; j < heads.length; j++) {
                    String setMethodName = "set" + heads[j].substring(0, 1).toUpperCase() + heads[j].substring(1);
                    // 处理第二个字母大写的属性并且属性名不为一个字母
                    if (heads[j].length() != 1) {
                        char s = heads[j].substring(1, 2).toCharArray()[0];
                        if (s >= 'A' && s <= 'Z') {
                            setMethodName = "set" + heads[j];
                        }
                    }
                    Method method = clazz.getMethod(setMethodName, new Class[] { String.class });
                    String result = getCellValue(sheet.getRow(i).getCell(j));
                    method.invoke(t, result);
                }
                Method setRowNumMethod = clazz.getMethod("setRowNum", int.class);
                setRowNumMethod.invoke(t, (i + 1));
                list.add(t);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
        return list;
    }

    /**
     * <p>
     * Description: 根据单元格格式获取单元格的值
     * </p>
     *
     * @param cell
     *            单元格
     * @return 单元格的值
     */
    public static String getCellValue(Cell cell) {
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                double d = cell.getNumericCellValue();
                Date date = HSSFDateUtil.getJavaDate(d);
                cellValue = sFormat.format(date);
            } else {
                cellValue = decimalFormat.format((cell.getNumericCellValue()));
            }
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            cellValue = "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            cellValue = "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            cellValue = cell.getCellFormula().toString();
        }
        return cellValue;
    }

    /* *//**
     * <p>
     * Description: 根据单元格格式获取单元格的值
     * </p>
     *
     * @param cell
     *            单元格
     * @return 单元格的值
     *//*
     * private static String getCellValue(Cell cell) {
     *
     * SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String cellValue = ""; if (cell == null) { return cellValue; } else if (cell.getCellType() ==
     * Cell.CELL_TYPE_STRING) { cell.setCellType(HSSFCell.CELL_TYPE_STRING); cellValue = cell.getStringCellValue(); } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) { //
     * cell.setCellType(HSSFCell.CELL_TYPE_STRING); if (HSSFDateUtil.isCellDateFormatted(cell)) { // cell.setCellType(HSSFCell.CELL_TYPE_STRING); double d = cell.getNumericCellValue(); Date
     * date = HSSFDateUtil.getJavaDate(d); cellValue = sFormat.format(date); } else { cellValue = String.valueOf(cell.getNumericCellValue()); } } else if (cell.getCellType() ==
     * Cell.CELL_TYPE_BLANK) { cellValue = ""; } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) { cell.setCellType(HSSFCell.CELL_TYPE_STRING); cellValue =
     * String.valueOf(cell.getBooleanCellValue()); } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) { cellValue = ""; } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
     * cell.setCellType(HSSFCell.CELL_TYPE_STRING); cellValue = cell.getCellFormula().toString(); } return cellValue; }
     */

    /**
     * <p>
     * Description: 获取表
     * </p>
     *
     * @param file
     *            文件
     * @return 返回结果
     */
    public static Sheet getSheet(MultipartFile file) {
        Workbook wb = null;
        InputStream is = null;
        try {
            is = file.getInputStream();
            // 此方法作废,不能解析不同的office版本(xlx&xlsx)
            //            wb = new XSSFWorkbook(is);

            wb = WorkbookFactory.create(is);
            Sheet sheet = wb.getSheetAt(0);
            CellStyle cellStyle = wb.createCellStyle();
            DataFormat format = wb.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("@"));
            sheet.setDefaultColumnStyle(10, cellStyle);
            return sheet;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(is, wb);
        }
        return null;
    }

    /**
     * <p>
     * Description: 校验行是否为空
     * </p >
     *
     * @param row
     *            行信息
     * @return boolean
     */
    public static boolean isRowEmpty(Row row) {
        int num = 0;
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                num++;
            }
        }
        if (num > 0) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Description: 检查上传的是否是EXCEL文件，以及EXCEL是否符合规则
     * </p>
     *
     * @param file
     *            EXCEL文件
     * @return 工作簿
     */
    public static Workbook checkExcelFile(MultipartFile file) {
        final String XLS = "xls";
        final String XLSX = "xlsx";
        // 判断文件是否存在
        if (null == file) {
            throw new BusinessException("EXCEL文件不存在");

        }
        // 获得文件名
        String fileName = file.getOriginalFilename();

        // 判断文件是否是excel文件
        if (StringUtils.isNotBlank(fileName)) {
            if (!(fileName.endsWith(XLS) || fileName.endsWith(XLSX) || fileName.endsWith(XLS.toUpperCase())
                    || fileName.endsWith(XLSX.toUpperCase()))) {
                LOGGER.info("File is not Excle");
                throw new BusinessException(fileName + "不是excel文件");
            }
        }
        long size = file.getSize();
        if (size == 0) {
            LOGGER.info("The size of excleFile is 0");
            throw new BusinessException("Excel文件有误,请按模板上传");
        }
        Workbook workbook = null;

        try {
            InputStream in = file.getInputStream();
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith(XLS) || fileName.endsWith(XLS.toUpperCase())) {
                // 2003
                workbook = new HSSFWorkbook(in);
            } else if (fileName.endsWith(XLSX) || fileName.endsWith(XLSX.toUpperCase())) {
                // 2007 及2007以上
                workbook = new XSSFWorkbook(in);
            }

        } catch (Exception exception) {
            LOGGER.error("解析EXCEL失败", exception);
        }
        if (workbook == null || workbook.getSheetAt(0) == null) {
            LOGGER.info("The excel is error");
            throw new BusinessException("Excel文件有误,工作簿不存在,请按模板上传");
        }
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        if (lastRowNum == 0) {
            LOGGER.info("The excel is error,data is null");
            throw new BusinessException("Excel文件有误,数据为空");
        }
        return workbook;
    }
    /**
     * <p>
     * Description: 校验EXCEL表头是否符合模板
     * </p>
     *
     * @param headerCh 表头数组
     */
    public static void checkExcelHead(Workbook workbook, String[] headerCh) {
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        if (row == null) {
            LOGGER.info("The excel headRow is null");
            throw new BusinessException("表头信息为空,请按模板上传");
        }
        for (int i = 0; i < headerCh.length; i++) {
            Cell cell = row.getCell(i);
            if (cell == null) {
                LOGGER.info("The excel is not template");
                throw new BusinessException("Excel文件表头信息第 " + (i + 1) + "列与模板不符合,请按模板上传");
            }
            String value = cell.getStringCellValue();
            if (!headerCh[i].equals(value)) {
                LOGGER.info("The excel is not template");
                throw new BusinessException("Excel文件表头信息第 " + (i + 1) + "列与模板不符合,请按模板上传");
            }
        }
    }
}
