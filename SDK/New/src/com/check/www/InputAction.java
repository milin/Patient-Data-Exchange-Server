package com.check.www;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.util.LabelValueBean;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;

public class InputAction extends DispatchAction {
	private final static String SUCCESS = "success";
	  
    //String username = user.getusername();
	public ActionForward populate(ActionMapping mapping, ActionForm  form,
	        HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
		Loginform user = (Loginform)request.getSession().getAttribute("Loginform"); 
	    ArrayList countryList = new ArrayList();
	    InputForm inputForm = (InputForm) form; 
	    String username = user.getusername();
	   // Loginform user = (Loginform) form; //change
	    //String username = user.getusername();
	    
	    Check part = new Check();
	    String[] part1 = part.partener(username);
	    int leng = part1.length;
	    //countryList.add(new CountryData("1","dhungana"));
	    
	    
	    
	    for(int i=0;i<leng;i++)
	    {	
	    
	    String aString = Integer.toString(i);	
	    //countryList.add(part1[i]);
	    countryList.add(new CountryData(aString,part1[i]));
	    
	   
	    } 
	    
	    inputForm.setCountryList(countryList);    
	    return mapping.findForward(SUCCESS);
	}
	public ActionForward save(ActionMapping mapping, ActionForm  form,
	        HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
	    
		 InputForm patientform = (InputForm) form;
		 String selectedpartner = patientform.getCountry();
		 Check1 emailfinder = new Check1();
		 String selectedpartneremail = emailfinder.emailfinder(selectedpartner);
	     //CountryData am = new CountryData();
		 //String username = patientform.getCountryList();
	     //int i = Integer.parseInt(username);
	     
		//ArrayList ab = patientform.getCountryList();
	    //Object ia[] = ab.toArray();
	    //int leng = ia.length;
	    //String leng1 = 
	     //int len = ab.size();
	     //String aString = Integer.toString(len);
	     
	     //int s = ab.size();
	     //String[] str = new String[s];
	     //ab.toArray(str);
	     //String kaam = str[i];
	    // String[] partners = (String[])ab.toArray(new String[ab.size()]);
	    // String check = partners[i];
	     String patientid = patientform.getPatientid();
	     String firstname = patientform.getFirstname();
	     String lastname = patientform.getLastname();
	     String sex = patientform.getSex();
	     String age = patientform.getAge();
	     String phoneno = patientform.getPhoneno();
	     String address = patientform.getAddress();
	     String email = patientform.getEmail();
	     String rec = selectedpartneremail;
			String SMTP_HOST_NAME = "smtp.gmail.com";
	        int SMTP_HOST_PORT = 465;
	       // Stric;
	       //* String pass;
	       // String text = <br> firstname </br> +lastname;
	        
	        String subject = "Request of Patient Information";
	        String to = rec;
	       
	        
	      Properties props = new Properties();
	      String SMTP_AUTH_USER="catchapurba@gmail.com";
	      String SMTP_AUTH_PWD="Reeboknike81";
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
	      part1.setText("patientid" + patientid);
	      BodyPart part2 = new MimeBodyPart();
	      part2.setText("Firstname" + " " + firstname);
	      BodyPart part3 = new MimeBodyPart();
	      part3.setText("Lastname" + " " + lastname);
	      BodyPart part4 = new MimeBodyPart();
	      part4.setText("Age" + " " + age);
	      BodyPart part5 = new MimeBodyPart();
	      part5.setText("Phoneno" + " " + phoneno);
	      BodyPart part6 = new MimeBodyPart();
	      part6.setText("Address" + " " + address);
	      BodyPart part7 = new MimeBodyPart();
	      part7.setText("Email" + " " + email);
	      multipart.addBodyPart(part1);
	      multipart.addBodyPart(part2);
	      multipart.addBodyPart(part3);
	      multipart.addBodyPart(part4);
	      multipart.addBodyPart(part5);
	      multipart.addBodyPart(part6);
	      multipart.addBodyPart(part7);
	      message.setContent(multipart);
	      
	      
	      // message.setContent(text, "text/html");
	      //message.setContent("<h1>text</h1>"+text, "text/plain");
	     // message.setContentMD5(text);
	  	//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
	      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	      transport.connect
	        (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

	      transport.sendMessage(message,
	          message.getRecipients(Message.RecipientType.TO));
	      transport.close();
		    
	     ActionForward forward= null;
	     forward = mapping.findForward("success");
	     return forward; 		
	}  
	}