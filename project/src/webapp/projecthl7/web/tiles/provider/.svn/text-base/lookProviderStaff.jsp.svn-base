<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
     <h2><bean:message key="applicationForm.hospital.view"/> <bean:message key="applicationForm.hospital.providerStass"/></h2>
			<input type="hidden" name="id" value="${param.staffId}">
				<table width="100%" cellspacing="0" cellpadding="0" >
					
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.username"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.username}</td>
					</tr><tr>
						<th scope="col"><bean:message key="applicationForm.hospital.contactName"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.contactName}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.contactMobile"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.contactMobile}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.contactEmail"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.contactEmail}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.lock"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<c:if test="${requestScope.providerStaff.status == 1}">
									No confirm email
							</c:if>
							<c:if test="${requestScope.providerStaff.status == 3}">
									<a href="lockProviderStaff.do?providerStaffId=${requestScope.providerStaff.id}" onclick="return confirm('Are you sure you want to lock ${requestScope.providerStaff.contactName}?')"><img src="./images/lock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
							</c:if>
							<c:if test="${requestScope.providerStaff.status == 2}">
									<a href="lockProviderStaff.do?providerStaffId=${requestScope.providerStaff.id}" onclick="return confirm('Are you sure you want to lock ${requestScope.providerStaff.contactName}?')"><img src="./images/unlock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
							</c:if>
						</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.listPersonal.delete"/> <bean:message key="applicationForm.hospital.providerStass"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><a href="deleteProviderStaff.do?id=${requestScope.providerStaff.id}"><bean:message key="applicationForm.hospital.listPersonal.delete"/></a></td>
					</tr>
					
				</table>
			