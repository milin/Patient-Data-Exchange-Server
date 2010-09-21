package com.example.action;

import java.util.Locale;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SetLocaleAction extends Action{
	private Logger logger=Logger.getLogger(SetLocaleAction.class);
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {
		Locale locale ;
		try{
			HttpSession session = request.getSession();
			//request.get
			logger.debug("request.getParameterurl++++++++++++++++++++"+request.getParameter("url"));
			String url=request.getParameter("url");
			logger.debug("request.getReader()1234++++++++++++++++++++++"+request.getContextPath());
			request.getRequestURI();
			
			String language = request.getParameter("language");
			//	String country = request.getParameter("country");
			if(language.endsWith("th")){
				locale = new Locale("th", "TH");
			}else{
				locale = new Locale("en", "EN");
			}
			
			//	Locale locale = new Locale(language, country);
			session.setAttribute(Globals.LOCALE_KEY, locale);

		}catch(Exception ex){

			throw new WebActionException(ex);
		}finally{

		}

		return (mapping.findForward("success"));

	}


}