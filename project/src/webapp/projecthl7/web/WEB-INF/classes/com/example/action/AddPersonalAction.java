package com.example.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


import com.example.model.Position;
import com.example.model.Provider;
import com.example.model.Personal;
import com.example.model.ProviderService;
import com.example.model.ProviderStaff;
import com.example.model.SendMail;
import com.example.other.RandomPersonal;
import com.example.persistence.HibernateUtil;

public class AddPersonalAction extends Action{
	private static Logger logger = Logger.getLogger(AddPersonalAction.class);
	
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
      throws Exception {
    	Integer status=0;
    	String firstName=request.getParameter("firstName");
    	String lastName=request.getParameter("lastName");
    	String phone=request.getParameter("phone1");
    	phone+=""+request.getParameter("phone2");
    	//int positionId=Integer.parseInt(request.getParameter("position"));
    	//HttpSession sessionUser = request.getSession();
    	ProviderStaff providerStaffSession=(ProviderStaff) request.getSession().getAttribute("User");
    	
    	logger.debug("+++++++++++++providerStaffSessionproviderStaffSessionproviderStaffSession;++++++++++++++++++++++"+providerStaffSession);
    	//logger.debug("++++++++++++++++++++++++++++++++++++positionId"+positionId);
       	DynaActionForm dynaActionForm = (DynaActionForm) form;
       	Personal personal=new Personal();
    	
    	BeanUtils.copyProperties(personal, dynaActionForm);
    	personal.setCreatedOn(new Date());
    	String name=firstName+" "+lastName;
    	personal.setName(name);
    	personal.setPhone(phone);
    	
    	//HttpSession sessionHospital=request.getSession();
    //	Provider Provider= (Provider) sessionHospital.getAttribute("User");
    	//Long providerId=Provider.getId();
    	Session session = null;
		Transaction tx = null;
		
		try{
			
			Personal contactPersonal=null;
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("from Personal p where p.name=:name and p.providerStaff.id=:providerStaffId");
			query.setString("name", name);
			query.setLong("providerStaffId", providerStaffSession.getId());
			contactPersonal = (Personal) query.uniqueResult();
			
			
			if(contactPersonal!=null){
				ActionErrors errors=new ActionErrors();
				logger.debug("++++++++++++xyxyxyxyyxyx+++++++++++"+contactPersonal+"-------------------------");
				errors.add("personal",new ActionMessage("applicationForm.hospital.personal.error.name"));
				saveErrors(request, errors);
				return mapping.getInputForward();
			}else{
				/*
				 * insert Data base
				 * */
				
				//ProviderStaff providerStaff=(ProviderStaff) session.load(ProviderStaff.class,providerStaff.getId());
				//Position position=(Position) session.load(Position.class, positionId);
				personal.setStatus(status);
			//	personal.setPosition(position);
				RandomPersonal randomPersonal=new RandomPersonal();
				personal.setUsername(randomPersonal.username());
				personal.setPassword(randomPersonal.username());
				personal.setProviderStaff(providerStaffSession);
				
				String user=null,pass=null;
				Query query1=session.createQuery("select sy.email,sy.password from SystemControl sy ");
				List systemControl = query1.setReadOnly(true).list();
				
				Iterator<Object> i = systemControl.iterator();
				while(i.hasNext()) {
					Object[] o = (Object[]) i.next();
					
					user = (String)o[0];
					pass = (String)o[1];					
					
				}	
				
				SendMail sendMail=new SendMail();
			//	provider.getContactEmail();
				String subject="";
				String text="<h1>Hi "+personal.getTitle()+" "+personal.getName()+"</h1><br><br><br><br>username :  "+personal.getUsername()+"<br>";
				text+="password :  "+personal.getPassword()+"<br><br>";
				 logger.debug("??????????????????????user????????????"+user+"/// "+pass+"/");
				 String[] txt=request.getRequestURL().toString().split("/");
					//  logger.debug("??????????????????????????????????"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/");
				String url="<a href='"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/confirmEmailPersonal.do?username="+personal.getUsername()+"&password="+personal.getPassword()+"'>"+txt[0]+"//"+txt[2]+"/"+txt[3]+"/confirmEmailPersonal.do?username="+personal.getUsername()+"&password="+personal.getPassword()+"</a>";
				 //logger.debug("username -"+username+" subject,- "+subject+ "text,-"+text+"user,-"+user+ "pass,-"+pass +"url-"+url);
				sendMail.send(personal.getEmail(), subject, text, user, pass, url);
				session.save(personal);
				
				/*
		    	 * send mail 
		    	 * */
		    	//SendMail sendMail=new SendMail();
		    	
		    	//sendMail.send(personal.getEmail(), subject, text, user, pass, url)
			//	sendMail.send(to, subject, text, user, pass, url)
			}
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
