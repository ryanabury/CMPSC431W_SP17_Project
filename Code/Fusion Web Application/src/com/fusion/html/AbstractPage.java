package com.fusion.html;

import static j2html.TagCreator.*;

import com.fusion.objects.User;

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
	
	private ContainerTag generateHead() {
		return head().with(
				title(pageTitle()),
				link().withRel("Stylesheet").withHref("main.css")
				);
	}
	
	private ContainerTag generateHeader(User user) {
		return header().with(							// Main Header Box
				h1("Fusion LTD.").withClass("header"), 						// Title
				div().with(							// Menu / Login Box
						generateMenu(),
						generateAccountInfo(user)
				)
		);
	}
	
	protected abstract ContainerTag generateBody();
	
	protected abstract String pageTitle();
	
	private ContainerTag generateFooter() {
		return footer().with(
				p("(C) 2017, Fusion Ltd.").withClass("footer")
				);
	}
	
	private static ContainerTag generateMenu() {
		ContainerTag ul = ul();
		for (int i = 0; i < MENU_ITEMS.length; i++) {
			ul.with(
					li().with(
						a(MENU_ITEMS[i]).withHref(MENU_ITEM_LINKS[i])
					)
			);
		}
		return ul.withId("menu");
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
				generateHead(),
				generateHeader(myUser), 
				generateBody(), 
				generateFooter()
		).render();
	}

}
