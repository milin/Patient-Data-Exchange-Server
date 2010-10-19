<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<select name="position" >
	<c:forEach var="position" items="${requestScope.position}" > 
	<option value="${position.id}" <c:if test="${position.id==param.position or position.id==requestScope.personal.position.id}"> selected="selected"</c:if>>${position.name}</option>
	</c:forEach>
			
</select>