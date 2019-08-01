package cn.gaohank.idea.java.base_07_io;


import com.typesafe.config.ConfigFactory;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Io10IoUtils {
    public static String getContent(String resourceName) throws Exception {
        return IOUtils.toString(Objects.requireNonNull(Io10IoUtils.class.getClassLoader().getResourceAsStream(resourceName)), "utf8");
    }

    public static List<String> getQueries(File file, String path) {
        return ConfigFactory.parseFile(file).getStringList(path);
    }

    public static List<String> getQueries(String conf, String path) {
        return ConfigFactory.load(conf).getStringList(path);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(getContent("test.json"));

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        String name = ConfigFactory.load("query.conf")
                .getString("cn.gaohank.program.javase.base.student.hank.name");
        System.out.println(name);

        System.out.println(getQueries("query.conf",
                "cn.gaohank.program.javase.base.student.hank.queries"));

        System.out.println(ConfigFactory.load("query.conf").getConfig("cn.gaohank.program.javase.base").root().keySet());
    }
}
