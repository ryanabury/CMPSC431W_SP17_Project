package com.fusion.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

public class AddItemSupp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AddItemSupp() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddItemSupp Post");
		
		//Gets the supplierID of logged in supplier
		String supplierID = new String();
		if(request.getSession().getAttribute("supplierID") != null){
			 supplierID = request.getSession().getAttribute("supplierID").toString();
		}
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String reservePrice = request.getParameter("reservePrice");
		String quantity = request.getParameter("quantity");
		String category = request.getParameter("category");
		String detailedDescriptionURL = request.getParameter("detailedDescriptionURL"); //Item image
		String typeOfSale = request.getParameter("typeOfSale");
		String description = request.getParameter("description");
		
		if(name.isEmpty() || supplierID.isEmpty() || price.isEmpty() || reservePrice.isEmpty() || quantity.isEmpty() || category.isEmpty() || detailedDescriptionURL.isEmpty() || typeOfSale.isEmpty() || description.isEmpty()){
			response.sendRedirect("/Fusion_Web_Application/addItemSupplier.jsp");
		}else{
			
			DBHelper db = null;
			try {
				db = new DBHelper();
			}catch(DBHelperException e) {
				e.printStackTrace();
			}
			
			int result = -1;
			try {
				result = db.setNewSalesItem(name, supplierID, price, reservePrice, quantity, category, detailedDescriptionURL, typeOfSale, description);
			}catch(DBHelperException e){
				e.printStackTrace();
			}
			
			if(result == 0){
				response.sendRedirect("/Fusion_Web_Application/supplierPage.jsp");
			}
		}
	}
}
