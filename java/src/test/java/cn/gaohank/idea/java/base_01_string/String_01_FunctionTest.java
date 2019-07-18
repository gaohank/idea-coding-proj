package cn.gaohank.idea.java.base_01_string;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class String_01_FunctionTest {
    @Test
    public void testStringName() {
        String s1 = "test.txt";
        System.out.println(s1.endsWith(".txt"));	// 查找是否以".txt"结尾
        System.out.println(s1.startsWith("test"));  // 查找前缀是否以开头
        System.out.println(s1.equalsIgnoreCase("TEST.TXT")); // 忽略大小写
        assertEquals("test.txt", s1);
    }
}