package com.example.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.HashPassword;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.model.SendMail;
import com.example.other.RandomPersonal;
import com.example.persistence.HibernateUtil;

public class AddProviderStaffAction extends Action{
	private static Logger logger = Logger.getLogger(AddProviderAction.class);

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		DynaActionForm dynaActionForm = (DynaActionForm) form;	
		String password=request.getParameter("password");
		String rePassword=request.getParameter("rePassword");
		if(!password.equals(rePassword)){
			ActionErrors errors = new ActionErrors();
			logger.debug("+++++++++++++++++++++"+request.getParameter("rePassword")+"-------------------------"+request.getParameter("hospitalRetypePassword"));
			errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.password"));
			logger.debug("yes");
			saveErrors(request, errors);
			return mapping.getInputForward();
		}



		String contactName =request.getParameter("contactName");
		contactName+=" "+request.getParameter("contactSurName");
		String username =request.getParameter("username");
		ProviderStaff providerStaff=new ProviderStaff();
		BeanUtils.copyProperties(providerStaff, dynaActionForm);
		logger.debug("+++++++++++++++++++++name 555555555555555"+contactName+"-------------------------");
		logger.debug("+++++++++++++++++++++username"+username+"-------------------------");
		ProviderStaff	providerStaffSession=(ProviderStaff) request.getSession().getAttribute("User");
		Session session = null;
		Transaction tx = null;
		try{
			ProviderStaff userName=null;
			ProviderStaff user=null;
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query	=session.createQuery("from ProviderStaff pf where pf.contactName=:contactName");
			query.setString("contactName", contactName);
			userName = (ProviderStaff) query.uniqueResult();
			if(userName!=null){
				ActionErrors errors=new ActionErrors();
				logger.debug("+++++++++++++++++++++name "+userName+"-------------------------");
				errors.add("hospitalUserName",new ActionMessage("applicationForm.hospital.error.Name"));
				saveErrors(request, errors);
				return mapping.getInputForward();

			}

			Query query1=session.createQuery("from ProviderStaff ps where ps.username=:username");
			query1.setString("username", username);
			user = (ProviderStaff) query1.uniqueResult();
			if(user!=null){
				ActionErrors errors=new ActionErrors();
				logger.debug("+++++++++++++++++++++testUser"+user+"-------------------------");
				errors.add("hospitalUserName",new ActionMessage("applicationForm.hospital.error.UserName"));
				saveErrors(request, errors);
				return mapping.getInputForward();
			}


			Provider provider=(Provider) session.get(Provider.class,providerStaffSession.getProvider().getId());
			providerStaff.setProvider(provider);
			providerStaff.setCreatedOn(new Date());


			HashPassword pass=new HashPassword();
			providerStaff.setPassword(pass.hashPassword(password));
			providerStaff.setMaster(0);
			logger.debug("+++++++++++++++++++++provider "+provider+"----------provider--------------");
			logger.debug("+++++++++++++++++++++contactName "+contactName+"----------contactName--------------");
			providerStaff.setContactName(contactName);
			session.save(providerStaff);
			/**TODO
			 * send mail
			 * 
			 */
			String subjectMail =getServlet().getServletContext().getInitParameter("subjectMail");
			// String textMail =getServlet().getServletContext().getInitParameter("textMail1");
			String textMail ="<br></br><br>"+getServlet().getServletContext().getInitParameter("textMail2")+"</br><br></br><br>";
			String[] txt=request.getRequestURL().toString().split("/");
			//  logger.debug("??????????????????????????????????"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/");
			String urlTxt=txt[0]+"//"+txt[2]+"/"+txt[3]+"/";
			// logger.debug("??????????????????????????????????url --"+url);
			String url=null;

			String userMail=null,passMail=null;
			Query queryMail=session.createQuery("select sy.email,sy.password from SystemControl sy ");
			List systemControl = queryMail.setReadOnly(true).list();

			Iterator<Object> i = systemControl.iterator();
			while(i.hasNext()) {
				Object[] o = (Object[]) i.next();

				userMail = (String)o[0];
				passMail = (String)o[1];					

			}	

			//   logger.debug("---------------------------------------providerId-----------------id --------"+providerId );

			SendMail sendMail=new SendMail();
			provider.setStatus(1);
			provider.setNumberStaff(2);
			String text="<br><h1>Hi "+providerStaff.getContactName()+"</h1></br><br>"+textMail+"</br>";
			text+="Username = "+username+"<br>Password = "+password;
			String linkUrl="<br><a href='"+urlTxt+"confirmEmailProvider.do?username="+providerStaff.getUsername()+"&password="+providerStaff.getPassword()+"'>";		   
			url= linkUrl+urlTxt+"confirmEmailProvider.do?username="+providerStaff.getUsername()+"&password="+providerStaff.getPassword()+"</a>";
			url=url+"</br><br>"+getServlet().getServletContext().getInitParameter("textMail3")+"</br>";
			sendMail.send(providerStaff.getContactEmail(),subjectMail,text,userMail,passMail,url);

			text="";
			url="";
			providerStaff.setStatus(1);
			 logger.debug("---------------");
			 	int menber=Integer.parseInt(request.getSession().getAttribute("menber").toString());
			 	 logger.debug("---------------menbermenbermenber--------"+menber );
			 	menber=menber+1;
			 	 logger.debug("---------------------------------------menbermenbermenbermenbermenbermenber---------------id --------"+menber );
			 	request.getSession().setAttribute("menber",menber); 
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
