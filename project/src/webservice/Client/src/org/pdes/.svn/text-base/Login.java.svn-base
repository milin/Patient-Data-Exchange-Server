package org.pdes;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.AxisFault;

public class Login extends HttpServlet{

	public String loginSystem(String username,String password) throws RemoteException {
		PatientDataExchangeStub stub = new PatientDataExchangeStub();
		
		PatientDataExchangeStub.CheckLogin cl = new PatientDataExchangeStub.CheckLogin();
		cl.setUsername(username);
		cl.setPassword(password);
		PatientDataExchangeStub.CheckLoginResponse res = stub.checkLogin(cl);
		String checkLogin=new Boolean(res.get_return()).toString();
		
		return checkLogin;
		
		
	}
		
	}
