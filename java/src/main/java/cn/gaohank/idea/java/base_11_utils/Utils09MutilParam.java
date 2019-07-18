package cn.gaohank.idea.java.base_11_utils;

public class Utils09MutilParam {
    public static int getSum(int ... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
