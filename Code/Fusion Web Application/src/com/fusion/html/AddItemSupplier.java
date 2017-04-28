package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;
import com.fusion.objects.Category;

public class AddItemSupplier extends AbstractPage {

	char[] supplierID;
	
	public AddItemSupplier(char[] supplierID){
		super(supplierID);
	}
	
	@Override
	protected ContainerTag generateBody() {
		
		try{
			
		DBHelper db = new DBHelper();
		Category catList = db.getCategoryTree();
		
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
														td("Categories"),
														td().with(
																select()
																.withName("Electronics & Computers")
																.withId("0")
																.with(
																		optgroup()
																		.attr("label","Home Audio & Theater")
																		.with(
																				option("Speakers")
																				.withValue("3"),
																				option("BlueTooth")
																				.withValue("4"),
																				option("Bookshelf")
																				.withValue("5"),
																				option("Ceiling & in-wall")
																				.withValue("6"),
																				option("Subwoofers")
																				.withValue("7"),
																				option("Surround sound")
																				.withValue("8")
																				),
																		optgroup()
																		.attr("label", "Stereo System components")
																		.with(
																				option("Receivers& amplifiers")
																				.withValue("10"),
																				option("Tuners")
																				.withValue("11"),
																				option("Turntables")
																				.withValue("12")
																				),
																		optgroup()
																		.attr("label", "Stereo System components")
																		.with(
																				option("Cables")
																				.withValue("14"),
																				option("Speaker accessories")
																				.withValue("15"),
																				option("Home entertainment furniture")
																				.withValue("16")
																				),
																		optgroup()
																		.attr("label", "Cell Phones & Accessories")
																		.with(
																				option("Cell Phones")
																				.withValue("18"),
																				option("Cases")
																				.withValue("19")
																				),
																		optgroup()
																		.attr("label", "Connected Devices")
																		.with(
																				option("Mobile Hotspots")
																				.withValue("21"),
																				option("Smart Watches")
																				.withValue("22"),
																				option("Wearable Tech")
																				.withValue("23")
																				),
																		optgroup()
																		.attr("label","Accessories")
																		.with(
																				option("Batteries")
																				.withValue("25"),
																				option("Chargers")
																				.withValue("26"),
																				option("Mounts")
																				.withValue("27"),
																				option("Screen Protectors")
																				.withValue("28")
																				),
																		optgroup()
																		.attr("label", "HeadPhones")
																		.with(
																				option("Earbud Headphones")
																				.withValue("30"),
																				option("Over Ear Headphones")
																				.withValue("31"),
																				option("On Ear Headphones")
																				.withValue("32"),
																				option("Noise cancelling Headphones")
																				.withValue("33")
																				),
																		optgroup()
																		.attr("label", "Computers & Tablets")
																		.with(
																				optgroup()
																				.attr("label","Desktops")
																				.with(
																						option("Towers")
																						.withValue("36"),
																						option("All-in-ones")
																						.withValue("37"),
																						option("Minis")
																						.withValue("38")
																						),
																				optgroup()
																				.attr("label","Laptops")
																				.with(
																						option("Traditional")
																						.withValue("40"),
																						option("2-in-1")
																						.withValue("41")
																						),
																				option("Tablets")
																				.withValue("42")
																				),
																		optgroup()
																		.attr("label", "Computer Parts & Components")
																		.with(
																				option("Processors")
																				.withValue("44"),
																				option("Motherboards")
																				.withValue("45"),
																				option("Graphics Card")
																				.withValue("46"),
																				option("Storage")
																				.withValue("47"),
																				option("Memory")
																				.withValue("48"),
																				option("Power Supplies & Fans")
																				.withValue("49"),
																				option("Software")
																				.withValue("50")
																				),
																		optgroup()
																		.attr("label", "Printers & ink")
																		.with(
																				option("InkJet printers")
																				.withValue("52"),
																				option("Laser printers")
																				.withValue("53"),
																				option("Label printers")
																				.withValue("54")
																				)
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
														span("Buy"),
														input()
														.withType("radio")
														.withName("typeOfSale")
														.withValue("2")
														.withStyle("color: #000000")
														.attr("size", "30"),
														span("Bid"),
														input()
														.withType("radio")
														.withName("typeOfSale")
														.withValue("0")
														.withStyle("color: #000000")
														.attr("size", "30"),
														span("Both")
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
												))));
		
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return div().with(
				p("Error retrieving categories.")
				);
													
	}

	@Override
	protected String pageTitle() {
		return "Add Item";
	}

}
