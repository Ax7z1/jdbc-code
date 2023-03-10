package io.github.ax7z1.jdbc_Demo;

import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * 这个程序负责修改被锁定的记录
 */
public class Test14 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "update stu set age = age * 100 where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"gai");
            int count = ps.executeUpdate();
            System.out.println(count);
            conn.commit();
        } catch (SQLException e) {
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }
    }
}
