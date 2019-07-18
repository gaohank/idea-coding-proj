package cn.gaohank.idea.java.base_05_collection.map;

import java.io.FileOutputStream;
import java.util.Properties;

/*
 * Properties
 * 可以把Map对象中的key-value对写入属性文件中，
 * 也可以把属性文件中的”属性名=属性值”加载到Map对象中。
 */
public class Map06Properties {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();

        // load文件
        // 绝对路径或相对路径
        prop.load(Map06Properties.class.getClassLoader().getResourceAsStream("jdbc.properties"));

        prop.setProperty("password", "1234");  // 修改

        System.out.println(prop.get("driver"));
        System.out.println(prop.get("url"));
        System.out.println(prop.get("user"));
        System.out.println(prop.get("password"));
        System.out.println(prop.getProperty("password"));

        prop.store(new FileOutputStream("D:/5_workstation/1_workstation_eclipse/test.prop"), "hank");
    }
}
