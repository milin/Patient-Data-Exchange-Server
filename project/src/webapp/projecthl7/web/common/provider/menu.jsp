<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script type="text/javascript">
function ajaxFunction(i){
	var htmlA1='';
	var htmlA2='';
	var htmlB1='';
	var htmlB2='';
	var htmlC1='';
	var htmlC2='';
	var xmlHttp;
	try{
 		 // Firefox, Opera 8.0+, Safari
 		xmlHttp=new XMLHttpRequest();
 		//alert('zzzz');
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
	//	alert("ss");
	document.getElementById('sub2').innerHTML="<div id=\"sub\"></div>";
  		if (xmlHttp.readyState==4)
  	  	{
  			//alert(i);
  	
  		   var text=xmlHttp.responseText;
  		 var tests=text.split("-");
  		 //  alert ("sss"+tests[1]);
  			//var texts[]=text.split("--");
	document.getElementById('sub').innerHTML=text;
			if(i==1){
				//alert("//1"+i);
				htmlA1='<li id="current">';
				htmlA2='</li>';
				document.getElementById('hidden1').innerHTML=htmlA1+'<a href="#" onclick="ajaxFunction(\'1\')"><bean:message key="applicationForm.provider"/></a>'+htmlA2;
				document.getElementById('hidden2').innerHTML='<li><a href="#" onclick="ajaxFunction(\'2\')"><bean:message key="applicationForm.hospital.main.personal"/></a></li>';
				document.getElementById('hidden3').innerHTML='<li><a href="#" onclick="ajaxFunction(\'3\')"><bean:message key="applicationForm.hospital.main.service"/></a></li>';
			}else if(i==2){
				//alert("//2"+i);
				htmlB1='<li id="current">';
				htmlB2='</li>';
				document.getElementById('hidden1').innerHTML='<li><li id="current1"><a href="#" onclick="ajaxFunction(\'1\')"><bean:message key="applicationForm.provider"/></a></li></li>';
				document.getElementById('hidden2').innerHTML=htmlB1+'<a href="#" onclick="ajaxFunction(\'2\')"><bean:message key="applicationForm.hospital.main.personal"/></a>'+htmlB2;
				document.getElementById('hidden3').innerHTML='<li><li id="current3"><a href="#" onclick="ajaxFunction(\'3\')"><bean:message key="applicationForm.hospital.main.service"/></a></li></li>';
			}else if(i==3){
				htmlC1='<li id="current">';
				htmlC2='</li>'
				document.getElementById('hidden1').innerHTML='<li><li id="current1"><a href="#" onclick="ajaxFunction(\'1\')"><bean:message key="applicationForm.provider"/></a></li></li>';
				document.getElementById('hidden2').innerHTML='<li><li id="current2"><a href="#" onclick="ajaxFunction(\'2\')"><bean:message key="applicationForm.hospital.main.personal"/></a></li></li>';
				document.getElementById('hidden3').innerHTML=htmlC1+'<a href="#" onclick="ajaxFunction(\'3\')"><bean:message key="applicationForm.hospital.main.service"/></a>'+htmlC2;
				}
			<% 
			String statusSubMenu=request.getParameter("statusSubMenu");
			statusSubMenu=null;
			
			//
			%>
			
			//alert(statusSubMenu);
			
		//	document.getElementById('current'+2).innerHTML=htmlB1+'<a href="#" onclick="ajaxFunction(\'2\')><bean:message key="applicationForm.hospital.main.personal"/></a>'+htmlB2;
		//	document.getElementById('current'+3).innerHTML=htmlC1+'<a href="#" onclick="ajaxFunction(\'3\')><bean:message key="applicationForm.hospital.main.service"/></a>'+htmlC2;
	  	}
  	}  	
    xmlHttp.open("GET","subMenu.do?subMenu="+i,true);
    xmlHttp.send(null);	
}
</script>
 	

<ul id="navtabs">
		<div id="hidden1">
			<li>
	   		<li id="current1">
	   			<c:if test="${param.statusSubMenu==1 or param.statusSubMenu==2 or param.statusSubMenu==9}">
	   				<li id="current">
	   			</c:if>
	   				<a href="#" onclick="ajaxFunction('1')"><bean:message key="applicationForm.provider"/></a>
	   			<c:if test="${param.statusSubMenu==1 or param.statusSubMenu==2 or param.statusSubMenu==9}">
	   				</li>
	   			</c:if>
	   		</li>
	   	</div>
	   	<div id="hidden2">
	   		<li>
	   		<li id="current2">
	   			<c:if test="${param.statusSubMenu==3 or param.statusSubMenu==4}">
	   				<li id="current">
	   			</c:if>
	   				 <a href="#" onclick="ajaxFunction('2')"><bean:message key="applicationForm.hospital.main.personal"/></a></li>
	   			<c:if test="${param.statusSubMenu==3 or param.statusSubMenu==4}">
	   		
	   				</li> 
	   			</c:if>
	   			</li> 
	   	</div>
	   	 <div id="hidden3">
	   	 	<li>
	   	 	<li id="current3">
				<c:if test="${param.statusSubMenu==5 or param.statusSubMenu==6 or param.statusSubMenu==7 or param.statusSubMenu==8}">
	   				<li id="current">
	   			</c:if>
	   			
	   			<a href="#" onclick="ajaxFunction('3')"><bean:message key="applicationForm.hospital.main.service"/></a>
	   			<c:if test="${param.statusSubMenu==5 or param.statusSubMenu==6 or param.statusSubMenu==7 or param.statusSubMenu==8}">
	   				</li>
	   		</c:if>
	   		</li> 
	   	</div>
</ul>
<div class="clear"></div>
<div id="sub2">
	<c:if test="${param.statusSubMenu!=null}">
		<c:import url="selectSubMenu.do?statusSubMenu=${param.statusSubMenu}"></c:import>
	</c:if>
</div>