package com.jdbc.myjdbc.preparedstatement_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.utils.JDBCUtils;

public class PreparedStatementHomework_ {
    public static void main(String[] args) {

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

        String showAdmin = "SELECT * FROM jdbcTest.admin";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

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

            resultSet = preparedStatement.executeQuery(showAdmin);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                System.out.println(id + "\t" + username);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }

    }
}
