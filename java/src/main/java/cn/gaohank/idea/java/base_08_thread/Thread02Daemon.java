package cn.gaohank.idea.java.base_08_thread;

public class Thread02Daemon {
    public static void main(String[] args) throws Exception {
        Thread daemon = new Thread(() -> {
            System.out.println("守护线程开始");
            // 设置为守护线程时，最终会退出，主程序结束
            while (true);
        });

        daemon.setDaemon(true);
        daemon.start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("thread t2");
            }
            System.out.println(daemon.getState());
//            while(true); 非守护线程，程序不会退出，主程序不会结束
        }).start();

        System.out.println(daemon.getState());
    }
}
