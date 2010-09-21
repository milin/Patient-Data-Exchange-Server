<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/layouts/commonLayoutAdmin.jsp" flush="true">
  <tiles:put name="header" value="/common/admin/header.jsp" />
  <tiles:put name="menu"   value="/common/admin/menu.jsp" />
  <tiles:put name="body"   value="/tiles/admin/adminProviderEdit.jsp" />
</tiles:insert>
