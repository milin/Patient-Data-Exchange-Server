<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
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
	<head>
		<title>adminTheme</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link rel="stylesheet" media="screen" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" media="screen" type="text/css" href="css/green.css" />
		<!--[if lte IE 6]>
		<link rel="stylesheet" media="screen" type="text/css" href="css/ie6.css" />
		<![endif]-->
		
	</head>
	
	<body>
	
		<div id="header">
			<h1>adminTheme - main styles</h1>
			<div id="login"><p>Logged in as: ${sessionScope.admin.username}</a> | <a href="logOutAdmin.do">Logout &raquo;</a></p>
			</div>
			<div id="language"></div>
			<div class="clear"></div>
		</div>
		<div id="content">
				<tiles:insert attribute="body" />		
		</div>
		
		
		
		
		
		<div id="sidebar">
			<tiles:insert attribute="menu" />
		</div>
				
		<div class="clear"></div>	
	
	</body>
	
</html>
