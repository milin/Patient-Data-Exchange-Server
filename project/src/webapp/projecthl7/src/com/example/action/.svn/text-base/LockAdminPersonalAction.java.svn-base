package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.example.model.Personal;
import com.example.persistence.HibernateUtil;

public class LockAdminPersonalAction extends Action{
	private static Logger logger = Logger.getLogger(LockAdminPersonalAction.class);
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
			Personal personal=(Personal) session.get(Personal.class, id);
	
	if(personal.getStatus()==1){
			personal.setStatus(2);
			}else if(personal.getStatus()==2){
			personal.setStatus(1);
		}
			id=null;
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
