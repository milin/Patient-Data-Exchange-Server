<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="samplePatientDataExchangeProxyid" scope="session" class="org.pdes.PatientDataExchangeProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
samplePatientDataExchangeProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = samplePatientDataExchangeProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        samplePatientDataExchangeProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        org.pdes.PatientDataExchange getPatientDataExchange10mtemp = samplePatientDataExchangeProxyid.getPatientDataExchange();
if(getPatientDataExchange10mtemp == null){
%>
<%=getPatientDataExchange10mtemp %>
<%
}else{
        if(getPatientDataExchange10mtemp!= null){
        String tempreturnp11 = getPatientDataExchange10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String srcHosp_1id=  request.getParameter("srcHosp16");
            java.lang.String srcHosp_1idTemp = null;
        if(!srcHosp_1id.equals("")){
         srcHosp_1idTemp  = srcHosp_1id;
        }
        String destHosp_2id=  request.getParameter("destHosp18");
            java.lang.String destHosp_2idTemp = null;
        if(!destHosp_2id.equals("")){
         destHosp_2idTemp  = destHosp_2id;
        }
        String hData_3id=  request.getParameter("hData20");
            java.lang.String hData_3idTemp = null;
        if(!hData_3id.equals("")){
         hData_3idTemp  = hData_3id;
        }
        java.lang.String requestToSend13mtemp = samplePatientDataExchangeProxyid.requestToSend(srcHosp_1idTemp,destHosp_2idTemp,hData_3idTemp);
if(requestToSend13mtemp == null){
%>
<%=requestToSend13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(requestToSend13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 22:
        gotMethod = true;
        String contactName_4id=  request.getParameter("contactName25");
            java.lang.String contactName_4idTemp = null;
        if(!contactName_4id.equals("")){
         contactName_4idTemp  = contactName_4id;
        }
        String location_5id=  request.getParameter("location27");
            java.lang.String location_5idTemp = null;
        if(!location_5id.equals("")){
         location_5idTemp  = location_5id;
        }
        String ipAddress_6id=  request.getParameter("ipAddress29");
            java.lang.String ipAddress_6idTemp = null;
        if(!ipAddress_6id.equals("")){
         ipAddress_6idTemp  = ipAddress_6id;
        }
        java.lang.String requestToReceive22mtemp = samplePatientDataExchangeProxyid.requestToReceive(contactName_4idTemp,location_5idTemp,ipAddress_6idTemp);
if(requestToReceive22mtemp == null){
%>
<%=requestToReceive22mtemp %>
<%
}else{
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(requestToReceive22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
}
break;
case 31:
        gotMethod = true;
        String username_7id=  request.getParameter("username34");
            java.lang.String username_7idTemp = null;
        if(!username_7id.equals("")){
         username_7idTemp  = username_7id;
        }
        String password_8id=  request.getParameter("password36");
            java.lang.String password_8idTemp = null;
        if(!password_8id.equals("")){
         password_8idTemp  = password_8id;
        }
        boolean checkLogin31mtemp = samplePatientDataExchangeProxyid.checkLogin(username_7idTemp,password_8idTemp);
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(checkLogin31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>