<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<div id="loginform">
    		<form method="post" action="forgotPassword.do" >
					<label class="inputname"><bean:message key="applicationForm.hospitalad.login.username"/>:</label>
						<input type="text" name="username" class="loginfield" value="${param.username}"/>
					<label class="inputname"><bean:message key="applicationForm.hospital.addPersonal.email"/>:</label>
						<input type="text" name="email" class="loginfield" value="${param.email}" />
						<input type="submit" name="button" class="loginbutton" value=<bean:message key="applicationForm.submit"/> />
				</form>													
			 
</div>
	<a class="link" href="signIn.jsp"><bean:message
									key="applicationForm.hospitalad.login.sign" /></a>