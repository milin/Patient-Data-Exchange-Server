package com.partner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Partner {
	 public String[] partener(String users) throws Exception/*SQLException, ClassNotFoundException*/ {
	      // Load the JDBC driver
		 
		 String user = users;
		 int k = 0;
		 
	      Class.forName("com.mysql.jdbc.Driver");
	      //System.out.println("Driver loaded");
	      String partner = null;
	     // Establish a connection
	       Connection connection = DriverManager.getConnection
	       ("jdbc:mysql://localhost/projecthl7","root","1234");
	     //System.out.println("Database connected");
	
	     // Create a statement
	     Statement statement = connection.createStatement();
	
	     // Execute a statement
	     ResultSet resultSet = statement.executeQuery("select serviceID from Provider where name='"+user+"'");
	
	     // Iterate through the result and print the student names
	     while (resultSet.next())
	     
	    	 partner = resultSet.getString(1);
	        //System.out.println(partner); 	 
	     
	      
	    	/* System.out.println(resultSet.getString(1) + "\t" +
	         resultSet.getString(2) + "\t" + resultSet.getString(3)); */
	
	     // Close the connection
	     String[] results = partner.split(",");
	     int length = results.length;
	     String arr[] = new String[length];    
		     for(int i =0;i<length;i++)
		     {
		    	 
		    	 ResultSet resultSet1 = statement.executeQuery("select name from Provider where id='"+results[i]+"'");
			
		     // Iterate through the result 
		     while (resultSet1.next())
		     { 
		    	 //int k = 0;
		    	
		    	 arr[k] =  resultSet1.getString(1);
		    	 //System.out.println(resultSet1.getString(1));
		         
		     }
		     
		     k++;
	    
	        }
		     
		     
		     connection.close();


		     return arr;

	 }
	 
}
