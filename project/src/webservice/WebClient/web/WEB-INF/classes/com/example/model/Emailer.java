package com.example.model;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.*;

public class Emailer{
	
	private String aFromEmailAddr;
	private String aToEmailAddr;
	private String aSubject;
	private String aBody;
	
	public Emailer(
			String aToEmailAddr
			){
		fetchConfig();
		this.aToEmailAddr = aToEmailAddr;
	};


  public void sendEmail(
    String aFromEmailAddr,
    String aSubject, String aBody
  ){
    
    Session session = Session.getDefaultInstance( fMailServerConfig, null );
    
    Message message = new MimeMessage( session );
    try {
    	Transport tr = session.getTransport("smtp");
    	System.out.println(fMailServerConfig.getProperty("mail.smtp.host"));
    	tr.connect(fMailServerConfig.getProperty("mail.smtp.host"), fMailServerConfig.getProperty("mail.smtp.user"), fMailServerConfig.getProperty("mail.smtp.password"));
        message.setFrom(new InternetAddress(aFromEmailAddr));
    	message.addRecipient(
                Message.RecipientType.TO, new InternetAddress(aToEmailAddr)
              );
        message.setSubject( aSubject );
        message.setContent( aBody, "text/html;charset=UTF-8" );  

        message.saveChanges();      
    	tr.sendMessage(message, message.getAllRecipients());
    	tr.close();
    }
    catch (MessagingException ex){
      System.err.println("Cannot send email. " + ex);
    }
  }

  public void refreshConfig() {
    fMailServerConfig.clear();
    fetchConfig();
  }

  private static Properties fMailServerConfig = new Properties();
  
  public Emailer(){
	  fetchConfig();
  }

  private void fetchConfig() {
    InputStream input = null;
    try {
      fMailServerConfig.load( this.getClass().getResourceAsStream("MyMailServer.properties") );
    }
    catch ( IOException ex ){
       ex.printStackTrace();
      System.err.println("Cannot open and load mail server properties file.");
    }
    finally {
      try {
        if ( input != null ) input.close();
      }
      catch ( IOException ex ){
    	
        System.err.println( "Cannot close mail server properties file." );
      }
    }
  }
} 
