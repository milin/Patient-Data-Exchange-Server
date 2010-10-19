package com.example.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.City;
import com.example.model.Country;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class GetProviderAction extends Action{
	private static Logger logger= Logger.getLogger(GetProviderAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {	

		//long id=Long.parseLong(request.getParameter("id"));
		//long id=1;
		//logger.debug("+xxxxxxxxxxxxid)xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+id);
		Long staffId = Long.parseLong(request.getParameter("staffId"));
		Session session = null;
		Transaction tx = null;
		
		
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Begin select Database Provider 
			ProviderStaff providerStaff = (ProviderStaff) session.get(ProviderStaff.class,staffId);
			Provider provider=providerStaff.getProvider();
			
			provider.getCity().getId();
			int countryId=providerStaff.getProvider().getCity().getCountry().getId();
			List<Country> country=session.createQuery("from Country co ").list();
			request.setAttribute("country", country);
			List<City> city =session.createQuery("from City c where c.country.id=:countryId order by c.id Asc").setInteger("countryId",countryId).setReadOnly(true).list();
			
			tx.commit();
			String[] contactName=providerStaff.getContactName().split(" ");
			//logger.debug("----------------contactName.length()---------"+contactName.length+"--------contactName.length()------------------");
			providerStaff.setContactName(contactName[0]);
			//check surname 
			
			if(contactName.length==2){
				request.setAttribute("contactSurName", contactName[1]);
			}
			String strPhone=new String(provider.getPhone());
			
			logger.debug("-----------------strPhone.substring(0,11);---------"+strPhone.substring(0,11)+"--------------------------");
			
			if(provider.getPhone().length()>11){
				int phoneLength=provider.getPhone().length();
				request.setAttribute("phone",strPhone.substring(11,phoneLength));
			//logger.debug("-----------------strPhone.substring(11,14);---------"+strPhone.substring(11,14)+"--------------------------");
			}
			provider.setPhone(strPhone.substring(0,11));
			request.setAttribute("providerStaff",providerStaff);
			request.setAttribute("city", city);
			request.setAttribute("provider", provider);
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
















