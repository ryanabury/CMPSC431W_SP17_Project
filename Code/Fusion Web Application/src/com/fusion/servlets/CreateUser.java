package com.fusion.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fusion.sql.DBHelper;
import com.fusion.sql.DBHelper.DBHelperException;

public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateUser() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CreateUser Post");
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String phone_num = request.getParameter("phone_num");
		String gender = request.getParameter("gender");
		String annual_salary = request.getParameter("annual_salary");
		
		if(first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || age.isEmpty() || phone_num.isEmpty() || annual_salary.isEmpty()){
			response.sendRedirect("./create_user.jsp");
		}else{
			
			DBHelper db = null;
			try {
				db = new DBHelper();
			} catch (DBHelperException e) {
				e.printStackTrace();
			}
			
			int result = -1;
			try {
				result = db.setCreateUser(first_name,last_name,username,email,password,age,phone_num,gender,annual_salary);
			} catch (DBHelperException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result == 0){
				response.sendRedirect("./login.jsp");
			}
		}
	}

}
