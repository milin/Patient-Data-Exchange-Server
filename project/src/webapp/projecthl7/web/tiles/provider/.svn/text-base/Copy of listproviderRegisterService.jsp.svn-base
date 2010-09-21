<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:choose>
	<c:when test="${empty requestScope.providerService}"> <br><br><br><br>
		<table width="100%">
			<tr>
				<td align="center"><bean:message key="applicationForm.hospital.listPersonal.noData"/></td>
			</tr>
		</table>
	</c:when>
	
	<c:otherwise>
	
		<table width="100%"  border="0">
			<tr>
				<td align="center"><bean:message key="applicationForm.hospital.listHospital.header"/></td>
			</tr>
			<tr>
				<td align="center">
					<table width="100%"  border="0">
						<tr>
							<td>
								<form action="listPersonal.do?id=${param.id}&select=1" method="post">
									
									<input type="text" name="search" value=<c:if test="${!empty requestScope.search}"> ${requestScope.search}</c:if>>
									<input type="submit" name="submit" value=<bean:message key="applicationForm.hospital.listPersonal.search"/>> 
									<br>
									
								</form>
								
							</td>
						</tr>
						<tr>
							<td align="right"><a href="listProviderService.do">add connect provider</a></td>
						</tr>
						<tr>
							<td>
								
								
								<table border="1" width="100%" cellpadding="1" cellspacing="1" >
									<tr>
										<td align="center" width="20%"><bean:message key="applicationForm.hospital.listPersonal.no"/></td>
										<td align="center" width="40%"><bean:message key="applicationForm.hospital.addPersonal.providerName"/></td>
										<td align="center" width="10%"><bean:message key="applicationForm.hospital.addStatus"/></td>
										<td align="center" width="10%"><bean:message key="applicationForm.hospital.addStatus"/></td>
									</tr>
									<% 	long index1 =(Long)request.getAttribute("index"); 
										long display =(Long)request.getAttribute("display"); 
										long num=((index1-1)*display)+1;	
									%>
									<c:forEach var="providerService" items="${requestScope.providerService}">
										<%if(num%2==0){ %>									
											<tr bgcolor="#FFFFCC">
										<%}else{ %>
											<tr>
										<%} %>
											<td align="center"><%=num++ %></td>
											<td align="center">${sessionScope.User.name} 
												
													<c:choose>
													     <c:when test="${providerService.provider.name == sessionScope.User.name}" >
													      	<a href="lookProvider.do?id=${providerService.providerTwo.id}">${providerService.providerTwo.id}${providerService.providerTwo.name}
													     </c:when>
													     <c:when test="${providerService.providerTwo.name == sessionScope.User.name}" >
													      	<a href="lookProvider.do?id=${providerService.provider.id}">${providerService.provider.id}${providerService.provider.name}</a>
													     </c:when>
	 												</c:choose>
												</a> 
											</td>
											<td align="center">${providerService.status}
												<c:choose>
												     <c:when test="${providerService.status == 1}" >
												      	<a href="connectProviderService.do?idPs=${providerService.id}">enable</a>
												     </c:when>
												     <c:when test="${providerService.status == 2}" >
												      	<a href="connectProviderService.do?idPs=${providerService.id}">disable</a>
												     </c:when>
 												</c:choose>
											</td>
											<td align="center">
										
												<c:choose>
													<c:when test="${providerService.provider.name == sessionScope.User.name}" >1
												     	<c:if test="${providerService.providerTwo.statusOnline==1}">
												     	  online
												     	</c:if>
												     	<c:if test="${providerService.providerTwo.statusOnline==0}">
												     	  offline
												     	</c:if>
													</c:when>
													<c:when test="${providerService.providerTwo.name == sessionScope.User.name}" >2
													    <c:if test="${providerService.provider.statusOnline==1}">
												     	  online
												     	</c:if>
												     	<c:if test="${providerService.provider.statusOnline==0}">
												     	  offline
												     	</c:if>
													</c:when>
 												</c:choose>
											</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr>
							<td align="center">
								<c:if test="${!empty requestScope.providerService}">
									<%
										long index = (Long) request.getAttribute("index");
											if (index > 1) {
										%>								
										<a href="listProviderRegisterService.do?id=${sessionScope.User.id}&index=1"><<</a>&nbsp;
										<a href="listProviderRegisterService.do?id=${sessionScope.User.id}&index=<%=(index - 1)%>"><</a>&nbsp;
										<% } %>							
										<%
											long totalPages = (Long) request.getAttribute("totalPages");
												for (long i = 1; i <= totalPages; i++) {
										%>
										<a href="listProviderRegisterService.do?id=${sessionScope.User.id}&index=<%=i%>">
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
									
										<a href="listProviderRegisterService.do?id=${sessionScope.User.id}&index=<%=(index + 1)%>">></a>&nbsp;
										<a href="listProviderRegisterService.do?id=${sessionScope.User.id}&index=<%=totalPages%>">>></a>
										<% }%>
								</c:if>
							</td>
						</tr>
						<tr>
							<td align="right"></td>
						</tr>
						
					</table>
				</td>
			</tr>
		</table>
</c:otherwise>
</c:choose>