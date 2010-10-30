/**
 * RequestsendServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.request.hl7;

public class RequestsendServiceLocator extends org.apache.axis.client.Service implements com.request.hl7.RequestsendService {

    public RequestsendServiceLocator() {
    }


    public RequestsendServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RequestsendServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Requestsend
    private java.lang.String Requestsend_address = "http://localhost:8082/Requestsend/services/Requestsend";

    public java.lang.String getRequestsendAddress() {
        return Requestsend_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RequestsendWSDDServiceName = "Requestsend";

    public java.lang.String getRequestsendWSDDServiceName() {
        return RequestsendWSDDServiceName;
    }

    public void setRequestsendWSDDServiceName(java.lang.String name) {
        RequestsendWSDDServiceName = name;
    }

    public com.request.hl7.Requestsend getRequestsend() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Requestsend_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRequestsend(endpoint);
    }

    public com.request.hl7.Requestsend getRequestsend(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.request.hl7.RequestsendSoapBindingStub _stub = new com.request.hl7.RequestsendSoapBindingStub(portAddress, this);
            _stub.setPortName(getRequestsendWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRequestsendEndpointAddress(java.lang.String address) {
        Requestsend_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.request.hl7.Requestsend.class.isAssignableFrom(serviceEndpointInterface)) {
                com.request.hl7.RequestsendSoapBindingStub _stub = new com.request.hl7.RequestsendSoapBindingStub(new java.net.URL(Requestsend_address), this);
                _stub.setPortName(getRequestsendWSDDServiceName());
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
        if ("Requestsend".equals(inputPortName)) {
            return getRequestsend();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://hl7.request.com", "RequestsendService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://hl7.request.com", "Requestsend"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Requestsend".equals(portName)) {
            setRequestsendEndpointAddress(address);
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
