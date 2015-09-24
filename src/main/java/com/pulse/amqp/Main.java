package com.pulse.amqp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.percero.agents.auth.vo.AuthenticationRequest;
import com.percero.agents.sync.services.SyncAgentService;
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
	@SuppressWarnings("resource")
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
		
//		// Test HTTP Connectors
//		Map<String, Object> root = new HashMap<String, Object>();
//		root.put("clientName", "CONVERGYS");
//		root.put("userName", "mobileapp");
//		root.put("password", "mobile");
//		root.put("value", "10851886002");
//
//		SyncAgentService syncAgentService = context.getBean(SyncAgentService.class);
//		try {
//			System.out.println(syncAgentService.runProcess("HTTP:EmployeeAccruals", root, null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		// Test StoredProc's Connectors
		Map<String, Object> storedProcParams = new HashMap<String, Object>();
		storedProcParams.put("lock_id", 12345);
		storedProcParams.put("lock_date", "2015-09-23 23:12:01");

		SyncAgentService syncAgentService = context.getBean(SyncAgentService.class);
		try {
			System.out.println(syncAgentService.runProcess("SQL_PROC:PULSE.MYTESTPROC", storedProcParams, null));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
