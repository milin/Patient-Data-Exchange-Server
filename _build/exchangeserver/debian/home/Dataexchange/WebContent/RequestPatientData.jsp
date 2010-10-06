<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data Exchange</title>
</head>
<body>

<h1>Request Patient Information</h1>
<form method="post" action="Sendmail"> 
			<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><b>Partner List</b></td><td> 
	   <select name="semp_id" size="1" onchange="showEmp(this.value);">
	   <option value="-1">Select</option> 
<%



Connection conn = null;
    String url = "jdbc:mysql://localhost:8080/";
    String dbName = "projecthl7";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "1234";

    int sumcount=0; 
	Statement st;
    try {
      Class.forName(driver).newInstance();
	 
      conn = DriverManager.getConnection(url+dbName,userName,password);
	    String query = "select name from Provider";
	
       st = conn.createStatement();
	   ResultSet  rs = st.executeQuery(query);
	   %>
	  
	   <%
	  while(rs.next())
		{
		  %>
		  
		   <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option> 
			
  <%
		}
  %>
     
  <%
     
	}
	catch (Exception e) {
      e.printStackTrace();
    }
	
%>
 </select>
</td></tr>
				
				
				
				<tr>
				 <td> Patient Information </td>
				</tr>
				
				
				
				<tr>
					<td>Patient ID: </td>
					<td><input type="text" name="patientid" size="20"/></td>
				</tr>
				<tr>
				</tr>
				<tr>
				   <td> First Name : </td>
				   <td><input type="text" name="firstname" size="20"/></td>
				   </tr>
				   <tr>
				   </tr>
				    
				   <tr>
				    <td> Last Name : </td>
				    <td><input type="text" name="lastname" size="20" /></td>
				   </tr>
				   <tr>
				   </tr>
				   <tr>
				    <td> Phone Number : </td>
				    <td><input type="text" name="phoneno" size="20" /></td>
				    </tr>
				  <tr>
				    <td> Age : </td>
				    <td><input type ="text" name="Age" size="20" /></td>
				    </tr>
				    <tr>
				     <td> Sex : </td>
				     <td><input type ="text" name="Sex" size="20" /></td>
				     </tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="B1"/>
<input type="reset" name="B2"/></td>
				</tr>
			</table>
		</form>



</body>
</html>