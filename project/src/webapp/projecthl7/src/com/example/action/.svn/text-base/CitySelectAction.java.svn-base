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

import com.example.model.City;
import com.example.persistence.HibernateUtil;

public class CitySelectAction extends Action{
	private static Logger logger = Logger.getLogger(CitySelectAction.class);

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {

		int id=Integer.parseInt(request.getParameter("id"));


		Session session=null;
		Transaction tx = null;
		try{

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			City city=(City) session.get(City.class, id);
			request.setAttribute("city", city);
			logger.debug("+++++++++++++++++++city+++++++++++++++++++++++++++++++++++++++"+city.getName());
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

