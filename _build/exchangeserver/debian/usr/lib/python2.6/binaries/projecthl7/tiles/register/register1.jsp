<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<table width="100%" border="0" >
	<tr>
		<td align="center">
		<br><br><br><bean:message key="applicationForm.hospital.header"/><br><br></td>
	</tr>
	<tr>
		<td align="center">
			<table width="40%" border="0">
				<tr>
					<td align="left"><html:errors/></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<form id="addProvider" method="post" action="addProvider.do">
				<table width="40%"border="1" cellpadding="1" cellspacing="1" bgcolor="#FFFFFF">
					<tr>
						<td>
							<table width="100%" border="0"  cellpadding="1" cellspacing="1">
								<tr>
									<td width="10%"></td>
									<td width="30%" valign="top" align="left"><B><bean:message key="applicationForm.hospital.name"/></B></td>
									<td width="5%" valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td width="55%" valign="top" align="left"><input ="text" name="name" value="${param.name}"/></td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.username"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="username" value="${param.username}"/><br><bean:message key="applicationForm.hospital.example.username"/></td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.password"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="password" name="password" value="${param.password}" maxlength="15"/><br>6 character minimum; case sensitive</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.repassword"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="password" name="rePassword" value="${param.rePassword}" maxlength="15"/></td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.www"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="www" value="${param.www}"/></td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.type"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left">
										<select style="width:150px" name="type">
											<option value="0">---</option>
											<option value="1" <c:if test="${param.type==1}"> selected="selected" </c:if> ><bean:message key="applicationForm.hospital.government"/></option>
											<option value="2" <c:if test="${param.type==2}"> selected="selected" </c:if> ><bean:message key="applicationForm.hospital.person"/></option>
												
										</select>
									</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.phone"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="phone1" value="${param.phone1}" maxlength="11" size="15" >-
									<input type="text" name="phone2" value="${param.phone2}" maxlength="3" size="5" ><br><bean:message key="applicationForm.hospital.example.phone"/>+xxxxxxxxxx-xxx</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.fax"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="fax" value="${param.fax}" maxlength="11"/><br><bean:message key="applicationForm.hospital.example.fax"/> +xxxxxxxxxx</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.country"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><c:import url="singUp.do"></c:import>
									</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.city"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left">
										
										
										<select style="width:150px" name="city" id="city">
											<option value="0">---</option>	
											<c:if test="${!empty param.city and param.city!=0}">
												<c:import url="citySelect.do?id=${param.city}"> </c:import>
										</c:if>	
										</select>
									</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top"  align="left"><B><bean:message key="applicationForm.hospital.address"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left">
										<label>
									  		<textarea name="address" cols="30" rows="5">${param.address}</textarea>
									  	</label>
								</tr>
								<tr>
									<td ></td>
									<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.zip"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="zip" value="${param.zip}" maxlength="5"/><br> <bean:message key="applicationForm.hospital.example.zip"/>xxxxx</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactName"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="contactName" value="${param.contactName}"/></td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactSurName"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="contactSurName" value="${param.contactSurName}"/></td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactMobile"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="contactMobile" value="${param.contactMobile}" maxlength="11"/><br><bean:message key="applicationForm.hospital.example.contactMobile"/>+xxxxxxxxxxx</td>
								</tr>
								<tr>
									<td ></td>
									<td valign="top" align="left"><B><bean:message key="applicationForm.hospital.contactEmail"/></B></td>
									<td valign="top"><bean:message key="applicationForm.hospital.add"/></td>
									<td valign="top" align="left"><input type="text" name="contactEmail" value="${param.contactEmail}" maxlength="50"/><br><bean:message key="applicationForm.hospital.example.contactEmail"/>xxx@xxxxxx.com</td>
								</tr>
								<tr>
									<td colspan="4" align="center">
										<input type="submit" name="sumbit" value=<bean:message key="applicationForm.sumbit"/>>
										<input type="reset" name="reset" value=<bean:message key="applicationForm.reset"/> onClick="document.getElementById('addProvider').action='getClubGallery.do'">
									</td>
								</tr>					
							</table>
						</td>
					</tr>
				</table>
			</form>
		</td>
	</tr>
</table>
