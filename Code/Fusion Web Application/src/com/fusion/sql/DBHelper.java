package com.fusion.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fusion.objects.*;

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
	
	public Address getAddress(char[] userid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public Category getCategory(String name) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public ContactInfo getContact(char[] supplierid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public CreditCard getCreditCard(char[] userid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public EmailAddress getEmailAddress(char[] userid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public ItemRating getItemRating(char[] itemid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public PhoneNumber getPhoneNumber(char[] supplierid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public SaleItem getSaleItem(char[] itemid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public SaleTransaction getSaleTransaction(char[] saleid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public Supplier getSupplier(char[] supplierid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public User getUser(char[] userid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
