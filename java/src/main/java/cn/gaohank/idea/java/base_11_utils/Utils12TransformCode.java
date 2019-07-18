package cn.gaohank.idea.java.base_11_utils;

import java.io.*;
import java.util.Scanner;

public class Utils12TransformCode {
    public static File src;
    public static File dest;

    public Utils12TransformCode() {
    }

    public Utils12TransformCode(File src, File dest) {
        Utils12TransformCode.src = src;
        Utils12TransformCode.dest = dest;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("转码源路径：");
        String srcPath = scanner.nextLine();
        System.out.println("转码目标路径：");
        String destPath = scanner.nextLine();

        Utils12TransformCode.src = new File(srcPath);
        Utils12TransformCode.dest = new File(destPath);

        Utils12TransformCode utils12TransformCode = new Utils12TransformCode();
        // TODO:转码过程
        utils12TransformCode.FileIterator(src, dest);
        System.out.println("转码结束");
    }

    private void FileIterator(File src, File dest) throws Exception {
        // 判断文件是否是文件夹，是的话就迭代遍历
        if (src.isDirectory()) {
            // 判断目标文件夹是否存在
            if (!dest.exists()) {
                dest.mkdir();
            }

            // 得到目录下所有文件
            File[] files = src.listFiles();

            for (int i = 0; i < files.length; i++) {
                // 如果是文件夹，递归处理
                if (files[i].isDirectory()) {
                    File res = new File(
                            dest.getPath() + "/" + files[i].getName()
                    );
                    this.FileIterator(files[i], res);
                } else {
                    // 单文件进行转码
                    File text = files[i];
                    File destFile = new File(
                            dest.getPath() + "/" + files[i].getName()
                    );
                    // 对应文件不存在就新建
                    if (!destFile.exists()) {
                        destFile.createNewFile();
                    }
                    decodeTransform(text, destFile);
                }
            }
        }else {
            if (src.exists()) {
                String[] srcPath = src.getPath().split("\\.");
                String transPath = srcPath[0].concat("转码.") + srcPath[1];
                File destPath = new File(transPath);
                if (!destPath.exists()) {
                    destPath.createNewFile();
                }
                decodeTransform(src, destPath);
            } else {
                throw new Exception("非法文件路径");
            }
        }
    }

    public static void decodeTransform(File file, File tempFile) throws Exception {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        // 转码后文件对象不存在就新建
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "utf-8"));
        String s;
        while ((s = reader.readLine()) != null) {
            writer.write(s + "\r\n");
        }
        reader.close();

        writer.flush();
        writer.close();
        System.out.println("转码结束");
    }
}
