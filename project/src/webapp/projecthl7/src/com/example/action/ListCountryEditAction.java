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

import com.example.persistence.HibernateUtil;

public class ListCountryEditAction extends Action{
	private static Logger logger= Logger.getLogger(ListCountryEditAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		int countryId=Integer.parseInt(request.getParameter("countryId"));
		//logger.debug("----------------------------------------countryId"+countryId);
		Session session = null;
		Transaction tx = null;
		try{
			//Begin Unit of work
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			List country = session.createQuery("from Country c").list();
			request.setAttribute("country", country);
			request.setAttribute("countryId", countryId);
			//session.save(register);
			//logger.debug("----------------------------------------countryId"+countryId);
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