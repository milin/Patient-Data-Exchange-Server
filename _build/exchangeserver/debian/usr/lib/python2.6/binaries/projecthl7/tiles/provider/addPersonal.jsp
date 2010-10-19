<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<script type="text/javascript" src="js/jquery/jquery-1.3.2.js"></script>

<c:import url="js/jquery/focus.jsp"></c:import>
<h2><bean:message key="applicationForm.hospital.addPersonal.header"/></h2>

<form id="addPersonal" action="addPersonal.do" method="post">
	
	<fieldset>	
  		<div class="errorMessages">		
  			<html:errors/>
		</div>
		<br>
 		<p>
 			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.title"/>:</label>
			<input type="text" name="title" class="textfield small" value="${param.title}"/>
 		</p>
 		<p>
 			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.firstName"/>:</label>
 			<input type="text" name="firstName" class="textfield small"value="${param.firstName}"/>
 		</p>	    		
 		<p>
 			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.lastName"/>:</label>
 			<input type="text" name="lastName" class="textfield small" value="${param.lastName}"/>
 			
 		</p>
 		<p>
 			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.email"/>:</label>
 			<input type="text" name="email" class="textfield small" value="${param.email}"/>
 		</p>
 		<p>
 			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.phone"/>:</label>
 			<input type="text" name="phone1"  id="phone1" value="${param.phone1}" style="width:10em" maxlength="11"  >-
			<input type="text" name="phone2"  value="${param.phone2}" maxlength="3" size="5"style="width:3em" >
 		</p>
 		<p>
 			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.mobile"/>:</label>
			<input type="text" name="mobile" id="mobile" class="textfield small" value="${param.mobile}" maxlength="11"/>
 		</p>
 		<p>
 			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.fax"/>:</label>
			<input type="text" name="fax" id="fax"  class="textfield small"  value="${param.fax}" maxlength="11"/>
 		</p>
 		
 		
 		<br>
 		</fieldset>
 		<br>					
	<div>
		 <input type="submit" name="button" class="button" value=<bean:message key="applicationForm.submit"/> />
		 <!-- <input type="submit" name="button" class="button" onclick="document.getElementById('addPersonal').action='addPersonal.do'" value=<bean:message key="applicationForm.reset"/> > -->
	</div>
</form>
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
	    			
