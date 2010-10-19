<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

			<h2><bean:message key="applicationForm.hospital.main.contactAdmin" /></h2>
			
<form id="addProvider" method="post" action="contactAdmin.do">
	<fieldset>
		<div class="errorMessages"><html:errors /></div>
	<br>
	<p>
		<label class="inputname"> 
		<bean:message key="applicationForm.hospital.contactAdmin" />: </label> 
		<textarea type="text" name="text" cols="50" rows="8" /></textarea></p>
	
<br>
</fieldset>
<div >
<p align="center">
	<input type="submit" name="button"  value=<bean:message key="applicationForm.submit"/> class="button"/> </p>

</div>
</form>	