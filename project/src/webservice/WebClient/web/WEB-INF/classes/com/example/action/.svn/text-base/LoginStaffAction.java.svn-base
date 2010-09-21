package com.example.action;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.pdes.LoginStaff;


import com.example.model.Address;
import com.example.model.User;

public class LoginStaffAction extends Action{


	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws Exception {

		String username=request.getParameter("username");
		String password=request.getParameter("password");

		try {

			LoginStaff loginStaff=new LoginStaff();
			String result=loginStaff.checkLogin(username, password);
			request.setAttribute("checkLogin", result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (mapping.findForward("success"));
	}


}

