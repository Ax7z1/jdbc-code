package io.github.ax7z1.jdbc_Demo;

import java.sql.*;
// 测试git
// 测试git  33
// hello git 4
// master test
// hot-fix test!
/*
    JDBC编程六步
 */
public class Test01 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Driver driver = new com.mysql.jdbc.Driver();   //多态，父类型引用指向子类型对象
            //  Driver driver = new oracle.jdbc.driver.OracleDriver(); // Oracle的驱动。
            DriverManager.registerDriver(driver);
            //2、获取连接
            /*
                url:统一资源定位符（网络中某个资源的绝对路径）
                https://www.baidu.com/ 这就是URL。
                URL包括哪几部分？
                    协议
                    IP
                    PORT
                    资源名

               http://14.215.177.38:80/index.html
                    http:// 通信协议
                    182.61.200.7 服务器IP地址
                    80 服务器上软件的端口
                    index.html 是服务器上某个资源名


               jdbc:mysql://127.0.0.1:3306/test
                    jdbc:mysql:// 协议
                    127.0.0.1 IP地址
                    3306 mysql数据库端口号
                    test 具体的的数据库实例名

               说明： localhost和127.0.0.1都是本机IP地址。

               什么是通信协议，有什么用？
                    通信协议是通信之前就提前定好的数据传送格式。
                    数据包具体怎么传数据，格式提前定好的。
                        你说话我能听懂，你说话我也能听懂，因为我们都遵循中国普通话协议。 你说家乡话，我肯定听不懂！
                     name=value&name=value&name=value

                    Oracle的URL：
                         jdbc:oracle:thin:@localhost:1521:orcl

             */
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            //Java.sql.Connection conn = new com.mysql.jdbc.JDBC4Connection(); 多态 ，类名即使改变了，改为获取Oracle数据库，也依然是用getConnection()方法获取连接对象！
            //数据库连接对象：com.mysql.jdbc.JDBC4Connection@5197848c
            System.out.println("数据库连接对象：" + conn);

            //3.获取数据库操作对象 (Statement专门执行sql语句的)
            stmt = conn.createStatement();

            //4.执行SQL语句
            String sql = "insert into stu(name,age) values('ceshi','23') ";
            //专门执行DML语句的（insert、update、delete）
            //返回值是“影响数据库中的记录条数”
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "保存成功" : "保存失败！");
            //5.处理查询结果集

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            //为了保证资源一定释放，在finally语句块中关闭资源
            //并且要遵循从小到大依次关闭
            //分别对其try..catch
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
