package com.fusion.html;

import com.fusion.objects.SaleItem;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class ItemPage extends AbstractPage{

	private char[] itemID;
	
	public ItemPage(char[] itemID, char[] userID) {
		super(userID);
		this.itemID = itemID;
	}
	
	@Override
	protected ContainerTag generateBody() {
		// Generate body based on itemID
		
		try {
			DBHelper db = new DBHelper();
		
			SaleItem item = db.getSaleItem(itemID);
			
			return div().with(
					h2(item.getName()),
					p("Sold By: " + item.getSellerID()),
					p(item.getDescription()),
					a("Detailed Description").withHref(item.getDetailedDescriptionURL())
					);
			
		} catch (DBHelperException e) {
			e.printStackTrace();
		}
		
		return div().with(
				p("Error in retrieving the Sale Item")
				);
	}

	@Override
	protected String pageTitle() {
		return "Item Page";
	}

}
