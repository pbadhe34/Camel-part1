package org.app.message;


 

import java.util.ArrayList;
import java.util.List;

 
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.Route;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class SpringContextLoader  {

	public static void main(String arg[]) throws Exception
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
		CamelContext camelContext = (CamelContext) ctx.getBean("camel");
		
		CamelContext context = SpringCamelContext.springCamelContext(
	            ctx, false);
		
	 	ProducerTemplate templ = camelContext.createProducerTemplate();
		       
	 	List routes = camelContext.getRoutes();
	 	Route route = camelContext.getRoute("test");
	 	//route.getConsumer();
	 	
      // templ.sendBody("Hi Users here are we..");
     //  templ.sendBody("timer:test","Hi Users here are we..");
	 	
        System.out.println("The data is sent here to file ");
        camelContext.start();
        Thread.sleep(6000);
        camelContext.stop();
		 
	}
     
    
     
}