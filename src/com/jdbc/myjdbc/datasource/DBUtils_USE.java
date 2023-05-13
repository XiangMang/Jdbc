package com.jdbc.myjdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_USE {
    // 使用 apache-DBUtils 工具类 + Druid 完成对表的 crud 操作
    public void testQueryMany() throws SQLException { // 返回结果是多行的情况
        // 1. 得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用 DBUtils 类和接口, 先引入 DBUtils 相关的 jar
        // 3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4. 执行相关的方法, 返回 ArrayList 方法
        String sql = "SELECT * FROM jdbcTest.actor WHERE id >= ?";
    }
}
