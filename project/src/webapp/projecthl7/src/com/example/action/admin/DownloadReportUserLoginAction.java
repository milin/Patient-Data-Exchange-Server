package com.example.action.admin;
import com.example.model.FileWrite;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.action.ListProviderRegisterServiceAction;
import com.example.action.WebActionException;
import com.example.model.Online;
public class DownloadReportUserLoginAction extends Action{

	private static Logger logger= Logger.getLogger(DownloadReportUserLoginAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {


		Writer output = null;
		String end=null,start=null;
		File file=null;
		String original_filename=null;
		if(request.getParameter("start")!=null){
			start=request.getParameter("start");
			end=request.getParameter("end");
			String date[]=start.split("/");
			start=date[2]+"-"+date[1]+"-"+date[0];

			logger.debug("-------------------------xxxxxxxxxxxxxxxxx-----------------------------------------------------------------");
			String endDate[]=end.split("/");
			int number =Integer.parseInt(endDate[0])+1;
			endDate[0]=Integer.toString(number);
			end=endDate[2]+"-"+endDate[1]+"-"+endDate[0];
			
				


			file = new File ( "/tmp/"+start+"-"+end+".txt");
			output = new BufferedWriter(new FileWriter(file));
			original_filename = start+"-"+end+".txt";
		}else{
			SimpleDateFormat str_date = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date new_date = new java.util.Date();
			String fmt  = str_date.format(new_date);
			file = new File ( "/tmp/"+fmt+".txt");
			logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5"+fmt);
			output = new BufferedWriter(new FileWriter(file));
			original_filename = fmt+".txt";
			logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5"+file);
		}

		// output.write(text);

		logger.debug("==000000000000000000000000000000");
		Session session = null;
		Transaction tx = null;
		try{

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			//String sql ="select o from Online o inner join fetch o.provider p inner join fetch o.providerStaff ps ";
			//sql+="where o.onlineTime between '"+start+"%' and ";
			String sql ="select o from Online o inner join fetch o.provider p inner join fetch o.providerStaff ps ";
			if(request.getParameter("start")!=null){
				sql+="where o.onlineTime between '"+start+"%' and ";
				sql+= " '"+end+"%'  order by o.onlineTime Desc";
			}else{
				sql+= "order by o.onlineTime Desc";
			}
			Query query1=session.createQuery(sql);
			List items = query1.list();
			logger.debug("1111111111111111111111111111111111");
			Iterator it = items.iterator();
			output.write("Provider-Name,Contact-Name,Online Time,Offline Time\n");
			while(it.hasNext()){

				//Online online = (Online) ob[0];

				//						Bid bid = (Bid) pair[1];
				Online online = (Online) it.next();
				output.write((online.getProvider().getName()+","+online.getProviderStaff().getContactName()+","+online.getOnlineTime()+","+online.getOfflineTime()+"\n"));
				//output.write((online.getProvider().getName()+","+online.getProviderStaff().getContactName()+","+online.getOnlineTime()+","+online.getOfflineTime()+"\n"));
				logger.debug("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			}
			tx.commit();
			output.close();

			logger.debug("Your file has been written");
			if ( file.createNewFile () )
			{
				logger.debug( "Make File Success." );
			}
			String filename=file.toString();



			File f = new File(filename);
			int length   = 0;
			ServletOutputStream op       = response.getOutputStream();
			ServletContext      context  = getServlet().getServletContext();
			String              mimetype = context.getMimeType( filename );

			//
			//  Set the response and go!
			//
			//
			response.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
			response.setContentLength( (int)f.length() );
			response.setHeader( "Content-Disposition", "attachment; filename=\"" + original_filename + "\"" );


			//
			//  Stream to the requester.
			//
			byte[] bbuf = new byte[filename.length()];
			DataInputStream in = new DataInputStream(new FileInputStream(f));

			while ((in != null) && ((length = in.read(bbuf)) != -1))
			{
				op.write(bbuf,0,length);
			}

			in.close();
			op.flush();
			op.close();






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
