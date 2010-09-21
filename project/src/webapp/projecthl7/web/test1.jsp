<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>


	<h2><bean:message key="applicationForm.hospital.listPersonal.header"/></h2>
	<table border="1" width="100%">
	<tr>
		<th align="center"><bean:message key="applicationForm.hospital.listPersonal.no"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.addPersonal.name"/></th>
		<th valign="center"><bean:message key="applicationForm.hospital.name"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.listPersonal.position"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.listPersonal.edit"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.lock"/></th>
	
	</tr>
	
	
			<c:forEach var="country" items="${requestScope.country}">
			<tr>
				<td align="center">${country[0].name}</td>
				<td align="center">  ${country[1].name}</td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="center"><img alt=<bean:message key="applicationForm.hospital.listPersonal.edit"/> src="./images/edit.png" width="20px" height="20px"></a></td>
				<td align="center">
			
				
				</td>
			</tr>
			</c:forEach>
		
	<tr>
</table>