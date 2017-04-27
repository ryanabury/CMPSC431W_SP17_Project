package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import com.fusion.objects.SaleItem;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

public class BuyItemPage extends AbstractPage{

	private SaleItem item;
	
	public BuyItemPage(char[] userID, char[] itemID) {
		super(userID);
		DBHelper db;
		try {
			
			db = new DBHelper();
			item = db.getSaleItem(itemID);
			
		} catch (DBHelperException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	protected ContainerTag generateBody() {
		return form()
				.withMethod("post")
				.withAction("PurchaseItem")
				.with(
					table().with(
						thead().with(
							tr().with(
								th("Buy " + item.getName())
							)
						),
						tbody().with(
							tr().with(
								td("Quantity to Purchase: "),
								td().with(
									input()
									.withType("text")
									.withName("quantity")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("Credit Card Number: "),
								td().with(
									input()
									.withType("text")
									.withName("card_number")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("Credit Card CVV code: "),
								td().with(
									input()
									.withType("text")
									.withName("cvv_code")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("Expiration Date: (MMYY)"),
								td().with(
									input()
									.withType("text")
									.withName("expiration_date")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("Street Address: "),
								td().with(
									input()
									.withType("text")
									.withName("address")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("State: "),
								td().with(
									input()
									.withType("text")
									.withName("state")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("City: "),
								td().with(
									input()
									.withType("text")
									.withName("city")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("Zip Code: "),
								td().with(
									input()
									.withType("text")
									.withName("zip")
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("Purchase Item ID: "),
								td().with(
									input()
									.withType("text")
									.withName("item_ID")
									.withValue(Integer.toString(item.getId()))
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td("Your User ID: "),
								td().with(
									input()
									.withType("text")
									.withName("user_ID")
									.withValue(new String(myUser.getRegId()))
									.withStyle("border:2px solid #000000")
									.attr("size", "30")
								)
							),
							tr().with(
								td().with(
									input()
									.withType("submit")
									.withValue("Submit Order")
								)
							)
						)
					)
				);
	}

	@Override
	protected String pageTitle() {
		return "Purchase Item";
	}

}
