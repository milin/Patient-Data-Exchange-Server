package org.pdes;

import javax.jws.WebMethod;
import org.apache.axis2.context.MessageContext;

public class NetworkProvider {
	
	@WebMethod(operationName = "getIP")
	public String getIP(){
		MessageContext context = MessageContext.getCurrentMessageContext();
		String ip = (String)context.getProperty(MessageContext.REMOTE_ADDR);
		System.out.println("Client IP Address : " + ip); // Show the client ip address to console
		return ip;
	}
}
