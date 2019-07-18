package cn.gaohank.idea.java.base_05_collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Collection01ExtendsTest {

    @Test
    public void getCollection() {
    }

    @Test
    public void display() {
    }

    @Test
    public void displayForeach() {
    }

    @Test
    public void getCount() {
    }

    @Test
    public void getString() {
    }

    @Test
    public void getMax() {
        Collection<Integer> collection = Collection01Extends.getCollection(3, 1, 7, 14);
        assertEquals(14, Collection01Extends.getMax(collection));
    }

    @Test
    public void getMin() {
        Collection<Integer> collection = Collection01Extends.getCollection(3, 1, 7, 14);
        assertEquals(1, Collection01Extends.getMin(collection));
    }

    @Test
    public void getSort() {
        Collection<Integer> collection = Collection01Extends.getCollection(3, 1, 3, 7, 14);
        assertEquals(Arrays.asList(14, 7, 3, 1), Collection01Extends.getSort(collection));
    }

    @Test
    public void getFilter() {
        Collection<Integer> collection = Collection01Extends.getCollection(3, 1, 3, 7, 14);
        assertEquals(Collections.singletonList(14), Collection01Extends.getFilter(collection));
    }
}