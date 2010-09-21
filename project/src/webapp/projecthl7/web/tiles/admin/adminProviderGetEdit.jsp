<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<table width="100%" border="1">
	<tr>
		<td align="center"><bean:message key="applicationForm.hospital.header"/></td>
	</tr>
	<tr>
		<td align="center">
			<table width="40%" border="1">
				<tr>
					<td><html:errors/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<form id="editProvider" method="post" action="editAdminProvider.do">
			<input type="hidden" name="id" value="${param.id}">
				<table width="40%" border="1">
					<tr>
						<td width="40%" valign="top"><bean:message key="applicationForm.hospital.name"/></td>
						<td width="5%" valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td width="55%" valign="top" align="left"><input type="hidden" name="name" value="${requestScope.provider.name}${param.name}"/>${requestScope.provider.name}${param.name}</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.username"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="hidden" name="username" value="${requestScope.providerStaff.username}${param.username}"/>${requestScope.providerStaff.username}${param.username}</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.password"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="password" name="password" value="${param.password}" maxlength="15"/></br>6 character minimum; case sensitive</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.repassword"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="password" name="rePassword" value="${param.rePassword}" maxlength="15"/></td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.www"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="www" value="${requestScope.provider.www}${param.www}"/></td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.phone"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="phone1" value="${requestScope.provider.phone}${param.phone1}" maxlength="11" size="15" >-
							<input type="text" name="phone2" value="${requestScope.phone}${param.phone2}" maxlength="3" size="5" ></br>
							<bean:message key="applicationForm.hospital.example.phone"/>+xxxxxxxxxx-xxx</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.fax"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="fax" value="${requestScope.provider.fax}${param.fax}" maxlength="11"/></br>
							<bean:message key="applicationForm.hospital.example.fax"/> +xxxxxxxxxx
						</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.country"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"></td>
						
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.city"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"></td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.address"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<label>
						  		<textarea name="address" cols="30" rows="5">${requestScope.provider.address}${param.address}</textarea>
						  	</label>
						</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.zip"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="zip" value="${requestScope.provider.zip}${param.zip}" maxlength="5"/>
							</br> 
							<bean:message key="applicationForm.hospital.example.zip"/>xxxxx
						</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.contactName"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactName" value="${requestScope.providerStaff.contactName}${param.contactName}"/>
						</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.contactSurName"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactSurName" value="${requestScope.contactSurName}${param.contactSurName}"/>
						</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.contactMobile"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactMobile" value="${requestScope.providerStaff.contactMobile}${param.contactMobile}" maxlength="11"/></br>
							<bean:message key="applicationForm.hospital.example.contactMobile"/>+xxxxxxxxxxx
						</td>
					</tr>
					<tr>
						<td valign="top"><bean:message key="applicationForm.hospital.contactEmail"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactEmail" value="${requestScope.providerStaff.contactEmail}${param.contactEmail}" maxlength="50"/></br>
							<bean:message key="applicationForm.hospital.example.contactEmail"/>xxx@xxxxxx.com
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="sumbit" value=<bean:message key="applicationForm.submit"/>>
						<input type="reset" name="reset" value=<bean:message key="applicationForm.reset"/>></td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
</table>
