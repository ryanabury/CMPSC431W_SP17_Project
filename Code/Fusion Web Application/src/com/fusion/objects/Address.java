package com.fusion.objects;

/**
 * This class represents one user's postal address.
 * @author Ethan Raymond
 */
public class Address {
	
	public static final int ZIP_CODE_SIZE = 5;

	private String city;
	private String state;
	private String streetAddress;
	private byte[] zipCode;
	
	/**
	 * Sets default empty values.
	 */
	public Address() {
		streetAddress = "";
		city = "";
		state = "";
		zipCode = new byte[9];
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public byte[] getZipCode() {
		return zipCode;
	}

	public void setCity(String city) {
		if (city == null) {
			throw new RuntimeException("Tried to set the city value to null.");
		}
		this.city = city;
	}

	public void setState(String state) {
		if (state == null) {
			throw new RuntimeException("Tried to set the state value to null.");
		}
		this.state = state;
	}

	public void setStreetAddress(String streetAddress) {
		if (streetAddress == null) {
			throw new RuntimeException("Tried to set the street address value to null.");
		}
		this.streetAddress = streetAddress;
	}

	public void setZipCode(byte[] zipCode) {
		if (zipCode == null) {
			throw new RuntimeException("Tried to set the zipcode value to null.");
		}
		if (zipCode.length != ZIP_CODE_SIZE) {
			throw new RuntimeException("Tried to set the zipcode value to an invalid zipcode [" + zipCode + "]");
		}
		this.zipCode = zipCode;
	}
	
}
