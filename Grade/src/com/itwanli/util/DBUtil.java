package com.itwanli.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    // 需要把常规参数封装给客户，客户可以参与直接调整服务器的事情：写成设置；
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;

    private static String initialSize;
    private static String maxIdle;
    private static String minIdle;
    private static String maxActive;
    private static String maxWait;

    private static Properties properties = new Properties();    // 初始化连接池配置文件
    private static BasicDataSource basicDataSource = new BasicDataSource();

    /**
     * 获取db.properties里面的参数数据
     */
    static{     // 自己加载,静态方法
        try {
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.root");
            pwd = properties.getProperty("jdbc.pwd");

            // 设置数据库连接池
            basicDataSource.setDriverClassName(driver);
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(user);
            basicDataSource.setPassword(pwd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConn(){
        Connection conn = null;
        // 上次的low
        try {
            conn = basicDataSource.getConnection();
            System.out.println("数据库连接成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        getConn();
    }

    public static void closeConn(ResultSet rs, PreparedStatement pstm, Connection conn) throws Exception {
        if(rs!=null){
            rs.close();
        }
        if(pstm!=null){
            pstm.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
}
