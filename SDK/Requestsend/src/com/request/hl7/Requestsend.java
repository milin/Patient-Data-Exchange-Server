package com.request.hl7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Requestsend {
	
	public void sendemail(String receiptent,String firstname,String lastname,String age,String sex) throws Exception
    {
		String Firstname = firstname;
		String Lastname = lastname;
		String Sex = sex;
		String Age = age;
		
		Class.forName("com.mysql.jdbc.Driver");
	      //System.out.println("Driver loaded");
	      String emailaddress = null;
	      String user = receiptent;
	     // Establish a connection
	       Connection connection = DriverManager.getConnection
	       ("jdbc:mysql://localhost/projecthl7","root","1234");
	     //System.out.println("Database connected");
	      
	     // Create a statement
	     Statement statement = connection.createStatement();
	     ResultSet resultSet = statement.executeQuery("select contactEmail from ProviderStaff where username='"+user+"'");
	     if(resultSet.next())
	     {	 
	      
	    	 emailaddress = resultSet.getString(1); 
	    	 String SMTP_HOST_NAME = "smtp.gmail.com";
	         int SMTP_HOST_PORT = 465;
	        // String user;
	        //* String pass;
	        // String check = "http://localhost:8080";
	        // String text = " Hello welcome,click <a href=\"http://localhost:8080/New/ER-EHR.pdf\"> here</a> to enjoy ";
	        
	        // String url = "<a href='"+check+"'>";
	         String subject = "Request of Patient data of" + Firstname + Lastname;
	         String to = emailaddress;
	         
	       Properties props = new Properties();
	       String SMTP_AUTH_USER="exchangeserverhl7@gmail.com";
	       String SMTP_AUTH_PWD="exchangeserver";
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
	       Multipart multipart = new MimeMultipart();
	       BodyPart part1 = new MimeBodyPart();
	       part1.setText("Firstname" + " " + Firstname);
	       BodyPart part2 = new MimeBodyPart();
	       part2.setText("Lastname" + " " + Lastname);
	       BodyPart part3 = new MimeBodyPart();
	       part3.setText("Age" +" " + Age);
	       BodyPart part4 = new MimeBodyPart();
	       part4.setText("Sex" +" " + Sex);
	       multipart.addBodyPart(part1);
	       multipart.addBodyPart(part2);
	       multipart.addBodyPart(part3);
	       multipart.addBodyPart(part4);
	       
	       message.setContent(multipart);
	       //message.setContent("<h1>text</h1>"+text, "text/plain");
	       //message.setContentMD5(text);
	   	//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
	       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	       transport.connect
	         (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

	       transport.sendMessage(message,
	           message.getRecipients(Message.RecipientType.TO));
	       transport.close();
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	connection.close(); 
	     } 
	     else
	     {
	    	 connection.close();
	     }
	

}
	
	
}
