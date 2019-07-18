package cn.gaohank.idea.java.base_08_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread09Pool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            Runnable r = () -> System.out.println(Thread.currentThread().getName() + "...");
            executorService.execute(r);
        }

        executorService.shutdown();
    }
}
