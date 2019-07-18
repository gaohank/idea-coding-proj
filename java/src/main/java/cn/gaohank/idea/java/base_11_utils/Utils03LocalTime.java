package cn.gaohank.idea.java.base_11_utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils03LocalTime {
    public static LocalDateTime getLocalDateTime(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }
}
