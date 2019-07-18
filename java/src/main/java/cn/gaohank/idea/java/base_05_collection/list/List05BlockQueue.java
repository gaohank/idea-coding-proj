package cn.gaohank.idea.java.base_05_collection.list;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class List05BlockQueue {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        bq.put("hank");
        bq.put("bob");
        // 多于2个就会阻塞队列
//        bq.put("vencent");
        // FIFO，先进先出
        System.out.println(bq.take());
    }
}
