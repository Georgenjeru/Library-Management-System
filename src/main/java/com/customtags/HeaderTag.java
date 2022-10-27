package com.customtags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class HeaderTag extends SimpleTagSupport {

    private String applicationLabel;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<!DOCTYPE html>"+
                "<html>"+
                "<head>"+
                "<meta charset=\"utf-8\">"+
                "<title> "+ applicationLabel +" </title>"+
                "<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">"+


                "<link href=\"img/favicon.ico\" rel=\"icon\">"+

                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">"+
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>"+
                "<link href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">"+

                "<link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">"+
                "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">"+

                "<link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">"+
                "<link href=\"lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />"+

                "<link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\">"+

                "<link href=\"./css/style.css\" rel=\"stylesheet\">"+
                "</head>"+

                "<body>");
    }

    public String getApplicationLabel() {
        return applicationLabel;
    }

    public void setApplicationLabel(String applicationLabel) {
        this.applicationLabel = applicationLabel;
    }
}
