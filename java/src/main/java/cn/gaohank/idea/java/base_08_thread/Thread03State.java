package cn.gaohank.idea.java.base_08_thread;

public class Thread03State {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            Thread curThread = Thread.currentThread();
            System.out.println(curThread);
            System.out.println(curThread.getPriority());
            System.out.println(curThread.getId());
            System.out.println(curThread.getName());
            System.out.println(curThread.isAlive());
            System.out.println(curThread.getState());
        });
        thread.start();
        Thread.sleep(1000);
    }
}
