package com.fusion.html;

import com.fusion.objects.User;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import java.util.ArrayList;

public class TelemarketerPage extends AbstractPage{

	public TelemarketerPage() {
		
	}
	
	@Override
	protected ContainerTag generateBody() {
		try {
			DBHelper db = new DBHelper();
			
			ArrayList<User> l = db.getTelemarketerReport();
			
			if (l != null) {
				return div().with(
						table().with(
							tr().with(
								th("User ID"),
								th("Name"),
								th("Address"),
								th("Email"),
								th("Phone Number"),
								th("Age"),
								th("Gender"),
								th("Salary")
								)	
							,
							each(l, user ->
								tr().with(
									td(user.getRegId().toString()),
									td(user.getFullName()),
									td(user.getPrimaryAddress()),
									td(user.getEmailAddress()),
									td(user.getPhoneNumber()),
									td(Byte.toString(user.getAge())),
									td(Character.toString(user.getGender())),
									td(Double.toString(user.getAnnualSalary()))
									)
								)
							).withClass("telemarketerReport")
						);
			}
		} catch (DBHelperException e) {
			e.printStackTrace();
		}
		
		return div().with(p("Could not generate report"));
	}

	@Override
	protected String pageTitle() {
		return "Telemarketer Report";
	}

}
