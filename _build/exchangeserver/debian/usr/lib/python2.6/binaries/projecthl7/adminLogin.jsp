<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<tiles:insert page="/layouts/commonLayoutAdminSingIn.jsp" flush="true">
  <tiles:put name="header" value="/common/header.jsp" />
  <tiles:put name="body"   value="/tiles/admin/adminLogin.jsp" />
</tiles:insert>
