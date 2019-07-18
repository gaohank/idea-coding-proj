package cn.gaohank.idea.java.base_06_jdbc;

import cn.gaohank.idea.java.base_11_utils.Utils13Jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc02Transaction {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat;
        try{
            conn = Utils13Jdbc.getConn();
            stat = conn.createStatement();
            conn.setAutoCommit(false);//关闭自动提交
            stat.executeUpdate("INSERT INTO location VALUES (111, 'haha')");//5	执行sql语句
            stat.executeUpdate("INSERT INTO location VALUES (222, 'haha')");//5	执行sql语句
            stat.executeUpdate("INSERT INTO location VALUES (333, 'haha')");//5	执行sql语句
            conn.commit();//手动提交
        } catch (SQLException e) {
            try {
                conn.rollback();//回滚
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println("sql操作异常");
            e.printStackTrace();
        }finally{
            Utils13Jdbc.close(conn);
        }
    }
}
