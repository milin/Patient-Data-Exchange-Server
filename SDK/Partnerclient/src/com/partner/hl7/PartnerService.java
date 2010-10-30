/**
 * PartnerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.partner.hl7;

public interface PartnerService extends javax.xml.rpc.Service {
    public java.lang.String getPartnerAddress();

    public com.partner.hl7.Partner getPartner() throws javax.xml.rpc.ServiceException;

    public com.partner.hl7.Partner getPartner(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
