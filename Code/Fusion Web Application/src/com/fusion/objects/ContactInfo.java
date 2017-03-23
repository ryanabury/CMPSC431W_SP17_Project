package com.fusion.objects;

public class ContactInfo {
	
	private EmailAddress emailAddress;
	private Address postalAddress;
	private PointOfContact pointOfContact;
	
	public ContactInfo(EmailAddress emailAddress, Address address, PointOfContact poc) {
		this.emailAddress = emailAddress;
		this.postalAddress = address;
		this.pointOfContact = poc;
	}
	
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public Address getPostalAddress() {
		return postalAddress;
	}

	public PointOfContact getPointOfContact() {
		return pointOfContact;
	}

	enum PointOfContact {
		EMAIL,
		POSTAL
	};

}
