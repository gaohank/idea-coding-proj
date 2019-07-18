package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Utils04RandomTest {

    @Test
    public void getMathRandom() {
        assertTrue(Utils04Random.getMathRandom(100) < 100);
        assertTrue(Utils04Random.getMathRandom(100) > 0);
    }

    @Test
    public void getRandom() {
    }

    @Test
    public void getThreadRandom() {
        assertTrue(Utils04Random.getThreadRandom(10, 20) < 30);
    }
}