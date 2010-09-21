<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<select class="textfield small" name="country" id="country" onchange="
	ajaxFunction(function(xmlHttp)
		{
		alert(xmlHttp.responseText);
		
		  	var citys = eval(xmlHttp.responseText);
			removeAllOptions(document.getElementById('city'));
			
		  	if (citys.length==0){
				addOption(document.getElementById('city'),'----','0'); 
			}else{
			
				for(var i=0;i<citys.length;i++){
					addOption(document.getElementById('city'),citys[i][1],citys[i][0]); 
   				}
		  	}
		},'ajaxListCityId.do?countryId='+this.options[this.selectedIndex].value
	)" >
	
	<c:forEach var="country" items="${requestScope.country}" > 
		<option value="${country.id}" <c:if test="${country.id==requestScope.countryId}"> selected="selected"</c:if>>${country.name}</option>
	</c:forEach>
</select>