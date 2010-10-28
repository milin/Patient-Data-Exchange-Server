package com.request.www;

public class MailserviceProxy implements com.request.www.Mailservice {
  private String _endpoint = null;
  private com.request.www.Mailservice mailservice = null;
  
  public MailserviceProxy() {
    _initMailserviceProxy();
  }
  
  public MailserviceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMailserviceProxy();
  }
  
  private void _initMailserviceProxy() {
    try {
      mailservice = (new com.request.www.MailserviceServiceLocator()).getMailservice();
      if (mailservice != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mailservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mailservice)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mailservice != null)
      ((javax.xml.rpc.Stub)mailservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.request.www.Mailservice getMailservice() {
    if (mailservice == null)
      _initMailserviceProxy();
    return mailservice;
  }
  
  public void sendmail() throws java.rmi.RemoteException{
    if (mailservice == null)
      _initMailserviceProxy();
    mailservice.sendmail();
  }
  
  
}