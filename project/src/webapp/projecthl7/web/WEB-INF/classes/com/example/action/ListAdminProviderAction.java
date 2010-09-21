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
import com.example.model.Personal;
import com.example.persistence.HibernateUtil;

public class ListAdminProviderAction extends Action{
	private static Logger logger = Logger.getLogger(ListAdminProviderAction.class);
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
				Query query=session.createQuery("select count(p) from Provider p where  p.status=1 or p.status=2 or p.status=3");
				Long totalProvider = (Long)query.uniqueResult();
				
				//logger.debug("+++++++++totalHospital+++++++++++++++++++++++++ "+totalHospital);
				logger.debug("++++++++totalProvider+++++++++++++++++++++++ "+totalProvider);
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
					Query query1=session.createQuery("from Provider p join p.providerStaffs ps where ps.status=1 or ps.status=2 or ps.status=3 order by p.id Asc");
					List<Provider> provider=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
					request.setAttribute("display", display);
					request.setAttribute("provider", provider);
					request.setAttribute("totalPages", totalPages);
					logger.debug("++++++++provider++++++++++++00+++++++++++ "+provider.size());
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


