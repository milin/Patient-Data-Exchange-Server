package com.example.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


public class ListPersonalAction extends Action{
	private Logger logger=Logger.getLogger(ListPersonalAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		long providerId=0;
		String search = null;
		int select=0;
		if (request.getAttribute("id")!=null) {
			providerId =(Long) (request.getAttribute("id"));
			logger.debug("+++getAttribute+++++++++++++++++++++++++++++"+providerId);
		} else if (request.getParameter("id")!=null){
			providerId =Long.parseLong(request.getParameter("id"));
			logger.debug("+++getParameter+++++++++++++++++++++++++++++"+providerId);
		}else{
			HttpSession session = request.getSession();
			ProviderStaff providerStaff=(ProviderStaff) session.getAttribute("User");
			providerId =providerStaff.getProvider().getId();
			logger.debug("+++session+++++++++++++++++++++++++++++"+providerId);
		}
		if	(request.getParameter("search")!=null){
			search=request.getParameter("search");
		//	logger.debug("+++search1++++++search1+++++++++++++++++search1+++++++++++++++++++++++++++++"+search);
			select=Integer.parseInt(request.getParameter("select"));
		//logger.debug("+++select++++++select+++++++++++++++++select+++++++++++++++++++++++++++++"+select);
		}
		long display=Integer.parseInt(getServlet().getServletContext().getInitParameter("maxDisplayPersonal"));
		//logger.debug("+++++++++display++++++++++++++++++++++++ "+display);
		long totalPages=3;
		Session session = null;
		Transaction tx = null;	
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			logger.debug("+++search2++++++search2+++++++++++++++++search2+++++++++++++++++++++++++++++"+search);
			if(search!=null){
				/** 1 =Position
				 * 	2 =Position
				 */
				logger.debug("+++search1++++++search1+++++++++++++++++search1+++++++++++++++++++++++++++++");
				if(select==1){
					Query query=session.createQuery("select count(pe) from Personal pe where pe.providerStaff.provider.id=:id " +
													"and pe.name like :search");
					query.setLong("id", providerId);
					query.setString("search",search+"%");
					Long totalPersonal = (Long)query.uniqueResult();
					logger.debug("+++++++++totalPersonalselect+++++++++++++++++++++++++ "+totalPersonal);
					if(totalPersonal!=0){
						totalPages=totalPersonal/display;
						if(totalPersonal%display!=0){
							totalPages++;
		
						}
						//logger.debug("+++++++++totalPages+++++++++++++++++++++++++ "+totalPages);
						long index=1;
					//	logger.debug("+++++++++request.getParameter(index)+++++++++++++++++++++++++ "+request.getParameter("index"));
		
						if(request.getParameter("index")!=null){
							index=Long.parseLong(request.getParameter("index"));
							//logger.debug("+++++++++index+++++++++++++++++++++++++ "+index);
						}
						request.setAttribute("index",index);
					
					
					//logger.debug("+++search4++++++search4+++++++++++++++++search4+++++++++++++++++++++++++++++");
					Query query1=session.createQuery("from Personal pe  " +
													"where pe.providerStaff.provider.id=:id " +
													"and pe.name like :search " +
													"order by pe.id Asc");
							//"select p from Personal p where p.name like :search");
					query1.setLong("id", providerId);
					query1.setString("search",search+"%");
					List<Personal> personals=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
					request.setAttribute("totalPages", totalPages);
					request.setAttribute("display", display);
					request.setAttribute("personals", personals);
					request.setAttribute("search", search);
					//logger.debug("+++Select++++++totalPersonalSelect+++++++++++++++++query++++++++ "+query);
					}
				}
				
				/*else if(select==2){
					
					Query query=session.createQuery("select count(pe) from Personal pe inner join fetch pe.position po where pe.provider.id=:id " +
										"and pe.position.name like :search");
					query.setLong("id", id);
					query.setString("search",search+"%");
					Long totalPersonal = (Long)query.uniqueResult();
					logger.debug("+++++++++totalPersonalselect+++++++++++++++++++++++++ "+totalPersonal);
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
					
					
					logger.debug("+++search4++++++search4+++++++++++++++++search4+++++++++++++++++++++++++++++");
					Query query1=session.createQuery("select pe from Personal pe inner join fetch pe.position po " +
										"where pe.provider.id=:id " +
										"and pe.position.name like :search " +
										"order by pe.id Asc");
					//"select p from Personal p where p.name like :search");
					query1.setLong("id", id);
					query1.setString("search",search+"%");
					List<Personal> personals=query1.setReadOnly(true).list();
					request.setAttribute("display", display);
					request.setAttribute("personals", personals);
					request.setAttribute("search", search);
					request.setAttribute("totalPages", totalPages);
					logger.debug("+++Select++++++totalPersonalSelect+++++++++++++++++query++++++++ "+query);
				}
				}*/
			}else{
				logger.debug("+++search2++++++search2+++++++++++++++++search2+++++++++++++++providerId++++++++++++++"+providerId);
				Query query=session.createQuery("select count(p) from Personal p where p.status=0 or p.status=1 or p.status=2 and p.providerStaff.provider.id=:providerId");
				query.setLong("providerId", providerId);
				Long totalPersonal = (Long)query.uniqueResult();
				logger.debug("+++++++++totalPersonal5555+++++++++++++++++++++++++ "+totalPersonal);
				//logger.debug("+++++++++email++++++++++++++++++++++++ "+email);
				if(totalPersonal!=0){
					totalPages=totalPersonal/display;
					if(totalPersonal%display!=0){
						totalPages++;
	
					}
					//logger.debug("+++++++++totalPages+++++++++++++++++++++++++ "+totalPages);
					long index=1;
					//logger.debug("+++++++++request.getParameter(index)+++++++++++++++++++++++++ "+request.getParameter("index"));
	
					if(request.getParameter("index")!=null){
						index=Long.parseLong(request.getParameter("index"));
					//	logger.debug("+++++++++index+++++++++++++++++++++++++ "+index);
					}
					request.setAttribute("index",index);
					Query query1=session.createQuery("select pe from Personal pe where pe.status not in(3) and pe.providerStaff.provider.id=:id order by pe.id Asc");
					query1.setLong("id",providerId);
					//logger.debug("+++++++++query1+++++++++++++++++++++++++ "+query1+"--------------------------id"+id);
					List<Personal> personals=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
					request.setAttribute("display", display);
					request.setAttribute("personals", personals);
					request.setAttribute("totalPages", totalPages);
	
	
					
					//logger.debug("+++++++++personals.get(0).getName()();+++++++++++++++++++++++++ "+personals.get(0).getName()+"--------------------------");
				}else{
					totalPages=0;
					request.setAttribute("totalPages", totalPages);
				}
			
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


