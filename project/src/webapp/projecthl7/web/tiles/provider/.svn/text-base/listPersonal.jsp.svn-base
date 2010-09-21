<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script language="javascript" src="./js/jquery/jquery-1.2.6.min.js"></script>



	<h2><bean:message key="applicationForm.hospital.listPersonal.header"/></h2>
						
									<a href="personalAdd.jsp"><bean:message key="applicationForm.hospital.listPersonal.add"/></a>
							
									<table border="1" width="100%" cellspacing="0" cellpadding="0">
										<tr>
											<th scope="col"><bean:message key="applicationForm.hospital.listPersonal.no"/></th>
											<th scope="col"><bean:message key="applicationForm.hospital.addPersonal.name"/></th>
											<th scope="col"><bean:message key="applicationForm.hospital.createdOn"/></th>
											<th scope="col"><bean:message key="applicationForm.hospital.view"/></th>
											<th scope="col"><bean:message key="applicationForm.hospital.listPersonal.edit"/></a></th>
											<th scope="col"><bean:message key="applicationForm.hospital.lock"/></a></th>
										</tr>
										<c:choose>
											<c:when test="${empty requestScope.personals}"> 
												<tr>
													<td align="center" colspan="6"><bean:message key="applicationForm.hospital.listPersonal.noData"/></td>
												</tr>
											</c:when>		
											<c:otherwise>
											<% 	long index1 =(Long)request.getAttribute("index"); 
												long display =(Long)request.getAttribute("display"); 
												long num=((index1-1)*display)+1;	
											%>
											<c:forEach var="personal" items="${requestScope.personals}">
												<%if(num%2==0){ %>									
												<tr bgcolor="#FFFFCC">
												<%}else{ %>
													<tr>
												<%} %>
													<td align="center"><%=num++ %></td>
													<td> ${personal.title} ${personal.name}</td>
													<td align="center">
													    <fmt:formatDate value="${personal.createdOn}" pattern="${initParam.dateAndTime}" type="DATE"/>  </td>
													<td align="center"><a href="getPersonal.do?personalId=${personal.id}&statusPage=1"><img src="./images/look.png" width="20px" height="20px"></a></td>
													<td align="center">
													<a href="getPersonal.do?personalId=${personal.id}&statusPage=2" onclick="return confirm('Are you sure you want to Edit ${personal.name} ?')"><img alt=<bean:message key="applicationForm.hospital.listPersonal.edit"/> src="./images/edit.png" width="20px" height="20px"></a>
													<td align="center">
													<c:if test="${personal.status == 0}">
															No confirm email
													</c:if>
													<c:if test="${personal.status == 2}">
															<a href="lockPersonal.do?personalId=${personal.id}" onclick="return confirm('Are you sure you want to lock ${personal.title} ${personal.name}?')"><img src="./images/lock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
													</c:if>
													<c:if test="${personal.status == 1}">
															<a href="lockPersonal.do?personalId=${personal.id}" onclick="return confirm('Are you sure you want to lock ${personal.title} ${personal.name}?')"><img src="./images/unlock.png" width="20px" height="20px" vspace="0" hspace="0" border="0"></a>
													</c:if>
													</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									
								
							<tr>
								<td align="center" colspan="6">
									<c:if test="${!empty requestScope.personals}">
										<%
											long index = (Long) request.getAttribute("index");
												if (index > 1) {
											%>								
											<a href="listPersonal.do?id=${sessionScope.User.id}&index=1"><<</a>&nbsp;
											<a href="listPersonal.do?id=${sessionScope.User.id}&index=<%=(index - 1)%>"><</a>&nbsp;
											<% } %>							
											<%
												long totalPages = (Long) request.getAttribute("totalPages");
													for (long i = 1; i <= totalPages; i++) {
											%>
											<a href="listPersonal.do?id=${sessionScope.User.id}&index=<%=i%>">
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
										
											<a href="listPersonal.do?id=${sessionScope.User.id}&index=<%=(index + 1)%>">></a>&nbsp;
											<a href="listPersonal.do?id=${sessionScope.User.id}&index=<%=totalPages%>">>></a>
											<% }%>
									</c:if>
								</td>
							</tr>
							
							
							
						</table>
	<a href="personalAdd.jsp"><bean:message key="applicationForm.hospital.listPersonal.add"/></a>