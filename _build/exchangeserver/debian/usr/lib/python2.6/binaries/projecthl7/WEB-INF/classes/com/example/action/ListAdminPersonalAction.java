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

import com.example.model.Personal;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class ListAdminPersonalAction extends Action{
	private Logger logger=Logger.getLogger(ListPersonalAction.class);
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
			Query query=session.createQuery("select count(p) from Personal p where p.status=0 or p.status=1 or p.status=2");
			Long totalPersonal = (Long)query.uniqueResult();
			logger.debug("+++++++++totalPersonal+++++++++++++++555555555555555555544++++++++++ "+totalPersonal);
			//logger.debug("+++++++++email++++++++++++++++++++++++ "+email);
			if(totalPersonal!=0){
				totalPages=totalPersonal/display;
				if(totalPersonal%display!=0){
					totalPages++;

				}
				logger.debug("+++++++++totalPages+++++++++++++++++++++++++ "+totalPages);
				long index=1;
				logger.debug("+++++++++request.getParameter(index)+++++++++++++++++++++++++ "+request.getParameter("index"));

				if(request.getParameter("index")!=null){
					index=Long.parseLong(request.getParameter("index"));
					logger.debug("+++++++++index+++++++++++++++++++++++++ "+index);
				}
				request.setAttribute("index",index);
			//	Query query1 = session.createQuery("select a from Album a left join fetch a.uploadedFile u left join fetch a.photos left join fetch a.albumMenu am where a.albumMenu.id =:albumMenuId order by a.lastUpdatedOn DESC");
			//	Query query1=session.createQuery("select p from Personal p left join fetch p.providerStaff s left join fetch s.Provider r");
				//Query query1=session.createQuery("from ProviderStaff ps join ps.personals pe join ps.provider pr where ps.status=1");
				Query query1=session.createQuery("from Provider p join p.providerStaffs ps join ps.personals pe where pe.status=0 or pe.status=1 or pe.status=2 order by p.id Asc");
			//	Query query1=session.createQuery("from Provider pr join pr.providerStaffs ps join ps.personals pe where ps.status=2");
				List<Provider> provider=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
			
				request.setAttribute("display", display);
				request.setAttribute("provider", provider);
				request.setAttribute("totalPages", totalPages);
				logger.debug("============================size==909===================+"+provider.size());
			}
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