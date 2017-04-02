package com.fusion.html;

import static j2html.TagCreator.*;

public class Footer {
	
	public static String generate() {
		String s = p("(C) 2017, Fusion Ltd.").withClass("footer").render();
		return s;
	}
	
}
