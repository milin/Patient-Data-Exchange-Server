package com.example.action;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TestSend extends Action {
	/*public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
        try {

            // The code to send mail
            Properties prop =System.getProperties();
            prop.put("mail.smtp.host", "locahost"); //mailhost 
            Session ses  = Session.getDefaultInstance(prop,null);
            MimeMessage msg = new MimeMessage(ses);
            msg.setFrom(new InternetAddress("conan_x@hotmail.com")); //from
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("conan_x@hotmail.com")); //to
            msg.setSubject("แจ้ง password");

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("เรียนท่านผู้จัดการบริษัท<br>");
            stringBuffer.append("รหัสผ่านของท่านคือ : 1234<br>"); 
            stringBuffer.append("ขอแสดงความนับถือ<br><br><br>");
            stringBuffer.append("Customer Service<br>");
            stringBuffer.append("Customer Service would like to inform your Username and Password.<br>");
            stringBuffer.append("Your password is : 1234<br><br>");
            stringBuffer.append("Please check the correctness<br>");
            stringBuffer.append("Fast Customer Service<br><br>");
            
            String text = stringBuffer.toString();
          
            msg.setContent( text , "text/html; charset=\"MS874\"");
            msg.setSentDate(new Date());

            Transport.send(msg);
        }catch(javax.mail.internet.AddressException ae){
            ae.printStackTrace();
        }catch(javax.mail.SendFailedException sfe) {
            sfe.printStackTrace();
        }
        catch(javax.mail.MessagingException me){
            me.printStackTrace();
        }

    }*/

}
