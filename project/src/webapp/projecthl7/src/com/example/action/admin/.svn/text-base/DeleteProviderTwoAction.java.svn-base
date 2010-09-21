package com.example.action.admin;

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
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class DeleteProviderTwoAction extends Action{
	private static Logger logger = Logger.getLogger(DeleteProviderTwoAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		logger.debug("providerStaffIdproviderStaffIdproviderStaffIdproviderStaffId");
		Long providerStaffId=Long.parseLong(request.getParameter("providerStaffId"));
		logger.debug("providerStaffIdproviderStaffIdproviderStaffIdproviderStaffId"+providerStaffId);
		Integer pageId=Integer.parseInt(request.getParameter("page"));
		logger.debug("pageIdpageIdpageIdpageIdpageIdpageIdpageIdpageIdpageId"+pageId);
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Provider provider=(Provider) session.get(Provider.class, providerId);
			//provider.setStatus(4);
			ProviderStaff providerStaff = (ProviderStaff) session.get(ProviderStaff.class,providerStaffId);
	
			//Query query=session.createQuery("select ps from ProviderStaff ps where ps.provider=:id ");
			//ProviderStaff providerStaff=(ProviderStaff) query.setLong("id", providerStaffId).uniqueResult();
			logger.debug("providerStaffproviderStaffproviderStaff"+providerStaff);
			//ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class,provider.getId());
			providerStaff.setStatus(4);
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
		}
		return (mapping.findForward("success"));


	}
}
