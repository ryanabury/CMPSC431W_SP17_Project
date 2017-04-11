package com.fusion.html;

import com.fusion.objects.User;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class Header {
	
	private static final String[] MENU_ITEMS = {"Home", "Browse", "About"};
	private static final String[] MENU_ITEM_LINKS = {"./", "./browse", "./about"};
	
	public static String generate(User user) {
		return div().with(								// Main Header Box
				h1("Fusion"), 						// Title
				div().with(								// Menu / Login Box
						generateMenu(),
						generateAccountInfo(user)
				)
		).withClass("header-main-box").render();
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
		if (user == null) {
			return div().with(
					a("Login"), 
					p(" / "), 
					a("Create Account")
			).withClass("header-account-box");
		} else {
			return div().with(
					a("My Account"), 
					p(" (" + user.getFullName() + ")")
			).withClass("header-account-box");
		}
	}

}
