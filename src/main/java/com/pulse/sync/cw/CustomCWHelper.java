//package com.pulse.sync.cw;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.UUID;
//
//import javax.annotation.PostConstruct;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.percero.agents.sync.cw.ChangeWatcherHelper;
//import com.percero.agents.sync.cw.ChangeWatcherHelperFactory;
//import com.percero.agents.sync.exceptions.SyncException;
//import com.percero.agents.sync.services.ISyncAgentService;
//import com.percero.agents.sync.vo.ClassIDPair;
//import com.percero.framework.vo.IPerceroObject;
//import com.pulse.mo.Person;
//
//@Component
//public class CustomCWHelper extends ChangeWatcherHelper {
//
//	private static final Logger log = Logger.getLogger(CustomCWHelper.class);
//	
//	private static final String CATEGORY = "CUSTOM";
//	private static final String SUB_CATEGORY = "";
//	
//	@Autowired
//	protected ISyncAgentService syncAgentService;
//	public void setSyncAgentService(ISyncAgentService value) {
//		syncAgentService = value;
//	}
//	public ISyncAgentService getSyncAgentService() {
//		return syncAgentService;
//	}
//
//	@PostConstruct
//	public void initialize() {
//		ChangeWatcherHelperFactory.getInstance().registerChangeWatcherHelper(CATEGORY, this);
//		registerChangeWatchers();
//	}
//	
//	public void registerChangeWatchers() {
//		Collection<String> fieldsToWatch = new HashSet<String>();
//		// Listen for changes to fullName for ALL Persons.
//		accessManager.addWatcherField(new ClassIDPair("0", Person.class.getCanonicalName()), "", fieldsToWatch);
//		accessManager.updateWatcherFields(CATEGORY, SUB_CATEGORY, "runMyTest", fieldsToWatch);
//	}
//
//	@Override
//	public void process(String category, String subCategory, String fieldName) {
//		process(category, subCategory, fieldName, null);
//	}
//	
//	@Override
//	public void process(String category, String subCategory, String fieldName, String[] params) {
//		if (fieldName.equalsIgnoreCase("runMyTest")) {
//			try {
//				calc_fullName(category, subCategory, fieldName);
//			} catch(Exception e) {
//				log.error("Unable to process runMyTest", e);
//			}
//		}
//		else {
//			super.process(category, subCategory, fieldName, params);
//		}
//	}
//	
//	public static int counter = 0;
//	public static Person lastPerson = null;
//	
//	public void calc_fullName(String category, String subCategory, String fieldName) throws Exception {
//		System.out.println("We did it!");
//		counter++;
//		
//		if (counter <= 6) {
//			if (lastPerson != null) {
//				Person thePerson = lastPerson;
//				lastPerson = null;
//				syncAgentService.systemDeleteObject(thePerson, null, true);
//			}
//			else {
//				lastPerson = new Person();
//				lastPerson.setFirstName("Counter");
//				lastPerson.setLastName("" + counter);
//				lastPerson.setUserId(UUID.randomUUID().toString());
//				lastPerson = syncAgentService.systemCreateObject(lastPerson, null);
//			}
//		}
//		else if (counter <= 8) {
//			Person example = new Person();
//			example.setFirstName("Collin");
//			List<IPerceroObject> persons = syncAgentService.systemFindByExample(example, null);
//			
//			if (persons != null && !persons.isEmpty()) {
//				Person firstPerson = (Person) persons.get(0);
//				
//				firstPerson.setLastName("Brown" + counter);
//				syncAgentService.systemPutObject(firstPerson, null, null, null, true);
//			}
//		}
//		else if (counter == 9) {
//			Person example = new Person();
//			example.setFirstName("Collin");
//			List<IPerceroObject> persons = syncAgentService.systemFindByExample(example, null);
//			
//			if (persons != null && !persons.isEmpty()) {
//				Person firstPerson = (Person) persons.get(0);
//				
//				firstPerson.setLastName("Brown");
//				syncAgentService.systemPutObject(firstPerson, null, null, null, true);
//			}
//		}
//	}
//
//
//}
