<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<form action="editPersonal.do" method="post">
<table border="0" width="100%">
	<tr>
		<td align="left">
		<input type="hidden" name="headName" value="${requestScope.personal.position.name} ${requestScope.personal.name} ${requestScope.lastName} ${param.headName}"/>
		<a href="listPersonal.do?id=${sessionScope.User.id} "><bean:message key="applicationForm.hospital.listPersonal.header"/></a> 
		>>${requestScope.personal.position.name} ${requestScope.personal.name} ${requestScope.lastName}${param.headName}</td>
	</tr>
	<tr>
		<td align="center"><bean:message key="applicationForm.hospital.Personal.editHeader"/></td>
	</tr>
	<tr>
		<td align="center">
			<table width="40%" border="0">
				<tr>
					<td><html:errors/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			
				<table width="100%" border="0"> 
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.position"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><c:import url="listPosition.do"></c:import></td>
					</tr>
					<tr>
						<td width="20%"></td>
						<td width="20%" valign="top" align="left"><input type="hidden" name="id" value=${param.id}><bean:message key="applicationForm.hospital.addPersonal.name"/></td>
						<td width="5%" valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td width="55%" valign="top" align="left"><input type="text" name="firstName" value="${requestScope.personal.name}${param.firstName}"/></td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.lastName"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="lastName" value="${requestScope.lastName}${param.lastName}"/></td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.email"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="email" value="${requestScope.personal.email}${param.email}"/></td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.phone"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="phone1" value="${requestScope.personal.phone}${param.phone1}" maxlength="11" size="15" >-
						<input type="text" name="phone2" value="${requestScope.phone}${param.phone2}" maxlength="3" size="5" ><br><bean:message key="applicationForm.hospital.example.phone"/>+xxxxxxxxxx-xxx</td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.mobile"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="mobile" value="${requestScope.personal.mobile}${param.mobile}" maxlength="11"/><br><bean:message key="applicationForm.hospital.example.contactMobile"/>+xxxxxxxxxxx</td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.fax"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="fax" value="${requestScope.personal.fax}${param.fax}"maxlength="11"/><br><bean:message key="applicationForm.hospital.example.fax"/> +xxxxxxxxxx</td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="submit" name="Sumbit" value=<bean:message key="applicationForm.sumbit"/>><input type="reset" name="reset" value=<bean:message key="applicationForm.reset"/>></td>
					</tr>
				</table>
		
		</td>
	</tr>
</table>
	</form>