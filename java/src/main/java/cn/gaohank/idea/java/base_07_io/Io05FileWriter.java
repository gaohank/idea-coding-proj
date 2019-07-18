package cn.gaohank.idea.java.base_07_io;

import java.io.FileWriter;
import java.io.IOException;

public class Io05FileWriter {
    public static void main(String[] args) {
        String outputFilePath = "./src/cn/com/gsl/_16_io/output.txt";
        try (
                // 第二个参数为true，意思为追加
                FileWriter fw = new FileWriter(outputFilePath)
        ) {
            fw.write("你好，高嵩凌");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
