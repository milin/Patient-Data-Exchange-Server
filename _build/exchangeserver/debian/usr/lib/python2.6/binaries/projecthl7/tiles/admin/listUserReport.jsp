<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>




	<!-- firebug lite -->
		<script type="text/javascript" src="js/firebug/firebug.js"></script>

        <!-- jQuery -->

		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
        
        <!-- required plugins -->
		<script type="text/javascript" src="js/jquery/scripts/date.js"></script>
		<!--[if IE]><script type="text/javascript" src="scripts/jquery.bgiframe.min.js"></script><![endif]-->
        
        <!-- jquery.datePicker.js -->
		<script type="text/javascript" src="js/jquery/scripts/jquery.datePicker.js"></script>
        
        <!-- datePicker required styles -->

		<link rel="stylesheet" type="text/css" media="screen" href="css/datePicker.css">
		
        <!-- page specific styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.css">
        
        <!-- page specific scripts -->
		<script type="text/javascript" charset="utf-8">



		$(function()
        {
			$('.date-pick').datePicker(
					{
						startDate: '01/04/2010',
						endDate: (new Date()).asString()
					}

			);
			$('#start-date').bind(
				'dpClosed',
				function(e, selectedDates)
				{
					var d = selectedDates[0];
					if (d) {
						d = new Date(d);
						
						$('#end-date').dpSetStartDate(d.addDays(1).asString());
					}
				}
			);
			$('#end-date').bind(
				'dpClosed',
				function(e, selectedDates)
				{
					var d = selectedDates[0];
					if (d) {
						d = new Date(d);
						$('#start-date').dpSetEndDate(d.addDays(-1).asString());
					}
				}
			);
        });
	</script>

<form name="chooseDateForm" id="chooseDateForm" method="post" action="listUserReportLogin.do?sidebar=4">
				<table>
					<tr valign="top">
						<td >
							Start date:
						</td>
                        <td>
                          
                         	 <label for="start-date">  </label>
                          
							<input name="start-date" id="start-date" class="date-pick" value="${requestScope.start}"/>
						
						</td>
						<td >
							 End date:
						</td>
						<td>
							<input name="end-date" id="end-date" class="date-pick" value="${requestScope.end}"/>
						</td>
						<td >
							<input type="submit" name=""submit" value="submit"/>
						</td>
						
					</tr>
				</table>	
			</form>



	<h2><bean:message key="applicationForm.hospital.listPersonal.header"/> <bean:message key="applicationForm.hospitalad.login"/></h2>
	<table border="1" width="100%">
	<tr>
		<th align="center"><bean:message key="applicationForm.hospital.listPersonal.no"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.name"/></th>
		<th align="center"><bean:message key="applicationForm.hospital.contactName"/></th>
		<th valign="center"><bean:message key="applicationForm.hospital.onlineTime"/></th>
		<th valign="center"><bean:message key="applicationForm.hospital.offlineTime"/></th>
	</tr>
	<c:choose>
		<c:when test="${!empty requestScope.online}">
		<% 	long index1 =(Long)request.getAttribute("index"); 
			long display =(Long)request.getAttribute("display"); 
			long num=((index1-1)*display)+1;	
		%>
			<c:forEach var="online" items="${requestScope.online}">
			<tr >
				<td align="center"><%=num++ %></td>
				<td align="center">${online.provider.name}</td>
				<td align="center">${online.providerStaff.contactName}</td>
				<td align="center">${online.onlineTime}</td>
				<td align="center">${online.offlineTime}</td>
				
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td align="center" colspan="6" ><bean:message key="applicationForm.hospital.listPersonal.noData"/></td>
			</tr>
		</c:otherwise>
		</c:choose>
	<tr>
		<td align="center" colspan="6">
			<c:if test="${!empty requestScope.online}">
				<% if(request.getAttribute("start")!=null){
					String url="&start-date=${requestScope.start}&end-date=${requestScope.end}";
					}
				
					long index = (Long) request.getAttribute("index");
						if (index > 1) {
					%>								
					<a href="listUserReportLogin.do?index=1&sidebar=4"+url><<</a>&nbsp;
					<a href="listUserReportLogin.do?index=<%=(index - 1)%>&sidebar=4"+url><</a>&nbsp;
					<% } %>							
					<%
						long totalPages = (Long) request.getAttribute("totalPages");
							for (long i = 1; i <= totalPages; i++) {
					%>
					<a href="listUserReportLogin.do?index=<%=i%>&sidebar=4"+url>
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
				
					<a href="listUserReportLogin.do?index=<%=(index + 1)%>&sidebar=4"+url>></a>&nbsp;
					<a href="listUserReportLogin.do?index=<%=totalPages%>&sidebar=4"+url>>></a>
					<% }%>
			</c:if>
			
			
		</td>
	</tr>
	
</table>

		<c:choose>
				<c:when test="${!empty requestScope.start}">
					<a href="downloadReportUserLogin.do?start=${requestScope.start}&end=${requestScope.end}">download</a>
				</c:when>
				<c:otherwise>
				    <a href="downloadReportUserLogin.do">download</a>
				</c:otherwise>
			</c:choose>
	