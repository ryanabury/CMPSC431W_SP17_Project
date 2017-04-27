package com.fusion.html;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

import com.fusion.objects.User;

public class HomePage extends AbstractPage {
	
	public HomePage() {
		super();
	}
	
	public HomePage(User user) {
		super(user);
	}
	
	public HomePage(char[] userID) {
		super(userID);
	}

	@Override
	protected ContainerTag generateBody() {
		return div();
	}

	@Override
	protected String pageTitle() {
		return "Home Page";
	}

}
