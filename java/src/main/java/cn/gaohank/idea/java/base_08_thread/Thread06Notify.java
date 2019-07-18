package cn.gaohank.idea.java.base_08_thread;

public class Thread06Notify {
    public static void main(String[] args) throws InterruptedException {
        final Object syncObj = new Object();
        new Thread(() -> {
            synchronized (syncObj) {
                System.out.println("in thread1");
                try {
                    syncObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("out thread1");
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            synchronized (syncObj) {
                System.out.println("in thread2");
                syncObj.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("out thread2");
            }
        }).start();

        Thread.sleep(1000);
    }
}
