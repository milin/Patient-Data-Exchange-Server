package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class LookProviderAction extends Action{
	private static Logger logger= Logger.getLogger(LookProviderAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {	
//TODO Edit Lock
		//long id=Long.parseLong(request.getParameter("id"));
		//long id=1;
		Long staffId;
		if (request.getAttribute("staffId")!=null) {
			staffId =(Long) (request.getAttribute("staffId"));
			//logger.debug("++++++++++++++++++++++++++++++test3+++++++++++++++++++++++++++++++++++++++++++");
		} else{
			staffId =Long.parseLong(request.getParameter("staffId"));
			logger.debug("++++++++++++++++++++++++++++++test4+++++++++++++++++++++++++++++++++++++++++++");
		}
		
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			logger.debug("+xxxxxxxxxxxxid)xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+staffId);
			ProviderStaff providerStaff = (ProviderStaff) session.get(ProviderStaff.class,staffId);
			//logger.debug("+xxxxxxxxxxxxid)xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+providerStaff);
		    //providerStaff
			providerStaff.getProvider().getCity().getName();
			providerStaff.getProvider().getCity().getCountry().getName();
			//logger.debug("----------------provider.getCity().getName()---------"+provider.getCity().getName()+"--------provider.getCity().getName()------------------");
		
			tx.commit();
			request.setAttribute("providerStaff", providerStaff);
			//logger.debug("----------------contactName.length()---------"+contactName.length+"--------contactName.length()------------------");
			
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