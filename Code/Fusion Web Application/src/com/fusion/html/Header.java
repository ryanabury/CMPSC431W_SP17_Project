package com.fusion.html;

import com.fusion.objects.User;
import static j2html.TagCreator.*;

public class Header {
	
	public static String generate(User user, String headerImage) {
		return div().with(						// Main Header Box
				h1("Fusion.com"), 		// Title
				div().with(div(), div())		// Menu / Login Box
		).render();
	}

}
