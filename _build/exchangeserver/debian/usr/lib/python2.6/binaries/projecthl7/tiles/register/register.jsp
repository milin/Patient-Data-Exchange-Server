
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery/jquery-1.3.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("input").focus(function() {
			$(this)
				.parent()
					.addClass("curFocus")
			der-Name: 	.children("div")
					.toggle();
		});
		$("input").blur(function() {
			$(this)
				.parent()
					.removeClass("curFocus")
				.children("div")
					.toggle();
		});
		$("select").focus(function() {
			$(this)
				.parent()
					.addClass("curFocus")
				.children("div")
					.toggle();
		});
		$("select").blur(function() {
			$(this)
				.parent()
					.removeClass("curFocus")
				.children("div")
					.toggle();
		});
		
		
	});
</script>
<c:import url="js/jquery/focus.jsp"></c:import>
<h2><bean:message key="applicationForm.hospital.header" /></h2>
<form id="addProvider" method="post" action="addProvider.do">
<fieldset>
<div class="errorMessages"><html:errors /></div>
<br>
<p><label class="inputname"> 
	<bean:message
	key="applicationForm.hospital.name" />: </label> 
	<input type="text" name="name" class="textfield small" value="${param.name}"/></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.username" />: </label> <input type="text"
	name="username" class="textfield small" value="${param.username}" /></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.password" />: </label> <input type="password"
	name="password" class="textfield small" value="${param.password}" /></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.repassword" />: </label> <input type="password"
	name="rePassword" class="textfield small" value="${param.rePassword}" />
</p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.www" />: </label> <input type="text" name="www"
	class="textfield small" value="${param.www}" /></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.type" />: </label> <select name="type"
	class="textfield small"
	onchange="document.getElementById('phone1').focus();">
	<option value="0">---</option>
	<option value="1"
		<c:if test="${param.type==1}"> selected="selected" </c:if>><bean:message
		key="applicationForm.hospital.government" /></option>
	<option value="2"
		<c:if test="${param.type==2}"> selected="selected" </c:if>><bean:message
		key="applicationForm.hospital.person" /></option>
</select></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.phone" />: </label> <input type="text"
	name="phone1" value="${param.phone1}" 
	maxlength="11" id="phone1" class="textfield1 small1">-<input type="text" name="phone2"
	value="${param.phone2}" maxlength="3" size="5" class="textfield1 small2">
</p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.fax" />: </label> <input type="text" name="fax"
	class="textfield small" value="${param.fax}" id="fax" maxlength="11" />
</p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.country" />: </label> <c:import url="singUp.do"></c:import>
</p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.city" />: </label> <select
	class="textfield small" name="city" id="city"
	onchange="document.getElementById('address').focus()">
	<option value="0">---</option>
	<c:if test="${!empty param.city and param.city!=0}">
		<c:import url="citySelect.do?id=${param.city}">
		</c:import>
	</c:if>
</select></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.address" />: </label> <textarea name="address"
	cols="30" rows="5">${param.address}</textarea></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.zip" />: </label> <input type="text" name="zip"
	id="zip" value="${param.zip}" maxlength="5" class="textfield small" />
</p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.contactName" />: </label> <input type="text"
	name="contactName" class="textfield small" value="${param.contactName}" />
</p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.contactSurName" />: </label> <input type="text"
	name="contactSurName" class="textfield small"
	value="${param.contactSurName}" /></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.contactMobile" />: </label> <input type="text"
	name="contactMobile" class="textfield small" id="contactMobile"
	value="${param.contactMobile}" maxlength="11" /></p>
<p><label class="inputname"> <bean:message
	key="applicationForm.hospital.contactEmail" />: </label> <input type="text"
	name="contactEmail" id="contactEmail" class="textfield small"
	value="${param.contactEmail}" maxlength="50" /></p>



</fieldset>
<br>
<div>

	<input type="submit" name="button" class="button" value="Submit"/> <input type="submit" name="reset" class="button" value=<bean:message key="applicationForm.hospital.cancel"/>
	onClick="document.getElementById('addProvider').action='signIn.jsp'">

</div>
</form>







