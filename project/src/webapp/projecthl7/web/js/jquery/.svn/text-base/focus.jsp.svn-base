<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<script type="text/javascript">

$(function(){
	var mobileSet="#mobile";
	var mobileSetText="<bean:message key='applicationForm.hospital.example.contactMobile'/>+xxxxxxxxxxx";
	var faxSet="#fax";
	var faxSetText="<bean:message key='applicationForm.hospital.example.contactMobile'/>+xxxxxxxxxx";
	var phone1Set="#phone1";
	var phone1Text="<bean:message key='applicationForm.hospital.example.phone'/>+xxxxxxxxxx";
	var phone2Set="#phone2";
	var phone2Text="<bean:message key='applicationForm.hospital.example.phone'/>+xxxxxxxxxx";
	var contactEmailSet="#contactEmail";
	var contactEmailText="<bean:message key='applicationForm.hospital.example.phone'/>xxxxx@xxxxx.com";
	var contactMobileSet="#contactMobile";
	var contactMobileText="<bean:message key='applicationForm.hospital.example.phone'/>+xxxxxxxxxxx";
	var zipSet="#zip";
	var zipText="<bean:message key='applicationForm.hospital.example.phone'/>xxxxx";
		if($(mobileSet).val()==""){
				$(mobileSet).val(mobileSetText);
		}	
		$(mobileSet).focus(function(){
			if($(mobileSet).val()==mobileSetText){
					$(mobileSet).val("");
			}	
		}).blur(function(){
			if($(mobileSet).val()==""){
					$(mobileSet).val(mobileSetText);
			}	
		});
		
		if($(faxSet).val()==""){
				$(faxSet).val(faxSetText);
		}	
		$(faxSet).focus(function(){
			if($(faxSet).val()==faxSetText){
					$(faxSet).val("");
			}	
		}).blur(function(){
			if($(faxSet).val()==""){
					$(faxSet).val(faxSetText);
			}	
		});

		if($(phone1Set).val()==""){
			$(phone1Set).val(phone1Text);
		}	
		$(phone1Set).focus(function(){
			if($(phone1Set).val()==phone1Text){
					$(phone1Set).val("");
			}	
		}).blur(function(){
			if($(phone1Set).val()==""){
					$(phone1Set).val(phone1Text);
			}	
		});

		if($(contactEmailSet).val()==""){
			$(contactEmailSet).val(contactEmailText);
		}	
		$(contactEmailSet).focus(function(){
			if($(contactEmailSet).val()==contactEmailText){
					$(contactEmailSet).val("");
			}	
		}).blur(function(){
			if($(contactEmailSet).val()==""){
					$(contactEmailSet).val(contactEmailText);
			}	
		});
		
		if($(contactMobileSet).val()==""){
			$(contactMobileSet).val(contactMobileText);
		}	
		$(contactMobileSet).focus(function(){
			if($(contactMobileSet).val()==contactMobileText){
					$(contactMobileSet).val("");
			}	
		}).blur(function(){
			if($(contactMobileSet).val()==""){
					$(contactMobileSet).val(contactMobileText);
			}	
		});
		
		if($(zipSet).val()==""){
			$(zipSet).val(zipText);
		}	
		$(zipSet).focus(function(){
			if($(zipSet).val()==zipText){
					$(zipSet).val("");
			}	
		}).blur(function(){
			if($(zipSet).val()==""){
					$(zipSet).val(zipText);
			}	
		});
		
		/*begin focus*/
		 $("input[name^='phone']").keyup(function(){  
			        if($(this).val().length==$(this).attr("maxLength")){  
			            $(this).next("input").focus();  
			        }  
		 });

		 
		/*end focus*/
		
	});
	</script>