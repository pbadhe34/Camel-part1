package org.app.Camel_Java_app;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
		
		/*
		 * System.out.println("CamelContext is running with Main"); Main main = new
		 * Main(); main.configure().addRoutesBuilder(new MyRouteBuilder()); //This is
		 * non-blocking main.run(args);
		 * 
		 * //The next code will never get to run.. main.stop(); main.shutdown();
		 * System.out.println("Main is shutting down");
		 */
		
		  System.out.println("CamelContext is getting created"); 
		  CamelContext ctx = new DefaultCamelContext(); 
		  ctx.addRoutes(new MyRouteBuilder());
		  ctx.start();
		  System.out.println("CamelContext is getting started"); 
		  Thread.sleep(5000);
		  ctx.stop(); 
		  ctx.shutdown(); 
		  System.out.println("CamelContext has shutdown");
		 
    	 
    	 
    }

}

