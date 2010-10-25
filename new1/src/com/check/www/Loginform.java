package com.check.www;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
public class Loginform extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7296737511907832409L;
	private String username = null;
    private String password = null;
    public Loginform()
    {
    	super();
    }
    public void setusername(String username)
    {
    	this.username = username;
    }
   public String getusername()
   {
	   return username;
   }
   public void setpassword(String password)
   {
	   this.password = password;
   }
   public String getpassword()
   {
	   return password;
   }
}

