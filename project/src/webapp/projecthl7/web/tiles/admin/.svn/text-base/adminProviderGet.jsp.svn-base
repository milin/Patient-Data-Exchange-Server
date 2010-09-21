<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>

			<a href=<c:choose> 
		                 <c:when test="${param.pageProvider==1}">
		                 	"listAdminProviderRegister.do"><bean:message key="applicationForm.admin.menu.register"/>
		                 </c:when>
		                 <c:when test="${param.pageProvider==2}">
		                 		"listAdminProvider.do"><bean:message key="applicationForm.admin.menu.provider"/>
		                 </c:when>
		             </c:choose>
  			</a> >> ${requestScope.provider.name}
  	<br></br>
			<h2><bean:message key="applicationForm.provider"/></h2>
				<table width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<th width="40%" valign="top"><bean:message key="applicationForm.hospital.name"/></th>
						<td width="5%" valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td width="55%" valign="top" align="left">${requestScope.provider.name}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.username"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.username}</td>
					</tr>
					
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.www"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.provider.www}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.phone"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.provider.phone}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.fax"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.provider.fax}
						</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.country"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.provider.city.country.name}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.city"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.provider.city.name}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.address"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.provider.address}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.zip"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.provider.zip}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.contactName"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.contactName}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.contactSurName"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.contactSurName}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.contactMobile"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.contactMobile}</td>
					</tr>
					<tr>
						<th valign="top"><bean:message key="applicationForm.hospital.contactEmail"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.contactEmail}</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						</td>
					</tr>
				</table>

