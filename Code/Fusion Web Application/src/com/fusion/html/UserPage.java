package com.fusion.html;

import com.fusion.objects.User;
import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class UserPage extends AbstractPage {

	private User user;
	
	public UserPage() {
		super();
		this.user = null;
	}
	
	public UserPage(User u) {
		super(u);
		this.user = u;
	}
	
	@Override
	protected ContainerTag generateBody() {
		//Generate body based on userID
		if(!user.equals(null)){
			return div().with(
					table().with(
							thead().with(
									tr().with(
											th(user.getUsername())
											)
									),
							tbody().with(
									tr().with(
											td(user.getEmailAddress())
											)
									),
									tr().with(
											td(user.getPhoneNumber())
											)
									));
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
