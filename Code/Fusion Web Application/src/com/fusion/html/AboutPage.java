package com.fusion.html;

import j2html.tags.ContainerTag;
import static j2html.TagCreator.*;

public class AboutPage extends AbstractPage{
	
	public AboutPage() {
		super();
	}

	@Override
	protected ContainerTag generateBody() {
		return div().with(
				p("This is an about page. It describes our company"),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("."),
				p("This is for testing the sticky footer btw")
				);
	}

	@Override
	protected String pageTitle() {
		return "About";
	}

}
