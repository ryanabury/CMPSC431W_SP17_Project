package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class LoginPage extends AbstractPage {

	public LoginPage(){
		super();
	}
	
	@Override
	protected ContainerTag generateBody() {
		// TODO Auto-generated method stub
		return div();
	}

	@Override
	protected String pageTitle() {
		return "Login";
	}

}
