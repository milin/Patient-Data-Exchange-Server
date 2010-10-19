<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<table width="100%" border="0">
	<tr>
		<td align="center"><bean:message key="applicationForm.hospital.header.edit"/></td>
	</tr>
	<tr>
		<td align="center">
			<table width="80%" border="0">
				<tr>
					<td><html:errors/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<form id="addProvider" method="post" action="editProvider.do"><input type="hidden" name="id" value="${param.id}">
				<table width="60%" border="1" cellpadding="1" cellspacing="1">
					<tr>
						<td width="40%" valign="top" align="left"><FONT face="Verdana"><bean:message key="applicationForm.hospital.name"/></FONT></td>
						<td width="5%" valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td width="55%" valign="top" align="left"><input type="hidden" name="name" value="${requestScope.provider.name}${param.name}"/>${requestScope.provider.name}${param.name}</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.username"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="hidden" name="username" value="${requestScope.provider.username}${param.username}"/>${requestScope.provider.username}${param.username}</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.www"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="www" value="${requestScope.provider.www}${param.www}"/></td>
					</tr>
					<tr>
						<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.type"/></B></td>
						<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<select style="width:150px" name="type">
								<option value="0">---</option>
								<option value="1" <c:if test="${requestScope.provider.type==1 || param.type==1}"> selected="selected" </c:if> ><bean:message key="applicationForm.hospital.government"/></option>
								<option value="2" <c:if test="${requestScope.provider.type==2 || param.type==2}"> selected="selected" </c:if> ><bean:message key="applicationForm.hospital.person"/></option>
									
							</select>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.phone"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="phone1" value="${requestScope.provider.phone}${param.phone1}" maxlength="11" size="15" >-
							<input type="text" name="phone2" value="${requestScope.phone}${param.phone2}" maxlength="3" size="5" ></br>
							<bean:message key="applicationForm.hospital.example.phone"/>+xxxxxxxxxx-xxx</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.fax"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="fax" value="${requestScope.provider.fax}${param.fax}" maxlength="11"/></br>
							<bean:message key="applicationForm.hospital.example.fax"/> +xxxxxxxxxx
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.country"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="hidden" name="countryId" value="${requestScope.provider.city.country.id}${param.countryId}">
							<c:import url="listCountryEdit.do?countryId=${requestScope.provider.city.country.id}${param.countryId}"></c:import></td>
						
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.city"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
						
						
						
						
						
							<select name="city" id="city" style="width:250px">
									<option value="0">---</option> 
								<c:forEach var="city" items="${requestScope.city}" > 
									<option value="${city.id}" <c:if test="${city.id==param.city or city.id==requestScope.provider.city.id}"> selected="selected"</c:if>>${city.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.address"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<label>
						  		<textarea name="address" cols="30" rows="5">${requestScope.provider.address}${param.address}</textarea>
						  	</label>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.zip"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left"><input type="text" name="zip" value="${requestScope.provider.zip}${param.zip}" maxlength="5"/>
							</br> 
							<bean:message key="applicationForm.hospital.example.zip"/>xxxxx
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactName"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactName" value="${requestScope.provider.contactName}${param.contactName}"/>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactSurName"/></B></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactSurName" value="${requestScope.contactSurName}${param.contactSurName}"/>
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactMobile"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactMobile" value="${requestScope.provider.contactMobile}${param.contactMobile}" maxlength="11"/></br>
							<bean:message key="applicationForm.hospital.example.contactMobile"/>+xxxxxxxxxxx
						</td>
					</tr>
					<tr>
						<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactEmail"/></td>
						<td valign="top" align="center"><bean:message key="applicationForm.hospital.add"/></td>
						<td valign="top" align="left">
							<input type="text" name="contactEmail" value="${requestScope.provider.contactEmail}${param.contactEmail}" maxlength="50"/></br>
							<bean:message key="applicationForm.hospital.example.contactEmail"/>xxx@xxxxxx.com
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						<input type="submit" name="submit" value=<bean:message key="applicationForm.submit"/>>
						<input type="reset" name="reset"  onclick="document.getElementById().action='getProvider.do?id=${sessionScope.User.id}'" value=<bean:message key="applicationForm.reset"/>></td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
</table>
