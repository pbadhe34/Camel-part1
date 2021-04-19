 
package org.app.CamelTestFileComponent;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * A basic example running as public static void main.
 */


//Java definition of the message Route
public final class CamelContextRunner {

    public static void main(String[] args) throws Exception {
        // create a CamelContext
        try (CamelContext camelContext = new DefaultCamelContext()) {

            // add routes which can be inlined as anonymous inner class
            // (to keep all code in a single java file for this basic example)
			
			  camelContext.addRoutes(new RouteBuilder() {
			  
			  @Override public void configure() { 
				  from("timer:test?period=200")
			       .log("Hello Camel User"); 
				  }
			  });		 

        	
         
        	//camelContext.addRoutes(new MyRouteBuilder());
            // start is not blocking
            camelContext.start();

            // so run for 5 seconds
            Thread.sleep(5000);

            // and then stop nicely
            camelContext.stop();
            camelContext.shutdown();
        }
    }
}
