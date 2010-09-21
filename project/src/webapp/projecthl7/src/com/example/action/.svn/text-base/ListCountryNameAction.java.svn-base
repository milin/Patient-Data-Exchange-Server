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

import com.example.model.Country;
import com.example.persistence.HibernateUtil;

public class ListCountryNameAction extends Action{
	private static Logger logger = Logger.getLogger(ListCountryNameAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		int id=Integer.getInteger(request.getParameter("id"));
		logger.debug("++===============id===============++"+id);
		Session session = null;
		Transaction tx = null;
		try{
			//Begin Unit of work
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Country country = (Country) session.get(Country.class,id);
			logger.debug("++===============country==============++"+country.getName());
			request.setAttribute("country", country);
			//session.save(register);
		
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

