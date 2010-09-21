package com.example.action.admin;

import java.util.Iterator;

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
import com.example.action.WebActionException;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class DeleteProviderAction extends Action{
	private static Logger logger = Logger.getLogger(DeleteProviderAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		logger.debug("providerStaffIdproviderStaffIdproviderStaffIdproviderStaffId");
		Long providerId=Long.parseLong(request.getParameter("providerId"));
		logger.debug("providerStaffIdproviderStaffIdproviderStaffIdproviderStaffId"+providerId);
		Integer pageId=Integer.parseInt(request.getParameter("page"));
		logger.debug("pageIdpageIdpageIdpageIdpageIdpageIdpageIdpageIdpageId"+pageId);
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Provider provider=(Provider) session.get(Provider.class, providerId);
			//provider.setStatus(4);
			
			
			Query query=session.createQuery("from ProviderStaff ps where ps.provider.id=:id ");
			 query.setLong("id", providerId);
			Iterator<ProviderStaff> providerStaffs = query.list().iterator();
			//logger.debug("providerStaffproviderStaffproviderStaff"+providerStaff);
			//ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class,provider.getId());
			while(providerStaffs.hasNext()){
				ProviderStaff v = providerStaffs.next();
				session.delete(v);
			}
			Query query1=session.createQuery("from Provider pr where pr.id=:id ");
			query1.setLong("id", providerId);
			Iterator<Provider> providers = query1.list().iterator();
			while(providers.hasNext()){
				Provider p =providers.next();
				session.delete(p);
			}
			logger.debug("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+pageId);
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
		}return (mapping.findForward("success"));
	}
	


}
