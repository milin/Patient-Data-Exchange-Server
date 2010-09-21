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

import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class ConFirmPasswordPaviderAction extends Action {
	private static Logger logger=Logger.getLogger(ConFirmPasswordPaviderAction.class );

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)

	throws Exception {
		//Provider providerSession=(Provider) request.getSession().getAttribute("User");
		long providerId=Long.parseLong(request.getParameter("providerId"));
		String password=request.getParameter("password");
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			ProviderStaff providerStaff =(ProviderStaff) session.get(ProviderStaff.class, providerId);
			logger.debug("+++++++++++++++++++++++++++++++++ProviderProviderr2+++++++++++++++");
			//ProviderStaff providerStaff=(ProviderStaff) query.setLong("providerId", providerId);
			providerStaff.setPassword(password);
			tx.commit();
			String text="You confirm e-mail succeed.";
			request.setAttribute("text",text);
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
