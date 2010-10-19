<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
   			<h2><bean:message key="userForm.add.header"/></h2> 
   		    <form id="addUser" method="post" action="addUser.do">
   		        <fieldset>	
   		        <div class="errorMessages">		
   		        <html:errors/>
   		        </div>
   		        <br>
	    		<p>
	    			<label class="inputname"><bean:message key="userForm.firstName"/>:</label>
	    			<input type="text" name="firstName" class="textfield small" value="${param.firstName}"/>
	    		</p>
	    		
	    		<p>
	    			<label class="inputname"><bean:message key="userForm.lastName"/>:</label>
	    			<input type="text" name="lastName" class="textfield small" value="${param.lastName}"/>
	    		</p>	    		
	    		
	    		<br>
	    		</fieldset>
	    		<br>					
	   		    <div>
	   		    <input type="submit" name="button" class="button" value="Submit" />
	   		    </div>
	   		    
   				
   		    </form>