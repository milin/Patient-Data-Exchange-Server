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

import com.example.model.Personal;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class DeleteProviderStaffAction extends Action{
	private static Logger logger = Logger.getLogger(DeleteProviderStaffAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		
		
		long id=Long.parseLong(request.getParameter("id"));
		logger.debug("++++++++++++++++++++++++++++++id++++++++++++++++++++++++++++++++++++++++++++"+id);

		//hospitalEdit.setContactName(contactName);
		//logger.debug("++++++++++++++++++++++++++++++personalEdit++++++++++++++++++++++++++++++++++++++++++++"+personalEdit.getPhone());
		Session session = null;
		Transaction tx = null;
		
		try{	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class, id);
			Integer master=providerStaff.getMaster();
			Provider provider=(Provider)session.get(Provider.class,providerStaff.getProvider().getId());
			int numberStaff=1;
				provider.setNumberStaff(1);
				providerStaff.setStatus(4);
				logger.debug("Yesmaster Yesmaster--------");
				request.getSession().setAttribute("menber",numberStaff);
			//personal.setStatus(true);
	
			tx.commit();
			id=0;
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