package org.pdes;

public class PatientDataExchangeProxy implements org.pdes.PatientDataExchange {
  private String _endpoint = null;
  private org.pdes.PatientDataExchange patientDataExchange = null;
  
  public PatientDataExchangeProxy() {
    _initPatientDataExchangeProxy();
  }
  
  public PatientDataExchangeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPatientDataExchangeProxy();
  }
  
  private void _initPatientDataExchangeProxy() {
    try {
      patientDataExchange = (new org.pdes.PatientDataExchangeServiceLocator()).getPatientDataExchange();
      if (patientDataExchange != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)patientDataExchange)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)patientDataExchange)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (patientDataExchange != null)
      ((javax.xml.rpc.Stub)patientDataExchange)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.pdes.PatientDataExchange getPatientDataExchange() {
    if (patientDataExchange == null)
      _initPatientDataExchangeProxy();
    return patientDataExchange;
  }
  
  public java.lang.String requestToSend(java.lang.String srcHosp, java.lang.String destHosp, java.lang.String hData) throws java.rmi.RemoteException{
    if (patientDataExchange == null)
      _initPatientDataExchangeProxy();
    return patientDataExchange.requestToSend(srcHosp, destHosp, hData);
  }
  
  public java.lang.String requestToReceive(java.lang.String contactName, java.lang.String location, java.lang.String ipAddress) throws java.rmi.RemoteException{
    if (patientDataExchange == null)
      _initPatientDataExchangeProxy();
    return patientDataExchange.requestToReceive(contactName, location, ipAddress);
  }
  
  public boolean checkLogin(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (patientDataExchange == null)
      _initPatientDataExchangeProxy();
    return patientDataExchange.checkLogin(username, password);
  }
  
  
}