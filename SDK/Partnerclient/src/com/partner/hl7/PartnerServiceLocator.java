/**
 * PartnerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.partner.hl7;

public class PartnerServiceLocator extends org.apache.axis.client.Service implements com.partner.hl7.PartnerService {

    public PartnerServiceLocator() {
    }


    public PartnerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PartnerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Partner
    private java.lang.String Partner_address = "http://localhost:8082/Partner/services/Partner";

    public java.lang.String getPartnerAddress() {
        return Partner_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PartnerWSDDServiceName = "Partner";

    public java.lang.String getPartnerWSDDServiceName() {
        return PartnerWSDDServiceName;
    }

    public void setPartnerWSDDServiceName(java.lang.String name) {
        PartnerWSDDServiceName = name;
    }

    public com.partner.hl7.Partner getPartner() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Partner_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPartner(endpoint);
    }

    public com.partner.hl7.Partner getPartner(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.partner.hl7.PartnerSoapBindingStub _stub = new com.partner.hl7.PartnerSoapBindingStub(portAddress, this);
            _stub.setPortName(getPartnerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPartnerEndpointAddress(java.lang.String address) {
        Partner_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.partner.hl7.Partner.class.isAssignableFrom(serviceEndpointInterface)) {
                com.partner.hl7.PartnerSoapBindingStub _stub = new com.partner.hl7.PartnerSoapBindingStub(new java.net.URL(Partner_address), this);
                _stub.setPortName(getPartnerWSDDServiceName());
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
        if ("Partner".equals(inputPortName)) {
            return getPartner();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://hl7.partner.com", "PartnerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://hl7.partner.com", "Partner"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Partner".equals(portName)) {
            setPartnerEndpointAddress(address);
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
