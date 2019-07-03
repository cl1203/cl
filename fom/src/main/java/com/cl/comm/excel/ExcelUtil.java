package com.cl.comm.excel;

import com.cl.comm.reflection.ReflectionHelper;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ExcelUtil
 * @Description 该类实现了将一组对象转换为Excel表格，并且可以从Excel表格中读取到一组List对象中
 * 该类利用了BeanUtils框架中的反射完成 使用该类的前提，在相应的实体对象上通过ExcelReources来完成相应的注解.
 * @Author 陈龙
 * @Date 2019/7/3 15:56
 * @Version 1.0
 **/
public class ExcelUtil {
    /**
     * <p>
     * Field eu: ExcelUtil.
     * </p>
     */
    @SuppressWarnings("rawtypes")
    private static ExcelUtil eu = new ExcelUtil();

    /**
     * <p>
     * Description: ExcelUtil.
     * </p>
     */
    private ExcelUtil() {
    }

    /**
     * <p>
     * Description: getInstance.
     * </p>
     *
     * @return 返回结果
     */
    @SuppressWarnings("rawtypes")
    public static ExcelUtil getInstance() {
        return eu;
    }

    /**
     * <p>
     * Description: 空行不读取.
     * </p>
     *
     * @param row 行
     * @return 返回结果
     */
    public static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Description: getCellValue.
     * </p>
     *
     * @param cell 单元格
     * @return 返回结果
     */
    public String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }

        String result = null;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_FORMULA:
                try {
                    result = String.valueOf(cell.getNumericCellValue());
                } catch (IllegalStateException e) {
                    result = String.valueOf(cell.getRichStringCellValue());
                }
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = null;
                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 58) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double value = cell.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                    result = sdf.format(date);
                } else {
                    double value = cell.getNumericCellValue();
                    DecimalFormat format = new DecimalFormat("###0.#######");
                    result = format.format(value);
                }
                break;
            case HSSFCell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().toString();
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                result = "";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }

    /**
     * <p>
     * Description: getHeaderList.
     * </p>
     *
     * @param clz 参数
     * @param titleRow 标题行
     * @return 结果
     */
    private List<ExcelHeader> getHeaderList(Class<T> clz, Row titleRow) {
        List<ExcelHeader> headers = Lists.newArrayList();
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            Class<?> methodReturnType = method.getReturnType();
            if (methodName.startsWith("get")) {
                if (method.isAnnotationPresent(ExcelResources.class)) {
                    ExcelResources er = method.getAnnotation(ExcelResources.class);
                    int columnIndex = -1;
                    if (er.useTitle()) {
                        for (Cell titleCell : titleRow) {
                            String title = titleCell.getStringCellValue();
                            if (er.title().equalsIgnoreCase(title.trim())) {
                                columnIndex = titleCell.getColumnIndex();
                                break;
                            }
                        }

                        if (er.titleMustExist() && columnIndex == -1) {
                            throw new RuntimeException(String.format("列(%s)不存在!", er.title()));
                        }
                    } else {
                        columnIndex = er.columnIndex();
                    }

                    ExcelHeader header = new ExcelHeader(er.title(), methodName.replace("get", ""), methodReturnType,
                            er.link(), er.notNull());
                    header.setNullSkip(er.nullSkip());
                    header.setTitleColumnIndex(columnIndex);
                    headers.add(header);
                }
            }
        }

        return headers;
    }

    /**
     * <p>
     * Description: 获取合并单元格的值.
     * </p>
     *
     * @param sheet 表
     * @param row 行
     * @param column 列
     * @return 返回 结果
     */
    public String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return this.getCellValue(fCell);
                }
            }
        }

        return null;
    }

    /**
     * <p>
     * . Description: getRangesByColumnIndex.
     * </p>
     *
     * @param sheet 表
     * @param columnIndex 列
     * @return 返回结果
     */
    public List<CellRangeAddress> getRangesByColumnIndex(Sheet sheet, int columnIndex) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        List<CellRangeAddress> leaderRanges = Lists.newArrayList();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();

            if (firstColumn == columnIndex && lastColumn == columnIndex) {
                leaderRanges.add(range);
            }
        }
        return leaderRanges;
    }

    /**
     * <p>
     * Description: handlerExcel2Objs.
     * </p>
     *
     * @param wb wb
     * @param clz clz
     * @param readLine readLine
     * @param tailLine tailLine
     * @param sheetNum sheetNum
     * @return 返回结果
     */
    private List<T> handlerExcel2Objs(Workbook wb, Class<T> clz, int readLine, int tailLine, int sheetNum) {
        Sheet sheet = wb.getSheetAt(sheetNum);
        List<T> objs = null;
        try {
            Row row = sheet.getRow(readLine);
            objs = Lists.newArrayList();

            List<ExcelHeader> headers = this.getHeaderList(clz, row);
            if (headers == null || headers.size() <= 0) {
                throw new RuntimeException("要读取的Excel的格式不正确，检查是否设定了合适的行");
            }

            for (int i = readLine + 1; i <= sheet.getLastRowNum() - tailLine; i++) {
                row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                T obj = clz.newInstance();
                boolean isNeedSkip = false; // 是否需要跳过本行

                for (ExcelHeader header : headers) {
                    int columnIndex = header.getTitleColumnIndex();
                    if (columnIndex < 0) {
                        continue;
                    }
                    Cell cell = row.getCell(columnIndex);
                    String methodName = header.getMethodName();
                    String cellValueStr = this.getCellValue(cell);

                    // 为空是否跳过本行
                    if (header.isNullSkip() && StringUtils.isBlank(cellValueStr)) {
                        isNeedSkip = true;
                        break;
                    }

                    // 不能为空
                    if (header.getNotNull() && StringUtils.isEmpty(cellValueStr)) {
                        throw new RuntimeException(
                                String.format("导入失败：第%s列，第%s行数据错误!", header.getTitleColumnIndex() + 1, i + 1));
                    }

                    Class<?> returnClazz = header.getReturnClazz();
                    Object cellValue = null;
                    try {
                        cellValue = this.parseValue(returnClazz, cellValueStr);
                    } catch (Exception ex) {
                        // 格式不正确
                        throw new RuntimeException(
                                String.format("导入失败：第%s列，第%s行数据错误!", header.getTitleColumnIndex() + 1, i + 1));

                    }

                    ReflectionHelper.invokeSetter(obj, methodName, cellValue);
                }

                if (isNeedSkip) {
                    continue;
                }

                objs.add(obj);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return objs;
    }

    /**
     * <p>
     * Description: 解析值.
     * </p>
     *
     * @param returnClazz 参数
     * @param cellValueStr 参数
     * @return 返回结果
     * @throws Exception 异常
     */
    private Object parseValue(Class<?> returnClazz, String cellValueStr) throws Exception {
        if (StringUtils.isNotEmpty(cellValueStr)) {
            cellValueStr = cellValueStr.trim();
        }

        Object cellValue = null;
        if (StringUtils.isNotEmpty(cellValueStr)) {
            if (returnClazz == Double.class) {
                cellValue = Double.valueOf(cellValueStr);
            } else if (returnClazz == Integer.class) {
                cellValue = Integer.valueOf(cellValueStr);
            } else if (returnClazz == Long.class) {
                cellValue = Long.valueOf(cellValueStr);
            } else if (returnClazz == Date.class) {
                if (StringUtils.contains(cellValueStr, ".")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                    cellValue = sdf.parse(cellValueStr);
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.parse(cellValueStr);
                }
            } else if (returnClazz == BigDecimal.class) {
                cellValue = new BigDecimal(cellValueStr);
            } else {
                cellValue = cellValueStr;
            }
        }
        return cellValue;
    }

    /**
     * <p>
     * Description: 读取excel.
     * </p>
     *
     * @param file 文件
     * @return 返回结果
     */
    public Workbook readExcel(File file) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(file);
            return wb;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Excel格式不正确,无法处理!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("未找到Excel文件!");
        }
    }

    /**
     * <p>
     * Description: 从类路径读取相应的Excel文件到对象列表，标题行为0，没有尾行.
     * </p>
     *
     * @param path 路径
     * @param clz 类型
     * @param sheetNum sheet号
     * @return 对象列表
     */
    public List<T> readExcel2ObjsByClasspath(String path, Class<T> clz, int sheetNum) {
        return this.readExcel2ObjsByClasspath(path, clz, 0, 0, sheetNum);
    }

    /**
     * <p>
     * Description: 从类路径读取相应的Excel文件到对象列表.
     * </p>
     *
     * @param path 类路径下的path
     * @param clz 对象类型
     * @param readLine 开始行，注意是标题所在行
     * @param tailLine 底部有多少行，在读入对象时，会减去这些行
     * @param sheetNum sheet号
     * @return 返回结果
     */
    public List<T> readExcel2ObjsByClasspath(String path, Class<T> clz, int readLine, int tailLine, int sheetNum) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(Resources.getResource(path).openStream());
            return this.handlerExcel2Objs(wb, clz, readLine, tailLine, sheetNum);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Excel格式不正确,无法处理!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("未找到Excel文件!");
        }
    }

    /**
     * <p>
     * Description: 从文件路径读取相应的Excel文件到对象列表，标题行为0，没有尾行.
     * </p>
     *
     * @param path 路径
     * @param clz 类型
     * @param sheetNum sheet号
     * @return 对象列表
     */
    public List<T> readExcel2ObjsByPath(String path, Class<T> clz, int sheetNum) {
        return this.readExcel2ObjsByPath(path, clz, 0, 0, sheetNum);
    }

    /**
     * <p>
     * Description: 从文件路径读取相应的Excel文件到对象列表.
     * </p>
     *
     * @param path 文件路径下的path
     * @param clz 对象类型
     * @param readLine 开始行，注意是标题所在行
     * @param tailLine 底部有多少行，在读入对象时，会减去这些行
     * @param sheetNum sheet号
     * @return 返回 结果
     */
    public List<T> readExcel2ObjsByPath(String path, Class<T> clz, int readLine, int tailLine, int sheetNum) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
            return this.handlerExcel2Objs(wb, clz, readLine, tailLine, sheetNum);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Excel格式不正确,无法处理!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("未找到Excel文件!");
        }
    }

    /**
     * <p>
     * Description: 读取相应的Excel文件到对象列表.
     * </p>
     *
     * @param file 文件file
     * @param clz 对象类型
     * @param readLine 开始行，注意是标题所在行
     * @param tailLine 底部有多少行，在读入对象时， 会 减去这些行
     * @param sheetNum sheet号
     * @return 对象列表
     */
    public List<T> readExcel2ObjsFromFile(File file, Class<T> clz, int readLine, int tailLine, int sheetNum) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(file);
            return this.handlerExcel2Objs(wb, clz, readLine, tailLine, sheetNum);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Excel格式不正确,无法处理!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("未找到Excel文件!");
        }
    }

    /**
     * <p>
     * Description: readExcel2ObjsFromFile.
     * </p>
     *
     * @param file 文件
     * @param clz 对象类型
     * @param readLine 开始行，注意是标题所在行
     * @param tailLine 底部有多少行，在读入对象时，会减去这些行
     * @param sheetNum 表格数
     * @return 返回结果
     */
    public List<T> readExcel2ObjsFromFile(InputStream file, Class<T> clz, int readLine, int tailLine, int sheetNum) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(file);
            return this.handlerExcel2Objs(wb, clz, readLine, tailLine, sheetNum);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Excel格式不正确,无法处理!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("未找到Excel文件!");
        }
    }

    /**
     * <p>
     * Description: Excel第一张表.
     * </p>
     *
     * @param file 文件
     * @return 返回结果
     */
    public Sheet readExcelFirstSheet(File file) {
        Workbook wb = this.readExcel(file);
        Sheet sheet = wb.getSheetAt(0);
        return sheet;
    }

    /**
     * <p>
     * Description: excel行数.
     * </p>
     *
     * @param file 文件
     * @return 返回结果
     */
    public int readExcelRowsCount(File file) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(file);
            Sheet sheet = wb.getSheetAt(0);
            return sheet.getLastRowNum();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Excel格式不正确,无法处理!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("未找到Excel文件!");
        }
    }

}
