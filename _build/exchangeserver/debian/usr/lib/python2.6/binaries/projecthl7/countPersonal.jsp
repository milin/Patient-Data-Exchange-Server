<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:choose>
	<c:when test="${param.sidebar==1 and requestScope.count !=0}">
		<li id="side-current">
			<a href="listPersonal.do?id=${sessionScope.User.provider.id}&statusSubMenu=4&sidebar=1">
				${requestScope.count} <bean:message key="applicationForm.hospital.main.personal"/>
			</a>
		</li>
	</c:when>
	<c:when test="${requestScope.count !=0}">
		<li>
			<a href="listPersonal.do?id=${sessionScope.User.provider.id}&statusSubMenu=4&sidebar=1">
				${requestScope.count} <bean:message key="applicationForm.hospital.main.personal"/>
			</a>
		</li>
	</c:when>
</c:choose>