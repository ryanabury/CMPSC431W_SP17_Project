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
				h3("We are Fusion LTD."),
				hr(),
				p("At Fusion LTD., we strive for profound simplicity. " + 
				"This is an ambitious project that attempts to borrow the most " + 
				"successful attributes from Amazon.com and Ebay.com and present them " +
				"in a more user-friendly and capable way. " + 
				"Ebay has major issues with it's company image, and site usability. " +
				"The site is messy and clogged with unecessary information and the " +
				"company is not popular with the upcoming generation that values " + 
				"simplicity more than past generations. " + 
				"Amazon's seller functionality is very lacking, and recently the website " + 
				"has become bloated and difficult for newcomer's to use."),
				p("Fusion LTD. attempts to overcome these shortcomings that our " + 
				"inspiration has failed to fix. At the same time we strive to develop " + 
				"the website in such a way that it is easily modifiable and extensible " + 
				"so when society inevitably changes, Fusion LTD. can adapt with the times " + 
				"quickly and fully."),
				p("In achieving these smaller goals, this website will achieve the " + 
				"aptly named goal of being profound while maintaining simplicity.")
				);
	}

	@Override
	protected String pageTitle() {
		return "About";
	}

}
