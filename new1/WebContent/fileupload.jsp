<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
        <html:errors />
        <table>
        <tr>
          <td align="right">
         <font size="3">  Partner List </font>
          </td>
          <td align="left">
            <select name="menu" size="1">

        <option value="1">HospitalA</option>
        <option value="2">HospitalC</option>
        <option value="3">HospitalD</option>
        <option value="4">HospitalE</option>

    </select>
        </tr>
        </table>
        <html:form action="/FileUploadAction1.do" method="post" enctype="multipart/form-data">
            File : <html:file property="file" /> <br/>
            <html:submit />
        </html:form>
    </body>
</html>