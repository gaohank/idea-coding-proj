package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Utils08HashTest {

    @Test
    public void getHashCode() {
        int h1 = Utils08Hash.getHashCode("hello");
        int h2 = Utils08Hash.getHashCode("hello");
        assertEquals(h1, h2);
    }
}