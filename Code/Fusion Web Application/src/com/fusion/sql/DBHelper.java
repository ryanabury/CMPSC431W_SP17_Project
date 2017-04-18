package com.fusion.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.fusion.objects.*;

public class DBHelper {
	
	// Database Address
	private static final String DEFAULT_ADDRESS = "localhost";
	private static final int DEFAULT_PORT = 3306;
	
	// Database Credentials
	private static final String DB_NAME = "fusion";
	private static final String USERNAME = "fusion";
	private static final String PASSWORD = "fusion_pass";
	
	private String address;
	private int port;
	
	private Connection connection;
	
	public DBHelper() throws DBHelperException {
		this(DEFAULT_ADDRESS, DEFAULT_PORT);
	}
	
	public DBHelper(String address, int port) throws DBHelperException {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(
					"jdbc:mysql://" + DEFAULT_ADDRESS + ":" + DEFAULT_PORT + "/" + DB_NAME, 
					USERNAME, 
					PASSWORD
			);
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new DBHelperException("Failed to initialize the database connection.", e);
		}
	}
	
	/**
	 * Fetches the billing address given the selected input.
	 * @param cardNumber	the card number to use as a search term
	 * @return	the address with the given card number. cannot return null
	 * @throws DBHelperException	thrown if there is an issue fetching the address or if no address is found
	 */
	public Address getBillingAddress(char[] cardNumber) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		Address address = null;
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM billing_addr WHERE card_number=" + new String(cardNumber) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			address = new Address();
			if (!rs.next()) {
				throw new DBHelperException("No value found for card number [" + new String(cardNumber) + "]");
			}
			address.setStreetAddress(rs.getString(1));
			address.setCity(rs.getString(2));
			address.setState(rs.getString(3));
			address.setZipCode(rs.getString(4).getBytes());
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return address;
		
	}
	
	/**
	 * Fetches the billing address given the selected input.
	 * @param cardNumber	the card number to use as a search term
	 * @return	the address with the given card number. cannot return null
	 * @throws DBHelperException	thrown if there is an issue fetching the address or if no address is found
	 */
	public Address getShippingAddress(int saleID) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		Address address = null;
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM billing_addr WHERE sale_id=" + saleID + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			address = new Address();
			if (!rs.next()) {
				throw new DBHelperException("No value found for sale id [" + saleID + "]");
			}
			address.setStreetAddress(rs.getString(2));
			address.setCity(rs.getString(3));
			address.setState(rs.getString(4));
			address.setZipCode(rs.getString(5).getBytes());
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return address;
		
	}
	
	/**
	 * Fetches a category from the DB.
	 * @param id	the id of the category
	 * @return	the fetched category
	 * @throws DBHelperException	thrown if there is an issue fetching the category or if no category is found
	 */
	public Category getCategory(int id) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		Category category = null;
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM Categories WHERE id=" + id + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			category = new Category();
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + id + "]");
			}
			category.setId(id);
			category.setName(rs.getString(2));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return category;
		
	}
	
	public ContactInfo getContact(char[] supplierid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	/**
	 * Fetches credit card info from db.
	 * @param userid	the user ID to use for searching
	 * @return
	 * @throws DBHelperException
	 */
	public CreditCard getCreditCard(char[] userid) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		CreditCard creditCard = null;
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM credit_card WHERE reg_id=" + new String(userid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			creditCard = new CreditCard();
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + userid + "]");
			}
			creditCard.setCardNumber(rs.getString(1));
			creditCard.setType(rs.getString(2));
			creditCard.setCvv(rs.getString(3));
			creditCard.setDate((short) rs.getInt(4), (short) rs.getInt(5));
			creditCard.setFirstName(rs.getString(6));
			creditCard.setLastName(rs.getString(7));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return creditCard;
		
	}
	
	public EmailAddress getEmailAddress(char[] userid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public ItemRating getItemRating(char[] itemid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	/**
	 * Fetches a user's phone number.
	 * @param userid
	 * @return
	 * @throws DBHelperException
	 */
	public PhoneNumber getPhoneNumber(char[] userid) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		PhoneNumber number = null;
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT phone_num FROM Users WHERE reg_id=" 
					+ new String(userid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			if (!rs.next()) {
				throw new DBHelperException("No phone number found for user id [" + userid + "]");
			}
			number = new PhoneNumber(rs.getString(1));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return number;
		
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
	
	public ArrayList<SaleItem> getSaleItemsFromSearchTerms(String[] searchTerms) throws DBHelperException {
		
		ArrayList<SaleItem> itemList = new ArrayList<>();
		Statement statement = null;
		ResultSet rs = null;
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM sale_items WHERE ";
			for (int i = 0; i < searchTerms.length; i++) {
				sql += "\n\t(name LIKE '%" + searchTerms[i] + "%' )";
				if (i < searchTerms.length - 1) {
					sql += " OR ";
				}
			}
			sql += ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			while (rs.next()) {
				SaleItem saleItem = new SaleItem();
				saleItem.setId(rs.getInt(1));
				saleItem.setName(rs.getString(2));
				saleItem.setSellerID(rs.getInt(3));
				saleItem.setPrice(rs.getInt(4));
				saleItem.setReservePrice(rs.getInt(5));
				saleItem.setQuantity(rs.getInt(6));
				saleItem.setCategory(getCategory(rs.getInt(7)));
				saleItem.setDetailedDescriptionURL(rs.getString(8));
				saleItem.setTypeOfSale(rs.getInt(9));
				saleItem.setDescription(rs.getString(10));
				itemList.add(saleItem);
			}
			
			// Close first result set
			rs.close();
			
			// Execute Statement
			sql = "SELECT * FROM sale_items WHERE ";
			for (int i = 0; i < searchTerms.length; i++) {
				sql += "\n\t(description LIKE '%" + searchTerms[i] + "%' )";
				if (i < searchTerms.length - 1) {
					sql += " OR ";
				}
			}
			sql += ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			while (rs.next()) {
				SaleItem saleItem = new SaleItem();
				saleItem.setId(rs.getInt(1));
				saleItem.setName(rs.getString(2));
				saleItem.setSellerID(rs.getInt(3));
				saleItem.setPrice(rs.getInt(4));
				saleItem.setReservePrice(rs.getInt(5));
				saleItem.setQuantity(rs.getInt(6));
				saleItem.setCategory(getCategory(rs.getInt(7)));
				saleItem.setDetailedDescriptionURL(rs.getString(8));
				saleItem.setTypeOfSale(rs.getInt(9));
				saleItem.setDescription(rs.getString(10));
				itemList.add(saleItem);
			}
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return itemList;
		
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void closeQuietly(Statement s) {
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {}
		}
	}
	
	private static void closeQuietly(ResultSet r) {
		if (r != null) {
			try {
				r.close();
			} catch (SQLException e) {}
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
