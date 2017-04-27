package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import com.fusion.sql.DBHelper.DBHelperException;
import com.fusion.objects.Category;

public class AddItemSupplier extends AbstractPage {

	char[] supplierID;
	
	public AddItemSupplier(char[] supplierID){
		super(supplierID);
	}
	
	@Override
	protected ContainerTag generateBody() {
		return form()
				.withMethod("post")
				.withAction("AddItemSupp")
				.with(
						table().with(
								thead().with(
										tr().with(
												td("Add a New Item")
												)
										),
								tbody().with(
										tr().with(
												td("Name: "),
												td().with(
														input()
														.withType("text")
														.withName("name")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Price: "),
												td().with(
														input()
														.withType("text")
														.withName("price")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Reserve price: "),
												td().with(
														input()
														.withType("text")
														.withName("reservePrice")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Quantity: "),
												td().with(
														input()
														.withType("text")
														.withName("quantity")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Category: "),
												td().with(
														select()
														.withName("category")
														.withId("category")
														.with(
																optgroup()
																.attr("label","Sports")
																.with(
																		option("1")
																		.withValue("1"),
																		option("2")
																		.withValue("2"),
																		option("3")
																		.withValue("3")
																		)
																)
														),
										tr().with(
												td("Image URL: "),
												td().with(
														input()
														.withType("text")
														.withName("detailedDescriptionURL")
														.withStyle("border:2px solid #000000")
														.attr("size", "75")
														)
												),
										tr().with(
												td("Type of Sale: "),
												td().with(
														input()
														.withType("radio")
														.withName("typeOfSale")
														.withValue("1")
														.withStyle("color: #000000")
														.attr("size","30"),
														p("Buy"),
														input()
														.withType("radio")
														.withName("typeOfSale")
														.withValue("2")
														.withStyle("color: #000000")
														.attr("size", "30"),
														p("Bid"),
														input()
														.withType("radio")
														.withName("typeOfSale")
														.withValue("0")
														.withStyle("color: #000000")
														.attr("size", "30"),
														p("both")
														)
												),
										tr().with(
												td("Description: "),
												td().with(
														textarea()
														.withName("description")
														.withStyle("border:2px solid #000000")
														.attr("rows","6")
														.attr("cols", "50")
														)
												),
										tr().with(
												td().with(
														input()
														.withType("submit")
														.withValue("Add Item")
														)
												)))));
													
	}

	@Override
	protected String pageTitle() {
		return "Add Item";
	}

}
