package com.fusion.html;

import static j2html.TagCreator.a;
import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.p;
import static j2html.TagCreator.text;

import com.fusion.objects.User;

import j2html.tags.ContainerTag;

public abstract class Page {
	
	private static final String[] MENU_ITEMS = {"Home", "Browse", "About"};
	private static final String[] MENU_ITEM_LINKS = {"./", "./browse", "./about"};
	
	private ContainerTag generateHeader(User user) {
		return div().with(								// Main Header Box
				h1("Fusion"), 						// Title
				div().with(								// Menu / Login Box
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

}
