package io.github.ax7z1.jdbc_Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务机制：
 *      1、JDBC中的事务是自动提交的，什么是自动提交？
 *          只要执行任意一条DML语句，则自动提交一次。这是JDBC默认的事务行为。
 *          但是在实际的业务当中，通常都是N条DNL语句共同联合才能完成的，必须
 *          保证他们这些DML语句在同一个事务中同时成功或者同时失败。
 *      2、以下程序先来验证一下JDBC的事务是否是自动提交机制！
 *          测试结果：JDBC中只要执行任意一条DML语句，就提交一次
 */
public class Test10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            // 3.获取预编译的数据库操作对象
            String sql1 = "update stu set age = ? where name = ?";
            ps = conn.prepareStatement(sql1);
            //第一次给占位符传值
            ps.setInt(1,333);
            ps.setString(2,"gai");
            int count = ps.executeUpdate(); // 执行第一条UPDATE语句
            System.out.println(count);

            //重写给占位符赋值
            ps.setInt(1,666);
            ps.setString(2,"zs");
            count = ps.executeUpdate(); //  执行第二条UPDATE语句
            System.out.println(count);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            // 6.释放资源
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if ( conn!= null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
