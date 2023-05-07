package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 完成简单从操作
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 1. 注册驱动
        Driver driver = new Driver();

        // 2. 得到连接
        String url = "jdbc:mysql://bj-cynosdbmysql-grp-mumtqr5k.sql.tencentcdb.com:25688/jdbcTest";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "!Txl290017");

        Connection connect = driver.connect(url, properties);

        // 3. 执行sql
        String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '110')";
        // statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是 dml 语句, 返回的为形象的行数
        System.out.println(rows > 0 ? "YES" : "NO");

        // 4. 关闭连接资源
        statement.close();
        connect.close();
    }
}
