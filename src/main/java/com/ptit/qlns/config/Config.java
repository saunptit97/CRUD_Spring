package com.ptit.qlns.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
	public static final String HOST_NAME = "localhost";
	
	public static final String DATABASE_NAME = "testdb";
	
	public static final String USERNAME = "root";
	
	public static final String PASSWORD = "";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	 
            String connectionURL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=utf-8";

            Connection conn = DriverManager.getConnection(connectionURL, USERNAME,
            		PASSWORD);
            return conn;	    
        }catch(Exception e) {
        	System.out.println("SQL exception");
        }
		return null;
	 }
}
