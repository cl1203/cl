package com.cl.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @ClassName DateUtils
 * @Description 时间工具类
 * @Author 陈龙
 * @Date 2019/6/24 15:21
 * @Version 1.0
 **/
public class DateUtils {
    /**
     * <p>Field DATEYEAR: yyyy</p>
     */
    public static final String DATEYEAR = "yyyy";
    /**
     * <p>
     * Field DATESHOWFORMAT: yyyy-MM-dd.
     * </p>
     */
    public static final String DATESHOWFORMAT = "yyyy-MM-dd";

    /**
     * <p>
     * Field TIMESHOWFORMAT: HH:mm:ss.
     * </p>
     */
    public static final String TIMESHOWFORMAT = "HH:mm:ss";

    /**
     * <p>
     * Field DATETIMESHOWFORMAT: yyyy-MM-dd HH:mm:ss.
     * </p>
     */
    public static final String DATETIMESHOWFORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * <p>Field DATETIMESHOWFORMAT3: yyyy-MM-dd HH:mm</p>
     */
    public static final String DATETIMESHOWFORMAT3 = "yyyy-MM-dd HH:mm";
    /**
     * <p>Field DATETIMESHOWFORMAT4: yyyyMMdd</p>
     */
    public static final String DATETIMESHOWFORMAT4 = "yyyyMMdd";
    /**
     * <p>
     * Field MINUTES_TEN: MINUTES_TEN.
     * </p>
     */
    public static final Long MINUTES_TEN = 600000L;

    /**
     * <p>
     * Field DATETIMESHOWFORMAT2: 时间格式（yyyy-MM-dd 00:00:00），如：2015-07-16
     * ：00:00:00.
     * </p>
     */
    public static final String DATETIMESHOWFORMAT2 = "yyyy-MM-dd 00:00:00";

    /**
     * <p>Field HOURSMINUTES: 时分格式化</p>
     */
    public static final String HOURSMINUTES = "HH:mm";

