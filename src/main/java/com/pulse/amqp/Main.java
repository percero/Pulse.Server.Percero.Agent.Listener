package com.pulse.amqp;

import java.util.Date;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.percero.agents.sync.services.ISyncAgentService;
import com.percero.agents.sync.services.SyncAgentService;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Agent;
import com.pulse.mo.LOBConfiguration;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.ThresholdExceededNotification;
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
//		PerceroAgentListener percero = PerceroAgentListener.getInstance();
//		AuthenticationRequest authRequest = new AuthenticationRequest();
//		authRequest.setClientId("TEST");
//		authRequest.setAuthProvider(PulseHttpAuthProvider.ID);
//		authRequest.setClientType("NP");
//		authRequest.setCredential("cbro3302@na.convergys.com:vavubKeifojCin0!");
//
//		percero.handleAuthRequest(authRequest, "authenticate", "TEST");
		
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

//		// Test HTTP Connectors
//		Map<String, Object> root = new HashMap<String, Object>();
//		root.put("query", "hello siri");
//
//		SyncAgentService syncAgentService = context.getBean(SyncAgentService.class);
//		try {
//			System.out.println(syncAgentService.runProcess("HTTP:AskGoogle", root, null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//		// Test StoredProc's Connectors
//		Map<String, Object> storedProcParams = new HashMap<String, Object>();
//		storedProcParams.put("lock_id", 12345);
//		storedProcParams.put("lock_date", "2015-09-23 23:12:01");
//
////		SyncAgentService syncAgentService = context.getBean(SyncAgentService.class);
//		try {
//			System.out.println(syncAgentService.runProcess("SQL_PROC:PULSE.MYTESTPROC", storedProcParams, null));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			PerceroList<IPerceroObject> allPulseUsers = syncAgentService.getAllByName(PulseUser.class.getCanonicalName(), true, null);
//			System.out.println(allPulseUsers.getTotalLength());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		ISyncAgentService syncAgentService = context.getBean(ISyncAgentService.class);
//		
//		// 100521449
//		try {
//			ClassIDPair cip = new ClassIDPair("100521449", TeamLeader.class.getCanonicalName());
//			TeamLeader teamLeader = new TeamLeader();
//			teamLeader.setID("100521449");
//			
//			Agent agent = new Agent();
//			agent.setID("100521449");
//			
//			LOBConfiguration lobConfiguration = new LOBConfiguration();
//			lobConfiguration.setID("ALE");
//			
//			ThresholdExceededNotification dtn = new ThresholdExceededNotification();
//			dtn.setAgent(agent);
//			dtn.setTeamLeader(teamLeader);
//			dtn.setDate(new Date());
//			dtn.setMessage("This only a test. Please ignore.");
//			dtn.setType("TEST");
//			dtn.setID(UUID.randomUUID().toString());
//			dtn.setName("TEST");
//			dtn.setLOBConfiguration(lobConfiguration);
//			try {
//				syncAgentService.systemCreateObject(dtn, null);
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			dtn.setName("My Other Name");
//			syncAgentService.systemPutObject(dtn, null, null, null, false);
//		} catch(Exception e1) {
//			e1.printStackTrace();
//		}
	}
}
