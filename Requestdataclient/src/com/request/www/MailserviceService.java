/**
 * MailserviceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.request.www;

public interface MailserviceService extends javax.xml.rpc.Service {
    public java.lang.String getMailserviceAddress();

    public com.request.www.Mailservice getMailservice() throws javax.xml.rpc.ServiceException;

    public com.request.www.Mailservice getMailservice(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
