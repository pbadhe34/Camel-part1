package org.app.CamelTestFileComponent;

import java.util.concurrent.TimeUnit;

import org.apache.camel.main.Main;
import org.apache.camel.spi.ShutdownStrategy;

/**
 * Use Main class (Camel-Main)that boots the Camel application
 */
public final class MyApplication {

    private MyApplication() {
    }

    public static void main(String[] args) throws Exception {
        // use Camels Main class
        Main main = new Main();
        // lets use a configuration class (you can specify multiple classes)
        // (properties are automatic loaded from application.properties)
        main.configure().addConfigurationClass(MyConfiguration.class);
        // and add the routes (you can specify multiple classes)
        main.configure().addRoutesBuilder(MyRouteBuilder.class);
        // now keep the application running until the JVM is terminated (ctrl + c or sigterm)
        
      //  main.getCamelContext().getRouteController().
         
      
     //   main.getCamelContext().setShutdownStrategy(shutdownStrategy);
         
            
       
       
       
        MyRunnable runnable = new MyRunnable(5000, main);

        runnable.excecute();

        main.run(args);
        
        
		
        
    }

}
