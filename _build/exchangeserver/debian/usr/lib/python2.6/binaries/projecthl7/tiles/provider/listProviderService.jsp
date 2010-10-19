<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<h2><bean:message key="applicationForm.hospital.listProvidersConnect"/></h2>
<table border="1" width="90%" cellpadding="1" cellspacing="1">
	<tr>
		<th><bean:message
			key="applicationForm.hospital.listPersonal.no" /></th>
		<th><bean:message
			key="applicationForm.hospital.addPersonal.providerName" /></th>
		<th><bean:message
			key="applicationForm.hospital.addStatus" /></th>
		<th><bean:message
			key="applicationForm.hospital.addStatus" />
		</th>
	</tr>
	<c:choose>
		<c:when test="${empty requestScope.providerService}">
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
			<c:forEach var="providerService"
				items="${requestScope.providerService}">
				<%if(num%2==0){ %>
				<tr bgcolor="#FFFFCC">
					<%}else{ %>
					<tr>
						<%} %>
						<td align="center"><%=num++ %></td>
						<td align="center"><c:choose>
							<c:when
								test="${providerService.provider.name == requestScope.providerSession}">
								<a href="lookProvider.do?staffId=${providerService.providerTwo.id}">${providerService.providerTwo.name}
								
							</c:when>
							<c:when
								test="${providerService.providerTwo.name == requestScope.providerSession}">
								<a href="lookProvider.do?staffId=${providerService.provider.id}">${providerService.provider.name}</a>
							</c:when>
						</c:choose></td>
						<td align="center"><c:choose>
							<c:when test="${providerService.status == 1}">
								<a href="connectProviderService.do?idPs=${providerService.id}" onclick="return confirm('Are you sure you want to disable ?')">enable</a>
							</c:when>
							<c:when test="${providerService.status == 2}">
								<a href="connectProviderService.do?idPs=${providerService.id}" onclick="return confirm('Are you sure you want to enable ?')">disable</a>
							</c:when>
						</c:choose></td>
						<td align="center"><c:choose>
							<c:when
								test="${providerService.provider.name == requestScope.providerSession}">
								<c:if test="${providerService.providerTwo.statusOnline==1}">
										     	 			online
										     			</c:if>
								<c:if
									test="${providerService.providerTwo.statusOnline==0 || providerService.providerTwo.statusOnline==null}">
										     	  			offline
										     			</c:if>
							</c:when>
							<c:when
								test="${providerService.providerTwo.name == requestScope.providerSession}">
								<c:if test="${providerService.provider.statusOnline==1}">
										     	  			online
										     			</c:if>
								<c:if
									test="${providerService.provider.statusOnline==0 || providerService.provider.statusOnline==null}">
										     	 		 	offline
										     			</c:if>
							</c:when>
						</c:choose></td>
					</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<tr>
		<td align="center" colspan="4"><c:if
			test="${!empty requestScope.providerService}">
			<%long index = (Long) request.getAttribute("index");
									if (index > 1) {
								%>
			<a href="listProviderService.do?id=${sessionScope.User.id}&index=1"><<</a>&nbsp;
								<a
				href="listProviderService.do?id=${sessionScope.User.id}&index=<%=(index - 1)%>"><</a>&nbsp;
								<% } %>
			<%
									long totalPages = (Long) request.getAttribute("totalPages");
										for (long i = 1; i <= totalPages; i++) {
								%>
			<a
				href="listProviderService.do?id=${sessionScope.User.id}&index=<%=i%>">
			<%
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
			<a
				href="listProviderService.do?id=${sessionScope.User.id}&index=<%=(index + 1)%>">></a>&nbsp;
									<a
				href="listProviderService.do?id=${sessionScope.User.id}&index=<%=totalPages%>">>></a>
			<% }%>
		</c:if></td>
	</tr>
</table>
