package com.eventsListeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionAttributeListener---attributeAdded() --");
        System.out.printf("added attribute name: %s, value:%s %n", event.getName(),
                event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionAttributeListener---attributeRemoved() --");
        System.out.printf("removed attribute name: %s, value:%s %n", event.getName(),
                event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("-- HttpSessionAttributeListener----attributeReplaced() --");
        System.out.printf("replaced attribute name: %s, value:%s %n", event.getName(),
                event.getValue());
    }
}
