package cn.gaohank.idea.java.base_06_jdbc;

import cn.gaohank.idea.java.base_11_utils.Utils13Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc01UseDbUtil {
    public static void main(String[] args) {
        // 1.使用工具类进行连接
        Connection conn = Utils13Jdbc.getConn();

        try {
            // 2.建立PreparedStatement
            String sql = "select * From goods g where USER_ID = ?";
            PreparedStatement stat = conn.prepareStatement(sql);

            // 填充占位符
            stat.setString(1, "1");

            // 3.返回结果集
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("goods_name"));
            }
        } catch (SQLException e) {
            System.out.println("sql操作异常");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("连接空指针异常");
            e.printStackTrace();
        }

        Utils13Jdbc.close(conn);
    }
}
