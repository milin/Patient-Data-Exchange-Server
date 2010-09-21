package org.pdes;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.List;  
import java.util.ArrayList; 

import javax.jws.WebMethod;

public class PatientDataExchange { 	
	
	public String requestToSend(String requesterID , String targetID , String patientName,
			String patientID , String transmitType)
	{
		// Push Mode
		ArrayList transmitInfo = new ArrayList();
		
		String serviceID=null;
		String IP_source=null;
		String IP_destination=null;
		String hospitalID=null;
		String sourceID=null;
		String r_patientName=null;
		String r_patientID=null;
		String r_transmitType=null;
		// r_ is return value;
		
		serviceID="aaa";
		IP_source="bbb";
		IP_destination="ccc";
		hospitalID="ddd";
		sourceID="eee";
		r_patientName="fff";
		r_patientID="ggg";
		r_transmitType="hhh";
		
		transmitInfo.add(serviceID);
		transmitInfo.add(IP_source);
		transmitInfo.add(IP_destination);
		transmitInfo.add(hospitalID);
		transmitInfo.add(sourceID);
		transmitInfo.add(r_patientName);
		transmitInfo.add(r_patientID);
		transmitInfo.add(r_transmitType);
				
		// wait for admin to validate connection.
		
		return serviceID;
	}
	
	
	
	
	public ArrayList requestToRetrieve(String hospitalID , String sourceID , String patientName,
			String patientID , String transmitType)
	{
		// Pull Mode
		// Get Log with IP Address
		ArrayList transmitInfo = new ArrayList();
		
		String serviceID=""; // Service is auto index from database
		String IP_source=null; // Get from getIP Function ( NetworkProvider Class )
		String IP_destination=null; // Get from the hospital that accept the request ???
		
		// Get ip from Network Provider Class
		NetworkProvider np = new NetworkProvider();
		
		IP_source= np.getIP();
		
		IP_destination="10.10.10.10";
		hospitalID="ddd";
		
		/*
		 * hospitalID :: Get from Database ( Provider ). 
		 * This is destination provider that will provide patient data to requester ( sourceID )
		 */
		
		sourceID="eee";
		/* Get from Database ( Provider ) 
		 * This parameter is requesterID who request the patient data.
		 */
		
		
		
		transmitInfo.add(serviceID);
		transmitInfo.add(IP_source);
		transmitInfo.add(IP_destination);
		transmitInfo.add(hospitalID);
		transmitInfo.add(sourceID);
		
		// validate connection.
		
		return transmitInfo;
	}  
	
	public String Subscription(){
		String result="";
		
		return result; 
	}   
	
	public boolean checkLogin(  String username, String password,String loginType) {
		boolean result=false;
	    // User the username and password from database.
		// Client must input the table name that want to Authenticate
		
		String dLogin,dPass = "";
		
		SecurityPDES sec = new SecurityPDES();
		DBConnect db = new DBConnect();
		
		loginType = "ProviderStaff";
		
		// loginType = ProdiverStaff or Personal
		
		String query = "Select * FROM "+ loginType +" Where username='"+username+"' and password='"+sec.hashPassword(password)+"' and status=2;";
		
		try {
			
			ResultSet rs = db.dbQuery(query);
			
			while (rs.next()) {
				dLogin = rs.getString("username");
				dPass = rs.getString("password");
			
				if((dLogin.equals(username)) && (dPass.equals(sec.hashPassword(password)))){
		            result = true;
		            System.out.println("--------- OK ---------");
		        }else{
		            result = false;
		            System.out.println("-------- FALSE -------");
		        }
			// end while	
			}
      
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
    }
	
}