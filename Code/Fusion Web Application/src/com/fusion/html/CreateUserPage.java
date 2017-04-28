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
		return form()
				.withMethod("post")
				.withAction("CreateUser")
				.with(
						table().with(
								thead().with(
										tr().with(
												th("Create Fusion Account").attr("colspan", "2")
												)
										),
								tbody().with(
										tr().with(
												td("First name: "),
												td().with(
														input()
														.withType("text")
														.withName("first_name")
														)
												),
										tr().with(
												td("Last name: "),
												td().with(
														input()
														.withType("text")
														.withName("last_name")
														)
												),
										tr().with(
												td("Username: "),
												td().with(
														input()
														.withType("text")
														.withName("username")
														)
												),
										tr().with(
												td("Email: "),
												td().with(
														input()
														.withType("text")
														.withName("email")
														)
												),
										tr().with(
												td("Password: "),
												td().with(
														input()
														.withType("password")
														.withName("password")
														)
												),
										tr().with(
												td("Age: "),
												td().with(
														input()
														.withType("text")
														.withName("age")
														)
												),
										tr().with(
												td("Phone number: "),
												td().with(
														input()
														.withType("text")
														.withName("phone_num")
														)
												),
										tr().with(
												td("Gender: "),
												td().with(
														input()
														.withType("radio")
														.withName("gender")
														.withValue("m")
														.attr("size", "30"),
														span("Male"),
														input()
														.withType("radio")
														.withName("gender")
														.withValue("f")
														.attr("size", "30"),
														span("Female"),
														input()
														.withType("radio")
														.withName("gender")
														.attr("checked","checked")
														.withValue("o")
														.attr("size", "30"),
														span("Other")
														)
												),
										tr().with(
												td("Annual Salary: "),
												td().with(
														input()
														.withType("text")
														.withName("annual_salary")
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
