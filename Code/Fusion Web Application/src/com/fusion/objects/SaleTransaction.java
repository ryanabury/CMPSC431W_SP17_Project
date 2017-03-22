package com.fusion.objects;

public class SaleTransaction {
	
	private int saleID;
	private CreditCard creditCard;
	private String status;
	private long completionDate;
	private SaleItem saleItem;
	private int quantity;
	private int salePrice; // cents
	private Address shippingAddress;
	
	public SaleTransaction() {
		saleID = 0;
		creditCard = new CreditCard();
		status = "";
		completionDate = 0;
		saleItem = new SaleItem();
		quantity = 0;
		salePrice = 0;
		shippingAddress = new Address();
	}
	
	public int getSaleID() {
		return saleID;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public String getStatus() {
		return status;
	}
	public long getCompletionDate() {
		return completionDate;
	}
	public SaleItem getSaleItem() {
		return saleItem;
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
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCompletionDate(long completionDate) {
		this.completionDate = completionDate;
	}
	public void setSaleItem(SaleItem saleItem) {
		this.saleItem = saleItem;
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
