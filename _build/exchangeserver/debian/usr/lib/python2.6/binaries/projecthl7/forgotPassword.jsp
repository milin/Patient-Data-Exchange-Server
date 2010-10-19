<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<tiles:insert page="/layouts/commonLayoutforgotPassword.jsp" flush="true">
  <tiles:put name="header" value="/common/header.jspp" />
  <tiles:put name="body"   value="/tiles/main/forGotPassword.jsp" />
</tiles:insert>
