<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<script type="text/javascript" src="js/jquery/jquery-1.3.2.js"></script>
<script type="text/javascript">
$(function(){
	$("span.close").click(function(){
		$(this).parents("div.myAlert").hide('fast');
		alert('y');
	});
	$(".DmyAlert button").click(function(){
		$(this).parents("div.myAlert").hide('fast');
		if(true){
			window.location="www.google.com";
			}
	});
});
function alm(msg){
	var nLeft=($(window).width()/2)-125;
	$("div.DetailAl").html(msg);	
	$("div.myAlert").css({
		position:"fixed",
		left:nLeft,
		top:200
	}).fadeIn('fast');
}
</script>
<style type="text/css">
.myAlert{
	width:250px;
	height:100px;
	border:2px solid #50A7D2;
	background-color:#F1F5FE;
	font-size:12px;
	display:none;
}
.HmyAlert{
	width:100%;
	float:left;
	height:20px;
	border:0px solid #50A7D2;
	background:url(images/bg_myalert.gif) right top no-repeat;
	font-size:12px;
	text-indent:3px;
	color:#FFFFFF;	
}
.HmyAlert span.close{
	float:right;
	display:block;
	height:20px;
	width:30px;
	cursor:pointer;
}
.HmyAlert span.iTitle{
	float:left;
	display:block;
	height:20px;
/*	background-color:#FFCC00;*/
}
.DmyAlert button{
	position:relative;
	margin-left:115px;
	margin-top:0px;
	border:1px solid #50A7D;
	background-color:#EAEAEA;
	cursor:pointer;
}
.DetailAl{
	width:95%;
	height:45px;
	margin:3px;
}
</style>

<div class="myAlert">
<div class="HmyAlert">
<span class="iTitle">Information notice</span>
<span class="close"></span></div>
<div class="DmyAlert">
<div class="DetailAl"></div>
<button>OK</button>
</div>
</div>

<a href="javascript:alm('My Alert Text Show Here');">Test</a>
