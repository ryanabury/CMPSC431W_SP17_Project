package com.fusion.html;

import static j2html.TagCreator.*;

public class Footer {
	
	public static String generate() {
		return p("(C) 2017, Fusion Ltd.").withClass("footer").render();
	}
	
}
