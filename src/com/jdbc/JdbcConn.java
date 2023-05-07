package com.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接mysql的五种方式
 */
public class JdbcConn {
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://bj-cynosdbmysql-grp-mumtqr5k.sql.tencentcdb.com:25688/jdbcTest";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "!Txl290017");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // 使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://bj-cynosdbmysql-grp-mumtqr5k.sql.tencentcdb.com:25688/jdbcTest";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "!Txl290017");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // 使用 DriverManager 替代 Diver 进行统一管理
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        // 创建 url 和 password
        String url = "jdbc:mysql://bj-cynosdbmysql-grp-mumtqr5k.sql.tencentcdb.com:25688/jdbcTest";
        String user = "root";
        String password = "!Txl290017";

        DriverManager.registerDriver(driver); // 注册 Driver 驱动
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        // 使用反射加载 Driver 类
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");

        // 创建 url 和 password
        String url = "jdbc:mysql://bj-cynosdbmysql-grp-mumtqr5k.sql.tencentcdb.com:25688/jdbcTest";
        String user = "root";
        String password = "!Txl290017";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        // 在 connect04 的基础上增加配置文件, 使得连接mysql更加灵活
        // 通过 Properties 对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src\\mysql.properties")));
        // 获取相关值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }
}
