<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
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
<h2><bean:message key="applicationForm.hospital.addproviderStass" /></h2>
<form  method="post" action="addProviderStaff.do">
<fieldset>
<div class="errorMessages"><html:errors /></div>
<br>
<input type="hidden" name="id" value="${param.staffId}">
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
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactName" />: </label> <input type="text"
	name="contactName" class="textfield small"
	value="${param.contactName}" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactSurName" />: </label> <input type="text"
	name="contactSurName" class="textfield small"
	value="${param.contactSurName}" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactMobile" />: </label> <input type="text"
	name="contactMobile" class="textfield small" id="contactMobile"
	value="${param.contactMobile}"
	maxlength="11" /></p>
<p><label class="inputname"><bean:message
	key="applicationForm.hospital.contactEmail" />: </label> <input type="text"
	name="contactEmail" class="textfield small" id="contactEmail"
	value="${param.contactEmail}"
	maxlength="50" /></p>
<br>
</fieldset>
<br>
<div class="center"><input type="submit" name="button"
	class="button" value="Submit" /></div>
</form>




