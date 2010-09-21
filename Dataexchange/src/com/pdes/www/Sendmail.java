package com.pdes.www;
import java.io.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sendmail
 */
public class Sendmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sendmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void sendmail() throws Exception
	{
		String rec = "catch_apurba@yahoo.com";
		String SMTP_HOST_NAME = "smtp.gmail.com";
        int SMTP_HOST_PORT = 465;
       // Stric;
       //* String pass;
        String text = "mail check";
        String url = "haha";
        String subject = "haha";
        String to = rec;
       
        
      Properties props = new Properties();
      String SMTP_AUTH_USER="exchangeserver@gmail.com";
      String SMTP_AUTH_PWD="Server";
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
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
	   	
		//String from = request.getParameter();
		//String to = request.getParameter(arg0);
		try {
			sendmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();

	      out.println("Email successfully sent");	
		
		// TODO Auto-generated method stub
	}

}
