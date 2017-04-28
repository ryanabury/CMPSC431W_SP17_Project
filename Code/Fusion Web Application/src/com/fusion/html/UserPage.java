package com.fusion.html;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;
import com.fusion.objects.User;
import com.fusion.objects.SaleItem;
import java.util.ArrayList;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import com.fusion.sql.DBHelper.DBHelperException;

public class UserPage extends AbstractPage {

	public UserPage(char[] userID){
		super(userID);
	}
	
	@Override
	protected ContainerTag generateBody() {
		//Generate body based on userID
		if (myUser != null){

			
			try{
				DBHelper db = new DBHelper();
				
				ArrayList<SaleItem> l = db.getUserPurchases(myUser.getRegId());
			
				return div().attr("align","center").with(
						table().with(
								thead().with(
										tr().with(
												th(myUser.getUsername())
												)
										),
								tbody().with(
										tr().with(
											td(myUser.getEmailAddress())
												)
										),
										tr().with(
												td(myUser.getPhoneNumber())
												)
										),
						table()
						.with(
							tr().with(
									h1(myUser.getUsername() + "'s Purchases")
									),
							each(l,purchaseItem ->
									table().with(
										tr().with(
												h3(purchaseItem.getName()).attr("width","300")
												),
										tr().with(
												img().withSrc(purchaseItem.getDetailedDescriptionURL()) //Item image
												),
										tr().with(
												td(purchaseItem.getDescription()).attr("width","300")
												),
										tr().with(
												td("$" + Integer.toString(purchaseItem.getPrice())).attr("width","300")
										)
								))));
		
			  } catch(DBHelperException e){
				  e.getStackTrace();
			  }
    		} else {
        		return div().with(
                	p("Error retrieving User.")
                	);
    		}
    
	return div().with(
		p("Error retrieving User.")
	);
		
		
	}

	@Override
	protected String pageTitle() {
		return "User Page";
	}

}
