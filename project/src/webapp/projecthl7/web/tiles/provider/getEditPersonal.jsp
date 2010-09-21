<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script type="text/javascript" src="js/jquery/jquery-1.3.2.js"></script>
<input type="hidden" name="headName" value="${requestScope.personal.title} ${requestScope.personal.name} ${requestScope.lastName} ${param.headName}"/>
		<a href="listPersonal.do?id=${sessionScope.User.provider.id} "><bean:message key="applicationForm.hospital.listPersonal.header"/></a> 
		>>${requestScope.personal.title} ${requestScope.personal.name} ${requestScope.lastName}${param.headName}
<br></br>
<h2><bean:message key="applicationForm.hospital.Personal.editHeader"/></h2> 
   		 <form id="editPersonal" action="editPersonal.do" method="post">
   		 <input type="hidden" name="personalId" value="${param.personalId}">
   		        <fieldset>	
   		        <div class="errorMessages">		
   		        <html:errors/>
   		        </div>
   		        <br>
	    		<p>
	    			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.title"/>:</label>
					<input type="text" name="title" class="textfield small" value="${requestScope.personal.title}${param.title}"/>
	    		</p>
	    		<p>
	    			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.firstName"/>:</label>
	    			<input type="text" name="firstName" class="textfield small"value="${requestScope.personal.name}${param.firstName}"/>
	    		</p>	    		
	    		<p>
	    			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.lastName"/>:</label>
	    			<input type="text" name="lastName" class="textfield small" value="${requestScope.lastName}${param.lastName}"/>
	    			
	    		</p>
	    		<p>
	    			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.email"/>:</label>
	    			<input type="text" name="email" class="textfield small" value="${requestScope.personal.email}${param.email}"/>
	    		</p>
	    		<p>
	    			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.phone"/>:</label>
	    			<input type="text" name="phone1"  id="phone1" value="${requestScope.personal.phone}${param.phone1}" style="width:10em" maxlength="11"  >-
					<input type="text" name="phone2" id="phone2" value="${requestScope.phone}${param.phone2}" maxlength="3" size="5"style="width:3em" >
	    		 
	    		</p>
	    		<p>
	    			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.mobile"/>:</label>
					<input type="text" name="mobile" id="mobile" class="textfield small" value="${requestScope.personal.mobile}${param.mobile}" maxlength="11"/>
	    		</p>
	    		<p>
	    			<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.fax"/>:</label>
					<input type="text" name="fax" id="fax"  class="textfield small"  value="${requestScope.personal.fax}${param.fax}" maxlength="11"/>
	    		</p>
	    		
	    		
	    		<br>
	    		</fieldset>
	    		<br>					
	   		    <div>
	   		   
	   		     <input type="submit" name="button" class="button" value=<bean:message key="applicationForm.submit"/> />
	   		    
	   		    </div>
	   		    
   				
   		    </form>

