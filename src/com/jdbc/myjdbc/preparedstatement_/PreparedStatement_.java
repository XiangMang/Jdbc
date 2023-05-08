package com.jdbc.myjdbc.preparedstatement_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示 PreparedStatement 使用
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入管理员的名字:");
        String admin_name = scanner.nextLine();
        System.out.println("请输入管理员的密码:");
        String admin_pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\mysql.properties")));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "SELECT id, name FROM jdbcTest.test WHERE id = ? AND name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
