<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<a
	href=<c:choose> 
		                 	<c:when test="${param.pageProvider==1}">
		                 		"listAdminProviderRegister.do"><bean:message key="applicationForm.admin.menu.register"/>
		                 	</c:when>
		                 	<c:when	test="${param.pageProvider==2}">
		                 		"listAdminProvider.do"><bean:message key="applicationForm.admin.menu.provider"/>
		                 	</c:when>
		                 	
		                 	</c:choose></a>
>> ${requestScope.provider.name}${param.name}
<br></br>
<h2><bean:message key="applicationForm.hospital.edit" /> <bean:message
	key="applicationForm.hospital" /></h2>
<form id="editProvider" method="post" action="editAdminProvider.do">
<fieldset>
<div class="errorMessages"><html:errors /></div>
<input type="hidden" name="id" value="${param.staffId}">
<input type="hidden" name="pageProvider" value="${param.pageProvider}">

<input type="hidden" name="providerSId" value=${requestScope.providerStaff.id}>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.name" />: </label> <input type="hidden"
	name="name" class="textfield small"
	value="${requestScope.provider.name}${param.name}" />${requestScope.provider.name}${param.name}
</p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.username" />: </label> <input type="hidden"
	name="username"
	value="${requestScope.providerStaff.username}${param.username}" />${requestScope.providerStaff.username}${param.username}
</p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.www" />: </label> <input type="text" name="www"
	value="${requestScope.provider.www}${param.www}" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.phone" />: </label> <input type="text"
	name="phone1" value="${requestScope.provider.phone}${param.phone1}"
	maxlength="11" size="15">- <input type="text" name="phone2"
	value="${requestScope.phone}${param.phone2}" maxlength="3" size="5">
</p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.fax" />: </label> <input type="text" name="fax"
	value="${requestScope.provider.fax}${param.fax}" maxlength="11" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.country" />: </label> 
	<input type="hidden"
	name="countryId"
	value="${requestScope.provider.city.country.id}${param.countryId}">
<c:import
	url="listCountryEdit.do?countryId=${requestScope.provider.city.country.id}${param.countryId}"></c:import>
</p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.city" />: </label> <select name="city" id="city"
	style="width: 250px">
	<option value="0">---</option>
	<c:forEach var="city" items="${requestScope.city}">
		<option value="${city.id}"
			<c:if test="${city.id==param.city or city.id==requestScope.provider.city.id}"> selected="selected"</c:if>>${city.name}</option>
	</c:forEach>
</select></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.address" />: </label> <textarea name="address"
	cols="30" rows="5">${requestScope.provider.address}${param.address}</textarea>
</p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.zip" />: </label> <input type="text" name="zip"
	value="${requestScope.provider.zip}${param.zip}" maxlength="5" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactName" />: </label> <input type="text"
	name="contactName"
	value="${requestScope.providerStaff.contactName}${param.contactName}" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactSurName" />: </label> <input type="text"
	name="contactSurName"
	value="${requestScope.contactSurName}${param.contactSurName}" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactMobile" />: </label> <input type="text"
	name="contactMobile"
	value="${requestScope.providerStaff.contactMobile}${param.contactMobile}"
	maxlength="11" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactEmail" />: </label> <input type="text"
	name="contactEmail"
	value="${requestScope.providerStaff.contactEmail}${param.contactEmail}"
	maxlength="50" /></p>
<br>
</fieldset>
<br>
<div class="center"><input type="submit" name="sumbit"
	value=<bean:message key="applicationForm.submit"/>> <input
	type="reset" name="reset"
	value=<bean:message key="applicationForm.reset"/>></div>
</form>
