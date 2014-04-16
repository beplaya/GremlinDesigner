package com.aj.gremlindesigner.pickers.base;

import com.aj.gremlindesigner.Gremlin;
import com.aj.wagon.Crate;

public class GremlinBuilder {

	@Crate(key = "gremlin", preference = true)
	public Gremlin gremlin;

	public GremlinBuilder() {
		gremlin = new Gremlin();
	}

}
