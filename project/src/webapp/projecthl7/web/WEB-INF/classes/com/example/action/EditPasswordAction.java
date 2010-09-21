package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.classic.HavingParser;

import com.example.model.HashPassword;
import com.example.model.Personal;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class EditPasswordAction extends Action{
	private static Logger logger = Logger.getLogger(EditPasswordAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		
		long personalId=0;
	//	int positionId;
		String passwordOld=request.getParameter("passwordOld");
		String passwordNew1=request.getParameter("passwordNew1");
		String passwordNew2=request.getParameter("passwordNew2");
		
		
		if(!passwordNew2.equals(passwordNew1)){
    		ActionErrors errors = new ActionErrors();
    		logger.debug("+++++++++++++++++++++"+request.getParameter("rePassword")+"-------------------------"+request.getParameter("hospitalRetypePassword"));
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.newPassword"));
    		logger.debug("yes");
			saveErrors(request, errors);
			return mapping.getInputForward();
    	}
		
		
		HttpSession sessionUser = request.getSession();
		ProviderStaff providerStaffSession=(ProviderStaff) sessionUser.getAttribute("User");
		HashPassword hashPassword=new HashPassword();
		
		
		
		
		
		
		Long sessionUserId =providerStaffSession.getId();
		Session session = null;
		Transaction tx = null;
		
		try{	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class, sessionUserId);
			
		
			passwordOld=hashPassword.hashPassword(passwordOld);
			if(!providerStaff.getPassword().equals(passwordOld)){
				ActionErrors errors = new ActionErrors();
	  //  		logger.debug("++++++++======+passwordOld+++++++++++   "+passwordOld+"  provider.getPassword()--------    "+provider.getPassword());
	    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.currentPassword"));
	    //		logger.debug("yes");
				saveErrors(request, errors);
				return mapping.getInputForward();
			}
			
			
			
			String passwordNew=hashPassword.hashPassword(passwordNew1);
			
			
			
			
			
			
			BeanUtils.copyProperties(providerStaff, dynaActionForm);
			providerStaff.setPassword(passwordNew);
			
			//session.save(personal);
			tx.commit();

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
