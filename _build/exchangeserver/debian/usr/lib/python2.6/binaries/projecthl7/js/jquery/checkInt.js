function checknumber(){
	key=event.keyCode
  if (key<48  ||  key>57) event.returnValue = false;
} 
$(function(){   
   
 	$("input[name^='identity_']").keyup(function(){   
	if($(this).val().length==$(this).attr("maxLength")){   
 		$(this).next("input").focus();   
	}   
	});    
}); 
$(function(){   
   
 	$("input[name^='postcode_']").keyup(function(){   
	if($(this).val().length==$(this).attr("maxLength")){   
 		$(this).next("input").focus();   
	}   
	});    
}); 
$(function(){   
   
 	$("input[name^='homeProvince_']").keyup(function(){   
	if($(this).val().length==$(this).attr("maxLength")){   
 		$(this).next("input").focus();   
	}   
	});    
}); 
