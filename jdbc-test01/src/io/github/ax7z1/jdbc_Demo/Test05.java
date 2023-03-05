package io.github.ax7z1.jdbc_Demo;/*
    处理查询结果集（遍历结果集。）
 */
import java.sql.*;
public class Test05 {
    public static void main(String []args){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            //3、获取数据库操作对象
            stmt = conn.createStatement();
            //4、执行SQL语句
            String sql = "select name as 'a',age from stu";
            //  int executeUpdate(insert/delete/update)
            //  ResultSet executeQuery(select)
            rs = stmt.executeQuery(sql);//专门执行DQL语句的方法。
            //5、处理查询结果集
            /*
            boolean flag1 = rs.next();  //true
            if(flag1){
                // 光标指向的行有数据
                // 取数据
                // getString() 方法的特点是：不管数据库中的数据类型是什么，都已String的类型取出。
                String name = rs.getString(1); // JDBC中所有下标从1开始。不是0开始
                String age = rs.getString(2);
                System.out.println(name + "," + "age" + age);
            }

            boolean flag2 = rs.next();  //true
            if(flag2){
                // 以下程序的1 2 3说的是第几列。
                String name = rs.getString(1); // JDBC中所有下标从1开始。不是0开始
                String age = rs.getString(2);
                System.out.println(name + "," + "age" + age);
            }
            */
            while(rs.next()){
/*                String name = rs.getString(1);
                String age = rs.getString(2);
                System.out.println(name + "," + "age" + age);*/

                /*
                // 这个不是以列的下标获取，以列的名字获取
                String name = rs.getString("a"); //重点注意：列名称不是表中的列名称，是查询结果集的列名称。
                String age = rs.getString("age");
                System.out.println(name + "," + age);
                */
                // 除了可以以String类型取出之外，还可以以特定的类型取出。
                String name = rs.getString("a");
                int age = rs.getInt("age");
                System.out.println(name + "," + (age+1000));

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            //6、释放资源
            if(rs != null){
                try{
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try{
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
