package cn.gaohank.idea.java.base_11_utils;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils10Pair {
    public static<T, R> List<Pair<T, R>> getPairs(Pair<T, R> ... pairs) {
        return new ArrayList<>(Arrays.asList(pairs));
    }

    public static void main(String[] args) {
        Pair<String, String> stu1 = new ImmutablePair<>("1", "hank");
        Pair<String, String> stu2 = new ImmutablePair<>("1", "bob");
        Pair<String, String> stu3 = new ImmutablePair<>("2", "james");
        List<Pair<String, String>> countList = new ArrayList<>();
        countList.add(stu1);
        countList.add(stu2);
        countList.add(stu3);
        countList.stream()
                .map(line1 -> new ImmutablePair<>(line1.getKey(), 1))
                .filter(line -> line.getKey().equals("1")) // 这里必须用filter过滤出相同的key值
                .reduce((line1, line2) ->
                        new ImmutablePair<>(line1.getKey(), line1.getValue() + line2.getValue()))
                .ifPresent(
                        System.out::println
                );
    }
}
