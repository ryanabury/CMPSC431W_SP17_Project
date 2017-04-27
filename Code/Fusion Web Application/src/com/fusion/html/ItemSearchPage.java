package com.fusion.html;

import com.fusion.objects.SaleItem;
import com.fusion.objects.User;

import static j2html.TagCreator.*;

import j2html.tags.ContainerTag;

public class ItemSearchPage extends AbstractPage {

	private String[] searchParameters;
	private SaleItem[] searchResults;

	public ItemSearchPage(User user, String[] searchParameters, SaleItem[] searchResults) {
		super(user);
		if (searchParameters == null) {
			this.searchParameters = new String[0];
		} else {
			this.searchParameters = searchParameters;
		}
		if (searchResults == null) {
			this.searchResults = new SaleItem[0];
		} else {
			this.searchResults = searchResults;
		}
	}

	@Override
	protected ContainerTag generateBody() {
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

	@Override
	protected String pageTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
