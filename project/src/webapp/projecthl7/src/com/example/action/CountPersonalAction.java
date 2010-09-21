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

public class CountPersonalAction extends Action{
	private static Logger logger=Logger.getLogger(CountPersonalAction.class );

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)

	throws Exception {
		ProviderStaff providerStaffSession=(ProviderStaff) request.getSession().getAttribute("User");
		


		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
		
			logger.debug("providerStaffSessionproviderStaffSessionproviderStaffSession"+providerStaffSession.getId());
			Long id =providerStaffSession.getProvider().getId();
			logger.debug("idididididididStaffSession"+id);
			Query query=session.createQuery("select count(pe) from Personal pe inner join pe.providerStaff ps inner join ps.provider pr where (pe.status=0 or pe.status=1 or pe.status=2) and pr.id=:id");
			query.setLong("id", id);
			Long count=(Long) query.uniqueResult();
			logger.debug("countcountcountcountStaffSession"+count);
			request.setAttribute("count", count);
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
