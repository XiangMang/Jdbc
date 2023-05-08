package com.jdbc.myjdbc.resultset_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * 演示查询语句
 * 返回 ResultSet, 并取出结果
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // 获取配置文件
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\mysql.properties")));
        // 获取相关值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // 注册驱动
        Class<?> aClass = Class.forName(driver);
        // 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 得到 Statement
        Statement statement = connection.createStatement();
        // 组织 SQL
        String sql = "SELECT id, name, sex, borndate FROM actor";
        ResultSet resultSet = statement.executeQuery(sql);
        // 使用 while 循环取出数据
        while (resultSet.next()) { // 让光标向后移动, 如果没有更多行, 返回 false
            int id = resultSet.getInt(1);// 获取该行第一列数据
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
