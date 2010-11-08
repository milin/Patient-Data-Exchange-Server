package com.check.www;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.io.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

public class InputAction1 extends DispatchAction {
	private final static String SUCCESS = "success";
	private final static String SUCC = "succ";  
    //String username = user.getusername();
	public ActionForward populate1(ActionMapping mapping, ActionForm  form,
	        HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
		Loginform user1 = (Loginform)request.getSession().getAttribute("Loginform"); 
	    ArrayList countryList = new ArrayList();
	    InputForm1 inputForm1 = (InputForm1) form; 
	    String username = user1.getusername();
	   // Loginform user = (Loginform) form; //change
	   // String username = user.getusername();
	    
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
	    
	    inputForm1.setCountryList(countryList);    
	    return mapping.findForward(SUCCESS);
	}
	public ActionForward save1(ActionMapping mapping, ActionForm  form,
	        HttpServletRequest request, HttpServletResponse response)
	{
		 
	     return mapping.findForward(SUCC);
	}
	
	}