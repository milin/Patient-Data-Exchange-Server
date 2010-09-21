package com.example.model;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.*;

import java.util.Date;
import java.util.Properties;



public class SendMail {
	
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_HOST_PORT = 465;
   // private static final String SMTP_AUTH_USER = "chinoros.x@gmail.com";
 //   public static final String SMTP_AUTH_USER = "chinoros.x@gmail.com";
    //private static final String SMTP_AUTH_PWD  = "mypwd";
   // private static final String SMTP_AUTH_PWD  = "077268487";
   /* public static void main(String[] args) throws Exception{
       new SimpleMail().test();
    }*/

    public void send(String to,String subject,String text,String user,String pass,String url) throws Exception{
        Properties props = new Properties();
        String SMTP_AUTH_USER=user;
        String SMTP_AUTH_PWD=pass;
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");
        // props.put("mail.smtps.quitwait", "false");

        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setSentDate(new Date());
        message.setContent(text+url, "text/html");
        //message.setContent("<h1>text</h1>"+text, "text/plain");
        message.setContentMD5(text);
    	//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
        transport.connect
          (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

        transport.sendMessage(message,
            message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
}
