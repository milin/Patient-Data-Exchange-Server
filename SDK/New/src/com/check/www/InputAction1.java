package com.check.www;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class InputAction1 extends DispatchAction {
	private final static String SUCCESS = "success";
	  
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
	public ActionForward save(ActionMapping mapping, ActionForm  form,
	        HttpServletRequest request, HttpServletResponse response)
	        throws Exception{
             return mapping.findForward(SUCCESS); 
	}
	}