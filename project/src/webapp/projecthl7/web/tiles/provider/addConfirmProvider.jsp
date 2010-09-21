<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div id="loginform">
					<form action="addProviderService.do?id=${param.id}" method="post" id="addProviderService">
						Adding New Provider Connect with ${requestScope.providerConfirm[0]}
									<input type="submit" name="submit" value="Add provider"/>
									<input type="submit" name="cancel" value="Cancel" onclick="document.getElementById('addProviderService').action='listProviderRegisterService.do'"/>
								
					</form>
				
			
    		
    		</div>