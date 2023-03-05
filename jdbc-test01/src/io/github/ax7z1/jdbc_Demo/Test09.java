package io.github.ax7z1.jdbc_Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement完成INSERT DELETE UPDATE
 */
public class Test09 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            // 3.获取预编译的数据库操作对象
/*            String sql = "insert into stu(name,age) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"xh");
            ps.setInt(2,19);*/

/*            String sql = "update stu set age = ? where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,100);
            ps.setString(2,"ls");*/

            String sql = "delete from stu  where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"ls");

            // 4.执行SQL
            int count = ps.executeUpdate();
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
