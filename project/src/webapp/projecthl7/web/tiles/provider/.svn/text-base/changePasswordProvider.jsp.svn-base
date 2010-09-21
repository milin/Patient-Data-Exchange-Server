<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<h2><bean:message key="applicationForm.hospital.changePassword"/> </h2>
<form id="changePassword" method="post" action="editPassword.do">
<fieldset>	
 	<div class="errorMessages">		
 	<html:errors/>
</div>
<br>
 	<p>
		<bean:message key="applicationForm.hospital.username"/>  :
		<input type="hidden" name="username" value="${requestScope.provider.username}${param.username}"/>${requestScope.provider.username}${param.username}
	</p>
	<p>
		<bean:message key="applicationForm.hospital.currentPassword"/> 
		<input type="password" name="passwordOld" class="textfield small" />
	</p>
	 <p>
		<bean:message key="applicationForm.hospital.choosePassword"/>  
		<input type="password" name="passwordNew1" class="textfield small" />
	</p>
	<p>
		<bean:message key="applicationForm.hospital.rePassword"/> 
		<input type="password" name="passwordNew2" class="textfield small" />
	</p> 
	<br>
		</fieldset>	
	<br>      
	     
	<div class="center">
	   	<input type="submit" name="button" class="button" value="Submit" />
	   		   
	 </div>	
</form>				
				
			    
			
	
