/**
 * LoginWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.pdes;

public class LoginWSServiceLocator extends org.apache.axis.client.Service implements org.pdes.LoginWSService {

    public LoginWSServiceLocator() {
    }


    public LoginWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoginWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LoginWS
    private java.lang.String LoginWS_address = "http://localhost:8080/PatientDataExchange/services/LoginWS";

    public java.lang.String getLoginWSAddress() {
        return LoginWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LoginWSWSDDServiceName = "LoginWS";

    public java.lang.String getLoginWSWSDDServiceName() {
        return LoginWSWSDDServiceName;
    }

    public void setLoginWSWSDDServiceName(java.lang.String name) {
        LoginWSWSDDServiceName = name;
    }

    public org.pdes.LoginWS getLoginWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LoginWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLoginWS(endpoint);
    }

    public org.pdes.LoginWS getLoginWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.pdes.LoginWSSoapBindingStub _stub = new org.pdes.LoginWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getLoginWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoginWSEndpointAddress(java.lang.String address) {
        LoginWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.pdes.LoginWS.class.isAssignableFrom(serviceEndpointInterface)) {
                org.pdes.LoginWSSoapBindingStub _stub = new org.pdes.LoginWSSoapBindingStub(new java.net.URL(LoginWS_address), this);
                _stub.setPortName(getLoginWSWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LoginWS".equals(inputPortName)) {
            return getLoginWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://pdes.org", "LoginWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://pdes.org", "LoginWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LoginWS".equals(portName)) {
            setLoginWSEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
