package com.example.action;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.persistence.HibernateUtil;
import com.example.model.HashPassword;
import com.example.model.Provider;
import com.example.model.ProviderStaff;



public class LoginProviderAction extends Action{
	private static Logger logger=Logger.getLogger(LoginProviderAction.class );

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)

	throws Exception {
		String username="";
		String password="";

        if(request.getSession().getAttribute("User")!=null){
        	return (mapping.findForward("success"));
        }
		if (request.getParameter("username") != null && !request.getParameter("username").equals("")) {
			username=request.getParameter("username");
			logger.debug("+++++++++++++++++++++++++++++++++++++++++++1");
		}else if(request.getParameter(password)==null && request.getParameter("password").equals("")){
			ActionErrors errors = new ActionErrors();
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.userName"));
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.password"));
			logger.debug("+++++++++++++++++++++++++++++++++++++++++++2");
			saveErrors(request, errors);
			return mapping.findForward("fail");
		}else{
			ActionErrors errors = new ActionErrors();
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.userName"));
			logger.debug("+++++++++++++++++++++++++++++++++++++++++++3");
			saveErrors(request, errors);
			return mapping.findForward("fail");

		}	logger.debug("+++++++++++++++++++++++++++++++++++++++++++password"+password);
		if(request.getParameter("password")!=null && !request.getParameter("password").equals("")){
			password=request.getParameter("password");
			HashPassword pass=new HashPassword();
			password=pass.hashPassword(password);
			logger.debug("++++++++++++++++;+++++++++++++++++++++++++++4--"+pass.hashPassword(password));
			logger.debug("+++++++++++++++++++++++++++++++++++++++++++password"+password);
		}else{
			ActionErrors errors = new ActionErrors();
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.password"));
			logger.debug("+++++++++++++++++++++++++++++++++++++++++++5"+password);
			saveErrors(request, errors);
			return mapping.findForward("fail");
		}

		Session session = null;
		Transaction tx = null;
		try{
			//HashPassword pass=new HashPassword();
			//password=pass.hashPassword(password);
			logger.debug("+++++++password======================================"+password);
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query q =session.createQuery("from ProviderStaff ps where ps.username=:username and ps.password=:password and ps.status=2");
			q.setString("username",username);
			q.setString("password",password);
			ProviderStaff providerStaff = (ProviderStaff) q.uniqueResult();
			

			if(providerStaff==null){
				logger.debug("+++++++++++++++++++++++++++++++++++++++++++6"+providerStaff);
				ActionErrors errors = new ActionErrors();
				errors.add("userLogin",new ActionMessage("errors.login.incorrect"));
				saveErrors(request, errors);
				return mapping.findForward("fail");
			}else{
				 Provider provider=providerStaff.getProvider();
				  Query queryCount =session.createQuery("select count(o) from Online o where o.offlineTime is null and o.provider.id=:providerId");
				  queryCount.setLong("providerId", provider.getId());
					Long total = (Long)queryCount.uniqueResult();
					if(total==1){
						logger.debug("+++++++user not Login 7====================");
						ActionErrors errors = new ActionErrors();
						errors.add("userLogin",new ActionMessage("errors.login.providerNotLogin"));
						saveErrors(request, errors);
						return mapping.findForward("fail");
					}
				
				logger.debug("+++++++++++++++++++++++++++++++++++++++++++yes3333");
			}
			



//			Query query =session.createQuery("from Provider p where p.statusOnline=1 and p.id=:id");
//			Provider provider=(Provider) query.setLong("id", 1);
//			if(provider!=null){
//				ActionErrors errors = new ActionErrors();
//				errors.add("userLogin",new ActionMessage("errors.login.incorrect"));
//				saveErrors(request, errors);
//				return mapping.findForward("fail");
//
//			}else{



				request.getSession().setAttribute("User", providerStaff); 
				request.getSession().setAttribute("menber",providerStaff.getProvider().getNumberStaff()); 
				/*Online online = new Online();
			Date createdOn = new Date();

			online.setOnlineTime(createdOn);
			online.setProviderName(provider.getName());
			session.save(online);*/
				session.save(providerStaff);
		//	}

		
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

	private void password(String hashPassword) {
		// TODO Auto-generated method stub

	}


}
