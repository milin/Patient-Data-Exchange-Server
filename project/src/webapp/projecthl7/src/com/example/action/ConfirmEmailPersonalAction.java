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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Personal;
import com.example.model.Provider;
import com.example.persistence.HibernateUtil;

public class ConfirmEmailPersonalAction extends Action{
	private static Logger logger = Logger.getLogger(ConfirmEmailProviderAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String text=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Query q =session.createQuery("from Personal pe where pe.username=:username and pe.password=:password and pe.status=0");
			//logger.debug("+++++++++++++++++++++++++++++++++ProviderProviderr2+++++++++++++++");
			 q.setString("username",username);
			 q.setString("password",password);
			 Personal personal = (Personal) q.uniqueResult();
			 
			// logger.debug("+++++++++++++++++++++++++++++++++provider+++++++++++++++"+provider);
				if(personal==null){
				
						ActionErrors errors = new ActionErrors();
						errors.add("userConfirm",new ActionMessage("errors.noConfirm"));
						saveErrors(request, errors);
						text="Not confirm e-mail!";
						request.setAttribute("text",text);
						return mapping.findForward("success");
						
					}else{
						personal.setStatus(1);
						session.save(personal);
						tx.commit();
						text="You confirm e-mail succeed.";
						request.setAttribute("text",text);
					}
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