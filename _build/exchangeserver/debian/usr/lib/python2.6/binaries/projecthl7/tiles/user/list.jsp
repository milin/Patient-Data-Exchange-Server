<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
			<h2><bean:message key="userForm.list.header"/></h2>
			
				<p><a href="addUser.jsp"/>Add New User</a></p>	
				
				<table width="100%" cellspacing="0" cellpadding="0">
				
	     			<tr>
	     				<th scope="col"></th>
	       				<th scope="col"><bean:message key="userForm.id"/></th>
	       				<th scope="col"><bean:message key="userForm.firstName"/></th>
	       				<th scope="col"><bean:message key="userForm.lastName"/></th>
	     			</tr>
					<c:forEach var="user" items="${requestScope.users}">     			
	      			<tr>
	       				<td><a href="getUser.do?id=${user.id}">Edit</a> | <a href="deleteUser.do?id=${user.id}">Delete</a></td>
	        			<td>${user.id}</td>
	        			<td>${user.firstName}</td>
	        			<td>${user.lastName}</td>
	     			</tr>
					</c:forEach>
	      		
	      	      			     			
	   		    </table>
   			