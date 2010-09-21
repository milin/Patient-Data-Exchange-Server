/**
 * PatientDataExchangeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.pdes;

public class PatientDataExchangeServiceLocator extends org.apache.axis.client.Service implements org.pdes.PatientDataExchangeService {

    public PatientDataExchangeServiceLocator() {
    }


    public PatientDataExchangeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PatientDataExchangeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PatientDataExchange
    private java.lang.String PatientDataExchange_address = "http://localhost:8080/PatientDataExchange/services/PatientDataExchange";

    public java.lang.String getPatientDataExchangeAddress() {
        return PatientDataExchange_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PatientDataExchangeWSDDServiceName = "PatientDataExchange";

    public java.lang.String getPatientDataExchangeWSDDServiceName() {
        return PatientDataExchangeWSDDServiceName;
    }

    public void setPatientDataExchangeWSDDServiceName(java.lang.String name) {
        PatientDataExchangeWSDDServiceName = name;
    }

    public org.pdes.PatientDataExchange getPatientDataExchange() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PatientDataExchange_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPatientDataExchange(endpoint);
    }

    public org.pdes.PatientDataExchange getPatientDataExchange(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.pdes.PatientDataExchangeSoapBindingStub _stub = new org.pdes.PatientDataExchangeSoapBindingStub(portAddress, this);
            _stub.setPortName(getPatientDataExchangeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPatientDataExchangeEndpointAddress(java.lang.String address) {
        PatientDataExchange_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.pdes.PatientDataExchange.class.isAssignableFrom(serviceEndpointInterface)) {
                org.pdes.PatientDataExchangeSoapBindingStub _stub = new org.pdes.PatientDataExchangeSoapBindingStub(new java.net.URL(PatientDataExchange_address), this);
                _stub.setPortName(getPatientDataExchangeWSDDServiceName());
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
        if ("PatientDataExchange".equals(inputPortName)) {
            return getPatientDataExchange();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://pdes.org", "PatientDataExchangeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://pdes.org", "PatientDataExchange"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PatientDataExchange".equals(portName)) {
            setPatientDataExchangeEndpointAddress(address);
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
