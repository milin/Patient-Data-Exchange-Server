package com.partner.hl7;

public class PartnerProxy implements com.partner.hl7.Partner {
  private String _endpoint = null;
  private com.partner.hl7.Partner partner = null;
  
  public PartnerProxy() {
    _initPartnerProxy();
  }
  
  public PartnerProxy(String endpoint) {
    _endpoint = endpoint;
    _initPartnerProxy();
  }
  
  private void _initPartnerProxy() {
    try {
      partner = (new com.partner.hl7.PartnerServiceLocator()).getPartner();
      if (partner != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)partner)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)partner)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (partner != null)
      ((javax.xml.rpc.Stub)partner)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.partner.hl7.Partner getPartner() {
    if (partner == null)
      _initPartnerProxy();
    return partner;
  }
  
  public java.lang.String[] partener(java.lang.String users) throws java.rmi.RemoteException{
    if (partner == null)
      _initPartnerProxy();
    return partner.partener(users);
  }
  
  
}