    /**
     * <p>
     * Description:给定时间往后延给定分钟.
     * </p>
     *
     * @param date 日期
     * @param minute 分钟
     * @return 计算后的日期
     * @author doumingjun
     * @create date 2012-06-27
     */
    public static Date addMinutes(Date date, int minute) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * <p>
     * Description:给定时间往后延给定秒钟.
     * </p>
     *
     * @param date 日期
     * @param second 秒钟
     * @return 计算后的日期
     * @create date 2019-04-18
     */
    public static Date addSeconds(Date date, int second) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * <p>
     * Description:检测d1 是否大于等于d2.
     * </p>
     *
     * @param pDt1 日期1
     * @param pDt2 日期2
     * @return true d1 是否大于等于d2
     */
    public static boolean checkMax(Date pDt1, Date pDt2) {
        boolean flag = false;
        if (null != pDt1) {
            if (null != pDt2) {
                String strD1s = getDateString(pDt1, "yyyyMMdd");
                String strD12s = getDateString(pDt2, "yyyyMMdd");
                if (Double.valueOf(strD1s) >= Double.valueOf(strD12s)) {
                    flag = true;
                }
            } else {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * <p>Description: 间隔月份</p>
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 间隔月份
     */
    public static int dataSubtractByMonth(Date startDate, Date endDate) {
        Calendar calTime1 = Calendar.getInstance();
        Calendar calTime2 = Calendar.getInstance();
        int monthInYear = 12;
        calTime1.setTime(startDate);
        calTime2.setTime(endDate);
        int month = calTime2.get(Calendar.MONTH) - calTime1.get(Calendar.MONTH);
        int year = calTime2.get(Calendar.YEAR) - calTime1.get(Calendar.YEAR);
        return year * monthInYear + month;
    }

    /**
     * <p>
     * Description:计算两个日之间的差.
     * </p>
     *
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @throws ParseException 解析异常
     * @return 两个日之间的差
     */
    public static int dataSubtractByMonth(String startDate, String endDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return dataSubtractByMonth(df.parse(startDate), df.parse(endDate));
    }

    /**
     * <p>
     * Description: 将日期截取为日期.
     * </p>
     *
     * @param date 日期
     * @return 截取日期
     */
    public static String dataSubtractDate(Date date) {
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
        String string = formate.format(date);
        return string;
    }

    /**
     * <p>
     * Description: 将日期截取为时间格式.
     * </p>
     *
     * @param date 日期
     * @return 时间格式
     */
    public static String dataSubtractTime(Date date) {
        SimpleDateFormat formate = new SimpleDateFormat("HH:mm");
        String string = formate.format(date);
        return string;
    }

    /**
     * <p>
     * Description:日期格式转换 DATE to DATE.
     * </p>
     *
     * @param date 日期
     * @param patten 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return 格式转换日期
     */
    public static Date dateToDate(Date date, String patten) {
        String dateStr = "";
        SimpleDateFormat formatter = new SimpleDateFormat(patten);

        if (date != null) {
            dateStr = formatter.format(date);
        }
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <p>
     * Description: 获取当前月第一天.
     * </p>
     *
     * @return 当前月第一天
     */
    public static String firstDate() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = ca.getTime();
        return getDateString(firstDate, DATESHOWFORMAT);
    }

    /**
     * <p>
     * Description:获取与指定日期相差指定 天数 的日期.
     * </p>
     *
     * @param baseDate 时间字符串，如：2008-12-03 11:00:00
     * @param dayCount 向前或向后的天数，向后为正数，向前为负数
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return String 处理后的日期字符
     */
    public static String getAfterDate(Date baseDate, int dayCount, String patternString) {
        String strBaseDate = getDateString(baseDate, DATETIMESHOWFORMAT);
        return getAfterDate(strBaseDate, dayCount, patternString);
    }

    /**
     * <p>
     * Description:获取与指定日期相差指定 天数 的日期.
     * </p>
     *
     * @param baseDate 时间字符串，如：2008-12-03 11:00:00
     * @param dayCount 向前或向后的天数，向后为正数，向前为负数
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return String 处理后的日期字符
     */
    public static String getAfterDate(String baseDate, int dayCount, String patternString) {
        int year = Integer.parseInt(baseDate.substring(0, 4));
        int month = Integer.parseInt(baseDate.substring(5, 7));
        int date = Integer.parseInt(baseDate.substring(8, 10));
        Calendar calendar = Calendar.getInstance();
        if (DATETIMESHOWFORMAT.equals(patternString)) {
            int hour = Integer.parseInt(baseDate.substring(11, 13));
            int minute = Integer.parseInt(baseDate.substring(14, 16));
            int second = Integer.parseInt(baseDate.substring(17, 19));
            calendar.set(year, month - 1, date, hour, minute, second);
        } else {
            calendar.set(year, month - 1, date);
        }
        calendar.set(year, month - 1, date);
        calendar.add(Calendar.DATE, dayCount);
        Date dateTime = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(patternString);
        String dateString = formatter.format(dateTime);
        return dateString;
    }

    /**
     * <p>
     * Description: 获取与指定日期相差指定 月数 的日期.
     * </p>
     *
     * @param baseDate 时间字符串，如：2008-12-03 11:00:00
     * @param monthCount 向前或向后的月数，向后为正数，向前为负数
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return String 处理后的日期字符
     */
    public static String getAfterMonth(Date baseDate, int monthCount, String patternString) {
        String strBaseDate = getDateString(baseDate, DATETIMESHOWFORMAT);
        return getAfterMonth(strBaseDate, monthCount, patternString);
    }

    /**
     * <p>
     * Description:获取与指定日期相差指定 月数 的日期.
     * </p>
     *
     * @param baseDate 时间字符串，如：2008-12-03 11:00:00
     * @param monthCount 向前或向后的月数，向后为正数，向前为负数
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return String 处理后的日期字符
     */
    public static String getAfterMonth(String baseDate, int monthCount, String patternString) {
        int year = Integer.parseInt(baseDate.substring(0, 4));
        int month = Integer.parseInt(baseDate.substring(5, 7));
        int date = Integer.parseInt(baseDate.substring(8, 10));
        Calendar calendar = Calendar.getInstance();
        if (DATETIMESHOWFORMAT.equals(patternString)) {
            int hour = Integer.parseInt(baseDate.substring(11, 13));
            int minute = Integer.parseInt(baseDate.substring(14, 16));
            int second = Integer.parseInt(baseDate.substring(17, 19));
            calendar.set(year, month - 1, date, hour, minute, second);
        } else {
            calendar.set(year, month - 1, date);
        }
        calendar.add(Calendar.MONTH, monthCount);
        Date dateTime = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(patternString);
        String dateString = formatter.format(dateTime);
        return dateString;
    }

    /**
     * <p>
     * Description:当前日期转换为指定月数后 的日期.
     * </p>
     *
     * @param monthCount 向前或向后的月数，向后为正数，向前为负
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return String 转换后的日期
     */
    public static String getBeforeMonth(int monthCount, String patternString) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, monthCount);
        Date dateTime = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(patternString);
        return formatter.format(dateTime);
    }

    /**
     * <p>
     * Description:计算两个日期的间隔天数.
     * </p>
     *
     * @param startDate 开始时间，如：2008-12-03 11:00:00
     * @param endDate 结束时间，如：2009-12-31 11:00:00
     * @return long 间隔天数(long)
     */
    public static long getBetweenDays(Date startDate, Date endDate) {
        if (endDate == null || startDate == null) {
            return -1;
        }
        Long days = endDate.getTime() - startDate.getTime();
        days = days / (1000 * 60 * 60 * 24);
        return days;
    }

    /**
     * <p>
     * Description:计算两个日期的间隔天数. 保留小数（四舍五入）
     * </p>
     *
     * @param startDate 开始时间，如：2008-12-03 11:00:00
     * @param endDate 结束时间，如：2009-12-31 11:00:00
     * @param scale 保留的小数点位数
     * @return BigDecimal 间隔天数(BigDecimal)
     */
    public static BigDecimal getBetweenDays(Date startDate, Date endDate, int scale) {
        if (endDate == null || startDate == null) {
            return null;
        }
        BigDecimal longTime = new BigDecimal(endDate.getTime() - startDate.getTime());
        BigDecimal oneDay = new BigDecimal(1000 * 60 * 60 * 24);
        BigDecimal days = longTime.divide(oneDay, scale, BigDecimal.ROUND_HALF_UP);
        return days;
    }

    /**
     * <p>
     * Description: 获取间隔天数.
     * </p>
     *
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 间隔天数
     */
    public static long getBetweenDays(String startDate, String endDate) {
        if (endDate == null || startDate == null) {
            return -1;
        }
        Date dateStart = isDate(startDate);
        if (null == dateStart) {
            return -1;
        }
        Date dateEnd = isDate(endDate);
        if (null == dateEnd) {
            return -1;
        }
        return getBetweenDays(dateStart, dateEnd);
    }

    /**
     * <p>
     * 把Date转换为Calendar对象.
     * </p>
     *
     * @param d Date对象
     * @return Calendar对象
     */
    public static Calendar getCalendar(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }

    /**
     * <p>
     * 获得格式化日期之后的 String数据.
     * </p>
     *
     * @param dateLong 日期毫秒数
     * @param patten 格式
     * @return 格式化日期
     */
    public static String getDateOfString(Long dateLong, String patten) {
        if (dateLong != null) {
            return (new SimpleDateFormat(patten).format(new Date(dateLong.longValue()))).toString();
        }
        return "";
    }

    /**
     * <p>
     * Description: 获取当前数据里的时间参数.
     * </p>
     *
     * @return 时间参数
     */
    public static String getDateStr() {
        return "sysdate";
    }

    /**
     * <p>
     * Description: 获取当前日期.
     * </p>
     *
     * @param patternString 日期格式，如：yyyy-MM-dd HH:mm:ss
     * @return 结果
     */
    public static String getDateStr(String patternString) {
        SimpleDateFormat formatter = new SimpleDateFormat(patternString);
        String date = formatter.format(new Date(System.currentTimeMillis()));
        return date;
    }

    /**
     * <p>
     * Description:日期格式化(Date转换为String).
     * </p>
     *
     * @param date 日期
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return 结果
     */
    public static String getDateString(Date date, String patternString) {
        String dateString = "";
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(patternString);
            dateString = formatter.format(date);
        }
        return dateString;
    }

