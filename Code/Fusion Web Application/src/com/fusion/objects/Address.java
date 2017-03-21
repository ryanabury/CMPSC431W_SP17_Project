package com.fusion.objects;

/**
 * This class represents one user's postal address.
 * @author Ethan Raymond
 */
public class Address {

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
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setZipCode(byte[] zipCode) {
		this.zipCode = zipCode;
	}
	
}
