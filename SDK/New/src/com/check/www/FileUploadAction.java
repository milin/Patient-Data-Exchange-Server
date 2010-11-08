package com.check.www;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;
import java.io.*;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 
 */
public class FileUploadAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        FileUploadForm uploadForm = (FileUploadForm) form;
        //InputForm1 user2 = (InputForm1)request.getSession().getAttribute("InputForm1");
        //String selectedpartner = user2.getCountry();
        FileOutputStream outputStream = null;
        FormFile formFile = null;
        try {
            formFile = uploadForm.getFile();
            String path = getServlet().getServletContext().getRealPath("")+"/"+ formFile.getFileName();
            outputStream = new FileOutputStream(new File(path));
            outputStream.write(formFile.getFileData());
            String SMTP_HOST_NAME = "smtp.gmail.com";
            int SMTP_HOST_PORT = 465;
            String filename = formFile.getFileName();
            String msg = "Please click here to download a patient file";
            String msg1 = "<a href=\"http://localhost:8080/New/";
            String msg2 = "\"> here</a>";
            String text = msg+msg1+filename+msg2;
           // Stric;
           //* String pass;
            String check = "http://localhost:8080";
            //String text = "Please click here to download a patient file <a href=\"http://localhost:8080/New/check.txt\"> here</a>";
           
           String url = "<a href='"+check+"'>";
            String subject = "patient data file";
            String to = "catchapurba@gmail.com";
            
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
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }

		//String rec = "catch_apurba@yahoo.com";
		

      return mapping.findForward(SUCCESS);
    }
}