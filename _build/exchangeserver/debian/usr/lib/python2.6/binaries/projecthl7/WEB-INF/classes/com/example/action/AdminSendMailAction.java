package com.example.action;

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

import com.example.model.Admin;
import com.example.model.Personal;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.model.SendMail;
import com.example.persistence.HibernateUtil;

public class AdminSendMailAction extends Action{
	private static Logger logger=Logger.getLogger(AdminSendMailAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		 String [] id ;
		 		logger.debug("-----------------rrrrrrrrr----------------------------------------------------error---------"+request.getParameterValues("id"));
		   if (request.getParameterValues("id") == null || request.getParameterValues("id").equals(null)) 
		   {
			   logger.debug("----------------------------------------tttttttttttttttttt-----------------------------error---------");
				ActionErrors errors = new ActionErrors();
				errors.add("checkbox",new ActionMessage("applicationForm.error.checkbox"));
				saveErrors(request, errors);
				return mapping.getInputForward();
		   }
			
		Session session = null;
		Transaction tx = null;
		try{
			
			
			//get Session Admin
			Admin admin=(Admin) request.getSession().getAttribute("admin");
			
			if(admin.getPassword()==""){
				ActionErrors errors = new ActionErrors();
				errors.add("checkbox",new ActionMessage("applicationForm.error.Passsword"));
				saveErrors(request, errors);
			} logger.debug("-----------------------------------------------------------------xxx --------" );
			id = request.getParameterValues("id");
			 logger.debug("------------------------------------------------------------------id566 --------"+id );
			 
			 String subjectMail =getServlet().getServletContext().getInitParameter("subjectMail");
			// String textMail =getServlet().getServletContext().getInitParameter("textMail1");
			 String textMail ="<br></br><br>"+getServlet().getServletContext().getInitParameter("textMail2")+"</br><br></br><br>";
			 String[] txt=request.getRequestURL().toString().split("/");
			//  logger.debug("??????????????????????????????????"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/");
			 String urlTxt=txt[0]+"//"+txt[2]+"/"+txt[3]+"/";
			// logger.debug("??????????????????????????????????url --"+url);
			 String url=null;
			 
			   for (int i = 0; i < id.length; i++) 
			      {
				   session = HibernateUtil.getSessionFactory().openSession();
				   tx = session.beginTransaction();
					
				   long providerId=Long.parseLong(id[i]);
				   logger.debug("---------------------------------------providerId-----------------id --------"+providerId );
				   Provider provider= (Provider) session.get(Provider.class,providerId);
				   Query query=session.createQuery("select ps from ProviderStaff ps where ps.provider=:id ");
					ProviderStaff providerStaff=(ProviderStaff) query.setLong("id",provider.getId()).uniqueResult();
				   
				   
				   SendMail sendMail=new SendMail();
				   provider.setStatus(1);
				   providerStaff.setStatus(1);
				   String text="<br><h1>Hi "+provider.getName()+"</h1></br><br>"+textMail+"</br>";
			
				   String linkUrl="<a href='"+urlTxt+"confirmEmailProvider.do?username="+providerStaff.getUsername()+"&password="+providerStaff.getPassword()+"'>";		   
				   url= linkUrl+urlTxt+"confirmEmailProvider.do?username="+providerStaff.getUsername()+"&password="+providerStaff.getPassword()+"</a>";
				   url=url+"</br><br>"+getServlet().getServletContext().getInitParameter("textMail3")+"</br>";
				   sendMail.send(providerStaff.getContactEmail(),subjectMail,text,admin.getAdminEmail(),admin.getAdminEmailPass(),url);
				   text="";
				   url="";
				 //  logger.debug("---------------------------------------------------------------------provider--------"+provider.getUsername());
				   tx.commit(); 	
			      }
			
			  logger.debug("---------------------------------------------------------------------subjectMail--------"+subjectMail); 
			
			//Personal contactPersonal=null;
			
			
			   		
			//  tx.commit(); 		
			
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



