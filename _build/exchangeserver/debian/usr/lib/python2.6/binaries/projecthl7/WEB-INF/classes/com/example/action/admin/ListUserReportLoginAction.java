package com.example.action.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Date;
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

import com.example.action.WebActionException;
import com.example.model.Online;
import com.example.persistence.HibernateUtil;

public class ListUserReportLoginAction extends Action{
	private Logger logger=Logger.getLogger(ListUserReportLoginAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {

		//long display=Integer.parseInt(getServlet().getServletContext().getInitParameter("maxDisplayAdmin"));
		long display=5;
		//logger.debug("+++++++++display++++++++++++++++++++++++ "+display);
		long totalPages;
		
		String onlineTime,offlineTime, start="",end="";
		String sqlCount ="select count(o) from  Online o right join o.provider p right join o.providerStaff ps ";
		String sql ="select o from Online o inner join fetch o.provider p inner join fetch o.providerStaff ps ";
		
		if(request.getParameter("start-date")!="" && request.getParameter("start-date")!=null && request.getParameter("end-date")!="" && request.getParameter("end-date")!=null ){
			 
			
			logger.debug("++++++++++++notnullend+++++++++++++++++++++++++++++++notnullend"+end);
			logger.debug("yesyesyesyesyesyesyesyesyesyesyesyes");
			 start =request.getParameter("start-date");
			 String date[]=start.split("/");
			 onlineTime=date[2]+"-"+date[1]+"-"+date[0];
			 sqlCount+="where o.onlineTime between '"+onlineTime+"%' and";
				sql+="where o.onlineTime between '"+onlineTime+"%' and ";
			 if(request.getParameter("end-date")!="" && request.getParameter("end-date")!=null){
				 logger.debug("yes2yes2yes2yes2yes2yes2yes2yes2yes2yes2yes2yes2");
				 end =request.getParameter("end-date");
				 String endDate[]=end.split("/");
				int number =Integer.parseInt(endDate[0])+1;
				endDate[0]=Integer.toString(number);
				 offlineTime=endDate[2]+"-"+endDate[1]+"-"+endDate[0];
				 sqlCount+= " '"+offlineTime+"%'";
				 sql+= " '"+offlineTime+"%' order by o.onlineTime Desc";
			 }
           	logger.debug("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			}else{
			logger.debug("NoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNoNo");
		}
		logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");



		Session session = null;
		Transaction tx = null;
		try{
			sql+=" order by o.id Desc";
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			// Date date=new Date();
			//logger.debug("datedatedatedate"+date);
			Query query=session.createQuery(sqlCount);
			Long totalPersonal = (Long)query.uniqueResult();
			logger.debug("+++++++++totalPersonal5555555555+++++++++++++++++++++++++ "+totalPersonal);
			//logger.debug("+++++++++email++++++++++++++++++++++++ "+email);
			if(totalPersonal!=0){
				totalPages=totalPersonal/display;
				if(totalPersonal%display!=0){
					totalPages++;

				}
				logger.debug("+++++++++totalPages+++++++++++++++++++++++++ "+totalPages);
				long index=1;
				logger.debug("+++++++++request.getParameter(index)+++++++++++++++++++++++++ "+request.getParameter("index"));

				if(request.getParameter("index")!=null){
					index=Long.parseLong(request.getParameter("index"));
					logger.debug("+++++++++index+++++++++++++++++++++++++ "+index);
				}
				request.setAttribute("index",index);
				Query query1=session.createQuery(sql);
				List<Online> online=query1.setFirstResult((int)((index-1)*display)).setMaxResults((int)display).setReadOnly(true).list();
				request.setAttribute("display", display);
				request.setAttribute("online", online);
				request.setAttribute("totalPages", totalPages);
				logger.debug("+++++++++55555555555555555++++++++++++++++++++++++ ");
				request.setAttribute("start", start);
				request.setAttribute("end", end);
				
				
				
			}
			//Begin Unit of work


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
