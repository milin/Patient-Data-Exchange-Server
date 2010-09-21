package com.example.action;

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

import java.util.Iterator;
import java.util.List;

import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class LockAdminProviderAction extends Action{
	private static Logger logger = Logger.getLogger(LockAdminProviderAction.class);
	
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
      throws Exception {
    	
    	Long id = Long.parseLong(request.getParameter("id"));
    	logger.debug("-------------id------------------------------------------------------------"+id);
		Session session = null;
		Transaction tx = null;
		
		try{	
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			//Provider hospital=(Provider) session.get(Provider.class, id);
		//TODO check status lock
			
			ProviderStaff providerStaff = (ProviderStaff) session.get(ProviderStaff.class,id);
			
		//	Iterator<ProviderStaff> ps = providerStaffs.iterator();
			
			//while(ps.hasNext()){
			//	ProviderStaff providerStaff = ps.next();
				//providerStaff.getId();
				if(providerStaff.getStatus()==2){
					providerStaff.setStatus(3);
				}else if(providerStaff.getStatus()==3){
					providerStaff.setStatus(2);
			//	}
			//}	
			//if(hospital.getStatus()==2){
			//	hospital.setStatus(3);
			//}else if(hospital.getStatus()==3){
			//	hospital.setStatus(2);
			}
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
