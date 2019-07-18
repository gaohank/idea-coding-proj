package cn.gaohank.idea.java.base_07_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Io04FileReader {
    public static void main(String[] args) {
        String filePath = "./src/cn/com/gsl/_16_io/test.txt";

        try (
                FileReader fr = new FileReader(filePath);
        ) {

            int charactor = -1;
            while ((charactor = fr.read()) != -1) {
                System.out.print((char)charactor);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
