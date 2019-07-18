package cn.gaohank.idea.java.base_08_thread;

/**
 * Thread类实现了Runnable接口
 */
public class Thread01Start {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i ++) {
                System.out.println("thread t1");
            }
        });

        // 定义线程t2,等待t1执行完成
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 100; i++) {
                System.out.println("thread t2");
            }
        });

        t2.start();
        t1.start();
    }
}
