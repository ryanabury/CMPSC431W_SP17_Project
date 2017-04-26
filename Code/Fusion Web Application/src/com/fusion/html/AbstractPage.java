package com.fusion.html;

import static j2html.TagCreator.*;

import com.fusion.objects.User;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

import j2html.tags.ContainerTag;

public abstract class AbstractPage {
	
	private static final String[] MENU_ITEMS = {"Home", "Browse", "About"};
	private static final String[] MENU_ITEM_LINKS = {"./", "./browse.jsp", "./about.jsp"};
	
	protected User myUser;
	
	public AbstractPage() {
		myUser = null;
	}
	
	public AbstractPage(User user) {
		myUser = user;
	}
	
	public AbstractPage(char[] userID) {
		DBHelper db;
		try {
			db = new DBHelper();
			
			myUser = db.getUser(userID);
			
		} catch (DBHelperException e) {
			e.printStackTrace();
		}
	}
	
	private ContainerTag generateHead() {
		return head().with(
				title(pageTitle()),
				link().withRel("Stylesheet").withHref("css/main.css")
				);
	}
	
	private ContainerTag generateHeader(User user) {
		return div().with(
				img().withSrc("images/Logo.png"),
				h1("Fusion LTD.").withClass("header"), 	
				div().with(					
						generateMenu(user)
				).withId("menu")
		).withId("header");
	}
	
	protected abstract ContainerTag generateBody();
	
	protected abstract String pageTitle();
	
	private ContainerTag generateFooter() {
		return div().with(
				p().withClass("center").with(
					// Replace 'https%3A%2F%2Fwww.google.com' with our site URL
					iframe().withSrc("https://www.facebook.com/plugins/share_button.php?href=https%3A%2F%2Fwww.google.com&layout=button_count&size=small&mobile_iframe=true&width=86&height=20&appId")
					.withClass("share-button")
				),
				p("\u00a9 2017 Fusion Ltd.").withClass("footer")
				).withId("footer");
	}
	
	private static ContainerTag generateMenu(User user) {
		ContainerTag ul = ul();
		for (int i = 0; i < MENU_ITEMS.length; i++) {
			ul.with(
					li().with(
						a(MENU_ITEMS[i]).withHref(MENU_ITEM_LINKS[i])
					)
			);
		}
		
		if (user == null) {
			ul.with(
					li().withClass("floatRight").with(
						a("Login").withHref("./login.jsp")
					),
					li().withClass("floatRight").with(
						a("Sign Up").withHref("./create_user.jsp")
					)
			);
		} else {
			ul.with(
					li().withClass("floatRight").with(
						a("My Account").withHref("./userpage.jsp")
					)
			);
		}
		
		return ul.withId("menu");
	}
	
	/*private static ContainerTag generateAccountInfo(User user) {
		ContainerTag div = div();
		if (user == null) {
			div.with(a("Login").withHref("./login.jsp"));
			div.withText(" / "); 
			div.with(a("Create Account").withHref("./create_user.jsp"));
		} else {
			div.with(a("My Account ").withHref("./account"));
			div.with(text(" (" + user.getFullName() + ")"));
			div.withText(" / "); 
			div.with(a("Log Out").withHref("./logout"));
		}
		return div.withClass("header-account-box");
	}*/
	
	public final String render() {
		return html().with(
				div().withClass("wrapper").with(
					generateHead(),
					generateHeader(myUser), 
					generateBody().withId("body"), 
					div().withClass("push")
				),
				generateFooter()
		).render();
	}

}
