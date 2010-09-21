<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>


	<h2><bean:message key="applicationForm.hospital.listPersonal.header"/></h2>
	<table border="1" width="100%">
	<tr>
		<th align="center"><bean:message key="applicationForm.hospital.listPersonal.no"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.main.personal"/>-<bean:message key="applicationForm.hospital.addPersonal.name"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.contactName"/></th>
		<th valign="center"><bean:message key="applicationForm.hospital.name"/></th>
		<th valign="center"><bean:message key="applicationForm.hospital.createdOn"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.view"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.listPersonal.edit"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.listPersonal.delete"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.lock"/></th>
	</tr>
	<c:choose>
		<c:when test="${!empty requestScope.provider}">
		<% 	long index1 =(Long)request.getAttribute("index"); 
			long display =(Long)request.getAttribute("display"); 
			long num=((index1-1)*display)+1;	
		%>
			<c:forEach var="providerStaff" items="${requestScope.provider}">
			<tr >
				<td align="center"><%=num++ %></td>
				<td align="center">${providerStaff[2].title}  ${providerStaff[2].name}</td>
				<td align="center">  ${providerStaff[1].contactName}</td>
				<td align="center">${providerStaff[0].name}</td>
				<td align="center">${providerStaff[2].createdOn}</td>
				<td align="center"><a href="getAdminPersonal.do?id=${providerStaff[2].id}&statusPage=1"><img src="./images/look.png" width="20px" height="20px"></a></td>
				<td align="center"><a href="getAdminPersonal.do?id=${providerStaff[2].id}&statusPage=2" onclick="return confirm('Are you sure you want to Edit ${providerStaff[2].name} ?')"><img alt=<bean:message key="applicationForm.hospital.listPersonal.edit"/> src="./images/edit.png" width="20px" height="20px"></a></td>
				<td align="center">
						<a href="deletePersonal.do?personalId=${providerStaff[2].id}" 
						onclick="return confirm('Are you sure you want to Delete ${providerStaff[2].name} ?')"><bean:message key="applicationForm.hospital.listPersonal.delete"/></a>
				</td>
				<td align="center">
							<c:if test="${providerStaff[2].status == 0}">
						<bean:message key="errors.noConfirm"/>
					</c:if>
					<c:if test="${providerStaff[2].status == 2}">
						<a href="lockAdminPersonal.do?id=${providerStaff[2].id}&sidebar=2" onclick="return confirm('Are you sure you want to lock ${providerStaff[2].name}?')"><img src="./images/lock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
					</c:if>
					<c:if test="${providerStaff[2].status == 1}">
						<a href="lockAdminPersonal.do?id=${providerStaff[2].id}&sidebar=2" onclick="return confirm('Are you sure you want to lock ${providerStaff[2].name}?')"><img src="./images/unlock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td align="center" colspan="9" ><bean:message key="applicationForm.hospital.listPersonal.noData"/></td>
			</tr>
		</c:otherwise>
		</c:choose>
	<tr>
		<td align="center" colspan="9">
			<c:if test="${!empty requestScope.provider}">
				<%
					long index = (Long) request.getAttribute("index");
						if (index > 1) {
					%>								
					<a href="listAdminPersonal.do?index=1&sidebar=2"><<</a>&nbsp;
					<a href="listAdminPersonal.do?index=<%=(index - 1)%>&sidebar=2"><</a>&nbsp;
					<% } %>							
					<%
						long totalPages = (Long) request.getAttribute("totalPages");
							for (long i = 1; i <= totalPages; i++) {
					%>
					<a href="listAdminPersonal.do?index=<%=i%>&sidebar=2">
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
				
					<a href="listAdminPersonal.do?index=<%=(index + 1)%>&sidebar=2">></a>&nbsp;
					<a href="listAdminPersonal.do?index=<%=totalPages%>&sidebar=2">>></a>
					<% }%>
			</c:if>
		</td>
	</tr>
</table>