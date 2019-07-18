package cn.gaohank.idea.java.base_11_utils;

import java.util.Timer;
import java.util.TimerTask;

/*
 * 定时，可延迟，可重复执行，还可以取消
 * 抛异常(Tread.sleep(100))
 * 多线程（发现两件事同时执行）
 */
public class Utils05Timer {
    // 只运行一次
    public static void startTimer(TimerTask timerTask, long delay) {
        new Timer().schedule(timerTask, delay);
    }

    public static void startTimer(TimerTask timerTask, long delay, long period) {
        new Timer().schedule(timerTask, delay, period);
    }

    public static void cancelTimer(Timer timer) {
        timer.cancel();
    }
}
