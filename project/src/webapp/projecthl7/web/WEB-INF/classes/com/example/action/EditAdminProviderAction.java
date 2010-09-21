package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.example.model.City;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class EditAdminProviderAction extends Action{
	private static Logger logger = Logger.getLogger(EditAdminProviderAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		
		logger.debug("++++++++++++++++++++++++++++++test1+++++++++++++++++++++++++++++++++++++++++++");
		long id=Long.parseLong(request.getParameter("id"));
		logger.debug("++++++++++++++++++++++++++++++test2+++++++++++++++++++++++++++++++++++++++++++"+id);
		
		long providerStaffId=Long.parseLong(request.getParameter("providerSId"));
		logger.debug("++++++++++++++++++++++++++++++test3+++++++++++++++++++++++++++++++++++++++++++"+providerStaffId);
		String phone=request.getParameter("phone1");
		DynaActionForm dynaActionForm = (DynaActionForm) form;
    	phone+=request.getParameter("phone2");
    	String contactNameEdit=request.getParameter("contactName")+" "+request.getParameter("contactSurName");
    	Provider providerEdit = new Provider();
    	
    	int pageProvider=Integer.parseInt(request.getParameter("pageProvider"));
    	int cityId=Integer.parseInt(request.getParameter("city"));
		if(cityId==0){
    		ActionErrors errors = new ActionErrors();
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.city"));
    		saveErrors(request, errors);
    		return mapping.getInputForward();
    	}
		
		logger.debug("++++++++++++++++++++++++++++++test4+++++++++++++++++++++++++++++++++++++++++++");
		//hospitalEdit.setContactName(contactName);
		//logger.debug("++++++++++++++++++++++++++++++hospitalEdit.getContactName++++++++++++++++++++++++++++++++++++++++++++"+hospitalEdit.getContactName());
		Session session = null;
		Transaction tx = null;
		
		try{	
			
	    	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			logger.debug("++++++++++++++++++++++++++++++test5+++++++++++++++++++++++++++++++++++++++++++"+providerStaffId);
			ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class, providerStaffId);
			//ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class, providerSId);
			logger.debug("++++++++++++++++++++++++++++++test5+++++++++++++++++++++++++++++++++++++++++++"+id);
			Provider provider=(Provider) session.get(Provider.class,id);
			City city=(City) session.load(City.class,cityId);
			provider.setCity(city);
			
			BeanUtils.copyProperties(provider, dynaActionForm);
			BeanUtils.copyProperties(providerStaff, dynaActionForm);
			providerStaff.setContactName(contactNameEdit);
		//	provider.setContactName(contactName);
			provider.setPhone(phone);
			session.update(provider);
			//hospital.setLocked(true);
			tx.commit();
			if(pageProvider==1){
				return (mapping.findForward("success1"));
			}else{
				return (mapping.findForward("success2"));
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
	}

}
