package com.jdbc.batch_;

import com.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 演示 java 的批处理
 */
public class Batch_ {
    @Test
    // 传统方法添加五千条数据
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "INSERT INTO jdbcTest.admin2 VALUES (NULL, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行");
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            preparedStatement.setString(1, "Ton" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.executeUpdate();
        }

        long end = System.currentTimeMillis();
        System.out.println("执行时间 = " + (end - start));

        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    // 传统方法添加五千条数据
    public void Batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "INSERT INTO jdbcTest.admin2 VALUES (NULL, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行");
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            preparedStatement.setString(1, "Ton" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.addBatch();
            if ((i + 1) % 100 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("执行时间 = " + (end - start));

        JDBCUtils.close(null, preparedStatement, connection);
    }
}


//执行时间 = 38881
//执行时间 = 39592

//执行时间 = 823
//执行时间 = 772