package com.fusion.html;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;
import com.fusion.objects.Supplier;
import com.fusion.objects.SaleItem;
import java.util.ArrayList;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class SupplierPage extends AbstractPage {

	private char[] supplierID;
	
	public SupplierPage(char[] supplierID){
		this.supplierID = supplierID;
	}
	@Override
	protected ContainerTag generateBody() {
		//Generate body for Supplier Page
		
		try{
			DBHelper db = new DBHelper();
			
			Supplier supplierInfo = db.getSupplier(supplierID);
			ArrayList<SaleItem> l = db.getSaleItemBySeller(supplierID);
			
			return div().attr("align", "center").with(
					table()
					.with(
							tr().with(
									h1(supplierInfo.getCompanyName())
									)
							,
							each(l,saleItem ->
									table().with(
											tr().with(
													h3(saleItem.getName()).attr("width","300")
													),
											tr().with(
													td(saleItem.getDescription()).attr("width","300")
													),
											tr().with(
													td("$" + Integer.toString(saleItem.getPrice())).attr("width","300")
													),
											tr().with(
													td().with(
															input()
															.withType("submit")
															.withValue("Buy Now")
															.withName("buy")
													)),
											tr().with(
													td().with(
															input()
															.withType("text")
															.withValue("Bid Amount")
															.withName("bid amount")
													),
													td().with(
															input()
															.withType("submit")
															.withValue("Bid")
															.withName("Bid")
													))
											))));
									
					
		}catch(DBHelperException e){
			e.getStackTrace();
		}
		
		return div().with(
				p("Error retrieving supplier.")
				);
	}

	@Override
	protected String pageTitle() {
		// TODO Auto-generated method stub
		return "Supplier Page";
	}

}
