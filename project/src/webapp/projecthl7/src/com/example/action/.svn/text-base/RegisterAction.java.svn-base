package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Provider;

import com.example.persistence.HibernateUtil;

public class RegisterAction extends Action{
private static Logger logger = Logger.getLogger(RegisterAction.class);
	
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
        throws Exception {
    	if(request.getParameter("hospitalPassword")!=request.getParameter("hospitalRetypePassword")){
    		ActionErrors errors=new ActionErrors();
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.password"));
    		logger.debug("========================="+request.getParameter("hospitalPassword")+"-------------------------"+request.getParameter("hospitalRetypePassword"));
    		saveErrors(request, errors);
			return mapping.getInputForward();
    	}
    	Session session = null;
		Transaction tx = null;
    	try{
    		Provider hospital=new Provider();
    		
			//Begin Unit of work
			
		}catch(Exception ex){
			if(tx != null){
				tx.rollback();
			}
			throw new WebActionException(ex);
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
        return (mapping.findForward("success"));

    }
}
