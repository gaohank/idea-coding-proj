package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import java.util.TimerTask;

public class Utils05TimerTest {

    @Test
    public void startTimer() throws Exception {
        Utils05Timer.startTimer(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer excuted");
            }
        }, 2000);

        // 休眠2s
        Thread.sleep(2000);
    }

    @Test
    public void startTimerPeriod() throws Exception {
        Utils05Timer.startTimer(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer excuted");
            }
        }, 1000, 200);

        Thread.sleep(2000);
    }
}