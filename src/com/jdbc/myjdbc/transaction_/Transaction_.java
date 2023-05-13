package com.jdbc.myjdbc.transaction_;

import com.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 在 JDBC 中如何使用事务
 */
public class Transaction_ {
    @Test
    public void noTransaction() {
        // 得到连接
        Connection connection = null;

        // 组织 sql
        String sql = "UPDATE jdbcTest.account SET balance = balance - 100 WHERE id = 1";
        String sql1 = "UPDATE jdbcTest.account SET balance = balance + 100 WHERE id = 2";

        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection(); // 默认情况下, connection 默认自动提交
            connection.setAutoCommit(false); // 将connection 设置为不自动提交(开启了事务)
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            System.out.println("执行异常, 撤销执行的sql");
            try {
                connection.rollback();
                // 进行回滚操作, 即撤销执行的 sql
                // 默认回滚到事务开始的状态
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
