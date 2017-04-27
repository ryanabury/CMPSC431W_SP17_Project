package com.fusion.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusion.html.PostParameters;

public class Search extends HttpServlet implements Servlet {

	public Search() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(req, response);
		
		String searchTerms = req.getParameter(PostParameters.SEARCH_TERMS);
		searchTerms = searchTerms.replaceAll(" ", "+");
		
		response.sendRedirect("/Fusion_Web_Application/itemsearch.jsp?" + PostParameters.SEARCH_TERMS + "=" + searchTerms);
		
	}

}
