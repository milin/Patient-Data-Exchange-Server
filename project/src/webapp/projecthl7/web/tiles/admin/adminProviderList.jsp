<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2><bean:message key="applicationForm.hospital.listhospital"/></h2>
	<table border="1" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<th><bean:message key="applicationForm.hospital.listPersonal.no"/></th>
			<th><bean:message key="applicationForm.hospital.name"/></th>
			<th><bean:message key="applicationForm.hospital.contactName"/></th>
			<th><bean:message key="applicationForm.hospital.view"/></th>
			<th><bean:message key="applicationForm.hospital.edit"/></th>
			<th><bean:message key="applicationForm.hospital.lock"/></th>
			<th><bean:message key="applicationForm.hospital.listPersonal.delete"/></th>
		</tr>
		<c:choose>
			<c:when test="${!empty requestScope.provider}"> 
				<% 	
						long index1 =(Long)request.getAttribute("index"); 
						long display =(Long)request.getAttribute("display"); 
						long num=((index1-1)*display)+1;	
				%>
			<c:forEach var="provider" items="${requestScope.provider}">
				<tr >
					<td align="center"><%=num++ %></td>
					<td align="center">${provider[0].name}</td>
					<td align="center">${provider[1].contactName}</td>
					<td align="center"><a href="getAdminProvider.do?staffId=${provider[0].id}&statusPage=1&pageProvider=2"><img src="./images/look.png" width="20px" height="20px"  vspace="0" hspace="0" border="0"/></a></td>
					<td align="center">
						<a href="getAdminProvider.do?staffId=${provider[0].id}&statusPage=2&pageProvider=2" onclick="return confirm('Are you sure you want to Edit ${provider[1].contactName} ?')">
						<img src="./images/edit.png" width="20px" height="20px"  vspace="0" hspace="0" border="0"></a></td>
					<td align="center">
						<c:if test="${provider[1].status == 1}">
							<bean:message key="errors.noConfirm"/>
						</c:if>
						<c:if test="${provider[1].status == 3}">
								<a href="lockAdminProvider.do?id=${provider[1].id}" onclick="return confirm('Are you sure you want to unlock ${provider[1].contactName}?')"><img src="./images/lock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
						</c:if>
						<c:if test="${provider[1].status == 2}">
								<a href="lockAdminProvider.do?id=${provider[1].id}" onclick="return confirm('Are you sure you want to lock ${provider[1].contactName}?')"><img src="./images/unlock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
						</c:if>
					</td>
					<td>
						<a href="providerDeleteTwo.do?providerStaffId=${provider[1].id}&page=2" 
						onclick="return confirm('Are you sure you want to Delete ${provider[1].contactName} ?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td align="center" colspan="7" ><br><br><bean:message key="applicationForm.hospital.listPersonal.noData"/><br><br></td>
				</tr>		
			</c:otherwise>
		</c:choose>
	<tr>
		<td align="center" colspan="7">
			<c:if test="${!empty requestScope.provider}">
				<%
					long index = (Long) request.getAttribute("index");
						if (index > 1) {
				%>								
					<a href="listAdminProvider.do?index=1"><<</a>&nbsp;
					<a href="listAdminProvider.do?index=<%=(index - 1)%>"><</a>&nbsp;
					<% } %>							
					<%
					long totalPages = (Long) request.getAttribute("totalPages");
						for (long i = 1; i <= totalPages; i++) {
					%>
					<a href="listAdminProvider.do?index=<%=i%>">
					<%
						if(i==index){
						out.print("<b>"+i+"</b>");
						} else {
							out.print(i);
						}
					%>
					</a>&nbsp;
					<% } %>
					<%
						if (index != totalPages ) {
					%>
					
					<a href="listAdminProvider.do?index=<%=(index + 1)%>">></a>&nbsp;
					<a href="listAdminProvider.do?index=<%=totalPages%>">>></a>
					<% }%>
			</c:if>
		</td>
	</tr>
</table>