package cn.gaohank.idea.java.base_08_thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread10Schedule {
    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("executor test");
        }
    }

    // 1. newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
    public static ExecutorService getCachedThreadPool() {
        return Executors.newCachedThreadPool();
    }

    // 2. newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    public static ExecutorService getFixedThreadPool(int numThreads) {
        return Executors.newFixedThreadPool(numThreads);
    }

    public static ExecutorService getFixedThreadPool(int numThreads, ThreadFactory threadFactory) {
        return Executors.newFixedThreadPool(numThreads, threadFactory);
    }

    // 3. newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
    // scheduled.scheduleAtFixedRate执行定期任务
    // scheduled.schedule指定任务延迟执行
    public static ScheduledExecutorService getScheduledThreadPool(int numThreads) {
        return Executors.newScheduledThreadPool(numThreads);
    }

    // 4.newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
    // 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

    private static class EngineCallbackThreadFactory implements ThreadFactory {
        private final AtomicInteger idx = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("engine-callback-" + idx.incrementAndGet());
            return t;
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new MyThread(), 1, 1, TimeUnit.SECONDS);

        // ScheduledExecutorService executor = Executors.newScheduledThreadPool(2, new QuartzScheduleThreadFactory())
        // ExecutorService callBackExecutor = Executors.newFixedThreadPool
        // executor.scheduleAtFixedRate
    }
}
