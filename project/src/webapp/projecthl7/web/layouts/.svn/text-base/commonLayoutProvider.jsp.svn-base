<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Provider</title>
		
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript">
		function ajaxFunction(callBackFunction,url){
			var xmlHttp;
			try{
		 		 // Firefox, Opera 8.0+, Safari
		 		xmlHttp=new XMLHttpRequest();
		  	}catch (e){
		 	 	// Internet Explorer
			  	try{
			   	 	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			    }catch (e){
				    try{
				     	xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				    }catch (e){
				      	alert("Your browser does not support AJAX!");
				      	return false;
				    }
			    }
		 	}
		  	xmlHttp.onreadystatechange=function(){
		  		if (xmlHttp.readyState==4)
		  	  	{
		  			callBackFunction(xmlHttp);
			  	}
		  	}  	
		    xmlHttp.open("GET",url,true);
		    xmlHttp.send(null);
		}
		  
		function addOption(selectbox,text,value )
		{
			var optn = document.createElement("OPTION");
			optn.text = text;
			optn.value = value;
			selectbox.options.add(optn);
		}
		function removeAllOptions(selectbox)
		{
			var i;
			for(i=selectbox.options.length-1;i>=0;i--)
			{
			selectbox.remove(i);
			}
		}	
		function removeSelectedOption(selectbox)
		{
			var i;
			for(i=selectbox.options.length-1;i>=0;i--)
			{
			if(selectbox.options[i].selected)
			selectbox.remove(i);
			}
		}		
	  </script>

		<link rel="stylesheet" media="screen" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" media="screen" type="text/css" href="css/green.css" />
		<!--[if lte IE 6]>
		<link rel="stylesheet" media="screen" type="text/css" href="css/ie6.css" />
		<![endif]-->
		
	</head>
	
	<body>
	
		<div id="header">
			<h1>adminTheme - main styles</h1>
			<div id="login"><p>Logged in as: ${sessionScope.User.contactName} . <a href="lookProvider.do?staffId=${sessionScope.User.id}">Settings</a> | <a href="signOutProvider.do">Logout &raquo;</a></p>
			
			<p1><a href="setLocale.do?language=en"><img src="./images/16_203.gif" alt="Eng" /></a>  <a href="setLocale.do?language=th"> <img src="./images/16_126.gif" alt="Thai" /></a></p1></div>
			<div id="language"></div>
			<div class="clear"></div>
		</div>
		<div id="navi">
			<tiles:insert attribute="menu" />
		</div>
		<div id="content">
				<tiles:insert attribute="body" />		
		</div>
		
		
		
		
		
		<div id="sidebar">
			<h5>Sidebar preview</h5>
			<ul id="sidebar-nav">
				<li id="side-current"><c:import url="countPersonal.do"></c:import></li>
				<c:import url="countProviderRequests.do"></c:import>
				<c:choose>
					<c:when test="${param.sidebar==2}">
						<li id="side-current">
					</c:when>
					<c:otherwise>
						<li>
					</c:otherwise>
				</c:choose>
				<c:if test="${sessionScope.User.master==1 and sessionScope.menber==1}">
				<c:choose>
					<c:when test="${param.sidebar==3}">
						<li id="side-current">
					</c:when>
					<c:otherwise>
						<li>
					</c:otherwise>
				</c:choose><a href="addProviderStaff.jsp">Add Provider Staff</a></li>
				</c:if>
				<c:if test="${sessionScope.User.master==1 and sessionScope.menber ==2 }">
				<c:choose>
					<c:when test="${param.sidebar==4 } ">
						<li id="side-current">
					</c:when>
					<c:otherwise>
						<li>
					</c:otherwise>
				</c:choose><a href="viewProviderStaff.do?sidebar=4">View  Provider Staff Two</a></li>
				</c:if>
				
			</ul>			
		</div>
				
		<div class="clear"></div>	
	
	</body>
	
</html>
