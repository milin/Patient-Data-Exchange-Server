package com.check.www;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.math.BigInteger;
import java.security.*;
public class Sqlconnection {
	
	String driverName = "com.mysql.jdbc.Driver";
    String server = "localhost";
    String dbName = "projecthl7";
    String username = "root";
    String password = "1234";
    
    private Connection connection;

    /**
     * Return a connection to the database. Initialize on first call.
     */
    private Connection getConnection() {
           if (connection==null) setUpConnection();
           return connection;
    }
    private void setUpConnection() {
        try {
                Class.forName(driverName);
                String url = "jdbc:mysql://" + server +  "/" + dbName;

                connection = DriverManager.getConnection(url, username,
                              password);
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
                e.printStackTrace();
        }
 }
  public boolean checklogin(String user,String pass) throws SQLException
  {
	  String user1 = user;//"HospitalA";
	  String pass1 = pass;
	  String hashword = null;
	  try {
          MessageDigest md5 = MessageDigest.getInstance("MD5");
          md5.update(pass1.getBytes());
          BigInteger hash = new BigInteger(1, md5.digest());
          hashword = hash.toString(16);
          } catch (NoSuchAlgorithmException nsae) {
          // ignore
          }

	  
	  //"ff4f570486b00aad70e82616ce987552"; 
	  Statement select = getConnection().createStatement();
	  ResultSet result = select.executeQuery("select username,password from ProviderStaff where username = '"+user1+"' and password = '"+hashword+"'");
	  if(result.next())
	  {
	   return true;
	  }
	  else
	  {
	   return false;
	  }
  }

}
