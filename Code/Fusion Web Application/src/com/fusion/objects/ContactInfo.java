package com.fusion.objects;

public class ContactInfo {
	
	private String emailAddress;
	private Address postalAddress;
	private String pointOfContact;
	
	public ContactInfo(String emailAddress, Address address, String poc) {
		this.emailAddress = emailAddress;
		this.postalAddress = address;
		this.pointOfContact = poc;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public Address getPostalAddress() {
		return postalAddress;
	}

	public String getPointOfContact() {
		return pointOfContact;
	}

	enum PointOfContact {
		EMAIL,
		POSTAL
	};

}
