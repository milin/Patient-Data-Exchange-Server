<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<a href="listPersonal.do?id=${sessionScope.User.provider.id} "><bean:message key="applicationForm.hospital.listPersonal.header"/></a> >> ${requestScope.personal.title} ${requestScope.personal.name}<br></br> 
	<h2><bean:message key="applicationForm.hospital.main.personal"/></h2>
				<table width="100%" border="1" width="100%" cellspacing="0" cellpadding="0">  
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.addPersonal.title"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.title}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.addPersonal.name"/></th>
						<td width="5%" valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td width="55%" valign="top" align="left">${requestScope.personal.name}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.addPersonal.email"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.email}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.addPersonal.phone"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.phone}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.addPersonal.mobile"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.mobile}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.addPersonal.fax"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.personal.fax}</td>
					</tr>
					
				</table>
	<a href="getPersonal.do?personalId=${requestScope.personal.id}&statusPage=2"><bean:message key="applicationForm.hospital.Personal.editHeader"/> </a>