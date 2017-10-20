package com.hp.up.core.utils.date;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * @Author haopeng
 * @Date 2017/9/7 17:24
 */

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static final String LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_FORMAT = "yyyy-MM-dd";

    public static SimpleDateFormat SIMPLE_LONG_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat SIMPLE_SHORT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date now() {
        return new Date();
    }

    public static Date convert2Date(String dateStr, String format) {
        if (StringUtils.isNotBlank(dateStr)) {
            try {
                return new SimpleDateFormat(format).parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String convert2String(Date date, String format) {
        if (date != null && StringUtils.isNotBlank(format)) {
            return new SimpleDateFormat(format).format(date);
        }
        return StringUtils.EMPTY;
    }

    public static Date format(Date date, SimpleDateFormat format) {
        Date result = null;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            result = format.parse(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE) + " "
                    + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @description -将日期字符串 按天 前后移动 (yyyy-MM-dd)
     *            dateStr -日期字符串 <br>
     *            int len -移动天数;eg: +1(明天),-1(昨天)
     * @return String
     * @date
     * @author
     */
    public static String dayMove(String dateStr, int len) {
        return dateMove(dateStr, len, Calendar.DATE, "yyyy-MM-dd");
    }

    public static Date dayMove(Date date, int len) {
        return dateMove(date, len, Calendar.DATE, "yyyy-MM-dd");
    }

    /**
     * @description -将日期字符串 按月 前后移动 (yyyy-MM-dd)
     *            dateStr -日期字符串 <br>
     *            int len -移动的月数;eg:+1(下个月),-1(上个月)
     * @return String
     * @date
     * @author
     */
    public static String mouthMove(String dateStr, int len) {
        return dateMove(dateStr, len, Calendar.MONTH, "yyyy-MM-dd");
    }

    /**
     * @description -将日期字符串 按月 前后移动 (yyyy-MM-dd)
     *            dateStr -日期字符串 <br>
     *            int len -移动的月数;eg:+1(下个月),-1(上个月)
     * @return String
     * @date
     * @author
     */
    public static Date mouthMove(Date date, int len) {
        return dateMove(date, len, Calendar.MONTH, "yyyy-MM-dd");
    }

    /**
     * @description -将日期字符串 按年 前后移动 (yyyy-MM-dd)
     * @param dateStr
     *            dateStr -日期字符串 <br>
     *            int len -移动的年数;eg:+1(明年),-1(去年)
     * @return String
     * @date
     * @author
     *
     */
    public static String yearMove(String dateStr, int len) {
        return dateMove(dateStr, len, Calendar.YEAR, "yyyy-MM-dd");
    }

    /**
     * @description -返回日期字符串dateStr按移动字段field,移动天数len移动后的字符串
     * @param dateStr
     *            dateStr -需要处理的字符串 <br>
     *            int len -移动天数 <br>
     *            Calendar.DATE field -按(天/月/年)移动
     * @return String 返回日期字符串
     * @date
     * @author
     *
     */
    public static String dateMove(String dateStr, int len, int field) {
        return dateMove(dateStr, len, field, "yyyy-MM-dd");
    }

    /**
     * @description -返回日期字符串dateStr移动小时len后的时间对象
     * @param dateStr
     *            dateStr -需要处理的字符串 String format -需要转换的时间格式 <br>
     *            int len -移动小时 <br>
     *            Calendar.HOUR field -按(小时时)移动
     * @return Date 返回日期
     * @date Nov 1, 2013
     * @author
     *
     */
    public static Date hourMove(String dateStr, int len, String format) {
        return stringToDate(dateMove(dateStr, len, Calendar.HOUR, format), format);
    }

    /**
     * @description -将日期字符串 按年 前后移动 (yyyy-MM-dd)
     *            dateStr -日期字符串 <br>
     *            int len -移动的分钟
     * @return String
     * @date
     * @author
     *
     */
    public static String minuteMove(String dateStr, int len) {
        return dateMove(dateStr, len, Calendar.MINUTE, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @description -将日期字符串 按年 前后移动 (yyyy-MM-dd)
     *            dateStr -日期字符串 <br>
     *            int len -移动的分钟
     * @return String
     * @date
     * @author
     *
     */
    public static Date minuteMove(Date date, int len) {
        return dateMove(date, len, Calendar.MINUTE);
    }

    /**
     * @description -返回日期字符串按移动字段field，移动天数len, 格式pattern
     *            dateStr -需要处理的字符串 <br>
     *            int len -移动天数 <br>
     *            Calendar.DATE field -按(天/月/年)移动 <br>
     *            String pattern -格式
     * @return String
     * @date
     * @author
     */
    public static String dateMove(String dateStr, int len, int field, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(stringToDate(dateStr, pattern));
        cal.add(field, len);
        return dateToString(cal.getTime(), pattern);
    }

    public static Date dateMove(Date date, int len, int field, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, len);
        return cal.getTime();
    }

    /**
     * @description -返回日期字符串按移动字段field，移动天数len, 格式pattern
     *            dateStr -需要处理的字符串 <br>
     *            int len -移动天数 <br>
     *            Calendar.DATE field -按(天/月/年)移动 <br>
     *            String pattern -格式
     * @return String
     * @date
     * @author
     */
    public static Date dateMove(Date date, int len, int field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, len);
        return cal.getTime();
    }

    /**
     * @description 返回系统时间的字符串 (yyyy-MM-dd HH:mm:ss)
     * @return String
     * @date
     * @author
     */
    public static String getTime() {
        return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @description 返回系统日期的字符串 (yyyy-MM-dd)
     * @return String
     * @date
     * @author
     *
     */
    public static String getDate() {
        return dateToString(new Date(), "yyyy-MM-dd");
    }

    /**
     * @description -返回系统现在时间的毫秒数
     * @return String
     * @date Nov 5, 2012 2:45:35 PM
     * @author
     */
    public static String getTimeMilliseconds() {
        return String.valueOf(new Date().getTime());
    }

    /**
     * @description 将日期对象date转化成格式pattern的日期字符串
     *            pattern -格式 <br>
     *            Date date -日期对象
     * @return String -日期字符串
     * @date
     * @author
     */
    public static String dateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * @description 返回指定时间的字符串 (yyyy-MM-dd HH:mm:ss)
     *            date
     * @return String
     * @date
     * @author
     */
    public static String timeToString(Date date) {
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @description 返回指定日期的字符串 (yyyy-MM-dd)
     *            日期对象
     * @return String 日期的字符串
     * @date
     * @author
     */
    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd");
    }

    /**
     * @description -按格式pattern将字符串dateStr转化为日期
     *            dateStr -日期字符串 <br>
     *            String pattern -转化格式
     * @return Date -转化成功返回该格式的日期对象,失败返回null
     * @date
     * @author
     */
    public static Date stringToDate(String dateStr, String pattern) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @description -将日期字符串timeStr转化为日期对象 (yyyy-MM-dd HH:mm:ss)
     *            timeStr -日期字符串
     * @return Date
     * @date
     * @author
     */
    public static Date stringToTime(String timeStr) {
        return stringToDate(timeStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @description -将日期字符串dateStr转化为日期对象 (yyyy-MM-dd)
     *            dateStr -日期字符串
     * @return Date
     * @date
     * @author
     */
    public static Date stringToDate(String dateStr) {
        return stringToDate(dateStr, "yyyy-MM-dd");
    }

    /**
     * @description -将日期字符按pattern串格式化
     *            dateString -日期字符串 <br>
     *            Stirng pattern -格式
     * @return String
     * @date
     * @author
     */
    public static String format(String dateString, String pattern) {
        String result = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            result = dateFormat.format(dateFormat.parse(dateString));
        } catch (ParseException e) {
            return getSysTime(pattern);
        }
        return result;
    }

    /**
     * @description-将日期字符按"yyyy-MM-dd"串格式化
     *            dateString
     * @return String
     * @author
     * @date :
     */
    public static String format(String dateString) {
        try {
            return format(dateString, "yyyy-MM-dd");
        } catch (Exception e) {
            return getSysTime("yyyy-MM-dd");
        }
    }

    /**
     * 取得系统时间
     *
     * @param pattern
     *            按什么格式输出如'yyyy-MM-dd'
     * @return
     */
    public static String getSysTime(String pattern) {
        if (pattern == null || "".equals(pattern)) {
            pattern = "yyyy-MM-dd";
        }
        Properties p = System.getProperties();
        p.setProperty("user.timezone", "GMT+8");
        String tt = new SimpleDateFormat(pattern).format(new Date());
        return tt;
    }

    /**
     * 计算两个日期之间的相差天数 如果,天时分秒都为零则返回0天0时0分1秒
     *
     * @param timeStart
     *            格式为 2012-12-12 12:24:30
     * @param timeEnd
     *            格式为 2012-12-12 12:24:30
     * @param pattern
     *            传入开始时间与结束时间的格式 如 "yyyy-MM-dd" 不传,默认为 "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getTimeDifference(String timeStart, String timeEnd, String pattern) {
        if (pattern == null || pattern.equals("")) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            java.util.Date now = df.parse(timeStart);
            java.util.Date date = df.parse(timeEnd);
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            if (day == 0 && hour == 0 && min == 0 && s == 0) {
                s = 1;
            }
            return ("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
        } catch (Exception e) {
            return "计算时差异常";
        }
    }

    /**
     * 计算两个日期之间的相差天数 如果,天时分秒都为零则返回0天0时0分1秒
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static String getTimeDifference(Date dateStart, Date dateEnd) {
        try {
            long l = dateStart.getTime() - dateEnd.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            if (day == 0 && hour == 0 && min == 0 && s == 0) {
                s = 1;
            }
            return ("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
        } catch (Exception e) {
            return "计算时差异常";
        }
    }

    /**
     * 计算两个日期之间的相差天数
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static Long getDayDifference(Date dateStart, Date dateEnd) {
        try {
            long l = dateStart.getTime() - dateEnd.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            return day;
        } catch (Exception e) {
            return 0L;
        }
    }

    // a integer to xx:xx:xx
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0) {
            return "00:00";
        }
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    return "99:59:59";
                }
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        } else {
            retStr = "" + i;
        }
        return retStr;
    }

    /**
     * Date format to cron pattern , eg. <b>2015-08-17 10:00:00</b> to <b>0 0 10 17 8 ? 2015</b>
     *
     * @param sourceDate
     * @return
     */
    public static String cronFormat(Date sourceDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(sourceDate);

        StringBuilder builder = new StringBuilder();
        builder.append(cal.get(Calendar.SECOND) + " ");
        builder.append(cal.get(Calendar.MINUTE) + " ");
        builder.append(cal.get(Calendar.HOUR_OF_DAY) + " ");
        builder.append(cal.get(Calendar.DATE) + " ");
        builder.append((cal.get(Calendar.MONTH) + 1) + " ? ");
        // builder.append(cal.get(Calendar.YEAR)+" ");

        return builder.toString();
    }

    public static String getBetweenTime(Date sourceDate) {

        if (null != sourceDate) {
            long l = System.currentTimeMillis() - sourceDate.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

            StringBuffer sb = new StringBuffer();
            // sb.append("发表于：");
            if (day > 0) {
                sb.append(day + "天");
            } else if (hour > 0) {
                sb.append(hour + "小时");
            } else if (min > 0) {
                sb.append(min + "分");
            } else {
                sb.append(s + "秒 ");
            }

            sb.append("前");
            return sb.toString();

        } else {
            return null;
        }

    }

}
