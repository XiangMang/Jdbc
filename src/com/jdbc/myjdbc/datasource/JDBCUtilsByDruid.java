package com.jdbc.myjdbc.datasource;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Stack;

/**
 * 基于 Druid 数据库连接池的工具类
 */
public class JDBCUtilsByDruid {
    private static DataSource dataSource;
    // 在静态代码块完成 dataSource 的初始化

    static {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get("src\\druid.properties")));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 编写 getConnection 方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 关闭连接(将连接放回到连接池)
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
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
