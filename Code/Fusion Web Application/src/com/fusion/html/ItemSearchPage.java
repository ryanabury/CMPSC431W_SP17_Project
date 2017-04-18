package com.fusion.html;

import com.fusion.objects.SaleItem;
import com.fusion.objects.User;

import static j2html.TagCreator.*;

import j2html.tags.ContainerTag;

public class ItemSearchPage extends AbstractPage {

	private SaleItem[] searchResults;

	public ItemSearchPage(User user, SaleItem[] searchResults) {
		super(user);
		this.searchResults = searchResults;
	}

	@Override
	protected ContainerTag generageBody() {
		return div().with(generateSearchBar(), generateSearchResults());
	}
	
	private ContainerTag generateSearchBar() {
		return form().with(
				input()
						.attr("type", "text")
						.attr("name", PostParameters.SEARCH_TERMS),
				input()
						.attr("type", "submit")
						.attr("value", "Search")
		);
	}
	
	private ContainerTag generateSearchResults() {
		return new ContainerTag("p");
	}

}
