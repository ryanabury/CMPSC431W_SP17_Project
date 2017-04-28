package com.fusion.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fusion.objects.*;
import com.fusion.objects.SaleItem.TypeOfSale;

public class DBHelper {
	
	// Database Address
	private static final String DEFAULT_ADDRESS = "localhost";
	private static final int DEFAULT_PORT = 3306;
	
	// Database Credentials
	private static final String DB_NAME = "fusion";
	private static final String USERNAME = "fusion";
	private static final String PASSWORD = "fusion_pass";
	
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
			address.setZipCode(Integer.parseInt(rs.getString(4)));
			
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
			address.setZipCode(Integer.parseInt(rs.getString(5)));
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return address;
		
	}
	
	public int checkLogin(String username, String password) throws DBHelperException {
		
		java.sql.PreparedStatement pst = null;
		ResultSet rs = null;
		
		try{
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			
			if(!rs.next()){
				pst.close();
				rs.close();
				throw new DBHelper.DBHelperException("No such username [" + username + "]");
			}else{
				pst.close();
				rs.close();
				return 0;
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return 1;
	}
	
	/**
	 * Creates a new user and enters it into the database
	 * @return	0 on success, 1 on failure	
	 * @throws 	DBHelperException	thrown if there is an issue entering data into db
	 */
	public int setCreateUser(String first_name,String last_name,String username,String email,String password, String age, String phone_num,String gender, String annual_salary) throws DBHelperException {
		
		java.sql.PreparedStatement pst = null;
		ResultSet rs = null;
		
		try{
			//Check for Open Connection
			if (connection.isClosed()){
				throw new DBHelperException("The connection has been closed.");
			}
			
			String sql = "Select U1.reg_id FROM users U1 WHERE U1.reg_id >= ALL (SELECT U2.reg_id FROM fusion.users U2)";
			
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			
			int reg_id = 0;
			int updateQuery = 0;
			
			while(rs.next()){
				reg_id = rs.getInt("reg_id") + 1;
			}
			
			pst.close();
			rs.close();
			
			pst = null;
			rs = null;
			
			if(email != null && username != null && first_name != null && last_name != null && password != null && age != null && phone_num != null && gender != null && annual_salary != null){
				sql = "INSERT INTO users (reg_id, email, active, username, first_name, last_name, password, age, phone_num, gender, annual_salary) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				
				pst = connection.prepareStatement(sql);
				pst.setInt(1,reg_id);
				pst.setString(2,email);
				pst.setInt(3,1);
				pst.setString(4,username);
				pst.setString(5,first_name);
				pst.setString(6,last_name);
				pst.setString(7,password);
				pst.setString(8,age);
				pst.setString(9,phone_num);
				pst.setString(10,gender);
				pst.setString(11,annual_salary);
				updateQuery = pst.executeUpdate();
				
				if(updateQuery == 0){
					throw new DBHelperException("Unable to create your Fusion account");	
				}
				pst.close();
				return 0;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return 1;
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
	public CreditCard getCreditCard(char[] userid, char[] card_number) throws DBHelperException {
		
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
			String sql = "SELECT * FROM credit_card WHERE reg_id=" + new String(userid) + " AND card_number = " + new String(card_number) + ";";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			creditCard = new CreditCard();
			if (!rs.next()) {
				throw new DBHelperException("No value found for id [" + userid.toString() + "]");
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
	 * Returns a list of Sales Items from a particular category and all of it's children.
	 * @return siL 	list of sales items
	 */
	public ArrayList<SaleItem> getSaleItemByCategory(Category category) throws DBHelperException {
		
		getCategoryTree(category);
		ArrayList<Integer> IDList = new ArrayList<>();
		compileCategoryList(IDList, category);
		
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
			String sql = "SELECT * FROM sale_items WHERE (";
			for (int i = 0; i < IDList.size(); i++) {
				sql += "category=" + IDList.get(i);
				if (i < IDList.size() - 1) {
					sql += " OR ";
				}
			}
			sql += ");";
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
	
	/**
	 * Fetches all sale items from db.
	 * @return 	array of sale item objects
	 * @throws	DBHelperException
	 */	
	public ArrayList<SaleItem> getAllSaleItems() throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SaleItem> saleItems = new ArrayList<>();
		
		try {
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM sale_items;";
			rs = statement.executeQuery(sql);
			
			// Assemble Data Structure
			while (rs.next()) {
				SaleItem si = new SaleItem();
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
				saleItems.add(si);
			}
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return saleItems;
		
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
				throw new DBHelperException("No value found for reg_id [" + new String(userid) + "]");
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
	
	public String getUserID(String username, String password) throws DBHelperException {
			
		Statement statement = null;
		ResultSet rs = null;
		String UserID = new String();
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT reg_id FROM users WHERE username='" + username + "' AND password='" + password + "';";
			rs = statement.executeQuery(sql);
			
			// Get UserID
			if (!rs.next()) {
				System.out.println("No reg_id matches [" + username + ", " + password + "]");
			} else{
				UserID = rs.getString(1);
			}
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		return UserID;
	}
	
	/**
	 * Performs a search on all of the items in the DB. If you wanted to perform a search of the 
	 * string "samsung phone" then you would input an array that looks like ["samsung", "phone"].
	 * 
	 * @param searchTerms	this is a list of strings that will be used as the terms of the search
	 * @return	A list of items returned by the search.
	 * @throws DBHelperException	when something goes wrong
	 */
	public SaleItem[] getSaleItemsFromSearchTerms(String[] searchTerms) throws DBHelperException {
		
		if (searchTerms == null) {
			return new SaleItem[0];
		}
		if (searchTerms.length == 0) {
			return new SaleItem[0];
		}
		
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
			sql += " OR ";
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
				saleItem.setTypeOfSale(TypeOfSale.fromInt(rs.getInt(9)));
				saleItem.setDescription(rs.getString(10));
				itemList.add(saleItem);
			}
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		SaleItem[] saleItems = new SaleItem[itemList.size()];
		itemList.toArray(saleItems);
		return saleItems;
		
	}
	
	public int setNewSalesItem(String name, String seller, String price, String reservePrice, String quantity, String category, String detailedDescriptionURL, String typeOfSale, String description) throws DBHelperException{
		
		java.sql.PreparedStatement pst = null;
		ResultSet rs = null;
		
		try{
			if(connection.isClosed()){
				throw new DBHelperException("The connection has been closed.");
			}
			
			String sql = "SELECT SI1.id FROM sale_items SI1 WHERE SI1.id >= ALL (SELECT SI2.id FROM sale_items SI2)";
			
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			
			int id = 0;
			int updateQuery = 0;
			
			while(rs.next()){
				id = Integer.parseInt(rs.getString("id")) + 1;
			}
			
			pst.close();
			rs.close();
			
			pst = null;
			rs = null;
			
			if(name != null && seller != null && price != null && reservePrice != null && quantity != null && category != null && detailedDescriptionURL != null && typeOfSale != null && description != null){
				sql = "INSERT INTO sale_items (id,name,seller,price,reservePrice,quantity,category,detailedDescriptionURL,typeOfSale,description) VALUES (?,?,?,?,?,?,?,?,?,?);";
						
				pst = connection.prepareStatement(sql);
				pst.setInt(1,id);
				pst.setString(2,name);
				pst.setString(3, seller);
				pst.setString(4, price);
				pst.setString(5, reservePrice);
				pst.setString(6, quantity);
				pst.setString(7, category);
				pst.setString(8, detailedDescriptionURL);
				pst.setString(9, typeOfSale);
				pst.setString(10, description);
				updateQuery = pst.executeUpdate();
				
				if(updateQuery == 0){
					throw new DBHelperException("Unable to add item.");	
				}
				pst.close();
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 1;
}
	
	/**
	 * Assembles a tree of categories from those stored in the DB. The category returned is 
	 * a dummy category called "ROOT" which contains all of the top level categories as 
	 * children.
	 * @throws DBHelperException
	 */
	public Category getCategoryTree() throws DBHelperException {
		return getCategoryTree(null);
	}
	
	private Category getCategoryTree(Category parent) throws DBHelperException {
		
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<Category> children = new ArrayList<>();
		try {
			
			// Check for Open Connection
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has been closed.");
			}
			
			// Create Statement
			statement = connection.createStatement();
			
			// Execute Statement
			String sql = "SELECT * FROM Categories ";
			if (parent == null) {
				sql += "WHERE parentID=0;";
			} else {
				sql += "WHERE parentID=" + parent.getId() + ";";
			}
			rs = statement.executeQuery(sql);
			
			// Assemble List
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				children.add(c);
			}
			
		} catch (SQLException e) {
			throw new DBHelperException("Encountered an error.", e);
		} finally {
			closeQuietly(statement);
			closeQuietly(rs);
		}
		
		for (int i = 0; i < children.size(); i++) {
			getCategoryTree(children.get(i));
		}
		
		if (parent == null) {
			Category root = new Category();
			root.setId(0);
			root.setChildren(children);
			root.setParent(null);
			root.setName("ROOT");
			return root;
		} else {
			if (children.size() > 0){
				parent.setChildren(children);
			}
			return parent;
		}
	}
		
	public void submitTransaction(SaleTransaction transaction, User user) throws DBHelperException{
		java.sql.PreparedStatement p = null;
		Statement s = null;
		String sql;
		ResultSet rs;
		
		try {
			
			if (connection.isClosed()) {
				throw new DBHelperException("The connection has closed");
			}
			
			// Create/Update Credit Card information
			
			CreditCard cc = transaction.getCreditCard();
			int n;
			
			try {
				getCreditCard(user.getRegId(), cc.getCardNumber().toCharArray());
				System.out.println("Found Credit Card");
				// If it did not throw an exception, the card already exists!
			} catch (Exception e) {
				// Create the new card
				
				sql = "INSERT INTO credit_card(card_number, type, cvv, exp_date_month, exp_date_year, first_name, last_name, reg_id) " + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				
				p = connection.prepareStatement(sql);
				p.setString(1, cc.getCardNumber());
				p.setString(2, cc.getType());
				p.setInt(3, Integer.parseInt(cc.getCvv()));
				p.setInt(4, cc.getDate()[0]);
				p.setInt(5, cc.getDate()[1]);
				p.setString(6, cc.getFirstName());
				p.setString(7, cc.getLastName());
				p.setInt(8, Integer.parseInt(new String(user.getRegId())));
				
				n = p.executeUpdate();
				
				if (n > 0) { System.out.println("Successfully added Credit Card"); }
				else { System.out.println("Failed to add Credit Card"); }
			}
			
			// TODO: Create/Update Billing Address
			
			// ** May not actually be necessary
			
			// Submit transaction
			
			// Find new ID
			s = connection.createStatement();
			
			sql = "SELECT MAX(sale_id) as max_sale_id FROM sales_transaction";
			
			rs = s.executeQuery(sql);
			
			if(!rs.next()) { n = 0; }
			else { n = rs.getInt("max_sale_id") + 1; }
			
			// Actually Submit Transaction			
			sql = "INSERT INTO sales_transaction(sale_id, credit_card, status, completion_date, item_id, quantity, sale_price) " + 
			"VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			/* IF NO ONE IS LOGGED IN TO BUY AN ITEM, WE HAVE A PROBLEM */
		
			p = connection.prepareStatement(sql);
			p.setInt(1, n); // MAX(ID) + 1 to create unique ID
			p.setString(2, transaction.getCreditCard().getCardNumber());
			p.setString(3, transaction.getStatus());
			p.setTimestamp(4, transaction.getCompletionDate());
			p.setInt(5, transaction.getSaleItem().getId());
			p.setInt(6, transaction.getQuantity());
			p.setInt(7, transaction.getSalePrice());
			
			n = p.executeUpdate();
			
			// TODO: Create Credit Card Record
			
			// TODO: Create Address record
			
			if (n > 0) {
				System.out.println("Successfully Completed Transaction");
			}
			else {
				System.err.println("Error Processing Transaction");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBHelperException("Encountered an error submitting transaction. ", e);
		}

	}
	
	public ArrayList<SaleItem> getUserPurchases(char[] userID) throws DBHelperException {
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<SaleItem> siL = new ArrayList<SaleItem>();
		
		try {
			
			//Check for open connection
			if(connection.isClosed()){
				throw new DBHelperException("The connection has been closed.");
			}
			
			String card_number = "";
			
			//Create Statement
			statement = connection.createStatement();
			
			//Execute statement
			String sql = "SELECT card_number FROM credit_card WHERE reg_id =" + new String(userID) + ";";
			rs = statement.executeQuery(sql);
			
			if (!rs.next()){
				System.out.println("The user does not have a credit card in the system.");
			} else {
				card_number = rs.getString("card_number");
			}
			
			statement.close();
			rs.close();
			
			statement = null;
			rs = null;
			
			ArrayList<char[]> itemIDs = new ArrayList<char[]>();
			
			if (card_number != null){
				statement = connection.createStatement();
				
				sql = "SELECT item_id FROM sales_transaction WHERE credit_card =" + card_number + ";";
				rs = statement.executeQuery(sql);
				
				while(rs.next()) {
					itemIDs.add(rs.getString("item_id").toCharArray());
				}
				
				statement.close();
				rs.close();
				
				statement = null;
				rs = null;
				
				int i = 0;
				
				for(i = 0; i < itemIDs.size(); i++){
					statement = connection.createStatement();
					
					sql = "SELECT * FROM sale_items WHERE id=" + new String(itemIDs.get(i)) + ";";
					rs = statement.executeQuery(sql);
					
					while(rs.next()){
						siL.add(new SaleItem(rs.getInt("id"),rs.getString("name"),rs.getInt("seller"),
								rs.getInt("price"),rs.getInt("reservePrice"), rs.getInt("quantity"),
								getCategory(Integer.parseInt(rs.getString("category"))),rs.getString("detailedDescriptionURL"),
								SaleItem.TypeOfSale.fromInt(Integer.parseInt(rs.getString("typeOfSale"))),
								rs.getString("description")));
					}
					
					statement.close();
					rs.close();
					
					statement = null;
					rs = null;
				}
			} else {
				System.out.println("Error with credit card value.");
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return siL;
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
	
	private void compileCategoryList(ArrayList<Integer> IDlist, Category root) {
		
		if (root != null) {
			IDlist.add(root.getId());
		}
		
		for (int i = 0; i < root.getChildren().size(); i++) {
			compileCategoryList(IDlist, root.getChildren().get(i));
		}
		
	}
	
	public static class DBHelperException extends Exception {
		
		private static final long serialVersionUID = 1L;

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
