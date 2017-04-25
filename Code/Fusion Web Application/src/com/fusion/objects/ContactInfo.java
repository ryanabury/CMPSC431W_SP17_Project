package com.fusion.objects;

public class ContactInfo {
	
	private String emailAddress;
	private String postalAddress;
	private String pointOfContact;
	
	public ContactInfo(String emailAddress, String address, String poc) {
		this.emailAddress = emailAddress;
		this.postalAddress = address;
		this.pointOfContact = poc;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPostalAddress() {
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
