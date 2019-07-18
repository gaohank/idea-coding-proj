package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Utils09MutilParamTest {

    @Test
    public void getSum() {
        assertEquals(10, Utils09MutilParam.getSum(1, 2, 3, 4));
    }
}