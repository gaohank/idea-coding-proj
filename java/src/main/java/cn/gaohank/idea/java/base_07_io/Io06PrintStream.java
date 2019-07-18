package cn.gaohank.idea.java.base_07_io;

import java.io.*;

/*
 * PrintStream属于字节输出流、高级流，可重定向
 * PrintWriter属于字符输出流、高级流
 * 高级流是对节点流进行了封装，比如会对节点流加上缓存处理等。
 * 处理流包装节点流是一种典型的装饰器设计模式
 */
public class Io06PrintStream {
    public static void main(String[] args) {
        String filePath = "./src/cn/com/gsl/_16_io/output.txt";
        try (
                FileOutputStream fos = new FileOutputStream(filePath, true);
                PrintStream ps = new PrintStream(fos);
                PrintWriter pw = new PrintWriter(fos);
        ) {
            ps.println("world");
            // 重定向输出流
            System.setOut(ps);
            System.out.println("小高你好！\n");
            pw.println("hello");
            pw.flush();//强制清空缓存
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
