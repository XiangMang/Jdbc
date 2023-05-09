package com.jdbc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.Stack;

/**
 * 工具类
 * 完成 mysql 的连接和关闭资源
 */
public class JDBCUtils {
    // 定义相关属性
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    // 初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get("src\\mysql.properties")));
            // 读取相关的属性
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
            // 将编译异常转成运行异常
            // 调用者可以捕获该异常, 也可以默认处理该异常
        }
    }

    // 连接数据库, 返回 Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭相关资源
    public static void close(ResultSet set, Statement statement, Connection connection) {
        // 如果需要关闭资源, 就传入对象, 否则传入 null
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
