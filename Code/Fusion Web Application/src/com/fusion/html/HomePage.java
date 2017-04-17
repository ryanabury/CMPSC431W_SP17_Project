package com.fusion.html;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

public class HomePage extends AbstractPage {

	@Override
	protected ContainerTag generageBody() {
		return div();
	}

}
