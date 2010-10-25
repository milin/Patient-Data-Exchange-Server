package com.www;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Logincheck {
	public static void main(String[] args)
	{
		AuthenServiceLocator loc = new AuthenServiceLocator();
		try
		{
			Authen db = loc.getAuthen();    ///.getCheckClient();
			System.out.println("login via webservice");
			String users = "HospitalA";
			String pwd = "HospitalA";
			boolean ma = db.checklogin(users,pwd);
			System.out.println(ma);
		}
		catch (ServiceException e) {
            e.printStackTrace();
    } catch (RemoteException e) {
            e.printStackTrace();
    }

}

}
