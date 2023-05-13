package com.jdbc.myjdbc.datasource;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtilsByDrudi_USE {
    @Test
    public void testDruid() {
        // 得到连接
        Connection connection = null;

        // 组织 sql
        String sql = "SELECT * FROM jdbcTest.actor WHERE id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 给占位符复制
            preparedStatement.setInt(1, 5);

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtilsByDruid.close(null, preparedStatement, connection);
        }
    }
}
