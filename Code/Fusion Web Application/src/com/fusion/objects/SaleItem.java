package com.fusion.objects;

import java.util.ArrayList;



public class SaleItem {
	
	public enum TypeOfSale {
		direct, bid;
		public static TypeOfSale fromInt(int i) {
			switch(i) {
				case 0:
					return direct;
				case 1:
					return bid;
				default:
					return direct; // I know it's superfluous, but it makes it slightly more readable. 
			}
		}
		public static int toInt(TypeOfSale i) {
			switch(i) {
			case direct:
				return 0;
			case bid:
				return 1;
			default:
				return 0;
			}
		}
	}
	private int id;
	private String name;
	private int sellerID;
	private int price; // Given in cents
	private int reservePrice; // Given in cents
	private int quantity;
	private Category category;
	private String detailedDescriptionURL;
	private TypeOfSale typeOfSale;
	private String description;
	private ArrayList<ItemRating> ratings;
	
	public SaleItem() {
		id = 0;
		name = "";
		sellerID = 0;
		price = 0;
		reservePrice = 0;
		quantity = 0;
		category = null;
		detailedDescriptionURL = "";
		typeOfSale = TypeOfSale.direct;
		description = "";
		ratings = new ArrayList<>();
	}
	
	public ArrayList<ItemRating> getRatings() {
		return ratings;
	}
	
	public void addRating(ItemRating rating) {
		ratings.add(rating);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getReservePrice() {
		return reservePrice;
	}
	public void setReservePrice(int reservePrice) {
		this.reservePrice = reservePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDetailedDescriptionURL() {
		return detailedDescriptionURL;
	}
	public void setDetailedDescriptionURL(String detailedDescriptionURL) {
		this.detailedDescriptionURL = detailedDescriptionURL;
	}
	public TypeOfSale getTypeOfSale() {
		return typeOfSale;
	}
	public void setTypeOfSale(TypeOfSale typeOfSale) {
		this.typeOfSale = typeOfSale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
