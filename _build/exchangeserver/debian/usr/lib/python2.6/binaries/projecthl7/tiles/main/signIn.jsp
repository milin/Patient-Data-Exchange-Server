<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<c:choose>
	<c:when test="${empty sessionScope.User}">
		<div id="loginform">
			<form action="providerLogin.do" method="post" id="userLogin">
				<label class="inputname"> 
					<bean:message key="applicationForm.hospitalad.login.username" />:</label> 
				<input name="username" type="text" class="loginfield" /> 
				<label class="inputname">
					<bean:message key="applicationForm.hospitalad.login.password" />:</label> 
				<input name="password" type="password" class="loginfield" /> 
				<input type="submit" name="button" class="loginbutton" value=<bean:message key="applicationForm.hospitalad.login"/> />
			</form>
			<a href="register.jsp"> 
			<bean:message key="applicationForm.hospitalad.login.singUp" /></a> | <a href="forgotPassword.jsp">
			<bean:message key="applicationForm.hospitalad.login.forgot" /></a>
		</div>
	</c:when>
	<c:otherwise>
	<form action="providerLogin.do" method="post" id="userLogin">
		
		<div id="loginform">
		     <label class="inputname">  ${sessionScope.User.contactName}</label>
		<input type="submit" name="button" class="loginbutton" value=<bean:message key="applicationForm.hospitalad.login"/> />
		</div>
	</form>
	</c:otherwise>
</c:choose>