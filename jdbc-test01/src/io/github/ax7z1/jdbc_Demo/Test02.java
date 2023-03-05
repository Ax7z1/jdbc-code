package io.github.ax7z1.jdbc_Demo;

import java.sql.*;

/*
    JDBC完成delete
*/
public class Test02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1. 注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2. 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            //3. 获取数据库操作对象
            stmt = conn.createStatement();
            //4. 执行SQL语句
            // JDBC 中的sql语句不需要提供分号结尾。
            // String sql = "delete from stu where name = 'zs'";
            String sql = "update stu set age = '999' where name='ls' ";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "删除成功" : "删除失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6. 释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
