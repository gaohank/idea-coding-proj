package cn.gaohank.idea.java.base_08_thread;

import java.util.concurrent.ArrayBlockingQueue;

public class Thread08Blockqueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    bq.put(i + "");
                    System.out.println("已生产："+i+"，仓库中还剩余:"+bq.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    System.out.println("已消费："+bq.take()+"，仓库还剩余："+bq.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
