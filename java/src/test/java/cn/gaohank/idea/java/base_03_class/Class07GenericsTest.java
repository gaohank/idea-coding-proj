package cn.gaohank.idea.java.base_03_class;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Class07GenericsTest {

    @Test
    public void display() {
        Class07Generics<String, Integer> class07Generics = new Class07Generics<>();
        class07Generics.display("hello", 10);
    }

    @Test
    public void getLeftClass() {
        Class07Generics<String, String> class07Generics = new Class07Generics<>();
        assertEquals(String.class, class07Generics.getLeftClass("hello"));
    }
}