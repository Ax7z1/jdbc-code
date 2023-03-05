package io.github.ax7z1.jdbc_Demo;

import java.sql.*;
import java.util.Scanner;

public class Test08 {
    public static void main(String[] args) {
        /*
        //用户在控制台输入desc就是降序，输入asc就是升序
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.println("请输入：");
        String keyWords = s.nextLine();

        // 执行SQL
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            String sql = "select name from stu order by age ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keyWords);
            rs = ps.executeQuery();
            //遍历结果集
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs !=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (ps !=null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (conn !=null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


         */

        //用户在控制台输入desc就是降序，输入asc就是升序
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.println("请输入：");
        String keyWords = s.nextLine();

        // 执行SQL
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            // 获取数据库操作对象
            stmt = conn.createStatement();
            // 执行SQL
            String sql = "select name from stu order by age "+ keyWords;
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs !=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (stmt !=null){
                try {
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (conn !=null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}
