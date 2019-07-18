package cn.gaohank.idea.java.base_08_thread;

public class Thread05Thread {
    public static class MyThread extends Thread {
        static int count = 100;
        static final Object syncObj = new Object();
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (syncObj) {// 因为count是共享资源，所以对它的操作要加锁
                    if (count > 0) {
                        System.out.println(name + "count = " + count);
                        count--;
                    } else {
                        System.out.println(name + " finished");
                        break;
                    }
                }
                for (int i = 0; i < 100000; i++);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
