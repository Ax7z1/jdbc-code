package io.github.ax7z1.jdbc_Demo;/*
	将连接数据库的所有信息配置到配置文件中
	    实际开发中不建议把连接数据库的信息写死到java程序中。
*/
import java.sql.*;
import java.util.*;
public class Test04
{
    public static void main(String[] args)
    {
        {
            //使用资源绑定器绑定属性配置文件
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            String driver = bundle.getString("driver");
            String url = bundle.getString("url");
            String user = bundle.getString("user");
            String password = bundle.getString("password");
            Connection conn = null;
            Statement stmt = null;
            try {
                //1. 注册驱动
                Class.forName(driver);
                //2. 获取连接
                conn = DriverManager.getConnection(url, user, password);
                //3. 获取数据库操作对象
                stmt = conn.createStatement();
                //4. 执行SQL语句
                String sql = "update stu set age = '19' where name='ls' ";
                int count = stmt.executeUpdate(sql);
                System.out.println(count == 1 ? "修改成功" : "修改失败");
            } catch (Exception e) {
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
}
