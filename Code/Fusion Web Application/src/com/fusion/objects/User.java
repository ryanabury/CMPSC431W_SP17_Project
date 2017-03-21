package com.fusion.objects;

import java.util.ArrayList;

/**
 * This class represents one user. This class contains the same data for a user
 * that would be found stored in the user table.
 * 
 * @author Ethan Raymond
 */
public class User {

	/**
	 * Specified how many characters long the user id is.
	 */
	public static final int REG_ID_SIZE = 20;

	private ArrayList<Address> addresses;
	private byte age;
	private double annualSalary;
	private ArrayList<CreditCard> creditCards;
	private String emailAddress;
	private String firstName;
	private char gender;
	private boolean isActive;
	private String lastName;
	private String password;
	private String phoneNumber;
	private char[] regId;
	private String username;
	
	/**
	 * Creates a default user. Use the setter methods for this class to fill in
	 * data.
	 */
	public User() {
		regId = new char[REG_ID_SIZE];
		emailAddress = "";
		isActive = false;
		username = "";
		password = "";
		firstName = "";
		lastName = "";
		age = 0;
		phoneNumber = "";
		gender = 'm';
		annualSalary = 0.0;
	}
	
	/**
	 * Adds a new address to the user's list of stored addresses.
	 */
	public void addAddress(Address address) {
		getAddresses().add(address);
	}
	
	/**
	 * Adds a new credit card for this user.
	 */
	public void addCreditCard(CreditCard creditCard) {
		creditCards.add(creditCard);
	}

	/**
	 * @return a list of the user's addresses.
	 */
	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @return the age of the user
	 */
	public byte getAge() {
		return age;
	}
	
	/**
	 * @return the annual salary of the user
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * @return the list of credit cards stored for this user
	 */
	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}

	/**
	 * @return the email address for this user.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return 'm' if this user is male, 'f' if this user is female.
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @return the user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the user's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the user ID
	 */
	public char[] getRegId() {
		return regId;
	}

	/**
	 * @return this user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return true if the user is active, false if the user is not active
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Removes and address from the user's list of stored addresses.
	 */
	public void removeAddress(Address address) {
		getAddresses().remove(address);
	}

	/**
	 * Removed a credit card from this user.
	 */
	public void removeCreditCard(CreditCard creditCard) {
		creditCards.remove(creditCard);
	}

	/**
	 * Sets the 'active' flag for this user.
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Sets a new age for the user.
	 */
	public void setAge(byte age) {
		this.age = age;
	}

	/**
	 * Sets a new annual salary of this user.
	 */
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	/**
	 * Sets a new email address.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Sets a new first name for the user.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the gender of this user
	 * 
	 * @param gender
	 *            only 'm' and 'f' are allowed. All else will be ignored.
	 */
	public void setGender(char gender) {
		if (gender != 'm' && gender != 'f') {
			return;
		}
		this.gender = gender;
	}

	/**
	 * Sets a new last name for the user.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets a new password for this user.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets a new phone number for the user.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Sets a new user ID.
	 */
	public void setRegId(char[] regId) {
		this.regId = regId;
	}

	/**
	 * Sets a new username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
