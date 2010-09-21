package com.example.action;

import java.util.Iterator;
import java.util.List;

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

import com.example.model.HashPassword;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.model.SendMail;
import com.example.model.SystemControl;
import com.example.other.RandomPersonal;
import com.example.persistence.HibernateUtil;

public class ForGotPasswordAction extends Action {
	private static Logger logger=Logger.getLogger(ForGotPasswordAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		String email=null,username=null;
		if(request.getParameter("username")!=null && !request.getParameter("username").equals("") ){
			username=request.getParameter("username");
			logger.debug("???????????username=============????????????????????"+username);
		}else{
			ActionErrors errors = new ActionErrors();
			errors.add("forgotPasswordUsername",new ActionMessage("errors.forgotPassword.username"));
			saveErrors(request, errors);
			logger.debug("???????????usernameerror????????????????????"+username);
			return mapping.findForward("fail");
		}
		if(request.getParameter("email")!=null && !request.getParameter("email").equals("") ){
			email=request.getParameter("email");
			logger.debug("???????????email=================????????????????????"+email);
		}else{
			ActionErrors errors = new ActionErrors();
			errors.add("forgotPasswordEmail",new ActionMessage("errors.forgotPassword.email"));
			saveErrors(request, errors);
			logger.debug("???????????email error????????????????????"+email);
			return mapping.findForward("fail");
			
		}
		
		Session session = null;
		Transaction tx = null;

		try{	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("from ProviderStaff ps where ps.contactEmail=:email and ps.username=:username");
			query.setString("email",email);
			query.setString("username",username);
			ProviderStaff providerStaff = (ProviderStaff) query.uniqueResult();
			logger.debug("???????????pxxxxxxxxxxxxxxxxxxx????????????????????"+providerStaff);
			
			if(providerStaff==null){
				ActionErrors errors = new ActionErrors();
				errors.add("forGotPassword",new ActionMessage("errors.forgot.incorrect"));
				saveErrors(request, errors);
				return mapping.findForward("fail");
			}else if(providerStaff.getStatus()==0){
				ActionErrors errors = new ActionErrors();
				errors.add("forGotPassword",new ActionMessage("errors.forgot.confirm"));
				saveErrors(request, errors);
				return mapping.findForward("fail");	
			}else if(providerStaff.getStatus()==1){
				ActionErrors errors = new ActionErrors();
				errors.add("forGotPassword",new ActionMessage("errors.forgot.noconfirm"));
				saveErrors(request, errors);
				return mapping.findForward("fail");	
			}else if(providerStaff.getStatus()==2){
				RandomPersonal randomPersonal=new RandomPersonal();
				//end random
				//begin md5
				HashPassword hashPassword=new HashPassword();
				String passwordNew=randomPersonal.password();

				String  passwordNew2=hashPassword.hashPassword(passwordNew);
				//end md5
				logger.debug("???????????provider.setPassword(randomPersonal.password())????????????????????");
				
				//logger.debug("???????????provider??getName????????????????????"+provider);
				
				String[] txt=request.getRequestURL().toString().split("/");
					//  logger.debug("??????????????????????????????????"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/");
				String url="<a href='"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/confirmPavider.do?providerId=" +
				""+providerStaff.getId()+"&password=" +passwordNew2+"'>"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/confirmPavider.do?providerId=" +
						""+providerStaff.getId()+"&password=" +passwordNew2+"</a>";
				String user=null,pass=null;
				SendMail sendMail=new SendMail();
			//	provider.getContactEmail();
				String subject="";
				
				/*
				 * TODO
				 * select user pass
				 * 
				 * */
				Query query1=session.createQuery("select sy.email,sy.password,sy.textForGot from SystemControl sy ");
				List systemControl = query1.setReadOnly(true).list();
				
				Iterator<Object> i = systemControl.iterator();
				while(i.hasNext()) {
					Object[] o = (Object[]) i.next();
					
					user = (String)o[0];
					pass = (String)o[1];					
					subject = (String)o[2];
				}			
				String text="<h1>Hi "+providerStaff.getContactName()+"</h1><br><br><br><br>username :  "+providerStaff.getUsername()+"<br>";
				text+="password :  "+passwordNew+"<br><br>Should you wish to confirm this request, please follow this link:<br>";
				 logger.debug("??????????????????????user????????????"+user+"/// "+pass+"/");
				 //logger.debug("username -"+username+" subject,- "+subject+ "text,-"+text+"user,-"+user+ "pass,-"+pass +"url-"+url);
				sendMail.send(email, subject, text, user, pass, url);
				logger.debug("??????????????????????user????????????xx"+user+"/// "+pass+"/");
			}
			logger.debug("??????????????????????user????????????s");
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