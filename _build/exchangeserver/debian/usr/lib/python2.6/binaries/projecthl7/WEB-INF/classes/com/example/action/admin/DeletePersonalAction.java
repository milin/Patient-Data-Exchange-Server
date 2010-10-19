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
import com.example.model.Personal;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class DeletePersonalAction extends Action {
	private static Logger logger = Logger.getLogger(DeleteProviderAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		Long personalId=Long.parseLong(request.getParameter("personalId"));
		//Integer pageId=Integer.parseInt(request.getParameter("page"));
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Personal personal=(Personal) session.get(Personal.class, personalId);
			personal.setStatus(3);
			logger.debug("++++++++++++++++++++++++++++++provider.getId()"+personal.getId());
		
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
