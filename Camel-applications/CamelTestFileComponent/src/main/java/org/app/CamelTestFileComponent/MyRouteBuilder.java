package org.app.CamelTestFileComponent;

import org.apache.camel.builder.RouteBuilder;

//Java definition of the message Route
public class MyRouteBuilder extends RouteBuilder {

	
    @Override
    public void configure() throws Exception {
        from("timer:foo?period={{myPeriod}}")
            .bean("myBean", "hello")
            .log("${body}")
            .bean("myBean", "bye")
            .log("${body}");
    }
}
