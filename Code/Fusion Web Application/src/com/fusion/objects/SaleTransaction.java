package com.fusion.objects;

public class SaleTransaction {
	
	private int saleID;
	private String creditCard;
	private String status;
	private long completionDate;
	private int saleItemID;
	private int quantity;
	private int salePrice; // cents
	private Address shippingAddress;
	
	public SaleTransaction() {
		saleID = 0;
		creditCard = "";
		status = "";
		completionDate = 0;
		saleItemID = 0;
		quantity = 0;
		salePrice = 0;
		shippingAddress = new Address();
	}
	
	public int getSaleID() {
		return saleID;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public String getStatus() {
		return status;
	}
	public long getCompletionDate() {
		return completionDate;
	}
	public int getSaleItem() {
		return saleItemID;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCompletionDate(long completionDate) {
		this.completionDate = completionDate;
	}
	public void setSaleItemID(int saleItemID) {
		this.saleItemID = saleItemID;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
