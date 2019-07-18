package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class Utils03LocalTimeTest {

    @Test
    public void getLocalDateTime() {
        LocalDateTime localDateTime = Utils03LocalTime.getLocalDateTime("2018/10/30 23:10:15", "yyyy/MM/dd HH:mm:ss");
        assertEquals(2018, localDateTime.getYear());
        assertEquals(10, localDateTime.getMonthValue());
        assertEquals(2, localDateTime.getDayOfWeek().getValue());
    }
}