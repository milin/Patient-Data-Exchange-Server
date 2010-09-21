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
import com.example.persistence.HibernateUtil;

public class ListAdminProviderRegisterAction extends Action{
	private static Logger logger = Logger.getLogger(ListAdminProviderRegisterAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		logger.debug("+++++++++Begin+++++++++++++++++++++++++ ");
		long display=Integer.parseInt(getServlet().getServletContext().getInitParameter("maxDisplayPersonal"));
		logger.debug("+++++++++display+++++++++++++++++++++++++ "+display);
		long totalPages;
		//logger.debug("+++++++++totalPages+++++++++++++++++++++++++ totalPages");
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			logger.debug("+++++++++query+++++++++++++++++++++++++ ");
			//Query query=session.createQuery("select count(p) from Provider p");
			//Query query1 = session.createQuery("select a from Album a left join fetch a.uploadedFile u left join fetch a.photos left join fetch a.albumMenu am where a.albumMenu.id =:albumMenuId order by a.lastUpdatedOn DESC");
			Query query=session.createQuery("select pr from Provider pr join fetch pr.providerStaffs ps where pr.status=0 and ps.master=1");
		//Long totalProvider = (Long)query.uniqueResult();
			List<Provider> providers=query.setReadOnly(true).list();
	//		logger.debug("+++++++++providers.size+++++++++++++++++++++++++ "+providers.size());
			logger.debug("+++++++++count(p)666+++++++++++++++++++++++++ "+providers.size());
			long totalProvider=providers.size();
			logger.debug("+++++++++totalProvider++++++++++++++++++++++++ "+totalProvider);
			if(totalProvider!=0){
				totalPages=totalProvider/display;
				if(totalProvider%display!=0){
					totalPages++;
				}
				long index=1;
//				//logger.debug("+++++++++request.getParameter(index)+++++++++++++++++++++++++ "+request.getParameter("index"));
//
				if(request.getParameter("index")!=null){
					index=Long.parseLong(request.getParameter("index"));
					//logger.debug("+++++++++index+++++++++++++++++++++++++ "+index);
				}
				request.setAttribute("index",index);
				Query query1=session.createQuery("from Provider p join fetch p.providerStaffs ps where ps.master=1");
				List<Provider> providers1=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
				logger.debug("+++++++++size+++++++++++++++++++++++++ "+providers1.size());
				request.setAttribute("display", display);
				request.setAttribute("provider", providers);
				request.setAttribute("totalPages", totalPages);
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
