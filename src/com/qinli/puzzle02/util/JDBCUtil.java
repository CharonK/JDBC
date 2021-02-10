package com.qinli.puzzle02.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author Cambria
 * @creat 2021/2/7 20:58
 */
public class JDBCUtil {

    public static Connection getConnection(){
        //Connection conn = null;
        try {
             return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC"
                    ,"root","65535Lel..");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
