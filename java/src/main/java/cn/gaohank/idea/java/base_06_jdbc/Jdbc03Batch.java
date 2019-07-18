package cn.gaohank.idea.java.base_06_jdbc;

import cn.gaohank.idea.java.base_11_utils.Utils13Jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc03Batch {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat;
        String sql;
        try{
            conn = Utils13Jdbc.getConn();
            conn.setAutoCommit(false);//关闭自动提交
            stat = conn.createStatement();
            for(int i=1;i<=20;i++){
                sql = "INSERT INTO location VALUES ("+i+", 'haha')";
                stat.addBatch(sql);//批量添加
                if(i%5==0){//5个一处理
                    stat.executeBatch();
                }
            }
            stat.executeBatch();//批量执行
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
