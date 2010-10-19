<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<tiles:insert page="/layouts/commonLayout.jsp" flush="true">
  <tiles:put name="header" value="/common/header.jsp" />
  <tiles:put name="menu"   value="/common/menu.jsp" />
  <tiles:put name="body"   value="/tiles/product/list.jsp" />
   <tiles:put name="footer"   value="/common/footer.jsp" />
</tiles:insert>