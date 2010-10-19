package com.example.action;
import java.util.Date;
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

import com.example.model.Provider;
import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class AddProviderServiceAction extends Action{
	private static Logger logger= Logger.getLogger(AddProviderServiceAction.class);

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception{ 
		String serviceId=null;
		serviceId=request.getParameter("id");
		ProviderService providerService;
		Long providerSerId=Long.parseLong(request.getParameter("id"));
		ProviderStaff providerStaff= (ProviderStaff) request.getSession().getAttribute("User");
		//Long providerId=provider.getId();
		long providerSessiongId=providerStaff.getProvider().getId();



		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			
			Provider provider=(Provider) session.get(Provider.class, providerSessiongId);
			Provider providerTwo=(Provider) session.get(Provider.class, providerSerId);
			Query queryId=session.createQuery("select ps.id,ps.createdOn from ProviderService ps join " +
					"ps.provider pr  join ps.providerTwo pt " +
					"where ps.provider.id=:id and ps.providerTwo.id=:idSes and ps.status=0");
					queryId.setLong("id", providerSerId);
					queryId.setLong("idSes", providerSessiongId);
					Object [] providerServiceSelect=(Object[]) queryId.uniqueResult();
				if(providerServiceSelect!=null ){
					long providerServiceId =(Long) providerServiceSelect[0];
					providerService=(ProviderService) session.get(ProviderService.class,providerServiceId);
					providerService.setStatus(1);
					logger.debug("==========================================))providerServiceSelect======="+providerServiceSelect);
				}else{
					providerService=new ProviderService();
					providerService.setProvider(provider);
					providerService.setProviderTwo(providerTwo);
					providerService.setStatus(0);
					providerService.setCreatedOn(new Date());
				}
				logger.debug("==============ssssssssssssssss============================");
				if(provider.getServiceId()==null  || (provider.getServiceId().equals(""))){
					logger.debug("==============xxxxxxxxxxxxxxxxxxxxxxxxxx============================");
					provider.setServiceId(serviceId);
				}else if(provider.getServiceId()!=null){
					logger.debug("==============yttyyyyyyyyyyyyyyyyyyyyyy=======provider.getServiceId()====================="+provider.getServiceId());
					provider.setServiceId(serviceId=provider.getServiceId()+","+serviceId);
				}
			session.save(providerService);
			session.save(provider);
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