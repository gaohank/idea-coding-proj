package cn.gaohank.idea.java.base_07_io;

import java.io.FileInputStream;

/*
 * 输入流：主要由InputStream和Reader为基类
 * InputStream属于低级流（节点流）
 * 是程序直接连接到数据源，和实际的输入输出节点连接
 * 1.read()
 * 2.read(byte[])
 * 3.read(byte[], off, length)
 *     off表示从byte的off便宜开始
 */
public class Io02InputStream {
    public static void main(String[] args) throws Exception {
        String filePath = "./src/cn/com/gsl/_16_io/test.txt";
        FileInputStream fis = new FileInputStream(filePath);

        // 1.read()
        System.out.println("====1.read====");
        int var;
        while ((var = fis.read()) != -1 ) { // 每次读取一个
            System.out.print((char)var);
        }
        System.out.println("");
        fis.close();

        // 2.read(byte[])
        System.out.println("====2.read(byte[])====");
        fis = new FileInputStream(filePath);
        int len = -1;
        byte buf[] = new byte[100];

        while ((len = fis.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
        fis.close();

        // 3.read(byte[], off, length)
        System.out.println("====3.read(byte[], off, length)====");
        fis = new FileInputStream(filePath);
        len = -1;

        len = fis.read(buf, 0, 5); // \r\n占了两个字符
        System.out.print(new String(buf, 0, len));
        fis.close();
    }
}
