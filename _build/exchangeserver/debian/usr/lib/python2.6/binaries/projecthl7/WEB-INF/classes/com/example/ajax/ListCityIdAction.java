package com.example.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.example.action.WebActionException;
import com.example.persistence.HibernateUtil;

import java.util.List;

public class ListCityIdAction extends Action{
	private static Logger logger=Logger.getLogger(ListCityIdAction.class);
	@Test
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		Integer countryId=Integer.parseInt(request.getParameter("countryId"));
		//int countryId=1;
		logger.debug("/////////////////////////////////////////////////////////////////////"+countryId);
	 Session session = null;
    Transaction tx = null;
			try{
			session = HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
			Query query = session.createQuery("select c.id, c.name from City c where c.country.id =:id order by name asc");
			query.setInteger("id",countryId);
			
			List city = query.setReadOnly(true).list();
			  //JSONObject jObject = JSONObject.fromObject(city);
			JSONArray jArray = JSONArray.fromObject(city);
			logger.debug("########################----------------");
			logger.debug(jArray);
			request.setAttribute("ajaxResponse", jArray);
			logger.debug("########################");
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
	
	return (mapping.findForward("ajaxResponse"));

}


}
