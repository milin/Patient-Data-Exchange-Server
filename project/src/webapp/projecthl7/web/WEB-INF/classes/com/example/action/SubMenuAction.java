package com.example.action;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Country;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

public class SubMenuAction extends Action{
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {

		String ajaxResponse="<div id=\"subnavi\">";
		ajaxResponse+="<ul id=\"subnav\">";
		Locale locale = request.getLocale();
		MessageResources messageResources = getResources(request);
		if(request.getParameter("subMenu")!=null){
			String  subMenu =request.getParameter("subMenu");



			ProviderStaff providerStaff= (ProviderStaff) request.getSession().getAttribute("User");
			Long sessionId=providerStaff.getProvider().getId();
			if(subMenu.equals("1")){

				String view = messageResources.getMessage(locale, "applicationForm.hospital.view");
				String edit = messageResources.getMessage(locale, "applicationForm.hospital.edit");
				String changePassword= messageResources.getMessage(locale, "applicationForm.hospital.changePassword");
				//errors.add("userLogin",new ActionMessage("applicationForm.hospital.errorLogin.userName"));
				//ActionMessage views=new ActionMessage("applicationForm.hospital.view");

				ajaxResponse+="<li><a href=\"lookProvider.do?staffId="+providerStaff.getId()+"&statusSubMenu=1\">"+view+"</a></li>";
				ajaxResponse+="<li><a href=\"getProvider.do?staffId="+providerStaff.getId()+"&statusSubMenu=2\">"+edit+"</a></li>";
				ajaxResponse+="<li><a href=\"changePassword.do?staffId="+providerStaff.getId()+"&statusSubMenu=9\">"+changePassword+"</a></li>";
				
				ajaxResponse+="</ul>";
				ajaxResponse+="<div class=\"clear\"></div>";
				ajaxResponse+="</div>";
				request.setAttribute("ajaxResponse", ajaxResponse);
			}else if(subMenu.equals("2")){
				String add = messageResources.getMessage(locale, "applicationForm.hospital.listPersonal.add");
				String listPersonal = messageResources.getMessage(locale, "applicationForm.hospital.listPersonal.header");
				ajaxResponse+="<li><a href=\"personalAdd.jsp?statusSubMenu=3\">"+add+"</a></li>";
				ajaxResponse+="<li><a href=\"listPersonal.do?id="+sessionId+"&statusSubMenu=4\">"+listPersonal+"</a></li>";
				ajaxResponse+="</ul>";
				ajaxResponse+="<div class=\"clear\"></div>";
				ajaxResponse+="</div>";
				request.setAttribute("ajaxResponse", ajaxResponse);
			}else if(subMenu.equals("3")){
				String menuProvider = messageResources.getMessage(locale, "applicationForm.menu.allProviders");
				String listProvider = messageResources.getMessage(locale, "applicationForm.menu.partnerList");
				String sentProviderRequests = messageResources.getMessage(locale, "applicationForm.menu.outgoingRequests");
				String providerRequests = messageResources.getMessage(locale, "applicationForm.menu.incomingRequests");
				ajaxResponse+="<li><a href=\"listProviderRegisterService.do?id="+sessionId+"&statusSubMenu=5\">"+menuProvider+"</a></li>";
				ajaxResponse+="<li><a href=\"listProviderService.do?statusSubMenu=6\">"+listProvider+"</a></li>";
				ajaxResponse+="<li><a href=\"sentProviderRequest.do?statusSubMenu=7\">"+sentProviderRequests+"</a></li>";
				ajaxResponse+="<li><a href=\"displayProviderRequests.do?statusSubMenu=8\">"+providerRequests+"</a></li>";
				ajaxResponse+="</ul>";
				ajaxResponse+="<div class=\"clear\"></div>";
				ajaxResponse+="</div>";
				request.setAttribute("ajaxResponse", ajaxResponse);
			}

		}
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			//				List<Country> country=session.createQuery("from Country country").list();
			//				request.setAttribute("country", country);
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