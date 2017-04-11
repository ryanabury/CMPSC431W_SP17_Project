package com.fusion.html;

import com.fusion.objects.User;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class Header {
	
	private static final String[] MENU_ITEMS = {"Home", "Browse", "About"};
	
	public static String generate(User user) {
		return div().with(								// Main Header Box
				h1("Fusion.com"), 						// Title
				div().with(								// Menu / Login Box
						generateMenu(),
						generateAccountInfo(user)
				)
		).render();
	}
	
	private static ContainerTag generateMenu() {
		ContainerTag div = div();
		for (int i = 0; i < MENU_ITEMS.length; i++) {
			div.with(a(MENU_ITEMS[i]));
		}
		return div;
	}
	
	private static ContainerTag generateAccountInfo(User user) {
		if (user == null) {
			return div().with(
					a("Login"), 
					p(" / "), 
					a("Create Account")
			);
		} else {
			return div().with(
					a("My Account"), 
					p(" (" + user.getFullName() + ")")
			);
		}
	}

}