    /**
     * <p>
     * Description:获取到指定样式的年月日(年月日参数为int型).
     * </p>
     *
     * @param year 年
     * @param month 月
     * @param date 日
     * @param patternString 日期格式，如：yyyy-MM-dd HH:mm:ss EEE
     * @return 格式化后的字符串
     */
    public static String getDateString(int year, int month, int date, String patternString) {
        String dateString = "";
        SimpleDateFormat formatter = new SimpleDateFormat(patternString);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date);
        Date showDate = calendar.getTime();
        dateString = formatter.format(showDate);
        return dateString;
    }

    /**
     * <p>
     * Description:日期格式化(String转换为String).
     * </p>
     *
     * @param date 日期字符串
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return 结果
     */
    public static String getDateString(String date, String patternString) {
        if (date == null) {
            return "";
        }
        if (date.length() < 10) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(patternString, Locale.ENGLISH);
        int len = patternString.length();
        if (len > date.length()) {
            patternString = patternString.substring(0, date.length());
        }
        return formatter.format(getDateToString(date, patternString));
    }

    /**
     * <p>
     * Description:获取到指定样式的年月日(年月日参数为String型).
     * </p>
     *
     * @param year 年
     * @param month 月
     * @param date 日
     * @param patternString 日期格式，如：yyyy-MM-dd HH:mm:ss EEE
     * @return 格式化后的字符串
     */
    public static String getDateString(String year, String month, String date, String patternString) {
        String dateString = "";
        try {
            int y = Integer.parseInt(year);
            int m = Integer.parseInt(month);
            int d = Integer.parseInt(date);
            dateString = getDateString(y, m, d, patternString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateString;
    }

    /**
     * <p>
     * Description:日期格式化(String转换为Date).
     * </p>
     *
     * @param dateStr 日期字符串
     * @param patten 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return 结果
     */
    public static Date getDateToString(String dateStr, String patten) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(patten);

        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <p>
     * Description:获取日期的日.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getDay(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.DATE);
    }

    /**
     * <p>
     * Description:获取日期的日.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getDay(String date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(DateUtils.getDateToString(date, DATESHOWFORMAT));
        return ca.get(Calendar.DATE);
    }

    /**
     * <p>
     * Description:获取与指定日期相差指定 月数 并减去天数的日期.
     * </p>
     *
     * @param baseDate 时间字符串，如：2008-12-03 11:00:00
     * @param monthCount 向前或向后的月数，向后为正数，向前为负
     * @param dateCount 加或减去的天数，向后为正数，向前为负
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return 结果
     */
    public static String getEndDate(Date baseDate, int monthCount, int dateCount, String patternString) {
        String strBaseDate = getDateString(baseDate, DATETIMESHOWFORMAT);
        return getEndDate(strBaseDate, monthCount, dateCount, patternString);
    }

    /**
     * <p>
     * Description: 获取与指定日期相差指定 月数 并减去天数的日期.
     * </p>
     *
     * @param baseDate 时间字符串，如：2008-12-03 11:00:00
     * @param monthCount 向前或向后的月数，向后为正数，向前为负
     * @param dateCount 加或减去的天数，向后为正数，向前为负
     * @param patternString 处理结果日期的显示格式，如："YYYY-MM-DD"
     * @return 结果
     */
    public static String getEndDate(String baseDate, int monthCount, int dateCount, String patternString) {
        int day = Integer.parseInt(baseDate.substring(8, 10));
        String endDate = getAfterMonth(baseDate, monthCount, patternString);
        int endDay = Integer.parseInt(endDate.substring(8, 10));
        // 说明日期没变
        if (endDay == day) {
            // 月数为正则为减一
            if (monthCount > 0) {
                endDate = getAfterDate(endDate, dateCount, patternString);
            } else {
                endDate = getAfterDate(endDate, dateCount, patternString);
            }
        } else { // 日期已变
            if (monthCount < 0) {
                endDate = getAfterDate(endDate, dateCount, patternString);
            }
        }
        return endDate;
    }

    /**
     * <p>
     * Description:获取日期的第几小时.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getHour(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * <p>
     * Description:获取日期的第几分钟.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getMin(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.MINUTE);
    }

    /**
     * <p>
     * Description: getMondayDate.
     * </p>
     *
     * @return 结果
     */
    public static Date getMondayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Calendar.SUNDAY - calendar.get(Calendar.DAY_OF_WEEK) + 1);
        return calendar.getTime();
    }

    /**
     * <p>
     * Description:获取日期的月.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.MONTH) + 1;
    }

    /**
     * <p>
     * Description:获取日期的月.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getMonth(String date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(DateUtils.getDateToString(date, DATESHOWFORMAT));
        return ca.get(Calendar.MONTH) + 1;
    }

    /**
     * <p>
     * Description: 获取月的最后一天.
     * </p>
     *
     * @param pDate1 日期
     * @param mntCycle 月数
     * @return 结果
     */
    public static Date getMonthLastDayByCycle(Date pDate1, int mntCycle) {
        Date date = null;
        try {
            String str = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar startdate = Calendar.getInstance();
            startdate.setTime(pDate1);

            startdate.add(Calendar.MONTH, mntCycle + 1); // 减mntCycle个月
            startdate.set(Calendar.DATE, 0); // 把日期设置为当月第一天

            str = sdf.format(startdate.getTime());
            date = parseDate(str, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * <p>
     * Description:根据延长周期，获取（当月数 + mntCycle - 1）月的最后一天.
     * </p>
     *
     * @param mntCycle mntCycle
     * @return 结果
     */
    public static Date getMonthLastDayByCycle(int mntCycle) {
        Date date = null;
        try {
            String str = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar lastDate = Calendar.getInstance();
            lastDate.add(Calendar.MONTH, mntCycle); // 减mntCycle个月
            lastDate.set(Calendar.DATE, 0); // 把日期设置为当月第一天

            str = sdf.format(lastDate.getTime());
            date = parseDate(str, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * <p>
     * Description:获得下个月第一天的日期.
     * </p>
     *
     * @return 结果
     */
    public static String getNextMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, 1); // 减一个月
        lastDate.set(Calendar.DATE, 1); // 把日期设置为当月第一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * <p>
     * Description:文本时间转换为时间对象.
     * </p>
     *
     * @param baseDate 日期字符串
     * @return 结果
     */
    public static java.sql.Date getSqlDate(String baseDate) {
        if (baseDate == null || baseDate.length() == 0) {
            return null;
        }
        Date date = getDateToString(baseDate, DATESHOWFORMAT);
        return new java.sql.Date(date.getTime());
    }

    /**
     * <p>Description: 获取星期日日期</p>
     * @return 星期日日期
     */
    public static Date getSundayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7 - calendar.get(Calendar.DAY_OF_WEEK) + 1);
        return calendar.getTime();
    }

    /**
     * <p>
     * Description:获取上一个月的日期.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static Date getUpMouth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, -1);
        return ca.getTime();
    }

    /**
     * <p>
     * Description:获取其他月的日期.
     * </p>
     *
     * @param date 日期
     * @param num 日期
     * @return 结果
     */
    public static Date getNumMouth(Date date,Integer num) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, num);
        return ca.getTime();
    }


    /**
     * <p>
     * Description:获取上一个月的日期.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static Date getUpMouth(String date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(DateUtils.getDateToString(date, DATESHOWFORMAT));
        ca.add(Calendar.MONTH, -1);
        return ca.getTime();
    }

    /**
     * <p>
     * Description:获取日期事第几周.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getWeek(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * <p>
     * Description:获取日期的第几周.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getWeek(String date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(DateUtils.getDateToString(date, DATESHOWFORMAT));
        return ca.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * <p>
     * Description:获取日期的年.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getYear(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.YEAR);
    }

    /**
     * <p>
     * Description:获取日期的年.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static int getYear(String date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(DateUtils.getDateToString(date, DATESHOWFORMAT));
        return ca.get(Calendar.YEAR);
    }

    /**
     * <p>
     * Description:验证输入的文本信息日期是否合规.
     * </p>
     *
     * @param dateStr 字符日期
     * @return 日期
     */
    public static Date isDate(String dateStr) {
        String dateFormat1 = "yyyy/MM/dd";
        String dateFormat2 = "yyyy-MM-dd";
        String dateFormat3 = "yyyyMMdd";
        String dateFormat4 = "yyyy.MM.dd";
        String[] dateFormat = { dateFormat1, dateFormat2, dateFormat3, dateFormat4 };
        for (int i = 0; i < dateFormat.length; i++) {
            Date tempDate = isDate(dateStr, dateFormat[i]);
            if (null != tempDate) {
                return tempDate;
            }
        }
        return null;
    }

    /**
     * <p>
     * Description: 验证输入的文本信息日期是否合.
     * </p>
     *
     * @param dateStr 日期
     * @param patternString 转换格式日期
     * @return 结果
     */
    public static Date isDate(String dateStr, String patternString) {
        if (StringUtils.isBlank(patternString)) {
            patternString = DATESHOWFORMAT;
        }
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat(patternString);
            formatDate.setLenient(false);
            ParsePosition pos = new ParsePosition(0);
            Date tempDate = formatDate.parse(dateStr, pos);
            tempDate.getTime();
            return tempDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <p>
     * Description: 周.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)
                || Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Description:获取当前月第一天.
     * </p>
     *
     * @return 结果
     */
    public static String lastDate() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.set(Calendar.DAY_OF_MONTH, 1);
        ca.add(Calendar.MONTH, 1);
        ca.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = ca.getTime();
        return getDateString(lastDate, DATESHOWFORMAT);
    }

    /**
     * <p>
     * Description:将时间对象转换成指定的格式无小时.
     * </p>
     *
     * @param date 日期
     * @return 返回
     */
    public static String parseDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat bartDateFormat = new SimpleDateFormat(DATESHOWFORMAT);
        return bartDateFormat.format(date);
    }

    /**
     * <p>
     * Description: 日期格式化.
     * </p>
     *
     * @param date 日期
     * @param format 转换格式
     * @return 返回结果
     * @throws ParseException 异常
     */
    public static Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat(format);
        return parser.parse(date);
    }

    /**
     * <p>
     * Description: 解析带时区的日期.
     * </p>
     *
     * @param date 日期
     * @param format 日期格式
     * @param zone 时区
     * @return 返回结果
     * @throws ParseException 异常
     */
    public static Date parseDate(String date, String format, TimeZone zone) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat(format);
        parser.setTimeZone(zone);
        return parser.parse(date);
    }

    /**
     * <p>
     * Description:将时间对象转换成指定的格式有小时.
     * </p>
     *
     * @param date 日期
     * @return 结果
     */
    public static String parseDateTime(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat bartDateFormat = new SimpleDateFormat(DATETIMESHOWFORMAT);
        return bartDateFormat.format(date);
    }

    /**
     * <p>
     * Description: 日期格式化.
     * </p>
     *
     * @param date 日期
     * @param format 转换格式
     * @return 结果
     * @throws ParseException 异常
     */
    public static String parseDateToString(Date date, String format) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat(format);
        return parser.format(date);
    }

    /**
     * <p>
     * Description:将时间对象转换成指定的格式有.
     * </p>
     *
     * @param date date
     * @return 结果
     */
    public static String parsTime(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat bartDateFormat = new SimpleDateFormat(TIMESHOWFORMAT);
        return bartDateFormat.format(date);
    }

    /**
     * <p>
     * Description:java.util.Date对象转换为java.sql.Date对象.
     * </p>
     *
     * @param date java.util.Date对象
     * @return Date java.sql.Date对象
     */
    public static java.sql.Date utilDateToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * <p>Description: 快速获取当天0点0分0秒（00:00:00），23点59分59秒（23:59:59）</p>
     * @param date
     * @return 返回数组第一个为当天0点0分0秒，第二个为23点59分59秒
     */
    public static Date[] beginAndEndOfDay(Date date) {
        Date[] array = new Date[2];
        if (date == null) {
            return array;
        }
        // 获取当天凌晨0点0分0秒Date
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        Date beginOfDate = calendar1.getTime();
        array[0] = beginOfDate;
        // 获取当天23点59分59秒Date
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        Date endOfDate = calendar1.getTime();
        array[1] = endOfDate;
        return array;
    }
    /**
     * <p>Description: 快速获取当天0点0分0秒（00:00:00），23点59分59秒（23:59:59）</p>
     * @param date 字符串date
     * @param patten 日期格式
     * @return 返回数组第一个为当天0点0分0秒，第二个为23点59分59秒
     */
    public static Date[] beginAndEndOfDay(String date, String patten) {
        Date dateFromString = getDateToString(date, patten);
        return beginAndEndOfDay(dateFromString);
    }

    /**
     * <p>Description: 获取一天的中午十二点</p>
     * @param date 日期
     * @return 中午十二点
     */
    public static Date getTheMiddleOfDayDate(Date date) {
        // 获取当天凌晨12点0分0秒Date
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                12, 0, 0);
        Date beginOfDate = calendar1.getTime();
        return beginOfDate;
    }

    /**
     * 日期转化为星期
     * @param datetime  日期，2019-08-14
     * @return			星期三
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar c = Calendar.getInstance();
        try {
        	Date date = sdf.parse(datetime);
            c.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int index = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (index < 0) {
        	index = 0;
        }
        return weekDays[index];
    }
    
}
