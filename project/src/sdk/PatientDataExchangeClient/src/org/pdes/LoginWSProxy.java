package org.pdes;

public class LoginWSProxy implements org.pdes.LoginWS {
  private String _endpoint = null;
  private org.pdes.LoginWS loginWS = null;
  
  public LoginWSProxy() {
    _initLoginWSProxy();
  }
  
  public LoginWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoginWSProxy();
  }
  
  private void _initLoginWSProxy() {
    try {
      loginWS = (new org.pdes.LoginWSServiceLocator()).getLoginWS();
      if (loginWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)loginWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)loginWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (loginWS != null)
      ((javax.xml.rpc.Stub)loginWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.pdes.LoginWS getLoginWS() {
    if (loginWS == null)
      _initLoginWSProxy();
    return loginWS;
  }
  
  public boolean checkLogin(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (loginWS == null)
      _initLoginWSProxy();
    return loginWS.checkLogin(username, password);
  }
  
  
}