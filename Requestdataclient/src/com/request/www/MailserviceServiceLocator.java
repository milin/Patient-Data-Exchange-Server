/**
 * MailserviceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.request.www;

public class MailserviceServiceLocator extends org.apache.axis.client.Service implements com.request.www.MailserviceService {

    public MailserviceServiceLocator() {
    }


    public MailserviceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MailserviceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Mailservice
    private java.lang.String Mailservice_address = "http://localhost:8082/Requestdata/services/Mailservice";

    public java.lang.String getMailserviceAddress() {
        return Mailservice_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MailserviceWSDDServiceName = "Mailservice";

    public java.lang.String getMailserviceWSDDServiceName() {
        return MailserviceWSDDServiceName;
    }

    public void setMailserviceWSDDServiceName(java.lang.String name) {
        MailserviceWSDDServiceName = name;
    }

    public com.request.www.Mailservice getMailservice() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Mailservice_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMailservice(endpoint);
    }

    public com.request.www.Mailservice getMailservice(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.request.www.MailserviceSoapBindingStub _stub = new com.request.www.MailserviceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMailserviceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMailserviceEndpointAddress(java.lang.String address) {
        Mailservice_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.request.www.Mailservice.class.isAssignableFrom(serviceEndpointInterface)) {
                com.request.www.MailserviceSoapBindingStub _stub = new com.request.www.MailserviceSoapBindingStub(new java.net.URL(Mailservice_address), this);
                _stub.setPortName(getMailserviceWSDDServiceName());
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
        if ("Mailservice".equals(inputPortName)) {
            return getMailservice();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.request.com", "MailserviceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.request.com", "Mailservice"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Mailservice".equals(portName)) {
            setMailserviceEndpointAddress(address);
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
