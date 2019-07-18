package cn.gaohank.idea.java.base_07_io;

import org.junit.Test;

public class Io10IoUtilsTest {
    @Test
    public void testGetConeent() throws Exception {
        String content = Io10IoUtils.getContent("test.json");
        System.out.println(content);
    }
}