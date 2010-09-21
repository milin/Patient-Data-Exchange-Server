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

public class ListProviderRegisterServiceAction extends Action{
	private static Logger logger= Logger.getLogger(ListProviderRegisterServiceAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {	
		long totalPages;
		long display=Integer.parseInt(getServlet().getServletContext().getInitParameter("maxDisplayPersonal"));


		Session session = null;
		Transaction tx = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			//Begin select page

			ProviderStaff providerStaff=(ProviderStaff) request.getSession().getAttribute("User");
			Provider provider=(Provider) session.get(Provider.class,providerStaff.getProvider().getId());
			String countSql1="select count(pr) from Provider pr where pr.id not in (";
			String countSql2=") and pr.status = 2";
			String sql1="select pr from Provider pr where pr.id not in (";
			String sql2=") and pr.status = 2 order by pr.id Asc"; 
				
			String id=String.valueOf(provider.getId());
		logger.debug("------------------provider.getServiceId-provider.getServiceIdprovider.getServiceId-------"+provider.getServiceId()+"ididididididid"+id);
			
			if((provider.getServiceId()==null) || (provider.getServiceId().equals(""))){
			/*
			 * Begin count data
			 * */
				logger.debug("------------------nullnullnullnullnullnullnullnullnullnullnull");
				Query queryCount=session.createQuery(countSql1+id+countSql2);
				Long totalProvider = (Long)queryCount.uniqueResult();
				if(totalProvider!=0){
					totalPages=totalProvider/display;
					if(totalProvider%display!=0){
						totalPages++;
	                  logger.debug("------------------totalPages--------"+totalPages+"---totalProvider--------------------"+totalProvider);
					}
					long index=1;
					if(request.getParameter("index")!=null){
						index=Long.parseLong(request.getParameter("index"));
					}
				request.setAttribute("index",index);
					
				Query query=session.createQuery(sql1+id+sql2);
				List<Personal> providers=query.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("display", display);
				request.setAttribute("provider", providers);
				tx.commit();
				}
			}else if(provider.getServiceId()!=null){
				
				logger.debug("---------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111");
				Query queryCount=session.createQuery(countSql1+id+","+provider.getServiceId()+countSql2);
				Long totalProvider = (Long)queryCount.uniqueResult();
				if(totalProvider!=0){
					totalPages=totalProvider/display;
					if(totalProvider%display!=0){
						totalPages++;
	                  logger.debug("------------------getServiceId--------"+totalPages+"---provider.getServiceId()--------------------"+provider.getServiceId());
					}
					long index=1;
					if(request.getParameter("index")!=null){
						index=Long.parseLong(request.getParameter("index"));
					}
				request.setAttribute("index",index);
				
				
				//Query query=session.createQuery("select pr from Provider pr order by pr.id Asc");
				Query query=session.createQuery(sql1+id+","+provider.getServiceId()+sql2);
				List<Personal> providers=query.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
				logger.debug("________------------query--------______________");
				request.setAttribute("provider", providers);
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("display", display);
				request.setAttribute("provider", providers);
				
				tx.commit();
			}
				/*String serviceId=provider.getServiceId();
				String[] serviceIds=serviceId.split("/");*/
				//}

				//Query query=session.createQuery("select count(pr) from Provider pr");
				/*Long totalPersonal = (Long)query.uniqueResult();
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
				request.setAttribute("index",index);Query query=session.createQuery("select count(pr) from Provider pr");
				Long totalPersonal = (Long)query.uniqueResult();
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
				 */







				//Query query1=session.createQuery("select ps from ProviderService ps RIGHT join " +
				/*Query query=session.createQuery("select count(pr) from Provider pr");
				Long totalPersonal = (Long)query.uniqueResult();
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
				 */
				//		"fetch ps.provider pr  join fetch ps.providerTwo pt " +
				//		"where (ps.provider.id=:id or ps.providerTwo.id=:id) and(ps.status=1 or ps.status=2) order by pr.id Asc");
				//	Query query1=session.createQuery("from ProviderService ps providerService join fetch ps.provider pr");
				//	Query qurey=session.createQuery("se")
				/*//Query query1=session.createQuery("select ps from Provider pr RIGHT join " +
															"fetch ps.provider pr left join fetch ps.providerTwo pt " +
															"where ps.provider.id=:id");*/
				// Query query1=session.createQuery("select pr from Provider pr left join fetch pr.providerService ps where pr.providerServices=:id");
				//	query1.setLong("id",id);
				//	List<ProviderService> providerService=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
				//	request.setAttribute("display", display);
				//	request.setAttribute("providerService", providerService);
				//	request.setAttribute("totalPages", totalPages);


				//}
				//End select page
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