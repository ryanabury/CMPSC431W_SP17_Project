package com.fusion.html;

import java.util.ArrayList;

import com.fusion.objects.SaleTransaction;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class SaleReportPage extends AbstractPage{
	
	private ArrayList<SaleTransaction> transaction_list;

	public SaleReportPage(char[] userID) {
	}
	
	@Override
	protected ContainerTag generateBody() {
		
		transaction_list = null;
		
		try {
			transaction_list = new DBHelper().getTransactionReport();
		} catch (DBHelperException e) {
			e.printStackTrace();
		}
		
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
					).withClass("sale-report")
				);
		}
		return div().with(
				p("There are no Transactions in the last week!"));
	}

	@Override
	protected String pageTitle() {
		// TODO Auto-generated method stub
		return "Sale Reports";
	}

}
