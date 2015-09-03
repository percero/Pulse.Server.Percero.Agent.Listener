package com.pulse.amqp;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.percero.agents.auth.vo.AuthenticationRequest;
import com.percero.amqp.PerceroAgentListener;
import com.pulse.auth.service.PulseHttpAuthProvider;
/**
 * This class supplies the main method that creates the spring context
 * and then all processing is invoked asynchronously by messaging.
 * 
 * @author Percero
 *
 */
public class Main{
	/**
	 * Main function for starting the process
	 */
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"spring/percero-spring-config.xml","spring/*.xml"});
		System.out.println(context.toString());
		
		// Test Login
//		Map<String, Object> componentBeans = context.getBeansWithAnnotation(Component.class);
		PerceroAgentListener percero = PerceroAgentListener.getInstance();
		AuthenticationRequest authRequest = new AuthenticationRequest();
		authRequest.setClientId("TEST");
		authRequest.setAuthProvider(PulseHttpAuthProvider.ID);
		authRequest.setClientType("NP");
		authRequest.setCredential("cbro3302@na.convergys.com:vavubKeifojCin0!");
		
		percero.handleAuthRequest(authRequest, "authenticate", "TEST");
	}
}
