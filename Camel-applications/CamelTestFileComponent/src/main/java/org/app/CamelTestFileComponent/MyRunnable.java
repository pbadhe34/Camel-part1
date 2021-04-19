package org.app.CamelTestFileComponent;

import java.util.concurrent.TimeUnit;

import org.apache.camel.main.Main;

public class MyRunnable implements Runnable {

    long waitingFor = -1;
    Main camelMain;

    public MyRunnable(long waitingFor, Main main){
        this.waitingFor = waitingFor;
        this.camelMain = main;
    }

    public void excecute(){

        Thread thread = new Thread(this);

        thread.start();
    }

    @Override
    public void run() {

        try {
            synchronized (this) {
                    this.wait( waitingFor );
            }
        } catch (InterruptedException e) {
        }

        try {
            System.out.println("MyRunnable is shutting down Camel Main");
            
            System.out.println("*****************");
            
            //camelMain.getShutdownStrategy().await();
            camelMain.getShutdownStrategy().await(8000, TimeUnit.MILLISECONDS);
          
            System.out.println("$$$$$$$$$$$$$$$$$$$");
            camelMain.shutdown();
            
            /*
    		 * camelMain.getShutdownStrategy().shutdown(); 
    		 * camelMain.getCamelContext().shutdown();
    		 * camelMain.getCamelContext().stop(); 
    		 * camelMain.getCamelContext().start();
    		 * camelMain.getInstance().completed();
    		 */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}