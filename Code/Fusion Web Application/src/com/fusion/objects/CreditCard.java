package com.fusion.objects;

import java.sql.Date;

/**
 * This represents one credit card.
 * @author Ethan Raymond
 */
public class CreditCard {

	public static final int CARD_NUMBER_SIZE = 16;
	public static final int CVV_SIZE = 3;
	
	private Address billingAddress;
	private byte[] cardNumber;
	private byte[] cvv;
	private Date date; // We might want to change this to something simpler to use.
	private String firstName;
	private String lastName;
	private String type;
	
	/**
	 * Sets the default values.
	 */
	public CreditCard() {
		cardNumber = new byte[CARD_NUMBER_SIZE];
		type = "";
		cvv = new byte[CVV_SIZE];
		date = new Date(System.currentTimeMillis());
		firstName = "";
		lastName = "";
		billingAddress = new Address();
	}

	/**
	 * @return the billing address attached to this card.
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @return the 16 digit credit card number
	 */
	public byte[] getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return the three digit cvv
	 */
	public byte[] getCvv() {
		return cvv;
	}

	/**
	 * @return the expiration date for this card.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the card owner's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the card owner's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the type of credit card
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets a new billing address for this card.
	 * @param billingAddress
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * Sets a new card number. This has to be exactly 
	 * 16 digits and each digit must be between 0 
	 * and 9 or else a runtime exception will be thrown.
	 */
	public void setCardNumber(byte[] cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Sets a new three digit cvv for this card.
	 * @param cvv
	 */
	public void setCvv(byte[] cvv) {
		this.cvv = cvv;
	}

	/**
	 * Sets a new expiration date for this card.
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Sets a new first name of the card owner
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets a new last name of the card owner
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets a new type for this card.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
