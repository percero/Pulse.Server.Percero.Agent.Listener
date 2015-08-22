package com.pulse.sync.cw;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.cw.DerivedValueChangeWatcherHelper;
import com.percero.agents.sync.vo.ClassIDPair;
import com.pulse.mo.Person;

@Component
public class PersonCWHelper extends DerivedValueChangeWatcherHelper {

	private static final Logger log = Logger.getLogger(PersonCWHelper.class);

	@Override
	public Object calculate(String fieldName, ClassIDPair pair) {
		return calculate(fieldName, pair, null);
	}
	
	@Override
	public Object calculate(String fieldName, ClassIDPair pair, String[] params) {
		Object result = null;
		Object oldValue = null;
		try {
			oldValue = accessManager.getChangeWatcherResult(pair, fieldName, params);
		} catch(Exception e) {}
		
		if (fieldName.equalsIgnoreCase("fullName")) {
			try {
				result = calc_fullName(pair);
				postCalculate(fieldName, pair, params, result, oldValue);
			} catch(Exception e) {
				log.error("Unable to calculate fullName", e);
			}
		}
		else {
			result = super.calculate(fieldName, pair, params);
		}
		
		return result;
	}
	
	public String calc_fullName(ClassIDPair pair) {
		String result = null;

		try {
			Person host = (Person) syncAgentService.systemGetById(pair);
			if (host == null) {
				log.warn("Unable to calculate fullName: Invalid objectId");
				return result;
			}
			
			// Setup fieldsToWatch.
			Collection<String> fieldsToWatch = new HashSet<String>();
			
			accessManager.addWatcherField(pair, "firstName", fieldsToWatch);
			accessManager.addWatcherField(pair, "lastName", fieldsToWatch);
			
			String firstName = host.getFirstName();
			String lastName = host.getLastName();
			
			boolean firstNameHasText = StringUtils.hasText(firstName);
			boolean lastNameHasText = StringUtils.hasText(lastName);
			
			if (firstNameHasText && lastNameHasText) {
				result = firstName + " " + lastName;
			}
			else if (firstNameHasText) {
				result = firstName;
			}
			else if (lastNameHasText) {
				result = lastName;
			}
			else {
				result = "";
			}
			
			accessManager.updateWatcherFields(pair, "fullName", fieldsToWatch);
			accessManager.saveChangeWatcherResult(pair, "fullName", result);
		} catch(Exception e) {
			log.error("Unable to calculate fullName", e);
		}
		
		return result;
	}


}
