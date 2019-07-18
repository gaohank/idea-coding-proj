package cn.gaohank.idea.java.base_11_utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Utils02DateTime {
    // 将Date格式化成unix时间戳
    public static long getMillis(String date) {
        return DateTime.parse(date).getMillis();
    }

    public static long getMillis(String date, String pattern) {
        return DateTime.parse(date, DateTimeFormat.forPattern(pattern)).getMillis();
    }

    public static String getPatternDate(String date, String srcPattern, String dstPattern) {
        return DateTime.parse(date, DateTimeFormat.forPattern(srcPattern)).toString(DateTimeFormat.forPattern(dstPattern));
    }

    // 将当前时间格式化成pattern的形式输出
    public static String getPatternDate(String pattern) {
        return DateTime.now().toString(DateTimeFormat.forPattern(pattern));
    }

    // 将date格式化成pattern的形式输出
    public static String getPatternDate(String date, String pattern) {
        return DateTime.parse(date).toString(DateTimeFormat.forPattern(pattern));
    }

    public static String getPatternDate(long timestamp, String pattern) {
        return new DateTime(timestamp).toString(DateTimeFormat.forPattern(pattern));
    }

    public static void main(String[] args) {
        System.out.println(DateTime.parse("2018-10-10 00:12:12", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).minusHours(1).toString(DateTimeFormat.forPattern("yyyyMMddHH")));
        System.out.println(DateTime.now().getMillis() / 1000);
    }
}
