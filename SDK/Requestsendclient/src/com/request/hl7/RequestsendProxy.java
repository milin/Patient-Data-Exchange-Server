package com.request.hl7;

public class RequestsendProxy implements com.request.hl7.Requestsend {
  private String _endpoint = null;
  private com.request.hl7.Requestsend requestsend = null;
  
  public RequestsendProxy() {
    _initRequestsendProxy();
  }
  
  public RequestsendProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestsendProxy();
  }
  
  private void _initRequestsendProxy() {
    try {
      requestsend = (new com.request.hl7.RequestsendServiceLocator()).getRequestsend();
      if (requestsend != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestsend)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestsend)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestsend != null)
      ((javax.xml.rpc.Stub)requestsend)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.request.hl7.Requestsend getRequestsend() {
    if (requestsend == null)
      _initRequestsendProxy();
    return requestsend;
  }
  
  public void sendemail(java.lang.String receiptent, java.lang.String firstname, java.lang.String lastname, java.lang.String age, java.lang.String sex) throws java.rmi.RemoteException{
    if (requestsend == null)
      _initRequestsendProxy();
    requestsend.sendemail(receiptent, firstname, lastname, age, sex);
  }
  
  
}