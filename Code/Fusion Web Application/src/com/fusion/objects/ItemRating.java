package com.fusion.objects;

public class ItemRating {
	
	private char[] ratingID;
	private long timestamp;
	private byte score;
	private String description;
	private String comment;
	private char[] userID;
	
	public ItemRating() {
		ratingID = new char[20];
		timestamp = 0;
		score = 0;
		description = "";
		comment = "";
		userID = new char[20];
	}

	public char[] getRatingID() {
		return ratingID;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public byte getScore() {
		return score;
	}

	public String getDescription() {
		return description;
	}

	public String getComment() {
		return comment;
	}

	public char[] getUserID() {
		return userID;
	}

	public void setRatingID(char[] ratingID) {
		this.ratingID = ratingID;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setScore(byte score) {
		this.score = score;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setUserID(char[] userID) {
		this.userID = userID;
	}

}
