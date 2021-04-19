package org.app.CamelTestFileComponent;


 

import java.util.ArrayList;
import java.util.List;

 
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.Route;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class SpringContextLoader  {

	public static void main(String arg[])
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("camel-context.xml");
		CamelContext camelContext = (CamelContext) ctx.getBean("camel-context-bean");
	 	ProducerTemplate templ = camelContext.createProducerTemplate();
		       
	 	List routes = camelContext.getRoutes();
	 	Route route = camelContext.getRoute("test");
	 	//route.getConsumer();
       // templ.sendBody("");
	 	
        System.out.println("The data is sent here ");
		 
	}
     
    
     
}