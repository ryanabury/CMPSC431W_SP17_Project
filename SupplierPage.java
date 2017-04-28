package com.fusion.html;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;
import com.fusion.objects.Supplier;

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
			
			return div().with(
					h2(supplierInfo.getCompanyName()),
					p(supplierInfo.getDescription()),
					a("Supplier Website").withHref(supplierInfo.getUrlExtention())
					);
					
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
