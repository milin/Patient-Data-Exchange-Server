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
import com.example.persistence.HibernateUtil;

public class ConfirmAddProviderAction extends Action{
	private static Logger logger=Logger.getLogger(CountProviderRequestsAction.class );

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)

	throws Exception {
		//Provider providerSession=(Provider) request.getSession().getAttribute("User");
		long id=Long.parseLong(request.getParameter("id"));
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("select pr.name from Provider pr where pr.id=:id");
			List<ProviderService> providerConfirm=query.setLong("id",id).list();
			
			
			request.setAttribute("providerConfirm", providerConfirm);
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

