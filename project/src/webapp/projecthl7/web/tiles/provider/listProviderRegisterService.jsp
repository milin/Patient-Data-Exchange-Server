<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<h2><bean:message key="applicationForm.admin.menu.provider"/></h2>
<table border="1" width="90%" cellpadding="1" cellspacing="1">
	<tr>
		<th><bean:message key="applicationForm.hospital.listPersonal.no" /></th>
		<th><bean:message key="applicationForm.hospital.name" /></th>
		<th><bean:message key="applicationForm.hospital.addService" /></th>
		<th><bean:message key="applicationForm.hospital.addPersonal.prority" /></th>
	</tr>
	<c:choose>
		<c:when test="${ empty requestScope.provider}">
			<tr>
				<td align="center" colspan="4"><bean:message
					key="applicationForm.hospital.listPersonal.noData" /></td>
			</tr>
		</c:when>
		<c:otherwise>
			<% 	long index1 =(Long)request.getAttribute("index"); 
										long display =(Long)request.getAttribute("display"); 
										long num=((index1-1)*display)+1;	
									%>
			<c:forEach var="provider" items="${requestScope.provider}">
				<%if(num%2==0){ %>
				<tr bgcolor="#FFFFCC">
					<%}else{ %>
					<tr>
						<%} %>

						<td align="center"><%=num++ %></td>
						<td align="center">${provider.name}</td>
						<td align="center"><a
							href="confirmAddProvider.do?id=${provider.id}"> <bean:message
							key="applicationForm.hospital.add1" /></a></td>
						<td align="center"><c:choose>
							<c:when test="${provider.statusOnline==0 or provider.statusOnline==null}">
							Offine
							</c:when>
							<c:otherwise> 
										Online
							</c:otherwise>
						</c:choose></td>
					</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>

	<tr>
		<td align="center" colspan="4"><c:if test="${!empty requestScope.provider}">
			<%
									long index = (Long) request.getAttribute("index");
										if (index > 1) {
									%>
			<a href="listProviderRegisterService.do?index=1"><<</a>&nbsp;
									<a href="listProviderRegisterService.do?index=<%=(index - 1)%>"><</a>&nbsp;
									<% } %>
			<%
										long totalPages = (Long) request.getAttribute("totalPages");
											for (long i = 1; i <= totalPages; i++) {
									%>
			<a href="listProviderRegisterService.do?index=<%=i%>"> <%
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

			<a href="listProviderRegisterService.do?index=<%=(index + 1)%>">></a>&nbsp;
										<a href="listProviderRegisterService.do?index=<%=totalPages%>">>></a>
			<% }%>
		</c:if></td>
	</tr>
	

</table>























