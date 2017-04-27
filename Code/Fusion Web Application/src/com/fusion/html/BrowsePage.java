package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import java.util.ArrayList;

import com.fusion.objects.Category;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

public class BrowsePage extends AbstractPage {

	private Sort itemSort;
	private Category categoryTree;
	
	public BrowsePage(char[] userID, Sort itemSort, Category categoryTree) throws DBHelperException {
		super(userID);
		this.itemSort = itemSort;
		this.categoryTree = categoryTree;
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
		ContainerTag d = div();
		for (int i = 0; i <categoryTree.getChildren().size(); i++) {
			generateFilterColumn(d, categoryTree.getChildren().get(i), 0);
		}
		return d;
	}
	
	private void generateFilterColumn(ContainerTag tag, Category category, int depth) {
		
		if (category == null) {
			return;
		}
		
		String text = "";
		for (int i = 0; i < depth; i++) {
			text += "\t";
		}
		text += category.getName();
		tag.with(
				a().with(
						p(text).withStyle("text-indent: " + (10*depth) + "px")
				).withHref("./browse.jsp?category=" + category.getId())
		);
		
		ArrayList<Category> children = category.getChildren();
		for (int i = 0; i < children.size(); i++) {
			generateFilterColumn(tag, children.get(i), depth+1);
		}
		
	}
	
	private ContainerTag generateSortBar() {
		return div();
	}
	
	private ContainerTag generateItemList() {
		return div();
	}

	@Override
	protected String pageTitle() {
		return "Browse for Items";
	}
	
	public enum Sort {
		ALPHABETICAL_DESCENDING,
		ALPHABETICAL_ASCENDING,
		PRICE_LOW_TO_HIGH,
		PRICE_HIGH_TO_LOW
	}

}
