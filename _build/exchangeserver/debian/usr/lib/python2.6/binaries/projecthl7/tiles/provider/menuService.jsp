
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<a href="listProviderRegisterService.do?id=${sessionScope.User.id}"><bean:message key="applicationForm.hospital.listHospital.header"/></a> || <a href="listProviderService.do"><bean:message key="applicationForm.hospital.listProvidersConnect"/> </a>||<a href="sentProviderRequest.do"><bean:message key="applicationForm.hospital.sentProviderRequests"/></a>||<a href="displayProviderRequests.do"><bean:message key="applicationForm.hospital.providerRequests"/></a>