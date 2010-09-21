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
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class CountProviderRequestsAction extends Action{
	private static Logger logger=Logger.getLogger(CountProviderRequestsAction.class );

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)

	throws Exception {
		ProviderStaff ProviderStaffSession=(ProviderStaff) request.getSession().getAttribute("User");
		long providerSessionId=ProviderStaffSession.getProvider().getId();


		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("select ps from ProviderService ps RIGHT join " +
					"fetch ps.provider pr  join fetch ps.providerTwo pt " +
			"where ps.providerTwo.id=:id and ps.status= 0");
			List<ProviderService> providerServiceCount=query.setLong("id",providerSessionId).list();
			logger.debug("++++++++++++++++++++++++++++++++=providerServiceCount.size()+++++++++++++"+providerServiceCount.size());
			int totalPersonal = providerServiceCount.size();
			request.setAttribute("totalProviderService", totalPersonal);
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

