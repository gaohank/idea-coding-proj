package cn.gaohank.idea.java.base_07_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Io07BufferReader {
    public static void main(String[] args) {
        String str = "";
        try (
                // InputStreamReader转换流，能在字节和字符间转换
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
        ) {

            while ((str = br.readLine()) != null) { // 读取一行
                if (str.equals("quit")) {
                    System.out.println("退出");
                    break;
                }
                System.out.println("输入：" + str);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
