package cn.gaohank.idea.java.base_03_class;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Class04InnerTest {
    @Test
    public void testInnerClass() {
        Class04Inner class04Inner = new Class04Inner();
        Class04Inner.InnerClass innerClass = class04Inner.new InnerClass();
        innerClass.setOuterValue(10);
        innerClass.setValue(100);
        assertEquals(10, class04Inner.getValue());
        assertEquals(100, innerClass.getValue());
    }

    @Test
    public void testInnerStaticClass() {
        Class04Inner.InnerStaticClass innerStaticClass = new Class04Inner.InnerStaticClass();
        innerStaticClass.setValue(10);
        assertEquals(10, innerStaticClass.getValue());
    }
}