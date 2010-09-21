<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="styles/form.css" />
	</head>
	<body>
		<div id="content">
		<table width="30%" border="0" align="center">
			<tr>
				<td>
					<form action="LoginStaff.do" method="post">
						 <fieldset><legend>Staff</legend>
							<table  align="center">
								<tr>
									<td>
										<div>
				       	 					<label>Username:</label>
				         					<input type="text" name="username" id="firstName" class="inputText" size="10" maxlength="100"  />
				      					</div>
				      				</td>
				      			</tr>
						      	<tr>
						      		<td>
						      			<div>
						       				 <label>Password:</label>
						          					<input type="password" name="password" id="firstName" class="inputText" size="10" maxlength="100" />
						     			 </div>											
									</td>
								</tr>
								<tr>
									<td>
										<div>
						         		 	<input type="submit" class="inputSubmit" value="submit" />
						        		</div>
									</td>
								</tr>
							</table>
						</fieldset>		    	    
					</form>
				</td>
			</tr>
		</table>
			
		</div>
		
	</body>
</html>