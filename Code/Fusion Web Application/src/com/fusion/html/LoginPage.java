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
		return div().with(
				table().with(
						thead().with(
								tr().with(
										th("Login").attr("colspan", "2")
										)
								),
						tbody().with(
								tr().with(
										td("Username: "),
										td().with(input()
												.withType("text")
												.withName("username")
												)												
										)
								),
								tr().with(
										td("Password: "),
										td().with(input()
												.withType("password")
												.withName("password")
												)
										)
								),
								tr().with(
										td().with(
												input()
												.withType("submit")
												.withValue("Login")
												.withName("Login")
												)
										));
	}

	@Override
	protected String pageTitle() {
		return "Login";
	}

}
