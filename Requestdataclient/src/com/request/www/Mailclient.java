package com.request.www;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;



public class Mailclient 
{
  public static void main(String[] args)
  {

		MailserviceServiceLocator loc = new MailserviceServiceLocator();
		try
		{
			Mailservice db = loc.getMailservice();    ///.getCheckClient();
			
			db.sendmail();
			
		}
		catch (ServiceException e) {
          e.printStackTrace();
  } catch (RemoteException e) {
          e.printStackTrace();
  }
  }
	
}	
	
	
	
	

