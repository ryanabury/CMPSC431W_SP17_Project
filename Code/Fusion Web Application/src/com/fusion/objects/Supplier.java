package com.fusion.objects;

public class Supplier {
	
	private int supplierID;
	private String companyName;
	private String password;
	private Category category;
	private int yearlyRevenue;
	private String urlExtention;
	private String description;
	
	public Supplier(int supplierID, String companyName, String password, Category category, int yearlyRevenue,
			String urlExtention, String description) {
		this.supplierID = supplierID;
		this.companyName = companyName;
		this.password = password;
		this.category = category;
		this.yearlyRevenue = yearlyRevenue;
		this.urlExtention = urlExtention;
		this.description = description;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getPassword() {
		return password;
	}

	public Category getCategory() {
		return category;
	}

	public int getYearlyRevenue() {
		return yearlyRevenue;
	}

	public String getUrlExtention() {
		return urlExtention;
	}

	public String getDescription() {
		return description;
	}
	
}
