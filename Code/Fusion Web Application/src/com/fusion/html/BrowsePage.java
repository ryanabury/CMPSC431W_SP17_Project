package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class BrowsePage extends AbstractPage {

	private Sort itemSort;
	
	public BrowsePage(char[] userID, Sort itemSort) {
		super(userID);
		this.itemSort = itemSort;
	}
	
	@Override
	protected ContainerTag generateBody() {
		return div().with(
				generateFilterColumn(), 
				div().with(
						generateSortBar(), 
						generateItemList()
				)
		);
	}
	
	private ContainerTag generateFilterColumn() {
		return null;
	}
	
	private ContainerTag generateSortBar() {
		return null;
	}
	
	private ContainerTag generateItemList() {
		return null;
	}

	@Override
	protected String pageTitle() {
		return "Browse for Items";
	}
	
	enum Sort {
		ALPHABETICAL_DESCENDING,
		ALPHABETICAL_ASCENINGM,
		PRICE_LOW_TO_HIGH,
		PRICE_HIGH_TO_LOW
	}

}
