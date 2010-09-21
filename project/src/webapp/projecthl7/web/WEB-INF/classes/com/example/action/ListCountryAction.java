package com.example.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Country;
import com.example.persistence.HibernateUtil;

public class ListCountryAction extends Action{
	
	 public ActionForward execute(ActionMapping mapping,
             ActionForm form,
             HttpServletRequest request,
             HttpServletResponse response)
	 throws Exception {
		 
	 
		 	Session session = null;
			Transaction tx = null;
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
				List<Country> country=session.createQuery("from Country country").list();
				request.setAttribute("country", country);
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

