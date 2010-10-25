/**
 * AuthenServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.www;

public class AuthenServiceLocator extends org.apache.axis.client.Service implements com.www.AuthenService {

    public AuthenServiceLocator() {
    }


    public AuthenServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthenServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Authen
    private java.lang.String Authen_address = "http://localhost:8080/Authentication/services/Authen";

    public java.lang.String getAuthenAddress() {
        return Authen_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuthenWSDDServiceName = "Authen";

    public java.lang.String getAuthenWSDDServiceName() {
        return AuthenWSDDServiceName;
    }

    public void setAuthenWSDDServiceName(java.lang.String name) {
        AuthenWSDDServiceName = name;
    }

    public com.www.Authen getAuthen() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Authen_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAuthen(endpoint);
    }

    public com.www.Authen getAuthen(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.www.AuthenSoapBindingStub _stub = new com.www.AuthenSoapBindingStub(portAddress, this);
            _stub.setPortName(getAuthenWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuthenEndpointAddress(java.lang.String address) {
        Authen_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.www.Authen.class.isAssignableFrom(serviceEndpointInterface)) {
                com.www.AuthenSoapBindingStub _stub = new com.www.AuthenSoapBindingStub(new java.net.URL(Authen_address), this);
                _stub.setPortName(getAuthenWSDDServiceName());
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
        if ("Authen".equals(inputPortName)) {
            return getAuthen();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.com", "AuthenService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.com", "Authen"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Authen".equals(portName)) {
            setAuthenEndpointAddress(address);
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
