package com.example.action;

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

import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class ViewProviderStaffAction extends Action{
	private static Logger logger= Logger.getLogger(ViewProviderStaffAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {	
//TODO Edit Lock
		//long id=Long.parseLong(request.getParameter("id"));
		//long id=1;
		Long staffId;
		
		ProviderStaff providerStaffSession=(ProviderStaff) request.getSession().getAttribute("User");
		
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Long providerId=providerStaffSession.getProvider().getId();
			logger.debug("+xxxxxxxxxxxxid)xxxxxx6666666666666666xxxxxxxxxxxxxxxxxxxxxxxxx"+providerId);
			logger.debug("+665555555555555555555555555555555555"+providerStaffSession.getId());
			Long sessionId=providerStaffSession.getId();
			logger.debug("+sessionIdsessionIdsessionIdsessionIdsessionIdsessionIdsessionIdsessionId"+providerStaffSession.getId());
			//String countSql1="=session.createQuery("
			//ProviderStaff providerStaff = (ProviderStaff) session.get(ProviderStaff.class,providerStaffSession.getId());
			Query query= session.createQuery("select ps from ProviderStaff ps join ps.provider pr where pr.id=:providerId and ps.id not in(:sessionId) and ps.status not in(4)");
			//ProviderStaff providerStaff = (ProviderStaff) session.get(ProviderStaff.class,sessionId);
//			String sql1="from ProviderStaff ps  where ps.provider.id=";
//			String sql2=" and ps.id not in(";
//			String sql3=")";
//			ProviderStaff providerStaff=(ProviderStaff) session.createQuery(sql1+providerId+sql2+sessionId+sql3);
			query.setLong("providerId", providerId);
			query.setLong("sessionId", sessionId);
			ProviderStaff providerStaff=(ProviderStaff) query.uniqueResult();
			//ProviderStaff providerStaff = (ProviderStaff) session.get(ProviderStaff.class,staffId);
			logger.debug("+000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		    //providerStaff
			//providerStaff.getProvider().getCity().getName();
		//	providerStaff.getProvider().getCity().getCountry().getName();
			logger.debug("+5555555555555555yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
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
