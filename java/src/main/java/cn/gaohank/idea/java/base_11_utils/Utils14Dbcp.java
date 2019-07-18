package cn.gaohank.idea.java.base_11_utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Utils14Dbcp {
    private static BasicDataSource dataSource = null;//数据库连接池

    //给BasicDataSource初始化	initial
    public static void init() {
        Properties dbProps = new Properties();
        // 取配置文件可以根据实际的不同修改
        try {
            dbProps.load(Utils14Dbcp.class.getClassLoader().getResourceAsStream("dbcp.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //从属性文件中取出值
            String driveClassName = dbProps.getProperty("driver");
            String url = dbProps.getProperty("url");
            String username = dbProps.getProperty("name");
            String password = dbProps.getProperty("password");
            String initialSize = dbProps.getProperty("dataSource.initialSize");
            String minIdle = dbProps.getProperty("dataSource.minIdle");
            String maxIdle = dbProps.getProperty("dataSource.maxIdle");
            String maxWait = dbProps.getProperty("dataSource.maxWait");
            String maxActive = dbProps.getProperty("dataSource.maxActive");

            //给连接池赋值
            dataSource = new BasicDataSource();//一个数据库连接池
            dataSource.setDriverClassName(driveClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            // 初始化连接数
            if (initialSize != null)
                dataSource.setInitialSize(Integer.parseInt(initialSize));
            // 最小空闲连接
            if (minIdle != null)
                dataSource.setMinIdle(Integer.parseInt(minIdle));
            // 最大空闲连接
            if (maxIdle != null)
                dataSource.setMaxIdle(Integer.parseInt(maxIdle));
            // 超时回收时间(以毫秒为单位)
            if (maxWait != null)
                dataSource.setMaxWaitMillis(Long.parseLong(maxWait));
            // 最大连接数
            if (maxActive != null) {
                if (!maxActive.trim().equals("0"))
                    dataSource.setMaxConnLifetimeMillis(Integer.parseInt(maxActive));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建连接池失败!请检查设置!!!");
        }
    }

    public static Connection getConn() throws SQLException {
        if(dataSource == null){
            init();
        }
        return dataSource.getConnection();//不用DriverManager获取了。
    }
}
