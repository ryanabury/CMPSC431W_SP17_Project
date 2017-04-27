package com.fusion.objects;

import java.util.Arrays;

/**
 * This class represents one user's postal address.
 * @author Ethan Raymond
 */
public class Address {
	
	public static final int ZIP_CODE_SIZE = 5;

	private String city;
	private String state;
	private String streetAddress;
	private int zipCode;
	
	/**
	 * Sets default empty values.
	 */
	public Address() {
		streetAddress = "";
		city = "";
		state = "";
		zipCode = 0;
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

	public int getZipCode() {
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

	public void setZipCode(int zipCode) {
		if (zipCode == 0) {
			throw new RuntimeException("Tried to set the zipcode value to null.");
		}
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "[" + streetAddress + ", " + city + ", " + state + " " + Integer.toString(zipCode) + "]";
	}
	
}
