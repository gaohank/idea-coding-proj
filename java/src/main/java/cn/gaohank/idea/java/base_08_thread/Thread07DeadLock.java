package cn.gaohank.idea.java.base_08_thread;

public class Thread07DeadLock {
    private static final String k1 = "左筷子";
    private static final String k2 = "右筷子";
    public static void main(String[] args) {
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            while (true) {
                synchronized (k1) {
                    System.out.println(name + "拿起" + k1 + ",等待" + k2);
                    synchronized (k2) {
                        System.out.println(name + "拿起" + k2 + ",吃饭");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            while (true) {
                synchronized (k2) {
                    System.out.println(name + "拿起" + k2 + ",等待" + k1);
                    synchronized (k1) {
                        System.out.println(name + "拿起" + k1 + ",吃饭");
                    }
                }
            }
        }).start();
    }
}
