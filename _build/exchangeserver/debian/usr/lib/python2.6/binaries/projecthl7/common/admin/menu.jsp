<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h5><bean:message key="applicationForm.hospitalad.login.sign.admin"/></h5> 

<ul id="sidebar-nav">
<c:choose>
	<c:when test="${param.sidebar==1}">
		<li id="side-current">
	</c:when>
	<c:otherwise>
		<li>
	</c:otherwise>
</c:choose>
<a href="listAdminProviderRegister.do?sidebar=1"><bean:message key="applicationForm.admin.menu.register"/></a></li>
<c:choose>
	<c:when test="${param.sidebar==2}">
		<li id="side-current">
	</c:when>
	<c:otherwise>
		<li>
	</c:otherwise>
</c:choose>
<a href="listAdminProvider.do?sidebar=2"><bean:message key="applicationForm.admin.menu.provider"/></a></li>
<c:choose>
	<c:when test="${param.sidebar==3}">
		<li id="side-current">
	</c:when>
	<c:otherwise>
		<li>
	</c:otherwise>
</c:choose>
<a href="listAdminPersonal.do?sidebar=3"><bean:message key="applicationForm.admin.menu.personal"/></a></li>

<c:choose>
	<c:when test="${param.sidebar==4}">
		<li id="side-current">
	</c:when>
	<c:otherwise>
		<li>
	</c:otherwise>
</c:choose>
<a href="listUserReportLogin.do?sidebar=4"><bean:message key="applicationForm.admin.menu.userReport"/></a></li>




</ul>	
			