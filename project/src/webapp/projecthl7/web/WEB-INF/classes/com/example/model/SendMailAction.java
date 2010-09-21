package com.example.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.junit.Test;

public class SendMailAction extends HttpServlet {
	@Test
	 public void doPost(HttpServletRequest req, 
             HttpServletResponse resp) 
  throws IOException { 
		
		Properties props = new Properties(); 
        Session session = Session.getDefaultInstance(props, null); 
 
        String msgBody = "..."; 
 
        try { 
            Message msg = new MimeMessage(session); 
            msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin")); 
            msg.addRecipient(Message.RecipientType.TO, 
                             new InternetAddress("chinoros.x@gmail.com", "Mr. User")); 
            msg.setSubject("Your Example.com account has been activated"); 
            msg.setText(msgBody); 
            Transport.send(msg); 
 
        } catch (AddressException e) { 
            // ... 
        } catch (MessagingException e) { 
            // ... 
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
