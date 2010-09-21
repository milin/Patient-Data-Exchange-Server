<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<div id="loginform">
			<form action="adminLogin.do" method="post" >
				<label class="inputname">
					<bean:message key="applicationForm.hospitalad.login.username"/>:</label>
					<input type="text" name="username" class="loginfield"/>
				<label class="inputname"><bean:message key="applicationForm.hospitalad.login.password" />:</label>
					<input type="password" name="password" class="loginfield"/>
					<input type="submit" name="submit" value=<bean:message key="applicationForm.hospitalad.login.sign"/>>
								
			</form>
</div>
