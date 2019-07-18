package cn.gaohank.idea.java.base_11_utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Utils13Jdbc {
    private static String driver;
    private static String url;
    private static String username;
    private static String passwd;
    private static Connection conn = null;

    public static void init() {
        Properties prop = new Properties();
        try {
            prop.load(Utils13Jdbc.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("user");
            passwd = prop.getProperty("password");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        if (conn == null) {
            init();
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (ClassNotFoundException e) {
                System.out.println("未找到驱动类");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("url连接异常");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("空指针异常");
                e.printStackTrace();
            }
        }

        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
