
/**
 * PatientDataExchangeCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package org.pdes;

    /**
     *  PatientDataExchangeCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PatientDataExchangeCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PatientDataExchangeCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PatientDataExchangeCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for checkLogin method
            * override this method for handling normal response from checkLogin operation
            */
           public void receiveResultcheckLogin(
                    org.pdes.PatientDataExchangeStub.CheckLoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkLogin operation
           */
            public void receiveErrorcheckLogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for subscription method
            * override this method for handling normal response from subscription operation
            */
           public void receiveResultsubscription(
                    org.pdes.PatientDataExchangeStub.SubscriptionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from subscription operation
           */
            public void receiveErrorsubscription(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for hashPassword method
            * override this method for handling normal response from hashPassword operation
            */
           public void receiveResulthashPassword(
                    org.pdes.PatientDataExchangeStub.HashPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hashPassword operation
           */
            public void receiveErrorhashPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for requestToReceive method
            * override this method for handling normal response from requestToReceive operation
            */
           public void receiveResultrequestToReceive(
                    org.pdes.PatientDataExchangeStub.RequestToReceiveResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from requestToReceive operation
           */
            public void receiveErrorrequestToReceive(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendRecord method
            * override this method for handling normal response from sendRecord operation
            */
           public void receiveResultsendRecord(
                    org.pdes.PatientDataExchangeStub.SendRecordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendRecord operation
           */
            public void receiveErrorsendRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for requestToSend method
            * override this method for handling normal response from requestToSend operation
            */
           public void receiveResultrequestToSend(
                    org.pdes.PatientDataExchangeStub.RequestToSendResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from requestToSend operation
           */
            public void receiveErrorrequestToSend(java.lang.Exception e) {
            }
                


    }
    