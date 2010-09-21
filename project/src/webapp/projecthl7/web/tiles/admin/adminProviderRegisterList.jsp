<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
function SetAllCheckBoxes(FormName, FieldName, CheckValue)
{
	if(!document.forms[FormName])
		return;
	//alert(""+!document.forms[FormName]);
	var objCheckBoxes = document.forms[FormName].elements[FieldName];
	if(!objCheckBoxes)
		return;
	var countCheckBoxes = objCheckBoxes.length;
	if(!countCheckBoxes)
		objCheckBoxes.checked = CheckValue;
	else
		// set the check value for all check boxes
		for(var i = 0; i < countCheckBoxes; i++)
			objCheckBoxes[i].checked = CheckValue;
}
</script>
	<h2><bean:message key="applicationForm.hospital.register" /></h2>
	<a href="adminProviderAdd.jsp"><bean:message
			key="applicationForm.hospital.listPersonal.addProvider"/></a>
<form method="post" name="myForm" id="myForm" action="adminSendMail.do"="returnfalse;">
<table border="1" width="100%">
	<tr>
		<th align="center"></th>
		<th align="center"><bean:message
			key="applicationForm.hospital.name" /></th>
		<th align="center"><bean:message
			key="applicationForm.hospital.phone" /></th>
		<th align="center"><bean:message
			key="applicationForm.hospital.view" /></th>
		<th align="center"><bean:message
			key="applicationForm.hospital.main.edit" /></th>
		<th align="center"><bean:message
			key="applicationForm.hospital.listPersonal.delete"/></th>	
	</tr>
	<c:choose>
		<c:when test="${!empty requestScope.provider}">

			<% 	
						long index1 =(Long)request.getAttribute("index"); 
						long display =(Long)request.getAttribute("display"); 
						long num=((index1-1)*display)+1;	
					%>

			<c:forEach var="provider" items="${requestScope.provider}">
				<tr>
					<td align="center"><input type="checkbox" name="id"
						value="${provider.id}" id=myCheckbox <%=num %>></td>
					<td align="left">${provider.name}</td>
					<td align="left">${provider.phone}</td>
					<td align="center"><a
						href="getAdminProvider.do?staffId=${provider.id}&statusPage=1&pageProvider=1"><img
						src="./images/look.png" width="20px" height="20px" vspace="0"
						hspace="0" border="0" /></a></td>
					<td align="center"><a
						href="getAdminProvider.do?staffId=${provider.id}&statusPage=2&pageProvider=1"
						onclick="return confirm('Are you sure you want to Edit ${provider.name} ?')">
					<img src="./images/edit.png" width="20px" height="20px"
						vspace="0" hspace="0" border="0"></a></td>
					<td>
						<a href="providerDelete.do?providerId=${provider.id}&page=1" 
						onclick="return confirm('Are you sure you want to Delete ${provider.name} ?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
			</c:when>
			 <c:otherwise>

					<tr>
						<td align="center" colspan="6"><bean:message
							key="applicationForm.hospital.listPersonal.noData" /></td>
					</tr>
			</c:otherwise> 
	</c:choose>
	<tr>
		<td colspan="6">
			<c:if test="${!empty requestScope.provider}">
			<a href="#" onclick="SetAllCheckBoxes('myForm', 'id', true);">
			Check All</a>/ <a href="#"
				onclick="SetAllCheckBoxes('myForm', 'id', false);"> Uncheck All</a> / <a
				href="#" onclick="document.getElementById('myForm').submit()">send
			mail
			</c:if>
		</td>

		
	</tr>
	<tr>

		<td colspan="6" align="center"><c:if test="${!empty requestScope.provider}">
			<%
								long index = (Long) request.getAttribute("index");
									if (index > 1) {
								%>
			<a href="listAdminProviderRegister.do?index=1&sidebar=1"><<</a>&nbsp;
								<a href="listAdminProviderRegister.do?index=<%=(index - 1)%>&sidebar=1"><</a>&nbsp;
								<% } %>
			<%
									long totalPages = (Long) request.getAttribute("totalPages");
										for (long i = 1; i <= totalPages; i++) {
								%>
			<a href="listAdminProviderRegister.do?index=<%=i%>&sidebar=1"> <%
									if(i==index){
									out.print("<b>"+i+"</b>");
									} else {
										out.print(i);
									}
								%> </a>&nbsp;
								<% } %>
			<%
									if (index != totalPages ) {
								%>

			<a href="listAdminProviderRegister.do?index=<%=(index + 1)%>&sidebar=1">></a>&nbsp;
								<a href="listAdminProviderRegister.do?index=<%=totalPages%>"&sidebar=1>>></a>
			<% }%>
		</c:if></td>
	</tr>
</table>
