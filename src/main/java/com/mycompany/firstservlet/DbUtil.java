package com.mycompany.firstservlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                /*
                    Properties prop = new Properties();
                    InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                    prop.load(inputStream);
                */
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/userdb";
                String user = "admin";
                String password = "test";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}