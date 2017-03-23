package com.fusion.objects;

public class EmailAddress {

	private String username;
	private String domain;
	
	public EmailAddress(String username, String domain) {
		this.username = username;
		this.domain = domain;
	}
	
	public String getUsername() {
		return username;
	}

	public String getDomain() {
		return domain;
	}

	@Override
	public String toString() {
		return username + "@" + domain;
	}
	
}
