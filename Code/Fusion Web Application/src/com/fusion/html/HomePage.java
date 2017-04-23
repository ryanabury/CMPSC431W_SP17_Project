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

	@Override
	protected ContainerTag generateBody() {
		return div();
	}

}
