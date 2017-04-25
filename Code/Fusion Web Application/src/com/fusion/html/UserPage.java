package com.fusion.html;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

import com.fusion.objects.User;
import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class UserPage extends AbstractPage {

	private char[] userID;
	
	public UserPage(char[] userID){
		this.userID = userID;
	}
	
	@Override
	protected ContainerTag generateBody() {
		//Generate body based on userID
		
		try{
			DBHelper db = new DBHelper();
			
			User userInfo = db.getUser(userID);
			
			return div().with(
					h2(userInfo.getFirstName() + "'s User Page"),
					p("UserName: " + userInfo.getUsername())
					);
		}
		catch(DBHelperException e){
			e.printStackTrace();
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
