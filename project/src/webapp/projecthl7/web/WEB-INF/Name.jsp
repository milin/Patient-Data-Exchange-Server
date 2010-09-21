<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insert page="/layouts/CommonLayout.jsp" flush="true">
  <tiles:put name="title"  value="Page Title" />
  <tiles:put name="header" value="/common/Header.jsp" />
  <tiles:put name="footer" value="/common/Footer.jsp" />
  <tiles:put name="menu"   value="/common/Menu.jsp" />
  <tiles:put name="body"   value="/tiles/NameBody.jsp" />
</tiles:insert>