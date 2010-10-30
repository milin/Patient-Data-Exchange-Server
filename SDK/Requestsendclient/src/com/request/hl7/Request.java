package com.request.hl7;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;


public class Request {
	public static void main(String[] args)
	{
		RequestsendServiceLocator loc = new RequestsendServiceLocator();
		try
		{
			
			Requestsend db = loc.getRequestsend();    ///.getCheckClient();
			//System.out.println("partner list via webservice");
			//String users = args[0];
			String users = "HospitalB";
			String fname = "apurba";
			String lname = "dhungana";
			String sex = "male";
			String age ="23";
			db.sendemail(users, fname, lname, age, sex);
			System.out.println("your request has been succesfully send");
			
			
			}
		catch (ServiceException e) {
            e.printStackTrace();
    } catch (RemoteException e) {
            e.printStackTrace();
    }

}
}
