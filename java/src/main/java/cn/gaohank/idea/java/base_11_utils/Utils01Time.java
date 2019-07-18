package cn.gaohank.idea.java.base_11_utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils01Time {
    // 获得当前的系统时间，精确到毫秒
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    // 将Date转化成unix时间戳
    public long getUnixTimestamp(Date date) {
        return date.getTime();
    }

    // 将Date格式化成String的时间
    public String getFormatDate(Date date, String parse) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parse);
        return simpleDateFormat.format(date);
    }

    // 将String的时间格式化成Date
    public Date getParseDate(String date, String parse) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parse);
        return simpleDateFormat.parse(date);
    }
}
