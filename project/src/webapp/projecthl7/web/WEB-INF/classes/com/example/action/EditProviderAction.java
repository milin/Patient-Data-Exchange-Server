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

import com.example.model.City;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class EditProviderAction extends Action{
	private static Logger logger = Logger.getLogger(EditProviderAction.class);
	
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		logger.debug("++++++++++++++++++++++++++++++test1+++++++++++++++++++++++++++++++++++++++++++");
		long providerStaffId;
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		
		logger.debug("++++++++++++++++++++++++++++++test2+++++++++++++++++++++++++++++++++++++++++++");
	
			//HttpSession session = request.getSession();
			ProviderStaff providerStaffSession=(ProviderStaff) request.getSession().getAttribute("User");
			providerStaffId =providerStaffSession.getId();
			
		logger.debug("++++++++++++++++++++++++++++++test5+++++++++++++++++++++++++++++++++++++++++++");
		
		String phone=request.getParameter("phone1");
    	phone+=request.getParameter("phone2");
    	String contactNameEdit=request.getParameter("contactName")+" "+request.getParameter("contactSurName");
    	
    	
    	logger.debug("++++++++++++++++++++++++++++++contactNameEdit+++++++++++++++contactNameEdit+++++++++++++contactName+++++++++++++++"+contactNameEdit);
    	int cityId=Integer.parseInt(request.getParameter("city"));
    	logger.debug("++++++++++++++++++++++++++++++cityId+++++++++++++++++++++++++++++++++++++++++++"+cityId);
		
    	if(cityId==0){
    		ActionErrors errors = new ActionErrors();
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.city"));
    		saveErrors(request, errors);
    		return mapping.getInputForward();
    	}
    	
		//hospitalEdit.setContactName(contactName);
	//	logger.debug("++++++++++++++++++++++++++++++hospitalEdit.getContactName++++++++++++++++++++++++++++++++++++++++++++"+hospitalEdit.getContactName());
		Session session = null;
		Transaction tx = null;
		
		try{	
			
	    	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class, providerStaffId);
			Provider provider=(Provider) session.get(Provider.class, providerStaff.getProvider().getId());
			City city=(City) session.load(City.class,cityId);
			//Provider provider=new Provider();
			provider.setCity(city);
			
			BeanUtils.copyProperties(provider, dynaActionForm);
			BeanUtils.copyProperties(providerStaff, dynaActionForm);
			providerStaff.setContactName(contactNameEdit);
			//providerStaff.setContactName(contactName);
			provider.setPhone(phone);
			//session.update(providerStaff);
			
			session.update(provider);
			tx.commit();
			request.setAttribute("staffId", providerStaff.getId());
			request.setAttribute("statusSubMenu",2);
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