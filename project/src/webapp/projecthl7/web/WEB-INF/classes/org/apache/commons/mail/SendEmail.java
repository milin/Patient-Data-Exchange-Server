package org.apache.commons.mail;

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import javax.mail.Transport;



public class SendEmail {
//	public void send() throws EmailException
//	   {
//			SimpleEmail email = new SimpleEmail();
//			//  email.setHostName("smtp.gmail.com");
//			  email.addTo("chinoros.x@gmail.com", "John Doe");
//			  email.setFrom("chinoros.x@gmail.com", "Me");
//			  email.setSubject("Test message");
//			  email.setMsg("This is a simple test of commons-email");
//			
//			
//			 email.setPopBeforeSmtp(true, "smtp.gmail.com", "chinoros.x@gmail.com","077268487");
//			//  email.setAuthentication("chinoros.x@gmail.com","077268487");
//			  email.setSmtpPort(587);
//			  
//	   }
private String mailhost = "smtp.gmail.com";
	
	public synchronized void SendEmail(String subject, String body, String sender, String recipients)  throws Exception 
	{	
		
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		 
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mailhost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
 
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{ return new PasswordAuthentication("username","password");	}
		});		
 
		MimeMessage message = new MimeMessage(session);
		message.setSender(new InternetAddress(sender));
		message.setSubject(subject);
		message.setContent(body, "text/plain");
		if (recipients.indexOf(',') > 0) 
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
		else
					message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
 
		
		Transport.send(message);
		
	}
	
	
	public static void main(String args[]) throws Exception
	{
	//	MailUtils mailutils = new MailUtils();
	//	mailutils.sendMail("test", "test", "from@gmail.com", "To@gmail.com");
		
	}
}

