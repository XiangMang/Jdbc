package com.jdbc.myjdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {
    @Test
    public void testDruid_() throws Exception {
        // 1. 加入 Druid.jar 包
        // 2. 加入配置文件 druid.properties, 将该文件添加到 src 目录
        // 3. 创建 Properties 对象, 读取配置文件
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\druid.properties")));
        // 4. 创建一个指定参数的 Druid 数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("成功连接");
        connection.close();
    }
}
