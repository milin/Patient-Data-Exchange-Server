<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>adminTheme</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<!--<link rel="stylesheet" media="screen" type="text/css" href="css/reset.css" />
		<link rel="stylesheet" media="screen" type="text/css" href="css/green.css" />
		[if lte IE 6]>
		<link rel="stylesheet" media="screen" type="text/css" href="css/ie6.css" />
		<![endif]-->
		<style type="text/css">
		<!--
		body {
			margin-top: 0px;
			margin-bottom: 0px;
			margin-left:0px;
			margin-right:0px;
		}
		-->
	  </style>
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
	</head>
	
	<body>
		
	<table width="100%" height="100%" >
		<tr>
			<td align="center" valign="middle">
			</td>
		</tr>
		<tr>
			<td><tiles:insert attribute="body"/> </td>
		</tr>
	</table>
		

	</body>
	
</html>
			