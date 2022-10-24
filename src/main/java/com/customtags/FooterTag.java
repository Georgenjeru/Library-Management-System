package com.customtags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class FooterTag extends SimpleTagSupport {

    StringWriter stringWriter =  new StringWriter();

    public void doTag() throws JspException, IOException {
        getJspBody().invoke(stringWriter);
        JspWriter out = getJspContext().getOut();
        out.println("<br/> " + stringWriter.toString() + "</body></html>");
    }
}