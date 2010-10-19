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

import com.example.model.Provider;
import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class AddProviderRequestAction extends Action{
	private static Logger logger = Logger.getLogger(AddProviderRequestAction.class);

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		Long id=Long.parseLong(request.getParameter("id"));
		ProviderStaff ProviderStaffSeeeion=(ProviderStaff) request.getSession().getAttribute("User");
		long providerSession=ProviderStaffSeeeion.getProvider().getId();

		Session session = null;
		Transaction tx = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			ProviderService providerService =(ProviderService) session.get(ProviderService.class,id);
			Provider provider=(Provider)session.get(Provider.class,providerSession);
			
			if(provider.getServiceId()==null || provider.getServiceId().equals("")){
				provider.setServiceId(String.valueOf(providerService.getProvider().getId()));	
			}else{
				provider.setServiceId(provider.getServiceId()+","+providerService.getProvider().getId());	
			}
			
			providerService.setStatus(1);
			session.save(provider);
			session.save(providerService);
			
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
