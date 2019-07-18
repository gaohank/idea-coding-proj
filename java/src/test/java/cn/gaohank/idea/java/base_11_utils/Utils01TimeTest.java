package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Utils01TimeTest {
    private final static Utils01Time utils01Time = new Utils01Time();

    @Test
    public void getCurrentTimeMillis() {
        System.out.println(utils01Time.getCurrentTimeMillis());
    }

    @Test
    public void getUnixTimestamp() throws Exception {
        // 2011/11/11 11:11:11 转换成unix时间戳是：1320981071000 单位是ms
        assertEquals(1320981071000L, utils01Time.getUnixTimestamp(
                utils01Time.getParseDate("2011-11-11 11:11:11", "yyyy-MM-dd HH:mm:ss")
        ));
    }

    @Test
    public void getFormatDate() {
        // 2011/11/11 11:11:11 转换成unix时间戳是：1320981071000 单位是ms
        assertEquals("20111111", utils01Time.getFormatDate(new Date(1320981071000L), "yyyyMMdd"));
    }

    @Test
    public void getParseDate() throws Exception {
        String dateStr = "2018-10-10 10:10:10";
        Date parseDate = utils01Time.getParseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        assertEquals("20181010", utils01Time.getFormatDate(parseDate, "yyyyMMdd"));
    }
}