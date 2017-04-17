package com.fusion.objects;

/**
 * This represents one credit card.
 * @author Ethan Raymond
 */
public class CreditCard {

	public static final int CARD_NUMBER_SIZE = 16;
	public static final int CVV_SIZE = 3;
	
	private Address billingAddress;
	private String cardNumber;
	private String cvv;
	private short[] expirationDate; // [month, year]
	private String firstName;
	private String lastName;
	private String type;
	
	/**
	 * Sets the default values.
	 */
	public CreditCard() {
		cardNumber = "0000000000000000";
		type = "";
		cvv = "000";
		expirationDate = new short[] {12, 2100};
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
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return the three digit cvv
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * @return the expiration date for this card.
	 */
	public short[] getDate() {
		return expirationDate;
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
		if (billingAddress == null) {
			throw new RuntimeException("Tried to set the billing address to null.");
		}
		this.billingAddress = billingAddress;
	}

	/**
	 * Sets a new card number. This has to be exactly 
	 * 16 digits and each digit must be between 0 
	 * and 9 or else a runtime exception will be thrown.
	 */
	public void setCardNumber(String cardNumber) {
		if (cardNumber == null) {
			throw new RuntimeException("Tried to set the card number to null.");
		}
		if (cardNumber.length() != CARD_NUMBER_SIZE) {
			throw new RuntimeException("Tried to set the card number to a number of the incorrect length [" + cardNumber + "].");
		}
		this.cardNumber = cardNumber;
	}

	/**
	 * Sets a new three digit cvv for this card.
	 * @param cvv
	 */
	public void setCvv(String cvv) {
		if (cvv == null) {
			throw new RuntimeException("Tried to set the cvv to null.");
		}
		if (cvv.length() != CVV_SIZE) {
			throw new RuntimeException("Tried to set the cvv to a number of the incorrect length [" + cvv + "].");
		}
		this.cvv = cvv;
	}

	/**
	 * Sets a new expiration date for this card.
	 * @param date
	 */
	public void setDate(short month, short year) {
		this.expirationDate[0] = month;
		this.expirationDate[1] = year;
	}

	/**
	 * Sets a new first name of the card owner
	 */
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new RuntimeException("Tried to set the card owner's first name to null.");
		}
		this.firstName = firstName;
	}

	/**
	 * Sets a new last name of the card owner
	 */
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new RuntimeException("Tried to set the card owner's last name to null.");
		}
		this.lastName = lastName;
	}

	/**
	 * Sets a new type for this card.
	 * @param type
	 */
	public void setType(String type) {
		if (type == null) {
			throw new RuntimeException("Tried to set the card type to null.");
		}
		this.type = type;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += "[ ";
		s += getFirstName() + ", ";
		s += getLastName() + ", ";
		s += getCardNumber();
		s += " ]";
		return s;
	}
	
}
