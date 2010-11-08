package com.check.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Check1 {
	public String emailfinder(String name) throws Exception/*SQLException, ClassNotFoundException*/
	{
		Class.forName("com.mysql.jdbc.Driver");
		String name1 = null;
		String email = null;
		name1=name;
		Connection connection = DriverManager.getConnection
	       ("jdbc:mysql://localhost/projecthl7","root","1234");
		Statement statement = connection.createStatement();
		
	     // Execute a statement
	     ResultSet resultSet = statement.executeQuery("select contactEmail from ProviderStaff where username='"+name1+"'");
	     while (resultSet.next())
		   
	    	 email = resultSet.getString(1);
		connection.close();
		return email;
		
	}

}
