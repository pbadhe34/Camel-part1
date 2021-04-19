package org.app.Camel_Java_app;

import java.util.concurrent.TimeUnit;

import org.apache.camel.main.Main;
import org.apache.camel.spi.ShutdownStrategy;

/**
 * Use Main class (Camel-Main)that boots the Camel application
 */
public final class RunnableMainApplication {

    private RunnableMainApplication() {
    }

    public static void main(String[] args) throws Exception {
        // use Camels Main class
        Main mainCamel = new Main();         
        mainCamel.configure().addRoutesBuilder(MyRouteBuilder.class);
        
      //shutdown from other thread
          
        MainRunnable runnable = new MainRunnable(5000, mainCamel);

        runnable.excecute();

        //Blocking execution
        mainCamel.run(args);      
        
		
        
    }

}
