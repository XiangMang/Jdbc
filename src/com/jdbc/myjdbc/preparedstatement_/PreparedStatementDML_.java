package com.jdbc.myjdbc.preparedstatement_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementDML_ {
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

        String sql = "UPDATE jdbcTest.test SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admin_pwd);
        preparedStatement.setString(2, admin_name);

        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");

        preparedStatement.close();
        connection.close();

    }
}
