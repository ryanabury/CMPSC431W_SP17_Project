package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class UserPage extends AbstractPage {

	public UserPage(char[] userID){
		super(userID);
	}
	
	@Override
	protected ContainerTag generateBody() {
		//Generate body based on userID
		if (myUser != null){
			return div().with(
					table().with(
							thead().with(
									tr().with(
											td("Username: "),
											td(myUser.getUsername())
											)
									),
							tbody().with(
									tr().with(
											td("Name: "),
											td(myUser.getFirstName() + " " + myUser.getLastName())
											),
									tr().with(
											td("Email: "),
											td(myUser.getEmailAddress())
											),
									tr().with(
											td("Phone Number: "),
											td(myUser.getPhoneNumber())
											),
									tr().with(
											td("Address: "),
											td(myUser.getPrimaryAddress())
											)
										)
								).withClass("about")
					);
		} else{
			return div().with(
					p("Error retrieving User.")
					);
		}
	}

	@Override
	protected String pageTitle() {
		return "User Page";
	}

}
