<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<script type="text/javascript" src="js/jquery/subMenu.js">
</script>
<style type="text/css" >
   
ul.v_menu{   
    list-style:none;   
    margin:0px;   
    padding:0px;   
    width:180px;   
   font-family:Arial, Helvetica, sans-serif;
    font-size:11px;   
   display:none;
    border:1px #CCCCCC solid;   	
}   
ul.v_menu > li{   
    display:block;   
    height:15px;    
    text-indent:5px;   
    background-color:#EAEAEA;   
    border:1px #FCFCFC solid;   
}   
ul.v_menu > li:hover{ 
    display:block;   
    height:15px;   
    text-indent:5px;   
   color:#FFFFFF;
    background-color:#B6DFF8;   
    border:1px #FFFFFF groove;   
}   
ul.v_menu > li > a{ 
    text-decoration:none;   
    color:#333333;   
   font-weight:bold;
}   




ul.v_menu2{   
    list-style:none;   
    margin:0px;   
    padding:0px;   
    width:180px;   
   font-family:Arial, Helvetica, sans-serif;
    font-size:11px;   
   display:none;
    border:1px #CCCCCC solid;   	
}   
ul.v_menu2 > li{   
    display:block;   
    height:15px;    
    text-indent:5px;   
    background-color:#EAEAEA;   
    border:1px #FCFCFC solid;   
}   
ul.v_menu2 > li:hover{ 
    display:block;   
    height:15px;   
    text-indent:5px;   
   color:#FFFFFF;
    background-color:#B6DFF8;   
    border:1px #FFFFFF groove;   
}   
ul.v_menu2 > li > a{ 
    text-decoration:none;   
    color:#333333;   
   font-weight:bold;
}   
</style>
<table border="1" width="100%" cellpadding="1" cellspacing="1">
	<tr>
		<td>
			<table border="0" width="100%" cellpadding="1" cellspacing="1">
				<tr>
					<td align="center" bgcolor="#6666FF">Welcome </td>
				</tr>
				<tr>
					<td align="center">
					<ul class="v_menu">  
					    <li><a href="lookProvider.do?id=${sessionScope.User.id}"><bean:message key="applicationForm.hospital.view"/></a></li>  
					    <li><a href="getProvider.do?id=${sessionScope.User.id}"><bean:message key="applicationForm.hospital.main.edit"/></a></li>  
					               			 
					</ul>  
					<span id="showmenu1" style="text-decoration:underline;color:#0066FF;">${sessionScope.User.name}</span> 
					</td>
				</tr>
				<tr>
					<td align="center"><a href="signOutProvider.do">sign out</a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table border="1" width="100%" cellpadding="0" cellspacing="0">
	<tr>
		<td>	
			<table border="0" width="100%" cellpadding="1" cellspacing="1">
				<!--<tr>
					<td width="15%"></td>
					<td width="75%">
						<a href="getProvider.do?id=${sessionScope.User.id}"><bean:message key="applicationForm.hospital.main.edit"/></a>
					</td>
					<td width="10%"></td>
				</tr>
				--><tr>
					<td></td>
					<td>
						<a href="personalAdd.jsp"><bean:message key="applicationForm.hospital.main.add"/></a>
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a href="listPersonal.do?id=${sessionScope.User.id}"><bean:message key="applicationForm.hospital.main.list"/></a>
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<ul class="v_menu2">  
						    <li><a href="listProviderRegisterService.do?id=${sessionScope.User.id}"><bean:message key="applicationForm.admin.menu.provider"/></a></li>  
						    <li><a href="listProviderService.do"><bean:message key="applicationForm.hospital.listProvidersConnect"/></a></li>  
							<li><a href="sentProviderRequest.do"><bean:message key="applicationForm.hospital.sentProviderRequests"/></a></li>
							<li><a href="displayProviderRequests.do"><bean:message key="applicationForm.hospital.providerRequests"/></a></li>					  	
					  	</ul>  
					<span id="showmenu2" style="text-decoration:underline;color:#0066FF;">Service</span> 
					
					
						<a href=""></a>
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a href="displayProviderRequests.do"><c:import url="countProviderRequests.do"></c:import></a>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<a href="contactAdmin.jsp" ><bean:message key="applicationForm.hospital.main.contactAdmin"/></a>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						online
					</td>
				</tr>		
			</table>
		</td>
	</tr>
</table>		
			