package org.app.CamelTestFileComponent;

public class MyBean {

    private String hi;
    private String bye;

    private int count=0;
    public MyBean(String hi, String bye) {
    	System.out.println("MyBean ()");
        this.hi = hi;
        this.bye = bye;
        count =0;
    }

    public String hello() {
    	count++;
        return hi + " how are you at "+count +"?";
    }

    public String bye() {
        return bye + " World";
    }
}
