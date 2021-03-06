package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import java.util.ArrayList;

import com.fusion.objects.Category;
import com.fusion.objects.SaleItem;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

public class BrowsePage extends AbstractPage {

	private Sort itemSort;
	private Category categoryTree;
	private int categoryFilter;
	private ArrayList<SaleItem> saleItems;
	
	public BrowsePage(char[] userID, Sort itemSort, Category categoryTree, int categoryFilter, ArrayList<SaleItem> saleItems) throws DBHelperException {
		super(userID);
		this.itemSort = itemSort;
		this.categoryTree = categoryTree;
		this.categoryFilter = categoryFilter;
		this.saleItems = saleItems;
	}
	
	@Override
	protected ContainerTag generateBody() {
		return div().with(
				generateFilterColumn().withStyle("float: left;"), 
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
				).withHref("./browse.jsp?category=" + category.getId() + "&" + "sort=" + Sort.toInt(itemSort))
		);
		
		ArrayList<Category> children = category.getChildren();
		for (int i = 0; i < children.size(); i++) {
			generateFilterColumn(tag, children.get(i), depth+1);
		}
		
	}
	
	private ContainerTag generateSortBar() {
		return div().with(
				a("Descending").withHref(
						"./browse.jsp?category=" + categoryFilter + "&" + "sort=" + Sort.toInt(Sort.ALPHABETICAL_DESCENDING)
				).withStyle("margin-right: 10px;"),
				a("Ascending").withHref(
						"./browse.jsp?category=" + categoryFilter + "&" + "sort=" + Sort.toInt(Sort.ALPHABETICAL_ASCENDING)
				).withStyle("margin-right: 10px; margin-left: 10px;"),
				a("Price : Low-to-High").withHref(
						"./browse.jsp?category=" + categoryFilter + "&" + "sort=" + Sort.toInt(Sort.PRICE_LOW_TO_HIGH)
				).withStyle("margin-right: 10px; margin-left: 10px;"),
				a("Price : High-to-Low").withHref(
						"./browse.jsp?category=" + categoryFilter + "&" + "sort=" + Sort.toInt(Sort.PRICE_HIGH_TO_LOW)
				).withStyle("margin-left: 10px;")
		);
	}
	
	private ContainerTag generateItemList() {
		ContainerTag div = div();
		for (int i = 0; i < saleItems.size(); i++) {
			SaleItem searchResult = saleItems.get(i);
			div.with(
					div().with(
							a().with(
									h3(searchResult.getName())
							).withHref("./item.jsp?item_ID=" + searchResult.getId()),
							p(searchResult.getDescription())
					)
			);
		}
		return div;
	}

	@Override
	protected String pageTitle() {
		return "Browse for Items";
	}
	
	public enum Sort {
		
		ALPHABETICAL_DESCENDING,
		ALPHABETICAL_ASCENDING,
		PRICE_LOW_TO_HIGH,
		PRICE_HIGH_TO_LOW;
		
		public static int toInt(Sort sort) {
			switch (sort) {
			case ALPHABETICAL_DESCENDING:
				return 0;
			case ALPHABETICAL_ASCENDING:
				return 1;
			case PRICE_LOW_TO_HIGH:
				return 2;
			default:
				return 3;
			}
		}
		
		public static Sort valueOf(int i){
			switch (i) {
			case 0:
				return ALPHABETICAL_DESCENDING;
			case 1:
				return ALPHABETICAL_ASCENDING;
			case 2:
				return PRICE_LOW_TO_HIGH;
			default:
				return PRICE_HIGH_TO_LOW;
			}
		}
		
	}

}
