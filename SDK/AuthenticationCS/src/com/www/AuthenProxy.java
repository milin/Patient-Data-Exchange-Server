package com.www;

public class AuthenProxy implements com.www.Authen {
  private String _endpoint = null;
  private com.www.Authen authen = null;
  
  public AuthenProxy() {
    _initAuthenProxy();
  }
  
  public AuthenProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenProxy();
  }
  
  private void _initAuthenProxy() {
    try {
      authen = (new com.www.AuthenServiceLocator()).getAuthen();
      if (authen != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authen)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authen)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authen != null)
      ((javax.xml.rpc.Stub)authen)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.www.Authen getAuthen() {
    if (authen == null)
      _initAuthenProxy();
    return authen;
  }
  
  public boolean checklogin(java.lang.String user, java.lang.String pass) throws java.rmi.RemoteException{
    if (authen == null)
      _initAuthenProxy();
    return authen.checklogin(user, pass);
  }
  
  
}