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

import com.example.model.Country;
import com.example.model.Position;
import com.example.model.Provider;
import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class ListProviderServiceAction extends Action{
	private static Logger logger= Logger.getLogger(ListProviderServiceAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		Integer status =2;
		long totalPages;
		long id=0;
		
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
					"where (ps.provider.id=:id or ps.providerTwo.id=:id) and(ps.status=1 or ps.status=2)");
			//Query query=session.createQuery("select count(pr) from Provider pr");
			
			List<ProviderService> providerServiceCount=query.setLong("id",providerSession).list();
			logger.debug("-----------------providerService.size()-----providerServiceCountproviderServiceCount--------------------------"+providerServiceCount.size());
			int totalPersonal = providerServiceCount.size();
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
			
			
			
			
			
			
			
			
			
			
			
			logger.debug("-=-----------providerSeeeion.getId()---------------------=-  "+providerServiceCount.size());
			/*String QueryString ="select pr from Provider pr left join fetch pr.providerServices ps left join fetch " +
					"pr.providerServicess pss where pr.id not in ("+providerSeeeion.getId()+") and pr.status="+status;
			QueryString +=" and (ps.provider.id in ("+providerSeeeion.getId()+")";
			QueryString +=" or pss.providerTwo.id in ("+providerSeeeion.getId()+"))";
			QueryString +=" order by pr.id Asc";
			Query query1=session.createQuery(QueryString);*/
			Query query1=session.createQuery("select ps from ProviderService ps RIGHT join " +
					"fetch ps.provider pr  join fetch ps.providerTwo pt " +
					"where (ps.provider.id=:id or ps.providerTwo.id=:id) and(ps.status=1 or ps.status=2) order by pr.id Asc");
					//"" +
				//	" RIGHT join " +
											//		"fetch ps.provider pr  join fetch ps.providerTwo pt " +
												//	"where (ps.provider.id=:id or ps.providerTwo.id=:id) and(ps.status=1 or ps.status=2) order by pr.id Asc");
		/*	Query query1=session.createQuery("select pr from Provider pr left join pr.providerServices ps where pr.status=:status and ps.provider.id " 
					"" +
					"" +
					":id or ps.providerTwo.id=:id)");*/
			// Query query1=session.createQuery("select pr from Provider pr left join pr.providerServices ps where pr.status=2 and not(ps.provider.id=:id or ps.providerTwo.id=:id)");
			//Query query1=session.createQuery("select pr,ps from Provider pr left join pr.providerServices ps where not ps.provider.id=:id ");
			//Query query1=session.createQuery("select pr from Provider pr left join pr.providerServices ps  where not (ps.provider.id=:id or ps.providerTwo.id=:id) and ps.status=0");
			//Query query1=session.createQuery("select pr from Provider pr");
			//query1.setInteger("status",2);
			//query1.setLong("id",providerSeeeion.getId());
		
			//List<Provider> provider=
//			List<ProviderService> providerService=query1.setReadOnly(true).list();
//			request.setAttribute("providerService", providerService);


			query1.setLong("id",providerSession);
			List<ProviderService> providerService=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
			logger.debug("-----------------providerService.size()-------------------------------"+providerService.size());
			request.setAttribute("display", display);
			request.setAttribute("providerService", providerService);
			request.setAttribute("totalPages", totalPages);
			request.setAttribute("providerSession", provider.getName());

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



