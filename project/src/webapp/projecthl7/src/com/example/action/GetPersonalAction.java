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

import com.example.model.Position;
import com.example.model.Provider;
import com.example.model.Personal;
import com.example.persistence.HibernateUtil;

public class GetPersonalAction extends Action{
	private static Logger logger = Logger.getLogger(AddProviderAction.class);

	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		long personalId=Long.parseLong(request.getParameter("personalId"));
		//logger.debug("++++++++++++++++++++++++++++++++++++++++++_______________________________id"+id);
		int statusPage=Integer.parseInt(request.getParameter("statusPage"));
		//logger.debug("++++++++++++++++++++++++++++++++++++++++++_______________________________statusPage"+statusPage);
		Session session=null;
		Transaction tx = null;
		try{
			//TODO ลืมเช็ค session
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Personal personal=(Personal) session.get(Personal.class, personalId);
		
			String strPhone=new String(personal.getPhone());
			tx.commit();
			logger.debug("-----------------strPhone.length()22222;---------"+strPhone.length()+"--------------------------");
			
			
			
			
			//logger.debug("++++++++++++++++++++++++++++++++++++++++++_______________________________statusPage"+statusPage);
			if(statusPage==1){
				
				request.setAttribute("personal", personal);
			//	logger.debug("++++++++++++++++++++++++++++++++++++++++++_______________________________successGet");
				return (mapping.findForward("successGet"));
			}else{ 
				String[] personalName=personal.getName().split(" "); 
				personal.setName(personalName[0]);
				logger.debug("++++++++++++++++++++++++++++++++++++++++++personal.setName(personalName[0])"+personalName[0]);
				if(strPhone.length()>11){
					int phoneLength=strPhone.length();
					request.setAttribute("phone",strPhone.substring(11,phoneLength));
				
				}
				request.setAttribute("lastName",personalName[1]) ;
				personal.setPhone(strPhone.substring(0,11));
				request.setAttribute("personal", personal);
				logger.debug("++++++++++++++++++++++++++++++++++++++++++_______________________________successGetEdit");
				return (mapping.findForward("successGetEdit"));
			}
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
		
		

	}
}


