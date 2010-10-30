/**
 * AuthenService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.www;

public interface AuthenService extends javax.xml.rpc.Service {
    public java.lang.String getAuthenAddress();

    public com.www.Authen getAuthen() throws javax.xml.rpc.ServiceException;

    public com.www.Authen getAuthen(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
