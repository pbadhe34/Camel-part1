 
package com.app;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;

 
public class MyRouteBuilder extends RouteBuilder {

     
	public static void main(String... args) throws Exception {
		System.out.println("Starting CamelContext with Sprig-Main");
	     Main.main(args);
	}
    /**
     * Lets configure the Camel routing rules using Java code...
     */
    public void configure() {
    	System.out.println("Spring main loading the route configured  with Java MyRouteBuilder");

        // TODO create Camel routes here.

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message
        // using XPath
		/*
		 * from("file:src/data?noop=true"). choice().
		 * when(xpath("/person/city = 'London'")).to("file:target/messages/uk").
		 * otherwise().to("file:target/messages/others");
		 */
     
            from("timer:app?period=300")                
                .log("Timer is running with java dsl");               
                 
      

    }
}
