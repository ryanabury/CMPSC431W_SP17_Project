package com.fusion.html;

import static j2html.TagCreator.*;

import com.fusion.objects.User;

import j2html.tags.ContainerTag;

public abstract class AbstractPage {
	
	private static final String[] MENU_ITEMS = {"Home", "Browse", "About"};
	private static final String[] MENU_ITEM_LINKS = {"./", "./browse", "./about"};
	
	protected User myUser;
	
	public AbstractPage() {
		myUser = null;
	}
	
	public AbstractPage(User user) {
		myUser = user;
	}
	
	private ContainerTag generateHeader(User user) {
		return div().with(							// Main Header Box
				h1("Fusion"), 						// Title
				div().with(							// Menu / Login Box
						generateMenu(),
						generateAccountInfo(user)
				)
		).withClass("header-main-box");
	}
	
	protected abstract ContainerTag generageBody();
	
	private ContainerTag generateFooter() {
		return p("(C) 2017, Fusion Ltd.").withClass("footer");
	}
	
	private static ContainerTag generateMenu() {
		ContainerTag div = div();
		for (int i = 0; i < MENU_ITEMS.length; i++) {
			div.with(
					a(MENU_ITEMS[i]).withHref(MENU_ITEM_LINKS[i])
			);
		}
		return div.withClass("header-menu-box");
	}
	
	private static ContainerTag generateAccountInfo(User user) {
		ContainerTag div = div();
		if (user == null) {
			div.with(a("Login"));
			div.withText(" / "); 
			div.with(a("Create Account"));
		} else {
			return div().with(
					a("My Account"), 
					text(" (" + user.getFullName() + ")")
			).withClass("header-account-box");
		}
		return div.withClass("header-account-box");
	}
	
	public final String render() {
		return html().with(
				generateHeader(myUser), 
				generageBody(), 
				generateFooter()
		).render();
	}

}
