package com.eventsListeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@WebListener

public class RequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(">>>>Request Made: " + sre.getServletContext().getContextPath());
        ServletRequest sr = sre.getServletRequest();
        HttpServletRequest request = (HttpServletRequest) sr;  // Cast to subinterface.

        String method = request.getMethod();
        Map<String,String[]> parameters = request.getParameterMap();

        System.out.println("Method: " + method);
        System.out.println("Path info: " + request.getServletPath());
        for (Map.Entry<String, String[]> parameter : parameters.entrySet())
            System.out.println(parameter.getKey() + " : " + parameter.getValue()[0]);

    }
}
