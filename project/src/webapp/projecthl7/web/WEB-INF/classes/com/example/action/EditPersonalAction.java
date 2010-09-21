package com.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.example.model.City;
import com.example.model.Position;
import com.example.model.Provider;
import com.example.model.Personal;
import com.example.persistence.HibernateUtil;

public class EditPersonalAction extends Action{
	private static Logger logger = Logger.getLogger(EditProviderAction.class);
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
	throws Exception {
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		
		long personalId=0;
	//	int positionId;
		String phone=request.getParameter("phone1");
		logger.debug("++++++++++++++++++++++++++++++phone1++++++++++++++++++++++++++++++++++++++++++++"+phone);
    	phone+=request.getParameter("phone2");
    	logger.debug("++++++++++++++++++++++++++++++phone2++++++++++++++++++++++++++++++++++++++++++++"+phone);
    	//positionId=Integer.parseInt(request.getParameter("position"));
    	if (request.getAttribute("personalId")!=null) {
    		personalId =(Long) (request.getAttribute("personalId"));
		} else if (request.getParameter("personalId")!=null){
			personalId =Long.parseLong(request.getParameter("personalId"));
		}/*else{
			HttpSession session = request.getSession();
			Provider hospital=(Provider) session.getAttribute("User");
			id =hospital.getId();
		}	*/	
    	logger.debug("++++++++++++++++++++++++++++++personalId++++++++++++++++++++++++++++++++++++++++++++"+personalId);
    	String firstName=request.getParameter("firstName");
    	String lastName=request.getParameter("lastName");
    	String name=firstName+" "+lastName;
		
		//hospitalEdit.setContactName(contactName);
		
		Session session = null;
		Transaction tx = null;
		
		try{	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Personal personal=(Personal) session.get(Personal.class, personalId);
			
			personal.setPhone(phone);
			BeanUtils.copyProperties(personal, dynaActionForm);
	       
			
			personal.setName(name);
			//request.setAttribute("id", personal.getId());
			session.save(personal);
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