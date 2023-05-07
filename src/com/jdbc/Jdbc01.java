package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.SQLException;

/**
 * 完成简单从操作
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 1. 注册驱动
        Driver driver = new Driver();

        // 2. 得到连接
        String url = ""
        // 3. 执行sql
        // 4. 关闭连接资源
    }
}
