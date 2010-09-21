<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" src="js/jquery/checkInt.js">   
  
</script>  
<form id="addUser" method="post" action="addUser.do">
	<table width="100%" border="1">
		<tr>
			<td><div class="errorMessages">		
   		       	 <html:errors/>
   		        </div>
				<table width="100%" border="1">
					<tr>
				  		<td colspan="8" align="center"><bean:message key="applicationForm.header"/></td>
					</tr>
					<tr>
						<td width="15%">&nbsp;&nbsp;</td>
						<td width="2%">&nbsp;</td>
						<td width="25%">&nbsp;</td>
						<td width="10%">&nbsp;</td>
						<td width="2%">&nbsp;</td>
						<td width="20%">&nbsp;</td>
						<td width="30%" rowspan="5" colspan="2" valign="top" align="center"><img name="" src="" width="150px" height="200px" alt=""></td>
					</tr>
					<tr>
						<td><bean:message key="applicationForm.positionApplyFor"/></td>
				  		<td></td>
						<td></td>
						<td><bean:message key="applicationForm.salaryExpected"/></td>
						<td></td>
						<td valign="middle"><input neme="salary" type="text" onkeypress="checknumber()" maxlength="5"/></td>
					</tr>
					<tr>
						<td><bean:message key="applicationForm.dateJob"/></td>
				  		<td></td>
						<td valign="middle" width="20%">
							<div class="demo">
								<input type="text" name="dateJob" id="dateJob" />
							</div>
							<div class="demo-description">
							
							</div>  
						</td>
						<td><bean:message key="applicationForm.unit"/></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
				  		<td colspan="6" align="center"><p>&nbsp;&nbsp;</td>
						<td colspan="2"></td>
					</tr>
		  		</table>	
			<!-- end head appliction  -->
			</td>			
		</tr>
		<tr>
			<td>
				<div class="iMenu">
					<span class="iTopic"><bean:message key="applicationForm.personal"/></span>
					<label class="iDetail">
						<table border="1" width="100%">
							<tr>
								<td width="100%">
									<table border="0" width="100%">
										<tr>
											<td width="20%">&nbsp;</td>
											<td width="20%"><bean:message key="applicationForm.nameSurmaneThai"/><p><bean:message key="applicationForm.nameSurmaneEng"/></td>
											<td width="20%"><input name="nameThai" type="text" onkeyup="chkEngLang(this,1)" maxlength="20"/><p>
												<input name="nameEng" type="text"  maxlength="20"  onkeyup="chkThaiLang(this,1)"> 
											</td>
											<td width="20%"><input name="laseThai" type="text" onkeyup="chkEngLang(this,1)" maxlength="20"/><p>
												<input name="laseEng" type="text" onkeyup="chkThaiLang(this,2)" maxlength="20">
											</td>
											<td width="20%">&nbsp;</td>
										</tr>		
									</table>						
								</td>
							</tr>
							<tr>
								<td>
									<table width="100%" border="0">
										<tr>
											<td><bean:message key="applicationForm.dateOfBirth"/></td>
											<td></td>
											<td valign="top">
												<div class="demo1">
													<input type="text" name="dateBird" id="dateBird" size="10"/>
												</div>
												<div class="demo1-description">
								
												</div> 
											</td>
											<td><bean:message key="applicationForm.age"/></td>
											<td></td>
											<td valign="top"><input name="age" id="age" type="text" size="2"  onFocus="test()"/> <bean:message key="applicationForm.year"/> <input name="old_month" id="old_month" type="text" size="2"/> <bean:message key="applicationForm.moth"/></td>
											<td><bean:message key="applicationForm.bloodGroup"/></td>
											<td></td>
											<td valign="top"></td>
											<td><bean:message key="applicationForm.placeOfBirth"/></td>
											<td></td>
											<td colspan="4" valign="top">
											</td>
											<td></td>
											<td></td>
										</tr>
									</table>
									<table width="100%" border="0">
										<tr>
											<td><bean:message key="applicationForm.nationality"/></td>
											<td></td>
											<td valign="top"><input name="nationality" type="text" value="" size="10"></td>
											<td><bean:message key="applicationForm.race"/></td>
											<td></td>
											<td valign="top"><input name="race" type="text" size="10" value=�� /></td>
											<td><bean:message key="applicationForm.relegion"/></td>
											<td></td>
											<td valign="top"></td>
											<td><bean:message key="applicationForm.weight"/></td>		
											<td></td>
											<td valign="top"><input name="weight" type="text" size="3" onkeypress="checknumber()" maxlength="3" />&nbsp;<bean:message key="applicationForm.kg"/></td>
											<td colspan="2"><bean:message key="applicationForm.height"/></td>
											<td></td>
											<td valign="top"><input name="height"type="text" size="3" onkeypress="checknumber()"  maxlength="3"/>&nbsp;<bean:message key="applicationForm.cm"/></td>
											<td></td>
											<td></td>
										</tr>
									</table>
								</td>
							</tr>	
							<tr>
								<td colspan="16">
									<table border="0" width="100%">
										<tr>
											<td><bean:message key="applicationForm.identityCardNo"/></td>
											<td>
											<input name="identity_1" type="text" id="identity_1" size="1" maxlength="1" style="width:10px;" onkeypress="checknumber()" />  -  
											<input name="identity_2" type="text" id="identity_2" size="3" maxlength="4" style="width:35px;" onkeypress="checknumber()" />  -  
											<input name="identity_3" type="text" id="identity_3" size="4" maxlength="5" style="width:40px;" onkeypress="checknumber()" />  -  
											<input name="identity_4" type="text" id="identity_4" size="1" maxlength="1" style="width:10px;" onkeypress="checknumber()" />  -  
											<input name="identity_5" type="text" id="identity_5" size="1" maxlength="2" style="width:15px;" onkeypress="checknumber()"  />
											</td>
											<td><bean:message key="applicationForm.issuedBy"/></td>
											<td valign="top"><textarea name="issued" cols="20" rows="3"></textarea></td>
											<td><bean:message key="applicationForm.dataExpire"/></td>
											<td>
												<div class="demo3">
													<input name="dataExpire" id="dataExpire" type="text"/>	
												</div>
												<div class="demo3-description">
							
												</div> 
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td colspan="16" valign="top">
									<table border="0" width="100%">
										<tr>
											<td width="10%" ><bean:message key="applicationForm.presentAddress"/></td>
											<td width="10%" valign="top"><textarea name="present_address" cols="30" rows="4"></textarea></td>
											<td width="10%" valign="top"></td>
											<td width="10%"><bean:message key="applicationForm.subLane"/></td>										
											<td width="20%"><input name="present_sub"type="text"  maxlength="10"/></td>
											<td width="10%"></td>
											<td width="10%"><bean:message key="applicationForm.road"/></td>
											<td width="20%"><input name="road" type="text" size="15"  maxlength="10"/></td>
										</tr>
									</table>
									<table border="0" width="100%">
										<tr>
											<td><bean:message key="applicationForm.subDistrict"/></td>
											<td valign="top"><input name="sub_district" type="text" size="15" maxlength="20" /></td>
											<td><bean:message key="applicationForm.district"/></td>
											<td valign="top"><input name="district" type="text" size="15" maxlength="20"/></td>
											<td><bean:message key="applicationForm.province"/></td>
											<td valign="top"></td>
											<td><bean:message key="applicationForm.postcode"/></td>
											<td colspan="4" valign="top">
												
												<input name="postcode_1" id="postcode_1" type="text" maxlength="1" style="width:10px;" onkeypress="checknumber()"/>
												<input name="postcode_2" id="postcode_2" type="text" maxlength="1" style="width:10px;"  onkeypress="checknumber()" />	  															
												<input name="postcode_3" id="postcode_3" type="text" maxlength="1" style="width:10px;"  onkeypress="checknumber()" />
											  	<input name="postcode_4" id="postcode_4"type="text" maxlength="1" style="width:10px;"  onkeypress="checknumber()" />
											  	<input name="postcode_5" id="postcode_5"type="text" maxlength="1" style="width:10px;"  onkeypress="checknumber()" />									            											</td>
										</tr>
									</table>
								</td>								
							</tr>
							<tr>
								<td colspan="16">
									<table border="0" width="100%">
										<tr>
											<td width="10%"><bean:message key="applicationForm.telephone"/></td>
											<td width="20%" valign="top"><input name="personal_telphone" type="text"  maxlength="10" onkeypress="checknumber()"></td>
											<td width="30%"></td>
											<td width="10%"><bean:message key="applicationForm.eMailAddress"/></td>
											<td width="30%" valign="top"><input name="personal_email" type="text" maxlength="30"></td>
											
										</tr>
									</table>		
								</td>
							</tr>
							<tr>
								<td colspan="16">
									<table border="0" width="100%">
										<tr>
											<td width="10%"><bean:message key="applicationForm.homeAddress"/></td>
											<td width="10%"><textarea name="home_address" cols="30" rows="4"></textarea></td>
											<td width="10%"></td>
											<td width="10%"><bean:message key="applicationForm.subLane"/></td>
											<td width="20%"><input name="home_sub"type="text" maxlength="20"/></td>
											<td width="10%"></td>
											<td width="10%"><bean:message key="applicationForm.road"/></td>
											<td width="20%"><input name="home_road" type="text" size="15" maxlength="20"/></td>
										</tr>
									</table>
									<table border="1" width="100%">
										<tr>
											<td><bean:message key="applicationForm.subDistrict"/></td>
											<td valign="top"><input name="home_sub_district" type="text" size="15" maxlength="20"/></td>
											<td><bean:message key="applicationForm.district"/></td>
											<td valign="top"><input name="home_district" type="text" size="15" maxlength="20"/></td>
											<td><bean:message key="applicationForm.province"/></td>
											<td valign="top"></td>
											<td><bean:message key="applicationForm.postcode"/></td>
											<td colspan="4" valign="top">
													<input name="homeProvince_1" id ="home_postcode_1" type="text" maxlength="1" style="width:10px;" onkeypress="checknumber()"/>
													<input name="homeProvince_2" id="home_postcode_2" type="text" maxlength="1" style="width:10px;" onkeypress="checknumber()" />	  															
													<input name="homeProvince_3" id="home_postcode_3" type="text" maxlength="1" style="width:10px;" onkeypress="checknumber()" />
												  	<input name="homeProvince_4" id="home_postcode_4" type="text" maxlength="1" style="width:10px;" onkeypress="checknumber()" />
												  	<input name="homeProvince_5" id="home_postcode_5" type="text" maxlength="1" style="width:10px;" onkeypress="checknumber()" />	
											</td>								            										
										</tr>
									</table>																			
								</td>
							</tr>
						</table>	
					</label>	
			</td>
		</tr>
		<tr>
			<td>
	<!--Begin Family-->
				<span class="iTopic">	
				<bean:message key="applicationForm.familyDetails"/></span>
				<label class="iDetail">
					<table border="1" width="100%">
						<tr>
							<td>
								<table border="1" width="100%">
									<tr>
										<td width="5%"></td>
										<td width="2%" valign="top">
											<input name="status" type="radio" value="1" onclick="show_spouse(0)"/></td>
										<td width="10%"><bean:message key="applicationForm.single"/></td>
										<td width="5%"></td>
										<td width="2%" valign="top">
											<input name="status" type="radio"  value="2" onclick="show_spouse(1)"/></td>
										<td width="10%"><bean:message key="applicationForm.married"/></td>
										<td width="5%"></td>
										<td width="2%" valign="top">
											<input name="status" type="radio"  value="3" onclick="show_spouse(1)"/></td>
										<td width="10%"><bean:message key="applicationForm.divorced"/></td>
										<td width="5%"></td>
										<td width="2%" valign="top">
											<input name="status" type="radio"  value="4" onclick="show_spouse(1)"/></td>
										<td width="10%"><bean:message key="applicationForm.widowed"/></td>
										<td width="5%"></td>
									</tr>
									<tr>
										<td colspan="13">
											<div id="spouse">	</div>
										</td>
									</tr>
								</table>	
							</td>
						</tr>
						<tr>
							<td>	
								<table border="1" width="100%">
									<tr>
										<td><bean:message key="applicationForm.father"/></td>
										<td></td>
										<td valign="top"><input name="father_name" type="text" />-<input name="father_Last" type="text" maxlength="20"/></td>
										<td><bean:message key="applicationForm.age"/></td>
										<td></td>
										<td valign="top"><input name="father_age" type="text" onkeypress="checknumber()" maxlength="3" size="5"/></td>
										<td><bean:message key="applicationForm.occupation"/></td>
										<td></td>
										<td valign="top"><input name="father_occupation" type="text" maxlength="20"/></td>
									</tr>
									<tr>
										<td><bean:message key="applicationForm.mother"/></td>
										<td></td>
										<td valign="top"><input name="mother_name" type="text"  maxlength="20"/>-<input name="father_last" type="text"  maxlength="20"/></td>
										<td><bean:message key="applicationForm.age"/></td>
										<td></td>
										<td valign="top"><input name="mother_age" type="text" onkeypress="checknumber()" maxlength="3" size="5"/></td>
										<td><bean:message key="applicationForm.occupation"/></td>
										<td></td>
										<td valign="top"><input name="mother_occupation" type="text" maxlength="20"/></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table border="0" width="100%">
									<tr>
										<td width="15%"><bean:message key="applicationForm.total"/></td>
										<td width="10%" valign="top"><input name="people_children" type="text" size="3" maxlength="2"/> &nbsp;��</td>
										<td width="5%"><bean:message key="applicationForm.brother"/></td>
										<td width="10%" valign="top">
											<input name="people_boy" type="text"  size="3" onkeypress="checknumber()" maxlength="2"/>&nbsp;��</td>
										<td width="5%"><bean:message key="applicationForm.sister"/></td>
										<td width="10%" valign="top"><input name="people_girl" type="text" size="3" onkeypress="checknumber()" maxlength="2"/>&nbsp;��</td>
										<td width="10%"><bean:message key="applicationForm.applicantIsNo"/></td>
										<td width="10%" valign="top">
							 				<input name="people_no" id="people_no" type="text" size="3" onkeypress="checknumber()" maxlength="2" onChange="applicant()"/>&nbsp;��</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<div id="family_no"></div>
							</td>
						</tr>
						<tr>
							<td>				
								<table border="0" width="100%">
									<tr>
										<td width="20%"><bean:message key="applicationForm.emegencyContact"/>Emegency Contact</td>
										<td width="20%"><bean:message key="applicationForm.position"/></td>
										<td width="20%"><bean:message key="applicationForm.relationship"/></td>
										<td width="15%"><bean:message key="applicationForm.telephoneandEmail"/></td>
										<td width="15%"><bean:message key="applicationForm.email"/></td>
										<td width="10%"></td>
									</tr>
									<tr>
										<td valign="top"><input name="contact_name" type="text"></td>
										<td valign="top"><input name="contact_position" type="text"></td>
										<td valign="top"><input name="contact_relationship" type="text"></td>
										<td valign="top"><input name="contact_tel" type="text"></td>
										<td valign="top"><input name="contact_email" type="text"></td>
										<td valign="top"><a href="#" onclick="insert_Contact(1)"></a></td>
									</tr>
									<tr>
										<div id="textContact"></div>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</label>	
			</td>
		</tr>
		<tr>
			<td>
				<span class="iTopic">	
					<bean:message key="applicationForm.headEducationalBackground"/>
				</span>
				<label class="iDetail">
					<table border="1" width="100%" >
						<tr>
							<td width="20%" align="center"><bean:message key="applicationForm.educationalBackground"/></td>
							<td width="20%" align="center"><bean:message key="applicationForm.between"/></td>
							<td width="20%" align="center"><bean:message key="applicationForm.institute"/></td>
							<td width="15%" align="center"><bean:message key="applicationForm.certificate"/></td>								
							<td width="15%" align="center"><bean:message key="applicationForm.gPA"/></td>
						</tr>
						<tr>
							<td><bean:message key="applicationForm.primarySchool"/></td>
							<td valign="top" align="center">
								<input name="primary_between1" id="primary_between1" type="text" size="8">-
								<input name="primary_between2" id="primary_between2" type="text" size="8"></td>
							<td valign="top" align="center"><input name="primary_institute" type="text" size="15"  maxlength="30"></td>
							<td></td>							
							<td valign="top" align="center"><input name="primarygrade_1" id="primarygrade_1" type="text" size="1" onkeypress="checknumber()" maxlength="1">.<input name="primarygrade_2" id="primarygrade_2" type="text" size="2" onkeypress="checknumber()" maxlength="2"></td>
						</tr>
						<tr>
							<td><bean:message key="applicationForm.secondarySchool"/></td>							
							<td valign="top" align="center">
								<input name="secondary_between1" id="secondary_between1" type="text" size="8">-
								<input name="secondary_between2" id="secondary_between2" type="text" size="8">
							</td>
							<td valign="top" align="center"><input name="secondary_institute" type="text" size="15"></td>
							<td valign="top" align="center"><input name="secondary_certificate" type="text" size="15"></td>
							<td valign="top" align="center"><input name="secondarygrade_1" id="secondarygrade_1" type="text" size="1" onkeypress="checknumber()" maxlength="1">.<input name="secondarygrade_2" id="secondarygrade_2" type="text" size="2" onkeypress="checknumber()" maxlength="2"></td>
						</tr>
						<tr>
							<td><bean:message key="applicationForm.vocational"/></td>
							<td valign="top" align="center">
								<input name="vocational_between1" id="vocational_between1" type="text" size="8">-
								<input name="vocational_between2" id="vocational_between2" type="text" size="8">
							</td>
							<td valign="top" align="center"><input name="vocational_institute" type="text" size="15"></td>
							<td valign="top" align="center"><input name="vocational_certificate" type="text" size="15"></td>
							<td valign="top" align="center"><input name="vocationalgrade_1" id="vocationalgrade_1" type="text" size="1" onkeypress="checknumber()" maxlength="1">.<input name="vocationalgrade_2" id="vocationalgrade_2" type="text" size="2" onkeypress="checknumber()" maxlength="2"></td>
						</tr>
						
						<tr>
							<td><bean:message key="applicationForm.bachelorDegree"/></td>
							<td valign="top" align="center"><input name="bachelor_between1" id="bachelor_between1" type="text" size="8">-
								<input name="bachelor_between2" id="bachelor_between2" type="text" size="8"></td>
							<td valign="top" align="center"><input name="bachelor_institute" type="text" size="15"></td>
							<td valign="top" align="center"><input name="bachelor_certificate" type="text" size="15"></td>
							<td valign="top" align="center"><input name="bachelorgrade_1" id="bachelorgrade_1" type="text" size="1" onkeypress="checknumber()" maxlength="1">.<input name="bachelorgrade_2" id="bachelorgrade_2" type="text" size="2" onkeypress="checknumber()" maxlength="2"></td>
						</tr>
						<tr>
							<td><bean:message key="applicationForm.master"/></td>
							<td valign="top" align="center"><input name="master_between1" id="master_between1" type="text" size="8">-
								<input name="master_between2" id="master_between2" type="text" size="8"></td>
							<td valign="top" align="center"><input name="master_institute" type="text" size="15"></td>
							<td valign="top" align="center"><input name="master_certificate" type="text" size="15"></td>
							<td valign="top" align="center"><input name="mastergrade_1" id="mastergrade_1" type="text" size="1" onkeypress="checknumber()" maxlength="1">.<input name="mastergrade_2" id="mastergrade_2" type="text" size="2" onkeypress="checknumber()" maxlength="2"></td>
						</tr>
						<tr>
							<td><bean:message key="applicationForm.doctoral"/></td>
							<td valign="top" align="center">
								<input name="doctoral_between1" id="doctoral_between1" type="text" size="8">-
								<input name="doctoral_between2" id="doctoral_between2" type="text" size="8"></td>
							<td valign="top" align="center"><input name="doctoral_institute" type="text" size="15"></td>
							<td valign="top" align="center"><input name="doctoral_certificate" type="text" size="15"></td>
							<td valign="top" align="center"><input name="doctoralgrade_1" id="doctoralgrade_1" type="text" size="1" onkeypress="checknumber()" maxlength="1">.<input name="doctoralgrade_2" id="doctoralgrade_2" type="text" size="2" onkeypress="checknumber()" maxlength="2"></td>
						</tr>
						<tr>
							<td><bean:message key="applicationForm.others"/></td>
							<td valign="top" align="center"><input name="others_between1" id="others_between1" type="text" size="8">-
								<input name="others_between2" id="others_between2" type="text" size="8"></td>
							<td valign="top" align="center"><input name="others_institute" type="text" size="15"></td>
							<td valign="top" align="center"><input name="others_certificate" type="text" size="15"></td>
							<td valign="top" align="center"><input name="othersgrade_1" id="othersgrade_1" type="text" size="1" onkeypress="checknumber()" maxlength="1">.<input name="othersgrade_2" id="othersgrade_2" type="text" size="2" onkeypress="checknumber()" maxlength="2"></td>
						</tr>
						<tr>
							<td><bean:message key="applicationForm.scholarshipInSchool"/></td>
							<td colspan="4" valign="top">
							<textarea name="scholarship" cols="50" rows="2"></textarea>
							</td>
						</tr>
					</table>
				</label>
			</td>
		</tr>
		<tr>
			<td valign="top">
				<span class="iTopic">
					<bean:message key="applicationForm.employment"/>
				</span>
				<label class="iDetail">
					<table border="1" width="100%">
						<tr>
							<td>
								<table border="0" width="100%">
									<tr>
										<td>
											<table border="0" width="100%">
												<tr>
													<td width="20%" align="center"><bean:message key="applicationForm.nameOfEmployer"/></td>
													<td width="20%" align="center"><bean:message key="applicationForm.business"/></td>
													<td width="15%" align="center"><bean:message key="applicationForm.insstituteAndMajor"/></td>
													<td width="10%" align="center"><bean:message key="applicationForm.from"/></td>
													<td width="10%" align="center"><bean:message key="applicationForm.to"/></td>
													<td width="20%" align="center"><bean:message key="applicationForm.reasonOfLeaving"/></td>
													<td width="5%" align="center"></td>	
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td><div id="employer"></div></td>
									</tr>
									<tr>
										<td>
											����ѵԡ�÷ӧҹ��������÷Ѵ
											<select name="employer_sum" id="employer_sum"onChange="employer()">
												<option value="0">-��س����͡-</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
											</select>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table border="1" width="100%">
						<tr>
							<td>
								<table width="100%"> 
									<tr>
										<td valign="top">
											<table border="0" width="100%">
												<tr>
													<td width="40%" align="center"><bean:message key="applicationForm.trainingRecords"/></td>
													<td width="30%" align="center"><bean:message key="applicationForm.course"/></td>
													<td width="20%" align="center"><bean:message key="applicationForm.period"/></td>
													<td width="10%"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td><div id="training"></div></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<select name="training_insert" id="training_insert" onChange="training_inserts()">
									<option vcalue="0">-��س����͡-</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
							</td>
						</tr>
					</table>
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<span class="iTopic">
					<bean:message key="applicationForm.specialCompetent"/>
				</span>
				<label class="iDetail">
					<table border="1" width="100%">
						<tr>
							<td>
								<table border="0" width="100%" >
									<tr>
										<td colspan="2" align="center" width="15%"><bean:message key="applicationForm.languageAbility"/></td>
										<td align="center" width="15%">Speaking</td>
										<td align="center" width="15%">Listening</td>
										<td align="center" width="15%">Writing</td>
										<td align="center" width="15%">Reading</td>
									</tr>
									<tr>
										<td colspan="2" align="center"><bean:message key="applicationForm.english"/></td>
										<td align="center" valign="top">
											<select name="eng_speaking">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
										<td align="center" valign="top">
											<select name="eng_listening">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
										<td align="center"valign="top">
											<select name="eng_writing">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
										<td align="center" valign="top">
											<select name="eng_reading">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
									</tr>
									<tr>
										<td align="center"><bean:message key="applicationForm.others"/>Others</td>
										<td valign="top"><input name="others_lang" type="text"></td>
										<td align="center" valign="top">
											<select name="others_speaking">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
										<td align="center" valign="top">
											<select name="others_listening">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
										<td align="center" valign="top">
											<select name="others_writing">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
										<td align="center" valign="top">
											<select name="others_reading">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
												<option value="3"></option>
												<option value="4"></option>
											</select>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>	
								<table width="100%">
									<tr>
										<td rowspan="3" valign="top" width="30%">
											<table width="100%">
												<tr>
													<td width="20%"></td>
													<td width="30%"></td>
													<td width="40%" valign="top">
														<input name="typing_thai" type="text" id="typing_thai" size="5%" maxlength="2" onkeypress="checknumber()"> /�ҷ�
													</td>
												</tr>
												<tr>
													<td></td>
													<td></td>
													<td valign="top"><input name="typing_eng" id="typing_eng" type="text" size="5%" maxlength="2" onkeypress="checknumber()"> /�ҷ�</td>
												</tr>
											</table>
										</td>
										<td width="10%"><bean:message key="applicationForm.vehicle"/></td>
										<td width="15%"><bean:message key="applicationForm.drivingAbility"/></td>
										<td width="20%"colspan="2"><bean:message key="applicationForm.licenceNumber"/></td>
										<td width="20%"><bean:message key="applicationForm.possesion"/></td>
									</tr>
									<tr>
										<td><bean:message key="applicationForm.others"/>Car</td>
										<td valign="top" >
											<select name="car" id="car" onChange="show_car()">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
											</select>
										</td >
										<td colspan="2" valign="top"><div id="show_car"></div></td>
										<td valign="top"><div id="car_possesion"></div></td>
									</tr>
									<tr>
										<td><bean:message key="applicationForm.motorcycle"/></td>
										<td valign="top"> 
											<select name="motorcycle" id="motorcycle" onChange="show_motorcycle()">
												<option value="0"></option>
												<option value="1"></option>
												<option value="2"></option>
											</select></td>
										<td colspan="2" valign="top"><div id="show_motorcycle"></div></td>
										<td valign="top"><div id="motorcycle_possesion"></id></td>	
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<span class="iTopic">
					<bean:message key="applicationForm.computerLiteracy"/>
				</span>
				<label class="iDetail">
					<table border="0" width="100%">
						<tr>
							<td align="right"><input name="word" type="checkbox"></td>
							<td><bean:message key="applicationForm.microsoftWord"/></td>
							<td align="right"><input name="excel" type="checkbox"></td>
							<td><bean:message key="applicationForm.microsoftExcel"/></td>
							<td align="right"><input name="email" type="checkbox"></td>
							<td><bean:message key="applicationForm.internetAndEmail"/></td>
						</tr>
						<tr>
							<td align="right"><input name="web" type="checkbox"></td>
							<td><bean:message key="applicationForm.homePage"/></td>
							<td align="right"><input name="access" type="checkbox"</td>
							<td><bean:message key="applicationForm.microsoftAccess"/></td>
							<td align="right"><input name="other" type="checkbox" onclick="other_input()"></td>
							<td><bean:message key="applicationForm.others"/></td>
						</tr> 
					</table>
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%">
					<tr>
						<td align="right"><input type="submit" name="Submit" value="Submit"></td>
						<td><input type="reset" name="Reset" value="Reset"></td>
					</tr>
				</table>
			</td>
		</tr>		
	</table>
</form>