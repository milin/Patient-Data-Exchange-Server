<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
  
<html>
<head>
<html:base/>
</head>
<body bgcolor="white">
<h1>Welcome <bean:write name="Loginform" property="username"></bean:write></h1>


<html:form action="/InputAction">
 
 

<html:errors/>
   <table>
        <tr>
          <td align="right">
         <font size="3">  Partner List </font>
          </td>
          <td align="left">
             <html:select property="country" >
                            <html:option value="0">Select Country</html:option>
                            <html:optionsCollection name="InputForm" property="countryList" label="countryName" value="countryId" />
                        </html:select>
        </tr>
        <tr>
          <td align="center" colspan="2">
		<font size="3">Please Enter the Following Details</font>
 	</tr>
	<tr>
          <td align="right">
            Id
          </td>
          <td align="left">
            <html:text property="patientid" size="20" maxlength="30" />
            </td>
        </tr>
        <tr>
          <td align="right">
            Firstname
          </td>
         <td align="left">
            <html:text property="firstname" size="20" maxlength="30"/>
          </td>
               
        </tr>

        <tr>
          <td align="right">
            Lastname
          </td>
          <td align="left">
            <html:text property="lastname" size="20" maxlength="30" />
            </td>
        </tr>
        <tr>
          <td align="right">
            Sex
          </td>
          <td align="left">
            <html:text property="sex" size="20" maxlength="30" />
            </td>
          
        </tr>
        <tr>
          <td align="right">
            Age
          </td>
          <td align="left">
            <html:text property="age" size="20" maxlength="30" />
            </td>
        </tr>
        <tr>
          <td align="right">
            Phoneno
          </td>
         <td align="left">
            <html:text property="phoneno" size="20" maxlength="30" />
            </td>
        </tr>
        <tr>
          <td align="right">
            Email
          </td>
          <td align="left">
            <html:text property="email" size="20" maxlength="30" />
            </td>
        </tr>
               <tr>
          <td align="right">
            Address
          </td>
          <td align="left">
            <html:text property="address" size="20" maxlength="30" />
            </td>
        </tr>   
	<tr>
          <td align="right">
           <html:submit property="method" value="save" />
          </td>
          <td align="left">
            <html:cancel>Cancel</html:cancel>
          </td>
        </tr>
  </table>
   </html:form>
   </body>
   </html>
   