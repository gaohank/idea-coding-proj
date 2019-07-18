package cn.gaohank.idea.java.base_11_utils;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Utils07ScannerTest {
    @Test
    public void scanLine() {
        String data = "hello world";
        Scanner scanner = Utils07Scanner.getScanner(new ByteArrayInputStream(data.getBytes()));
        Utils07Scanner.scanLine(scanner);
    }

    @Test
    public void scanWord() {
        String data = "hello world";
        Scanner scanner = Utils07Scanner.getScanner(new ByteArrayInputStream(data.getBytes()));
        Utils07Scanner.scanWord(scanner);
    }

    @Test
    public void scanByte() {
        Scanner scanner = new Scanner("h n hello world 1 2 3");
        Utils07Scanner.scanByte(scanner);
    }

    @Test
    public void scanDouble() {
        Scanner scanner = new Scanner("3.14 1.24");
        Utils07Scanner.scanDouble(scanner);
    }
}