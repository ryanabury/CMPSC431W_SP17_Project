package com.fusion.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	// Database Address
	private static final String DEFAULT_ADDRESS = "localhost";
	private static final int DEFAULT_PORT = 3306;
	
	// Database Credentials
	private static final String USERNAME = "fusion";
	private static final String PASSWORD = "fusion_password";
	
	private String address;
	private int port;
	
	private Connection connection;
	
	public DBHelper() throws DBHelperException {
		this(DEFAULT_ADDRESS, DEFAULT_PORT);
	}
	
	public DBHelper(String address, int port) throws DBHelperException {
		try {
			connection = DriverManager.getConnection(
					DEFAULT_ADDRESS + ":" + DEFAULT_PORT, 
					USERNAME, 
					PASSWORD
			);
		} catch (SQLException e) {
			throw new DBHelperException("Failed to initialize the database connection.", e);
		}
	}
	
	public static class DBHelperException extends Exception {
		
		public DBHelperException() {
			super();
		}
		
		public DBHelperException(String message) {
			super(message);
		}
		
		public DBHelperException(String message, Throwable cause) {
			super(message, cause);
		}
		
	}

}
