package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

import com.fusion.sql.DBHelper.DBHelperException;

public class CreateUserPage extends AbstractPage {

	public CreateUserPage(){
		super();
	}
	
	@Override
	protected ContainerTag generateBody() {
		// TODO Auto-generated method stub
		return form()
				.withMethod("post")
				.withAction("create_user.jsp")
				.with(
						table()..with(
								thead().with(
										tr().with(
												th("Create Fusion Account")
												)
										),
								tbody().with(
										tr().with(
												td("First name: "),
												td().with(
														input()
														.withType("text")
														.withName("first_name")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Last name: "),
												td().with(
														input()
														.withType("text")
														.withName("last_name")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Username: "),
												td().with(
														input()
														.withType("text")
														.withName("username")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Email: "),
												td().with(
														input()
														.withType("text")
														.withName("email")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Password: "),
												td().with(
														input()
														.withType("password")
														.withName("password")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Age: "),
												td().with(
														input()
														.withType("text")
														.withName("age")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Phone number: "),
												td().with(
														input()
														.withType("text")
														.withName("phone_num")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td("Gender: "),
												td().with(
														input()
														.withType("radio")
														.withName("gender")
														.withValue("M")
														.withStyle("color: #000000")
														.attr("size", "30"),
														p("Male"),
														input()
														.withType("radio")
														.withName("gender")
														.withValue("F")
														.withStyle("color: #000000")
														.attr("size", "30"),
														p("Female"),
														input()
														.withType("radio")
														.withName("gender")
														.attr("checked","checked")
														.withValue("O")
														.withStyle("color: #000000")
														.attr("size", "30"),
														p("Other")
														)
												),
										tr().with(
												td("Annual Salary: "),
												td().with(
														input()
														.withType("text")
														.withName("annual_salary")
														.withStyle("border:2px solid #000000")
														.attr("size", "30")
														)
												),
										tr().with(
												td().with(
														input()
														.withType("submit")
														.withValue("Create your Fusion account")
														)
												)
										)
								)
						);
	}

	@Override
	protected String pageTitle() {
		return "Create User";
	}

}
