/**
 * PatientDataExchangeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.pdes;

public interface PatientDataExchangeService extends javax.xml.rpc.Service {
    public java.lang.String getPatientDataExchangeAddress();

    public org.pdes.PatientDataExchange getPatientDataExchange() throws javax.xml.rpc.ServiceException;

    public org.pdes.PatientDataExchange getPatientDataExchange(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
