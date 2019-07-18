package cn.gaohank.idea.java.base_11_utils;

import java.io.InputStream;
import java.util.Scanner;

public class Utils07Scanner {
    public static Scanner getScanner(InputStream inputStream) {
        return new Scanner(inputStream);
    }

    public static void scanLine(Scanner scanner) {
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void scanWord(Scanner scanner) {
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    public static void scanByte(Scanner scanner) {
        while (scanner.hasNextByte()) {
            System.out.println(scanner.nextByte(7));
        }
    }

    public static void scanDouble(Scanner scanner) {
        while (scanner.hasNextDouble()) {
            System.out.println(scanner.nextDouble());
        }
    }
}
