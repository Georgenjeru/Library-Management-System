package com.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.Serializable;
import java.util.Properties;

public class JavaEmailSender implements Serializable {

    private String emailAddressTo = new String();
    private String msgSubject = new String();
    private String msgText = new String();

    final String USER_NAME = "njerugeorge57@gmail.com";   //Username of the Google(gmail) account
    final String PASSSWORD = "GeorgeMuchene@23";  //Password of the Goole(gmail) account
    final String FROM_ADDRESS = "njerugeorge57@gmail.com";  //From address

    public JavaEmailSender() {
    }

    public static void main(String[] args) {
        JavaEmailSender email = new JavaEmailSender();
        //Sending test email
        email.createAndSendEmail("njerugeorge57@gmail.com", "Test email subject",
                "Congratulations !!! \nThis is test email sent by java class.");
    }

    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage() {

        //Create email sending properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("njerugeorge57@gmail.com", "GeorgeMuchene@23");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("njerugeorge57@gmail.com")); //Set from address of the email
            message.setContent(msgText,"text/html"); //set content type of the email

            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("njerugeorge57@gmail.com")); //Set email recipient

            message.setSubject("Hello World"); //Set email message subject
            Transport.send(message); //Send email message

            System.out.println("sent email successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmailAddressTo(String emailAddressTo) {
        this.emailAddressTo = emailAddressTo;
    }

    public void setSubject(String subject) {
        this.msgSubject = subject;
    }

    public void setMessageText(String msgText) {
        this.msgText = msgText;
    }

}



