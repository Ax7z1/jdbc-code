package io.github.ax7z1.jdbc_Demo;

import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这个程序两个任务
 *      第一：测试DBUtil是否好用
 *      第二：模糊查询怎么写？
 */
public class Test12 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtil.getConnection();
            // 获取预编译的数据库操作对象
            // 错误的写法
            /*
            String sql = "select age from stu where name like '_?%' ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"a");
            */

            String sql = "select name from stu where name like ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"_a%");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源2
            DBUtil.close(conn,ps,rs);
        }
    }
}
