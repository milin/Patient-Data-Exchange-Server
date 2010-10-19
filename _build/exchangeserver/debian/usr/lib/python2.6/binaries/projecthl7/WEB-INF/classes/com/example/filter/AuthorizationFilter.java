package com.example.filter;
import java.io.*; 
import java.net.URLEncoder;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.example.model.Provider;
import com.example.model.Admin;
import com.example.model.ProviderStaff;
public class AuthorizationFilter implements Filter{
	private static Logger logger=Logger.getLogger(CharsetFilter.class );
	 private String encoding;
	 private FilterConfig filterConfig;
		
	private static List<String> providerUrls = new ArrayList<String>();
	private static List<String> adminUrl = new ArrayList<String>();
	 static {
			providerUrls.add("/lookProvider.do");
			providerUrls.add("/addProviderStaff.do");
			providerUrls.add("/listPersonal.do");
			providerUrls.add("/getProvider.do");
			providerUrls.add("/addPersonal.do");
			providerUrls.add("/addProviderRequest.do");
			providerUrls.add("/editPassword.do");
			providerUrls.add("/changePassword.do");
			providerUrls.add("/connectProviderService.do");
			providerUrls.add("/subMenu.do");
			providerUrls.add("/editProvider.do");
			providerUrls.add("/getPersonal.do");
			providerUrls.add("/getPersonal.do");
			providerUrls.add("/editPersonal.do");
			providerUrls.add("/lockPersonal.do");
			providerUrls.add("/listProviderRegisterService.do");
			providerUrls.add("/signOutProvider.do");
			providerUrls.add("/listProviderService.do");
			providerUrls.add("/sentProviderRequest.do");	
			providerUrls.add("/displayProviderRequests.do");
			providerUrls.add("/addProviderService.do");
			providerUrls.add("/confirmAddProvider.do");		
			
			
			adminUrl.add("/deletePersonal.do");
			adminUrl.add("/listUserReportLogin.do");
			adminUrl.add("/addAdminProvider.do");
			adminUrl.add("/listAdminProviderRegister.do");
			adminUrl.add("/listAdminProvider.do");
			adminUrl.add("/adminSendMail.do");
			adminUrl.add("/getAdminProvider.do");
			adminUrl.add("/editAdminProvider.do");
			adminUrl.add("/lockAdminProvider.do");
			adminUrl.add("/logOutAdmin.do");
			adminUrl.add("/lockAdminPersonal");
			adminUrl.add("/listAdminPersonal.do");
			
	 }
	 public void init(FilterConfig filterConfig) throws ServletException{
		  encoding = filterConfig.getInitParameter("requestEncoding");
		  if( encoding==null ) encoding="UTF-8";
		//  System.out.print("**************************************init**************************************8");
	 }

	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
	 throws IOException, ServletException{
		  // Respect the client-specified character encoding
		  // (see HTTP specification section 3.4.1)
		    HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession httpSession = req.getSession();
			
			
			logger.debug("-------------------------getServletPath1111-----------------------------------------"+req.getServletPath());
			//logger.debug("-------------------------getgetRequestURL-----------------------------------------"+req.getRequestURL());
			
			logger.debug("*******doFilter***********doFilter*************doFilter*******");
			/*logger.debug("-------------------------getRequestURI-----------------------------------------"+req.getRequestURI());
			logger.debug("-------------------------getLocalName-----------------------------------------"+req.getLocalName());
			logger.debug("-------------------------getContextPath-----------------------------------------"+req.getContextPath());	
			logger.debug("-------------------------getCharacterEncoding-----------------------------------------"+req.getCharacterEncoding());	
			logger.debug("-------------------------getContentType-----------------------------------------"+req.getContentType());
			logger.debug("-------------------------getContextPath-----------------------------------------"+req.getContextPath());
			logger.debug("-------------------------getServletPath-----------------------------------------"+req.getServletPath());
			logger.debug("-------------------------getgetRequestURL-----------------------------------------"+req.getRequestURL());
			logger.debug("-------------------------getgetRemoteHost-----------------------------------------"+	req.getRemoteHost());
			logger.debug("-------------------------getHeaderNames-----------------------------------------"+req.getHeaderNames());
			logger.debug("-------------------------getLocalAddr-----------------------------------------"+req.getLocalAddr());
			logger.debug("-------------------------getParameterNames-----------------------------------------"+req.getParameterNames());
			logger.debug("-------------------------getPathTranslated-----------------------------------------"+req.getPathTranslated());
			logger.debug("-------------------------getPathInfo-----------------------------------------"+req.getPathInfo());
			logger.debug("-------------------------getPathTranslated-----------------------------------------"+req.getPathTranslated());
			logger.debug("-------------------------getQueryString-----------------------------------------"+req.getQueryString());*/
			String urlWithReplace = req.getRequestURI().replaceFirst(req.getContextPath(), "");
			//logger.debug(urlWithReplace);
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++ begin check 2 ++++++++++++++urlWithReplace+++++++++++++++++"+urlWithReplace);
			
			String returnUrl = urlWithReplace;
			
			returnUrl = returnUrl.replace("/", "");
			Enumeration<String> enumParams = req.getParameterNames();
			int count = 0;
			while (enumParams.hasMoreElements()) {
				//String param = "";
				String paramName = (String) enumParams.nextElement();
				if (count == 0) {
					returnUrl += "?";
				} else {
					returnUrl += "&";
				}
				returnUrl += paramName + "=" + req.getParameter(paramName);
				count++;
			}
			String encodeReturnUrl = URLEncoder.encode(returnUrl, "UTF-8");
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++ encodeReturnUrl : "+ encodeReturnUrl+" +++++++++++++++++++++++++++++++");
			req.setAttribute("returnUrl", encodeReturnUrl);
			//logger.debug("+++++++++++++++++++++++++++++++++++++++++ begin check 2 ++++++++returnUrl+++++++++++++++++++++++"+returnUrl);
		
			/** Begin:**/
			if (providerUrls.contains(urlWithReplace)) {
				ProviderStaff providerStaff=(ProviderStaff) httpSession.getAttribute("User");
				 System.out.print("*******************providerUrls******************providerUrls******************providerUrls*******");
				if(providerStaff==null){
					 req.getRequestDispatcher("signIn.jsp").forward(req, res);
					//req.getRequestDispatcher(filterConfig.getInitParameter("onSessionError")).forward(req, res);
					logger.debug("**************************************providerUrls************providerUrls();*************************8");
				}
			}else if (adminUrl.contains(urlWithReplace)) {
				Admin admin=(Admin) httpSession.getAttribute("admin");
				 logger.debug("**************************************adminUrl1***********adminUrl();************************adminUrl");
				if(admin==null){
					 req.getRequestDispatcher("adminLogin.jsp").forward(req, res);
					// req.getRequestDispatcher(filterConfig.getInitParameter("onProviderError")).forward(req, res);
					 logger.debug("**************************************adminUrl2************adminUrl();***66666666666666*********************adminUrl");
				}
				
			 }
		  if(null == request.getCharacterEncoding())
		    request.setCharacterEncoding(encoding);
		  
		 // System.out.print("**************************************doFilter*************Provider.getName()*************************8");
		  next.doFilter(request, response);
	 }

 	 public void destroy(){}
}

