package cn.gaohank.idea.java.base_07_io;

import java.io.File;
import java.io.IOException;

/*
 * File
 * 1.文件操作
 * 2.目录遍历
 * 3.不能访问文件内容
 */
public class Io01File {
    public static void main(String[] args) {
// 1.文件操作
        System.out.println("====1.文件操作====");
        File file = new File("./src/cn/com/gsl/_16_io/test.txt"); // 当前路径为工程路径

        System.out.println("文件分隔符：" + File.separator);
        try {
            // 不存在则创建文件
            System.out.println("创建文件是否成功：" + file.createNewFile());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件名：" + file.getName());
        System.out.println("是否为文件：" + file.isFile());
        System.out.println("是否为目录：" + file.isDirectory());
        System.out.println("文件长度：" + file.length());
        System.out.println("文件路径：" + file.getPath());

        file.delete(); // 删除文件

        // 2.遍历目录
        System.out.println("====2.遍历目录====");
        File direcotry = new File("./src/cn/com/gsl/");

        File[] fileList = direcotry.listFiles();
        System.out.println(fileList.length);

        for (File f : fileList) {
            System.out.println(f.getName() + "----" + f.length());
        }
    }
}
