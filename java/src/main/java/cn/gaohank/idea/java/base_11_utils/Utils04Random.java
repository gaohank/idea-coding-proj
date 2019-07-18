package cn.gaohank.idea.java.base_11_utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * 随机数是假的，
 * 三种生成随机数的方法
 * Math.random();生成0-1的浮点数
 * Random.nextInt(100);生成１００以内随机整数
 * ThreadLocalRandom tlr.nextInt(30,50);生成30到50的随机数
 */
public class Utils04Random {
    // 生成0到1之间的随机数
    public static double getMathRandom() {
        return Math.random();
    }

    // 生成0到range之间的随机整数
    public static int getMathRandom(int range) {
        return (int) (Math.random() * range);
    }

    // 生成0到range之间的随机整数
    public static int getRandom(int seed, int range) {
        return new Random(seed).nextInt(range);
    }

    // 生成begin到end之间的随机整数
    public static int getThreadRandom(int begin, int end) {
        return ThreadLocalRandom.current().nextInt(begin, end);
    }
}
