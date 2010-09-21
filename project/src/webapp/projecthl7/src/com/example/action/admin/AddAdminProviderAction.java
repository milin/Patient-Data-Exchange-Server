package com.example.action.admin;

import java.net.InetAddress;
import java.util.Date;

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

import com.example.model.City;
import com.example.model.HashPassword;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;
import com.example.action.WebActionException;
public class AddAdminProviderAction extends Action{
private static Logger logger = Logger.getLogger(AddAdminProviderAction.class);
	
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
      throws Exception {
    	
    	logger.debug("========================="+request.getParameter("password")+"-------------------------"+request.getParameter("hospitalRetypePassword"));
    	String password=request.getParameter("password");
    	String rePassword=request.getParameter("rePassword");
    	String contactName=request.getParameter("contactName");
    	String name=request.getParameter("name");
    	int country =Integer.parseInt(request.getParameter("country"));
    	int type =Integer.parseInt(request.getParameter("type"));
    	contactName+=" "+request.getParameter("contactSurName");
    	String phone=request.getParameter("phone1");
    	phone+=request.getParameter("phone2");
    	int cityId=Integer.parseInt(request.getParameter("city"));
    	
    	 logger.debug("====================contactName== "+contactName+" -----------contactName--------------");
    	 
    	String username=request.getParameter("username");
    	InetAddress thisIp =InetAddress.getLocalHost();
    	String  i=thisIp.getHostAddress();
    	
    	
    	logger.debug("====================thisIp=="+thisIp.getAddress()+"-----------thisIp--------------");
    	if(!password.equals(rePassword)){
    		ActionErrors errors = new ActionErrors();
    		logger.debug("+++++++++++++++++++++"+request.getParameter("rePassword")+"-------------------------"+request.getParameter("hospitalRetypePassword"));
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.password"));
    		logger.debug("yes");
			saveErrors(request, errors);
			return mapping.getInputForward();
    	}
    	if(type==0){
    		ActionErrors errors = new ActionErrors();
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.type"));
    		saveErrors(request, errors);
			return mapping.getInputForward();
    	}
    	
    	//check Country
     	if(country==0){
    		ActionErrors errors = new ActionErrors();
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.country"));
    		saveErrors(request, errors);
			return mapping.getInputForward();
    	}
     	
    	//check City
     	if(cityId==0){
    		ActionErrors errors = new ActionErrors();
    		errors.add("hospitalPassword", new ActionMessage("applicationForm.hospital.error.city"));
    		saveErrors(request, errors);
    		return mapping.getInputForward();
    	}
     	
    	DynaActionForm dynaActionForm = (DynaActionForm) form;
    		
    	Provider register = new Provider();
    	ProviderStaff providerStaff=new ProviderStaff();
    	//.setHospitalDateRegister(new Date());
    	providerStaff.setCreatedOn(new Date());
    	register.setIpAddress(i);
    	
    	
    	BeanUtils.copyProperties(register, dynaActionForm);
		BeanUtils.copyProperties(providerStaff, dynaActionForm);
		providerStaff.setContactName(contactName);
		register.setStatus(0);
		register.setPhone(phone);
		/*String encryptPass = com.omb.onlineclub.encrypt.OneWayEncrypt.getInstance().encrypt(register.getPassword());
		user.setPassword(encryptPass);
		*/
		
    	Session session = null;
		Transaction tx = null;
		try{
			//Begin Unit of work
			ProviderStaff user=null;
			Provider userName=null;
			
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Query query1=session.createQuery("from Provider p where p.name=:name");
			query1.setString("name", name);
			userName = (Provider) query1.uniqueResult();
			logger.debug("+++++++++++++++++++++userName "+userName+"-------------------------");
			if(userName!=null){
				ActionErrors errors=new ActionErrors();
				logger.debug("+++++++++++++++++++++name "+user+"-------------------------");
				errors.add("hospitalUserName",new ActionMessage("applicationForm.hospital.error.Name"));
				saveErrors(request, errors);
				return mapping.getInputForward();
					
			}
			//check username
			Query query=session.createQuery("from ProviderStaff ps where ps.username=:username");
			query.setString("username", username);
			user = (ProviderStaff) query.uniqueResult();
			if(user!=null){
				ActionErrors errors=new ActionErrors();
				logger.debug("+++++++++++++++++++++testUser"+user+"-------------------------");
				errors.add("hospitalUserName",new ActionMessage("applicationForm.hospital.error.UserName"));
				saveErrors(request, errors);
				return mapping.getInputForward();
			}
		
			logger.debug("+++++++++++++++++++++city"+cityId+"------city------------------");
			HashPassword pass=new HashPassword();
			providerStaff.setPassword(pass.hashPassword(password));
			providerStaff.setMaster(1);
			
			//1 true
			City city=(City)session.load(City.class,cityId);
			register.setCity(city);
			register.setNumberStaff(1);
			session.save(register);
			providerStaff.setStatus(0);
			providerStaff.setProvider(register);
			session.save(providerStaff);
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
