package com.example.action;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Provider;
import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;



public class ConnectProviderServiceAction extends Action{
	
	private static Logger logger= Logger.getLogger(ConnectProviderServiceAction.class);
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
    
    throws Exception {	
    	Long id = Long.parseLong(request.getParameter("idPs"));
    	ProviderStaff ProviderStaffSeeeion=(ProviderStaff) request.getSession().getAttribute("User");
		long providerSession=ProviderStaffSeeeion.getProvider().getId();
		
    	
		Session session = null;
		Transaction tx = null;
		try{
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Provider provider=(Provider) session.get(Provider.class, providerSession);
			ProviderService providerService=(ProviderService) session.get(ProviderService.class, id);
			if(providerService.getStatus()==1){
				providerService.setStatus(2);
			}else if(providerService.getStatus()==2) {
				providerService.setStatus(1);
			}
			//Provider provider=(Provider) request.getSession().getAttribute("User");
			logger.debug("--------------------------------------------"+provider.getId()+"========================");
			session.save(providerService);
			
			
			request.setAttribute("id",provider.getId());
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
