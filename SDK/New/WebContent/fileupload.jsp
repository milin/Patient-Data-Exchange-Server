<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
        <html:form action="/InputAction1">
        <html:errors />
        <table>
        <tr>
          <td align="right">
         <font size="3">Partner List</font>
          </td>
          <td align="left">
           <html:select property="country" >
                            <html:option value="0">Select Partner List</html:option>
                            <html:optionsCollection name="InputForm1" property="countryList" label="countryName" value="countryName" />
                        </html:select>
        </td>
        </tr>
        </table>
        
        </html:form>
        <html:form action="/FileUploadAction1.do" method="post" enctype="multipart/form-data">
            File : <html:file property="file" /> <br/>
            <html:submit />
        </html:form>
        
        
        
        
    </body>
</html>