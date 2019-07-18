package cn.gaohank.idea.java.base_11_utils;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Utils10PairTest {

    @Test
    public void getPairs() {
        List<Pair<String, Integer>> scores = Utils10Pair.getPairs(
                new ImmutablePair<>("gaohank", 90),
                new ImmutablePair<>("james", 89),
                new ImmutablePair<>("vencent", 70)
        );

        assertEquals("gaohank", scores.iterator().next().getKey());
    }
}