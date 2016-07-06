package james.a.grant.gremlindesigner.pickers.base;


import james.a.grant.gremlindesigner.Gremlin;
import james.a.grant.wagon.Crate;

public class GremlinBuilder {

    @Crate(key = "gremlin", preference = true)
    public Gremlin gremlin;

    public GremlinBuilder() {
        gremlin = new Gremlin();
    }

}
