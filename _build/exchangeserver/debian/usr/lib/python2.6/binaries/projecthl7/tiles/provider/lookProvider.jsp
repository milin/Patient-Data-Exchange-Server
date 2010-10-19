<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
     <h2><bean:message key="applicationForm.hospital.view"/> <bean:message key="applicationForm.provider"/></h2>
			<input type="hidden" name="id" value="${param.staffId}">
				<table width="100%" cellspacing="0" cellpadding="0" >
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.name"/></th>
						<td width="5%" valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td width="55%" valign="top" align="right">${requestScope.providerStaff.provider.name}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.username"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.username}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.www"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.provider.www}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.type"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
						<c:choose>
							<c:when test="${requestScope.providerStaff.provider.type==1}">
								<bean:message key="applicationForm.hospital.government"/>
							</c:when>
							<c:otherwise>
								<bean:message key="applicationForm.hospital.person"/>
							</c:otherwise>
						</c:choose></td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.phone"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							${requestScope.providerStaff.provider.phone}${requestScope.phone}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.fax"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.provider.fax}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.country"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.provider.city.country.name}</td>
						
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.city"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.provider.city.name}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.address"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.provider.address}</td>
					</tr>
					<tr>
						<th scope="col"><bean:message key="applicationForm.hospital.zip"/></th>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">${requestScope.providerStaff.provider.zip}</td>
					</tr>
					<tr>
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
				</table>
			