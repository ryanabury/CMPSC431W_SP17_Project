package com.fusion.objects;
import java.sql.Timestamp;

public class SaleTransaction {
	
	private int saleID;
	private CreditCard creditCard;
	private String status;
	private Timestamp completionDate;
	private SaleItem saleItem;
	private int quantity;
	private int salePrice; // cents
	private Address shippingAddress;
	
	public SaleTransaction() {
		this(0, new CreditCard(), "", new Timestamp(0), new SaleItem(), 0, 0, new Address());
	}
	
	public SaleTransaction(int saleID, CreditCard creditCard, String status, Timestamp completionDate, SaleItem saleItem, int quantity, int salePrice, Address shippingAddress) {
		this.saleID = saleID;
		this.creditCard = creditCard;
		this.status = status;
		this.completionDate = completionDate;
		this.saleItem = saleItem;
		this.quantity = quantity;
		this.salePrice = salePrice;
		this.shippingAddress = shippingAddress;
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
	public Timestamp getCompletionDate() {
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
	public void setCompletionDate(Timestamp completionDate) {
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
