package com.fusion.objects;

public class Supplier {
	
	private int supplierID;
	private String companyName;
	private String password;
	private String cat;
	private int yearlyRevenue;
	private String urlExtention;
	private String description;
	private String banner_img;
	
	public Supplier() {
		supplierID = 0;
		companyName = "";
		password = "";
		cat = "";
		yearlyRevenue = 0;
		urlExtention = "";
		banner_img = "";
		description = "";
	}

	public int getSupplierID() {
		return supplierID;
	}
	
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public String getCategory() {
		return cat;
	}
	
	public void setCategory(String cat){
		this.cat = cat;
	}

	public int getYearlyRevenue() {
		return yearlyRevenue;
	}
	
	public void setYearlyRevenue(int yearlyRevenue){
		this.yearlyRevenue = yearlyRevenue;
	}

	public String getUrlExtention() {
		return urlExtention;
	}
	
	public void setUrlExtention(String urlExtention){
		this.urlExtention = urlExtention;
	}
	public String getBannerImg() {
		return banner_img;
	}
	
	public void setBannerImg(String bannerImg){
		this.banner_img = bannerImg;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
}
