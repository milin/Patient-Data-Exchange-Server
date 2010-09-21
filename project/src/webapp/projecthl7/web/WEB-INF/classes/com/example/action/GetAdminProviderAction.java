package com.example.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.City;
import com.example.model.Country;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class GetAdminProviderAction extends Action{
	private static Logger logger = Logger.getLogger(ListAdminProviderAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		
		Long staffId=Long.parseLong(request.getParameter("staffId"));
		int statusPage=Integer.parseInt(request.getParameter("statusPage"));
		logger.debug("+xxxxxxxxxxxxstatusPage)xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+statusPage);
		logger.debug("+xxxxxxxxxxxxid)xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+staffId);
		Session session = null;
		Transaction tx = null;
try{
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			logger.debug("+1111111111111111111111111111111111"+staffId);
			//Begin select Database Provider 
			Provider provider = (Provider) session.get(Provider.class,staffId);
			logger.debug("+222222222222222222222222222"+provider);
			
			Query query1=session.createQuery("from ProviderStaff ps where ps.provider.id=:id and ps.master =1");
			query1.setLong("id", staffId);
			ProviderStaff providerStaff=(ProviderStaff) query1.uniqueResult();
			provider.getCity().getId();
			int countryId=provider.getCity().getCountry().getId();
			List<Country> country=session.createQuery("from Country co ").list();
			request.setAttribute("country", country);
			List<City> city =session.createQuery("from City c where c.country.id=:countryId order by c.id Asc").setInteger("countryId",countryId).setReadOnly(true).list();
			logger.debug("+xxxxxxxxxxxx+++++++++++++++xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			tx.commit();
			String[] contactName=providerStaff.getContactName().split(" ");
			//logger.debug("----------------contactName.length()---------"+contactName.length+"--------contactName.length()------------------");
			providerStaff.setContactName(contactName[0]);
			//check surname 
			
			if(contactName.length==2){
				request.setAttribute("contactSurName", contactName[1]);
			}
			if(statusPage==1){
				request.setAttribute("provider", provider);
				request.setAttribute("providerStaff",providerStaff);
				request.setAttribute("city", city);
				return (mapping.findForward("successGet"));
			}else if(statusPage==2){
				
				String strPhone=new String(provider.getPhone());
				
				if(provider.getPhone().length()>11){
					int phoneLength=provider.getPhone().length();
					request.setAttribute("phone",strPhone.substring(11,phoneLength));
				//logger.debug("-----------------strPhone.substring(11,14);---------"+strPhone.substring(11,14)+"--------------------------");
				}
				provider.setPhone(strPhone.substring(0,11));
				request.setAttribute("provider", provider);
				request.setAttribute("city", city);
				request.setAttribute("providerStaff",providerStaff);
				return (mapping.findForward("successGetEdit"));
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
