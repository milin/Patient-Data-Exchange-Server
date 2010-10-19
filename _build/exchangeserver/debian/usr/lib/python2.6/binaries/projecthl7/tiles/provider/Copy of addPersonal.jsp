<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<table border="0" width="100%">
	<tr>
		<td align="center"><bean:message key="applicationForm.hospital.addPersonal.header"/></td>
	</tr>
	<tr>
		<td >
			<table width="100%" border="0">
				<tr >
					<td ><html:errors/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<form id="addPersonal" action="addPersonal.do" method="post">
				<table width="100%" border="0">  
					<tr>
						<td width="25%"></td>
						<td width="15%" valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.position"/></td>
						<td width="5%" valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td width="55%" valign="top" align="left"><c:import url="listPosition.do"></c:import></td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.firstName"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="firstName" value="${param.firstName}"/></td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.lastName"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="lastName" value="${param.lastName}"/></td>
					</tr>
					
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.email"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="email" value="${param.email}"/></td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.phone"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="phone1" value="${param.phone1}" maxlength="11" size="15" >-
						<input type="text" name="phone2" value="${param.phone2}" maxlength="3" size="5" ><br><bean:message key="applicationForm.hospital.example.phone"/>+xxxxxxxxxx-xxx</td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.mobile"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="mobile" value="${param.mobile}" maxlength="11"/><br><bean:message key="applicationForm.hospital.example.contactMobile"/>+xxxxxxxxxxx</td>
					</tr>
					<tr>
						<td></td>
						<td valign="top" align="left"><bean:message key="applicationForm.hospital.addPersonal.fax"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="fax" value="${param.fax}"maxlength="11"/><br><bean:message key="applicationForm.hospital.example.fax"/> +xxxxxxxxxx</td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="submit" name="Sumbit" value=<bean:message key="applicationForm.submit"/>><input type="reset" name="reset"  onclick="document.getElementById('addPersonal').action='addPersonal.do'" value=<bean:message key="applicationForm.reset"/> ></td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
</table>
