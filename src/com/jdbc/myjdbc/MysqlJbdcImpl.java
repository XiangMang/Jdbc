package com.jdbc.myjdbc;

public class MysqlJbdcImpl implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("获得连接");;
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成MySQL的增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭连接");
    }
}
