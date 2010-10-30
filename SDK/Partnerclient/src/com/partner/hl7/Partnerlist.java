package com.partner.hl7;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;


public class Partnerlist {
	
	public static void main(String[] args)
	{
		PartnerServiceLocator loc = new PartnerServiceLocator();
		try
		{
			int i = 0;
			Partner db = loc.getPartner();    ///.getCheckClient();
			System.out.println("partner list via webservice");
			//String users = args[0];
			String users = "HospitalB";
			
			String[] ma = db.partener(users);
			
			for(i = 0 ;i<ma.length;i++)
			{
			System.out.println(ma[i]);
			}
			}
		catch (ServiceException e) {
            e.printStackTrace();
    } catch (RemoteException e) {
            e.printStackTrace();
    }

}

}
