<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:if test="${requestScope.totalProviderService != 0 }">
	<c:if test="${param.sidebar==5}"><li id="side-current"></c:if>
	<c:if test="${param.sidebar!=5}"><li></c:if>
<a href="displayProviderRequests.do?sidebar=5">${requestScope.totalProviderService}  Provider Requests</a></li>
</c:if>