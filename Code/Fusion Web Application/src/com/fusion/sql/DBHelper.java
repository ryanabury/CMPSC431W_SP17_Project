package com.fusion.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.fusion.objects.*;

public class DBHelper {
	
	// Database Address
	private static final String DEFAULT_ADDRESS = "localhost";
	private static final int DEFAULT_PORT = 3306;
	
	// Database Credentials
	private static final String DB_NAME = "fusion";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "sentence429&pattern&yes&";
	
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
		} catch (SQLException e) {
			throw new DBHelperException("Failed to initialize the database connection.", e);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
				throw new DBHelperException("No value found for id [" + String.valueOf(supplierid) + "]");
			}
			ci = new ContactInfo(new EmailAddress("test", "yahoo.com"), new Address(), ContactInfo.PointOfContact.EMAIL);
			
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
	
	public EmailAddress getEmailAddress(char[] userid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	public ItemRating getItemRating(char[] itemid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	/**
	 * Fetches a user's phone number.
	 * @param 	userid
	 * @return
	 * @throws 	DBHelperException
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
			String sql = "SELECT phone_num FROM users WHERE reg_id=" 
					+ new String(userid) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			if (!rs.next()) {
				throw new DBHelperException("No phone number found for user id [" + userid.toString() + "]");
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
	 * Returns a list of transactions that ocurred in the last week of sales.
	 * @return l	list of Transactions to be printed in a table format. 
	 */
	public ArrayList<SaleTransaction> getTransactionReport() {
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SaleTransaction> l = new ArrayList<SaleTransaction>();
		
		try {
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			statement = connection.createStatement();
			
			String sql = "SELECT * FROM sales_transaction WHERE completion_date >= curdate() - INTERVAL 1 WEEK";
			rs = statement.executeQuery(sql);
			System.out.println("Received Transaction Report");
			while(rs.next()) {
				l.add(new SaleTransaction(rs.getInt("sale_id"), new CreditCard(), rs.getString("status"), 
						rs.getTimestamp("completion_date"), getSaleItem(rs.getString("item_id").toCharArray()),
						rs.getInt("quantity"), rs.getInt("sale_price"), new Address()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;		
	}

	/**
	 * Returnes a list of users for the telemarketer report
	 * @return l	list of Users to be printed in a table report
	 */
	public ArrayList<User> getTelemarketerReport() {
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<User> l = new ArrayList<User>();
		
		try {
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed");
			}
			
			statement = connection.createStatement();
			
			boolean active;
			String sql = "SELECT * FROM users";
			rs = statement.executeQuery(sql);
			System.out.println("Received Telemarketer Report");
			while(rs.next()) {
				if (rs.getInt("active") == 1)
					active = true;
				else
					active = false;
				l.add(new User(Integer.toString(rs.getInt("reg_id")).toCharArray(), rs.getString("email"),
						active, rs.getString("username"), rs.getString("password"),
						rs.getString("first_name"), rs.getString("last_name"), (byte) rs.getInt("age"), 
						rs.getString("phone_num"), rs.getString("gender").charAt(0), rs.getFloat("annual_salary")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	/**
	 * Returns a list of Sales Items from a particular seller
	 * @return siL 	list of sales items to be displayed on supplier page
	 */
	public ArrayList<SaleItem> getSaleItemBySeller(char[] seller) throws DBHelperException {
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SaleItem> siL = new ArrayList<SaleItem>();
		
		try{
			
			//Check for Open Connection
			if (connection.isClosed()){
				throw new DBHelperException("The connection has been closed.");
			}
			
			//Create Statement
			statement = connection.createStatement();
			
			//Execute Statement
			String sql = "SELECT * FROM sale_items WHERE seller=" + new String(seller) + ";";
			rs = statement.executeQuery(sql);
			
			//Assemble Data Structure
			while(rs.next()){
				siL.add(new SaleItem(rs.getInt("id"),rs.getString("name"),rs.getInt("seller"),
						rs.getInt("price"),rs.getInt("reservePrice"), rs.getInt("quantity"),
						getCategory(Integer.parseInt(rs.getString("category"))),rs.getString("detailedDescriptionURL"),
						SaleItem.TypeOfSale.fromInt(Integer.parseInt(rs.getString("typeOfSale"))),
						rs.getString("description")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return siL;
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
				throw new DBHelperException("No value found for id [" + String.valueOf(itemid) + "]");
			}
			
			si.setId(Integer.parseInt(rs.getString(1)));
			si.setName(rs.getString(2));
			si.setSellerID(Integer.parseInt(rs.getString(3)));
			si.setPrice(Integer.parseInt(rs.getString(4)));
			si.setReservePrice(Integer.parseInt(rs.getString(5)));
			si.setQuantity(Integer.parseInt(rs.getString(6)));
			si.setCategory(getCategory(Integer.parseInt(rs.getString(7))));
			si.setDetailedDescriptionURL(rs.getString(8));
			si.setTypeOfSale(SaleItem.TypeOfSale.fromInt(Integer.parseInt(rs.getString(9))));
			si.setDescription(rs.getString(10));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return si;
	}
	
	public SaleTransaction getSaleTransaction(char[] saleid) throws DBHelperException {
		throw new RuntimeException("Not yet implemented...");
	}
	
	
	/**
	 * Fetches supplier from db.
	 * @param	supplierid			supplier ID to find supplier
	 * @return 	supplier 		supplier object
	 * @throws	DBHelperException 	thrown if there's an error fetching or the supplierid is absent in the db
	 */	
	public Supplier getSupplier(char[] supplierid) throws DBHelperException {
		Statement statement = null;
		ResultSet rs = null;
		Supplier supplier = null;
		try{
			//Check for Open Connection
			if(connection.isClosed()) {
				throw new DBHelperException("The connection has been closed");
			}
			
			//Create statement
			statement = connection.createStatement();
			
			//Execute statement
			String sql = "SELECT * FROM suppliers WHERE supplier_id=" + new String(supplierid) + ";";
			rs = statement.executeQuery(sql);
			
			supplier = new Supplier();
			if (!rs.next()){
				throw new DBHelperException("No value found for id [" + String.valueOf(supplierid) + "]");
			}
			
			supplier.setSupplierID(rs.getInt(1));
			supplier.setCompanyName(rs.getString(2));
			supplier.setPassword(rs.getString(3));
			supplier.setCategory(rs.getString(4));
			supplier.setYearlyRevenue(rs.getInt(5));
			supplier.setUrlExtention(rs.getString(6));
			supplier.setBannerImg(rs.getString(7));
			supplier.setDescription(rs.getString(8));
			
		}catch(SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		}
		finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return supplier;
	}
	
	public User getUser(char[] userid) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		User user = null;
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
			user= new User();
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + new String(userid) + "]");
			}
			user.setRegId(rs.getString(1).toCharArray());
			user.setEmailAddress(rs.getString(2));
			user.setActive(rs.getBoolean(3));
			user.setUsername(rs.getString(4));
			user.setFirstName(rs.getString(5));
			user.setLastName(rs.getString(6));
			user.setPassword(rs.getString(7));
			user.setAge(rs.getByte(8));
			user.setPhoneNumber(rs.getString(9));
			user.setGender(rs.getString(10));
			user.setAnnualSalary(rs.getDouble(11));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return user;
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
