package com.fusion.html;

import java.util.ArrayList;

import com.fusion.objects.SaleTransaction;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class SaleReportPage extends AbstractPage{
	
	private ArrayList<SaleTransaction> transaction_list;

	public SaleReportPage(ArrayList<SaleTransaction> transaction_list) {
		this.transaction_list = transaction_list;
	}
	
	@Override
	protected ContainerTag generateBody() {
		
		if (transaction_list != null) {
		return div().with(
				table().with(
					tr().with(
						th("Sale ID"),
						th("Status"),
						th("Date"),
						th("Item ID"),
						th("Quantity"),
						th("Price"),
						th("Address")
					),
					each(transaction_list, transaction ->
						tr().with(
							td(Integer.toString(transaction.getSaleID())),
							td(transaction.getStatus()),
							td(transaction.getCompletionDate().toString()),
							td(Integer.toString(transaction.getSaleItem().getId())),
							td(Integer.toString(transaction.getQuantity())),
							td(Integer.toString(transaction.getSalePrice())),
							td(transaction.getShippingAddress().toString())
							)
						)	
					)
				);
		}
		return div().with(
				p("There are no Transactions in the last week!"));
	}

	@Override
	protected String pageTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
