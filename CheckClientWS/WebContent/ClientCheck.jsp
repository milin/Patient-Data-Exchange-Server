<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.xml.rpc.ServiceException"%>
<%@page import="java.rmi.RemoteException"%>
 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckClient through webservices</title>
</head>
<body>
<form name="f1" method="post">
<table>
<tr>
<td>User Name</td><td><input type="text" name="t1" ></td>
</tr>
<tr>
   <td>Password</td>
   <td><input type="password" name="t2"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="b1" value="LogIn"></td>
</tr>
</table>




</form>
</body>
</html>