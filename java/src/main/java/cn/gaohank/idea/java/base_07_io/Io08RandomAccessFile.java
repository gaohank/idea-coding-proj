package cn.gaohank.idea.java.base_07_io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile
 * 既可以读取文件内容，也可以向文件输出数据
 * 支持“随机访问”的方式，程序可以直接跳转到文件的任意地方来读写数据
 * RandomAccessFile包含了如下两个方法来操作文件记录指针：
 * long getFilePointer()：返回文件记录指针的当前位置。
 * void seek(long pos)：将文件记录指针定位到pos位置
 * 多线程断点续传可以使用RandomAccessFile来实现
 */
public class Io08RandomAccessFile {
    public static void main(String[] args) {
        String filePath = "./src/cn/com/gsl/_16_io/test.txt";
        try(
                RandomAccessFile raf = new RandomAccessFile(filePath,"rw");
        ) {
            raf.seek(raf.length());//移位置，把光标移到最后
            raf.write("abcd".getBytes());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
