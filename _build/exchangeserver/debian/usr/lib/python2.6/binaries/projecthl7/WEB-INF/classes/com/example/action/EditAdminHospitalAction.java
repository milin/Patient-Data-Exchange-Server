package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Provider;
import com.example.persistence.HibernateUtil;

public class EditAdminHospitalAction extends Action{
	private static Logger logger = Logger.getLogger(EditAdminHospitalAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		
		long id=Long.parseLong(request.getParameter("id"));
		
		String phone=request.getParameter("phone1");
    	phone+=request.getParameter("phone2");
    	String contactName=request.getParameter("contactName");
    	contactName+=" "+request.getParameter("contactSurName");
    	Provider providerEdit = new Provider();
    	
		
		
		
		//hospitalEdit.setContactName(contactName);
		//logger.debug("++++++++++++++++++++++++++++++hospitalEdit.getContactName++++++++++++++++++++++++++++++++++++++++++++"+hospitalEdit.getContactName());
		Session session = null;
		Transaction tx = null;
		
		try{	
			
	    	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Provider hospital=(Provider) session.get(Provider.class, id);
			
			
			BeanUtils.copyProperties(providerEdit, dynaActionForm);
			//hospital.setContactName(contactName);
			hospital.setPhone(phone);
			//hospital.setLocked(true);
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
