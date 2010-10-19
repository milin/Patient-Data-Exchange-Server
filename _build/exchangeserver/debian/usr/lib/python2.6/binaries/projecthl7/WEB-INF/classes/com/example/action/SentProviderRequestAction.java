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
import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class SentProviderRequestAction extends Action{
	private static Logger logger= Logger.getLogger(SentProviderRequestAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {

		ProviderStaff ProviderStaffSeeeion=(ProviderStaff) request.getSession().getAttribute("User");
		long display=Integer.parseInt(getServlet().getServletContext().getInitParameter("maxDisplayPersonal"));
		long providerSession=ProviderStaffSeeeion.getProvider().getId();
		//String providerName=ProviderStaffSeeeion.getProvider().getName();
		//logger.debug("===============providerIdproviderIdproviderIdproviderIdproviderIdproviderId================================"+providerId);
		long totalPages;

		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Provider provider=(Provider) session.get(Provider.class, providerSession);
			
			Query queryCount=session.createQuery("select ps from ProviderService ps RIGHT join " +
					"fetch ps.provider pr  join fetch ps.providerTwo pt " +
					"where ps.provider.id=:id and ps.status=0 order by ps.id Asc");
			//List<ProviderService> providerCount=(List<ProviderService>) queryCount.setLong("id",providerId);
			List<ProviderService> providerCount=queryCount.setLong("id",providerSession).list();
			int totalProvider=providerCount.size();
			//logger.debug("+++++++++totalHospital+++++++++++++++++++++++++ "+totalHospital);
			logger.debug("++++++++totalProvider33333333333+++++++++++++++++++++++ "+totalProvider);
			if(totalProvider!=0){
				totalPages=totalProvider/display;
				if(totalProvider%display!=0){
					totalPages++;

				}
				long index=1;
				//logger.debug("+++++++++request.getParameter(index)+++++++++++++++++++++++++ "+request.getParameter("index"));

				if(request.getParameter("index")!=null){
					index=Long.parseLong(request.getParameter("index"));
					//logger.debug("+++++++++index+++++++++++++++++++++++++ "+index);
				}
				request.setAttribute("index",index);
			
			
			
			Query query=session.createQuery("select ps from ProviderService ps RIGHT join " +
											"fetch ps.provider pr  join fetch ps.providerTwo pt " +
											"where ps.provider.id=:id and ps.status=0 order by ps.id Asc");
			query.setLong("id",providerSession);
			List<Personal> providers=query.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
			logger.debug("________------------providerSessionproviderSessionproviderSessionproviderSessionproviderSessionproviderSession-------______________"+providerSession);
			request.setAttribute("providerService", providers);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("display", display);
			request.setAttribute("provider", providers);
			request.setAttribute("providerSession", provider.getName());
			
			tx.commit();
		}
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
