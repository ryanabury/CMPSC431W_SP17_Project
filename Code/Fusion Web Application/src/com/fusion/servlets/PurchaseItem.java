package com.fusion.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.fusion.objects.Address;
import com.fusion.objects.CreditCard;
import com.fusion.objects.SaleItem;
import com.fusion.objects.SaleTransaction;
import com.fusion.objects.User;
import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

public class PurchaseItem extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
    
	public PurchaseItem(){
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Purchasing Item");
		
		String quantity = request.getParameter("quantity");
		String card_number = request.getParameter("card_number");
		String cvv_code = request.getParameter("cvv_code");
		String exp_date = request.getParameter("expiration_date");
		String street_address = request.getParameter("address");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");		
		String item_ID = request.getParameter("item_ID");
		String user_ID = request.getParameter("user_ID");
		
		try {
			
			DBHelper db = new DBHelper();
			User user = db.getUser(user_ID.toCharArray());
			
			SaleItem saleItem = db.getSaleItem(item_ID.toCharArray());
					
			Address a = new Address();
			a.setCity(city);
			a.setState(state);
			a.setStreetAddress(street_address);
			a.setZipCode(Integer.parseInt(zip));
		
			CreditCard cc = new CreditCard();
			cc.setBillingAddress(a);
			cc.setCardNumber(card_number);
			cc.setCvv(cvv_code);
			cc.setDate((short)Integer.parseInt(exp_date.substring(0, 2)), (short)Integer.parseInt(exp_date.substring(2, 4)));
			cc.setFirstName(user.getFirstName());
			cc.setLastName(user.getLastName());
			cc.setType("None");
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			SaleTransaction transaction = new SaleTransaction(
					0,
					cc,
					"Complete",
					timestamp,
					saleItem,
					Integer.parseInt(quantity),
					saleItem.getPrice(),
					a);
			
			db.submitTransaction(transaction, user);
			
			String to = db.getEmailAddress(user_ID);
			String from = "fusionltd@gmail.com";
			String host = "localhost";
			Properties properties = System.getProperties();
			properties.setProperty("mail.smtp.host", host);
			Session session = Session.getDefaultInstance(properties);
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Fusion Ltd. Confirmation Email");
				message.setText("Thank you for purchasing an item via Fusion Ltd.");
				Transport.send(message);
				System.out.println("Message send was successful.");
			}
			
			catch (MessagingException mex) {
				mex.printStackTrace();
			}
			
			response.sendRedirect("./userpage.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		System.out.println("LogIn Init");
	}

}
