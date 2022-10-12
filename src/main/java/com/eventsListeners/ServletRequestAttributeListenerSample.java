package com.eventsListeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener

public class ServletRequestAttributeListenerSample implements ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent srae)
    {
        System.out.println("A new request attribute is added");
        System.out.println("Name of this attribute " + srae.getName());
        System.out.println("Value of this attribute " + srae.getValue());
        System.out.println();
        System.out.println();
    }



    public void attributeRemoved(ServletRequestAttributeEvent srae)
    {

        System.out.println("A request attribute is removed");
        System.out.println("Name of this attribute " + srae.getName());
        System.out.println("Value of this attribute " + srae.getValue());
        System.out.println();
        System.out.println();

    }


    public void attributeReplaced(ServletRequestAttributeEvent srae)
    {

        System.out.println("A request attribute is replaced");
        System.out.println("Name of this attribute " + srae.getName());
        System.out.println("Value of this attribute " + srae.getValue());
        System.out.println();
        System.out.println();

    }

}

