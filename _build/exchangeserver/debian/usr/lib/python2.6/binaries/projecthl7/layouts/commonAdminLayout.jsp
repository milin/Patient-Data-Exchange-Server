<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<head>
		<title>adminTheme</title>
		<link rel="stylesheet" media="screen" type="text/css" href="css/jquery.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		 	
		<!--Begin sile menu-->
	
		<!--End-->
		<!--Begin datepicker -->
			<link type="text/css" href="css/base/ui.all.css" rel="stylesheet" />
	
		<!--End-->
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
	   <style type="text/css">
		<!--
		v  {
			margin-top: 0px;
			margin-bottom: 0px;
			margin-left:0px;
			margin-right:0px;
		}
		-->
	  </style>
	  <style type="text/css">
		<!--
		body {
			margin-top: 0px;
			margin-bottom: 0px;
			margin-left:0px;
			margin-right:0px;
		}
		-->
		td.text{
			align="center";
			style="font-family:AngsanaUPC; 
			font-size:16pt;
			font-weight:normal";
			}
	  </style>
	</head>
	
	<body>
	<table border="0" width="100%" height="100%" bgcolor="#EEEEEE" >
		<tr>
			<td align="center">
				<table border="1" width="75%" height="100%" bgcolor="#FFFFFF" cellpadding="1" cellspacing="1">
					<tr>
						<td>
							<table width="100%" height="100%"  cellpadding="0" cellspacing="0">
								<tr height="20%">
									<td >
										<tiles:insert attribute="header" />
									</td>		
								</tr>
								<tr >
									<td align="center" >
										<table border="0" width="100%" height="100%"> 
											<tr valign="top">
												<td width="20%" align="left">
													<tiles:insert attribute="menu" />
												</td>	
												<td width="80%" align="left" >
													<tiles:insert attribute="body" />
												</td>
											</tr>	
										</table>	
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
		<!--<div id="navi">
			
		</div>
		<div id="content">
			<tiles:insert attribute="body" /> 		 	
		</div>

	--></body>
	
</html>
	