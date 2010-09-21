package com.example.action;

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

import com.example.model.Admin;
import com.example.model.HashPassword;
import com.example.model.Provider;
import com.example.persistence.HibernateUtil;

public class AdminLoginAction extends Action{
	private static Logger logger = Logger.getLogger(AdminLoginAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String username="";
		String password="";
		
		if (request.getParameter("username") != null && !request.getParameter("username").equals("")) {
			username=request.getParameter("username");
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++++username"+username);
		}else if(request.getParameter(password)==null && request.getParameter("password").equals("")){
			ActionErrors errors = new ActionErrors();
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.userName"));
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.password"));
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++++usernameNO"+username);
			saveErrors(request, errors);
			return mapping.findForward("fail");
		}else{
			ActionErrors errors = new ActionErrors();
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.userName"));
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++++usernameNO"+username);
			saveErrors(request, errors);
			return mapping.findForward("fail");
			
		}
		if(request.getParameter("password")!=null && !request.getParameter("password").equals("")){
			password=request.getParameter("password");
			HashPassword pass=new HashPassword();
			 password=pass.hashPassword(password);
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++++password"+password);
		}else{
			ActionErrors errors = new ActionErrors();
			errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.password"));
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++++password"+password);
			saveErrors(request, errors);
			return mapping.findForward("fail");
		}
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++++usernameNO"+username);
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++++password"+password);
			Query q =session.createQuery("from Admin a where a.username=:username and a.password=:password");
			 q.setString("username",username);
			 q.setString("password",password);
			 Admin admin = (Admin) q.uniqueResult();
			 tx = session.beginTransaction();
			 tx.commit();
			if(admin==null){
				//logger.debug("+++++++++++++++++nullnullnullnullnull++++++++++++++++++++++++++null"+null);
					ActionErrors errors = new ActionErrors();
					errors.add("userLogin",new ActionMessage("errors.login.incorrect"));
					saveErrors(request, errors);
					return mapping.findForward("fail");
				} /*if(hospital.getState()==0){
					ActionErrors errors = new ActionErrors();
					errors.add("userLogin",new ActionMessage("errors.login.idIsLocked"));				
					saveErrors(request, errors);
					return mapping.findForward("fail");
				} else*/ 
					/*LoginSystem login=new LoginSystem();
					login.setHospitalUserName("username");
					login.setLoginDate(new Date());*/
					
					request.getSession().setAttribute("admin", admin);
					
					//session.save(login);
					
					
				
			 
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
