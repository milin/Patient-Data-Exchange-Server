<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<a href="listAdminPersonal.do"><bean:message key="applicationForm.hospital.listPersonal.header"/></a> >> ${requestScope.personal.title} ${requestScope.personal.name}

			<h2><bean:message key="applicationForm.hospital.addPersonal.header"/></h2>
	
				<table width="100%" border="1"> 
					<tr>
						<th valign="top" align="right"><bean:message key="applicationForm.hospital.addPersonal.name"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.title} ${requestScope.personal.name}</td>
					</tr>
					<tr>
						<th valign="top" align="right"><bean:message key="applicationForm.hospital.addPersonal.email"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.email}</td>
					</tr>
					<tr>
						<th valign="top" align="right"><bean:message key="applicationForm.hospital.addPersonal.phone"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.phone}</td>
					</tr>
					<tr>
						<th valign="top" align="right"><bean:message key="applicationForm.hospital.addPersonal.mobile"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.mobile}</td>
					</tr>
					<tr>
						<th valign="top" align="right"><bean:message key="applicationForm.hospital.addPersonal.fax"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.fax}</td>
					</tr>
				</table>
<a href="getAdminPersonal.do?id=${requestScope.personal.id}&statusPage=2"><bean:message key="applicationForm.hospital.Personal.editHeader"/></a>
