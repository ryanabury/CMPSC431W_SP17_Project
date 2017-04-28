package com.fusion.html;

import com.fusion.objects.SaleItem;
import com.fusion.objects.Supplier;
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
		
		System.out.println("On item page: " + new String(itemID));
		
		try {
			DBHelper db = new DBHelper();
		
			SaleItem item = db.getSaleItem(itemID);
			
			Supplier supplier = db.getSupplier(Integer.toString(item.getSellerID()).toCharArray());
			
			return div().with(
					h2(item.getName()),
					p("Sold By: ").with(
						a(supplier.getCompanyName()).withHref("./supplierPage.jsp?supplier_ID=" + supplier.getSupplierID())	
						),
					p(item.getDescription()),
					p().with(a("Detailed Description").withHref(item.getDetailedDescriptionURL())),
					hr(),
					// TODO: Make this a button 
					p().with(a("Buy Item").withHref("./buyItem.jsp?item_ID=" + new String(itemID)).withClass("buyButton"))					
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
