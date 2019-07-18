package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Utils02DateTimeTest {

    @Test
    public void getMillis() {
        // 2011/11/11 11:11:11 转换成unix时间戳是：1320981071000 单位是ms
        assertEquals(1320981071000L, Utils02DateTime.getMillis("2011-11-11 11:11:11", "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void getPatternDateNow() {
        System.out.println(Utils02DateTime.getPatternDate("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void getPatternDate() {
        assertEquals("2018", Utils02DateTime.getPatternDate("2018-10-10", "yyyy"));
        assertEquals("20181010", Utils02DateTime.getPatternDate("2018-10-10 12:12:12", "yyyy-MM-dd HH:mm:ss", "yyyyMMdd"));
    }

    @Test
    public void getPatternDateTimestamp() {
        assertEquals("2011-11-11 11:11:11", Utils02DateTime.getPatternDate(1320981071000L, "yyyy-MM-dd HH:mm:ss"));
    }
}