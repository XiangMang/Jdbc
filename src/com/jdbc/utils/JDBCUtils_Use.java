package com.jdbc.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示如何使用 JDBCUtils 工具类
 * 完成 dml 和 select
 */
public class JDBCUtils_Use {
    @Test
    public void testDML() {
        // 得到连接
        Connection connection = null;

        // 组织 sql
        String sql = "UPDATE jdbcTest.test SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 给占位符复制
            preparedStatement.setInt(1, 888);
            preparedStatement.setInt(2, 5);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
