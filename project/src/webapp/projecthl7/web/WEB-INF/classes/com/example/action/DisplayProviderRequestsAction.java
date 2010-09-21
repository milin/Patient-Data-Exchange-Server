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
import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class DisplayProviderRequestsAction extends Action{
	private static Logger logger = Logger.getLogger(DisplayProviderRequestsAction.class);

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {

		Integer status =2;
		long totalPages;

		long display=Integer.parseInt(getServlet().getServletContext().getInitParameter("maxDisplayPersonal"));
		ProviderStaff ProviderStaffSeeeion=(ProviderStaff) request.getSession().getAttribute("User");
		long providerSession=ProviderStaffSeeeion.getProvider().getId();

		Session session = null;
		Transaction tx = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			
			Provider provider=(Provider) session.get(Provider.class, providerSession);
			Query query=session.createQuery("select ps from ProviderService ps RIGHT join " +
					"fetch ps.provider pr  join fetch ps.providerTwo pt " +
			"where ps.providerTwo.id=:id and ps.status= 0");
			List<ProviderService> providerServiceCount=query.setLong("id",providerSession).list();

			int totalPersonal = providerServiceCount.size();
			logger.debug("++++++++DisplayProviderRequestsAction++++++totalPersonal++++++++++++++++++ "+totalPersonal);
			if(totalPersonal!=0){
				totalPages=totalPersonal/display;
				if(totalPersonal%display!=0){
					totalPages++;

				}

				long index=1;
				if(request.getParameter("index")!=null){
					index=Long.parseLong(request.getParameter("index"));
					logger.debug("+++++++++index+++++++++++++++++++++++++ "+index);
				}
				request.setAttribute("index",index);

				Query query1=session.createQuery("select ps from ProviderService ps RIGHT join " +
						"fetch ps.provider pr  join fetch ps.providerTwo pt " +
				"where ps.providerTwo.id=:id and ps.status= 0 order by pr.id Asc");
				query1.setLong("id",providerSession);
				List<ProviderService> providerService=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
				logger.debug("-----------------providerService.size()---DisplayProviderRequestsAction----------------------------"+providerService.size());
				request.setAttribute("display", display);
				request.setAttribute("provider", providerService);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("providerSession", provider.getName());
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

