package cn.gaohank.idea.java.base_08_thread;

public class Thread04Sync {
    private static int count = 0;
    private static final Object syncObj = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (syncObj) {
                for (int i = 0; i < 30; i++) {
                    count ++;
                    System.out.println("thread1 -- " + count);
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (syncObj) {
                for (int i = 0; i < 30; i++) {
                    count --;
                    System.out.println("thread2 -- " + count);
                }
            }
        }).start();
    }
}
