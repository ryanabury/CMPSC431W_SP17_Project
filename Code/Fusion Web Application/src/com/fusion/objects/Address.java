package com.fusion.objects;

/**
 * This class represents one user's postal address.
 * @author Ethan Raymond
 */
public class Address {

	private String streetAddress;
	private String city;
	private String state;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public byte[] getZipCode() {
		return zipCode;
	}

	public void setZipCode(byte[] zipCode) {
		this.zipCode = zipCode;
	}
	
}
