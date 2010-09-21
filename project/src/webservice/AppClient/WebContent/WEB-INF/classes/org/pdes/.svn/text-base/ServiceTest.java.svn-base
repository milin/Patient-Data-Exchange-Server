package org.pdes;


import java.rmi.RemoteException;
import org.pdes.*;

public class ServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws RemoteException{
		// TODO Auto-generated method stub
		PatientDataExchangeStub stub = new PatientDataExchangeStub();
		
		PatientDataExchangeStub.CheckLogin cl = new PatientDataExchangeStub.CheckLogin();
		
		String uName = args[0];
		String passwd = args[1];
		
		cl.setUsername(uName);
		cl.setPassword(passwd);
		
		PatientDataExchangeStub.CheckLoginResponse res = stub.checkLogin(cl);
		System.out.println("Result = " + res.get_return());
		
		
	}

}
