package com.jdbc.myjdbc.preparedstatement_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.utils.JDBCUtils;

public class PreparedStatementHomework_ {
    public static void main(String[] args) {
        Connection connection = null;

        String createTable = "CREATE TABLE admin (" +
                "id INT PRIMARY KEY," +
                "username CHAR(8))";

        String insertValues = "INSERT INTO jdbcTest.admin VALUES" +
                "(1, '1')," +
                "(2, '2')," +
                "(3, '3')," +
                "(4, '4')," +
                "(5, '5')";

        String updateUsername = "UPDATE jdbcTest.admin SET username = 'king' WHERE id = 3";

        String delete = "DELETE FROM jdbcTest.admin WHERE id = 2";

        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(createTable);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(insertValues);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(updateUsername);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }

    }
}
