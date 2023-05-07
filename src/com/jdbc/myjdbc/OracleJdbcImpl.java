package com.jdbc.myjdbc;

/**
 * 模拟oracle数据库实现
 */
public class OracleJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("获得oracle的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("实现增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭连接");
    }
}
