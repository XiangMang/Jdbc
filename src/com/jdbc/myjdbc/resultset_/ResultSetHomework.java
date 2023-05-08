package com.jdbc.myjdbc.resultset_;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class ResultSetHomework {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\mysql.properties")));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

//        String sql = "CREATE TABLE test(" +
//                "id INT PRIMARY KEY ," +
//                "name INT)";
//        String sql1 = "INSERT INTO test (id, name) VALUES " +
//                "(1, 1)," +
//                "(2, 2)," +
//                "(3, 3)," +
//                "(4, 4)," +
//                "(5, 5);";
//        String sql2 = "UPDATE test SET name = 999 WHERE id = 1";
        String sql3 = "DELETE FROM test" +
                " WHERE id = 3";

//        int i = statement.executeUpdate(sql);
//        int ii = statement.executeUpdate(sql1);
//        int iii = statement.executeUpdate(sql2);
        int iiii = statement.executeUpdate(sql3);

        statement.close();
        connection.close();
    }
}
