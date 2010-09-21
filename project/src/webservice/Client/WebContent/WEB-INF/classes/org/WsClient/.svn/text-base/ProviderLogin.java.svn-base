package org.WsClient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pdes.Login;
import org.pdes.PatientDataExchangeStub;

public class ProviderLogin extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Login Login =new Login();
		String checkLogin=Login.loginSystem(username, password);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.println("Beer Selection Advice<br> -checkLogin-"+checkLogin);
		String color = request.getParameter("color");
		out.print("</center>");
		
		
	}
}

