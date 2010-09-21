package com.example.test;

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

import com.example.action.WebActionException;
import com.example.model.Country;
import com.example.model.Personal;
import com.example.persistence.HibernateUtil;
public class testAction extends Action{
	private Logger logger=Logger.getLogger(testAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		
		long display=Integer.parseInt(getServlet().getServletContext().getInitParameter("maxDisplayPersonal"));
		//logger.debug("+++++++++display++++++++++++++++++++++++ "+display);
		long totalPages;
		Session session = null;
		Transaction tx = null;
		try{

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
	
			//	Query query1 = session.createQuery("select a from Album a left join fetch a.uploadedFile u left join fetch a.photos left join fetch a.albumMenu am where a.albumMenu.id =:albumMenuId order by a.lastUpdatedOn DESC");
			//	Query query1=session.createQuery("select p from Personal p left join fetch p.providerStaff s left join fetch s.Provider r");
			//	Query query1=session.createQuery("select ps from ProviderStaff ps right join fatch ps.personal pe ");
			//	List<Personal> personals=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
			
				Query query1=session.createQuery("from Country co join co.citys ci");
				List<Country> country=query1.setReadOnly(true).list();
			
				
				
				request.setAttribute("display", display);
				request.setAttribute("country", country);
			//	request.setAttribute("totalPages", totalPages);
			logger.debug("============================size=====================+"+country.size());
			//s}
			//Begin Unit of work


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