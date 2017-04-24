package com.fusion.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			connection = DriverManager.getConnection(
					"jdbc:mysql://" + DEFAULT_ADDRESS + ":" + DEFAULT_PORT + "/" + DB_NAME, 
					USERNAME, 
					PASSWORD
			);
		} catch (SQLException e) {
			throw new DBHelperException("Failed to initialize the database connection.", e);
		}
	}
	
	/**
	 * Fetches the billing address given the selected input.
	 * @param 	cardNumber		the card number to use as a search term
	 * @return	address 		the address with the given card number, cannot return null
	 * @throws 	DBHelperException	thrown if there is an issue fetching the address or if no address is found
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
	 * @param 	cardNumber		the card number to use as a search term
	 * @return	address 		the address with the given card number, cannot return null
	 * @throws 	DBHelperException	thrown if there is an issue fetching the address or if no address is found
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
	 * @param 	id			the id of the category
	 * @return	category		category object
	 * @throws 	DBHelperException	thrown if there is an issue fetching the category or if no category is found
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
	
	/**
	 * Fetches contact info from db.
	 * @param	supplierid		the supplier ID to use for searching
	 * @return	ci			contact info object (contains e-mail, address, poc)
	 * @throws	DBHelperException	thrown if there is an issue fetching or contact info can't be found
	 */
	public ContactInfo getContact(char[] supplierid) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		ContactInfo ci = null;
		
		try {
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM contact_info WHERE supplier_id=" + new String(supplierid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + supplierid + "]");
			}
			ci = new ContactInfo(rs.getString(1), rs.getString(2), rs.getString(3));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return ci;
	}
	
	/**
	 * Fetches credit card info from db.
	 * @param 	userid			the user ID to use for searching
	 * @return 	creditCard		credit card object
	 * @throws 	DBHelperException	thrown if there's an issue fetching or the userid is absent in the db
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
	
	/**
	 * Fetches email address for specific user from db.
	 * @param	userid			the user ID used for searching the db
	 * @return 	<email> 		the email address of any user(s) with a matching user ID
	 * @throws	DBHelperException	thrown if there's an issue fetching or the userid is absent in the db
	 */
	public EmailAddress getEmailAddress(char[] userid) throws DBHelperException {
		
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
			String sql = "SELECT * FROM users WHERE reg_id=" + new String(userid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + userid + "]");
			}
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return rs.getString(2);
	}
	
	/**
	 * Fetches item rating for specific item from db.
	 * @param	itemid			the item ID used for searching the db
	 * @return 	ir	 		Item Rating object for item(s) with matching ID
	 * @throws	DBHelperException	thrown if there's an issue fetching or the userid is absent in the db
	 */
	public ItemRating getItemRating(char[] itemid) throws DBHelperException {
		Statement statement = null;
		ResultSet rs = null;
		ItemRating ir = null;
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM sale_items_rating WHERE rid=" + new String(itemid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			ir = new ItemRating();
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + itemid + "]");
			}
			ir.setRatingID(rs.getString(1));
			ir.setTimestamp(rs.getString(2));
			ir.setScore(rs.getString(3));
			ir.setDescription(rs.getString(4));
			ir.setComment(rs.getString(5));
			ir.setUserID(rs.getString(6));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return ir;
	}
	
	/**
	 * Fetches a user's phone number from the db.
	 * @param 	userid			the user ID used for searching the db
	 * @return 	number			PhoneNumber object corresponding to the userid paramater
	 * @throws 	DBHelperException	thrown if there's an issue fetching or the userid is absent in the db
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
	
	/**
	 * Fetches sale item from db.
	 * @param	itemid			item ID used to find item
	 * @return 	si 			sale item object
	 * @throws	DBHelperException 	thrown if there's an error fetching or the itemid is absent in the db
	 */	
	public SaleItem getSaleItem(char[] itemid) throws DBHelperException {
		Statement statement = null;
		ResultSet rs = null;
		SaleItem si = null;
		
		try {
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM sale_items WHERE id=" + new String(itemid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			si = new SaleItem();
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + itemid + "]");
			}
			
			si.setId(rs.getString(1));
			si.setName(rs.getString(2));
			si.setSellerId(rs.getString(3));
			si.setPrice(rs.getString(4));
			si.setReservePrice(rs.getString(5));
			si.setQuantity(rs.getString(6));
			si.setCategory(rs.getString(7));
			si.setDetailedDescriptionURL(rs.getString(8));
			si.setTypeOfSale(rs.getString(9));
			si.setDescription(rs.getString(10));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return si;
	}
	
	/**
	 * Fetches a sale transaction from db.
	 * @param	saleid			sale ID used to find transaction
	 * @return 	st			sale transaction object
	 * @throws	DBHelperException 	thrown if there's an error fetching or the saleid is absent in the db
	 */	
	public SaleTransaction getSaleTransaction(char[] saleid) throws DBHelperException {
		Statement statement = null;
		ResultSet rs = null;
		SaleTransaction st = null;
		
		try {
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM sales_transaction WHERE sale_id=" + new String(saleid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			st = new SaleTransaction();
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + saleid + "]");
			}
			
			st.setSaleID(rs.getString(1));
			st.setCreditCard(rs.getString(2));
			st.setStatus(rs.getString(3));
			st.setCompletionDate((short) rs.getInt(4), (short) rs.getInt(5));
			st.setSaleItem(rs.getString(5));
			st.setSalePrice(rs.getString(6));
			st.setShippingAddress(rs.getString(7));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return st;
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
