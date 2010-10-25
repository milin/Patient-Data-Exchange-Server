package com.check.www;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

public class LoginAction extends org.apache.struts.action.Action
{
   private final static String SUCCESS = "success";
   private final static String FAILURE = "failure";
   public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
   {
	Loginform loginform = (Loginform) form;   
	String user = loginform.getusername();
	String pass = loginform.getpassword();
	Sqlconnection conn = new Sqlconnection();
    boolean result = conn.checklogin(user, pass);
    if(result)
    {
    	return mapping.findForward(SUCCESS);
    	
    }
    else
    {
    	 return mapping.findForward(FAILURE);
    }
   }

}
