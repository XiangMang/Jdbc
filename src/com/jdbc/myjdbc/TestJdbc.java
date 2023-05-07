package com.jdbc.myjdbc;

public class TestJdbc {
    public static void main(String[] args) {
        JdbcInterface jdbcInterface = new MysqlJbdcImpl();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
