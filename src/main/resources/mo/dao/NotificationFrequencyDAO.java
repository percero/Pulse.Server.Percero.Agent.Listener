


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.ActiveStackSqlSessionFactory;
import com.percero.agents.sync.dao.IActiveStackSqlQuery;
import com.percero.agents.sync.dao.IActiveStackSqlSession;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.metadata.MappedField;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.agents.sync.vo.ClassIDPairs;
import com.percero.framework.vo.IPerceroObject;

import com.pulsemobile.mo.NotificationFrequency;

/*Why these?
import com.pulsemobile.mo.Person;
*/

@Component
public class NotificationFrequencyDAO extends SqlDataAccessObject<NotificationFrequency> implements IDataAccessObject<NotificationFrequency> {

	static final Logger log = Logger.getLogger(NotificationFrequencyDAO.class);
	
	private static final String DATA_SOURCE_NAME = "dataSource";
	
	@Autowired
	ActiveStackSqlSessionFactory sessionFactory;
	public void setSessionFactory(ActiveStackSqlSessionFactory value) {
		sessionFactory = value;
	}

	public NotificationFrequencyDAO() {
		
	}
	
	@Override
	public List<IPerceroObject> findAllRelatedObjects(
			IPerceroObject perceroObject, MappedField mappedField,
			Boolean shellOnly, String userId) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationFrequency readObjectFromDatabase(ClassIDPair classIdPair, String userId,
			Boolean shellOnly) throws SyncException {
		NotificationFrequency result = null;
		
		boolean isUser = StringUtils.hasText(userId);

		String selectQueryString = null;
		if (shellOnly) {
			selectQueryString = "SELECT ID FROM NotificationFrequency WHERE ID=:id";
		}
		else {
			selectQueryString = "SELECT ID, value, person_ID FROM NotificationFrequency WHERE ID=:id";
		}

		// Open the database session.
		IActiveStackSqlSession s = null;
		try {
			s = sessionFactory.retrieveOpenSession(DATA_SOURCE_NAME);
			IActiveStackSqlQuery query = null;

			query = overlayReadQuery(classIdPair.getClassName(), userId, isUser,
					selectQueryString, s);
			
			query.setString("id", classIdPair.getID());

			if (shellOnly) {
				String nextId = (String) query.uniqueResult();
				if (StringUtils.hasText(nextId)) {
					result = new NotificationFrequency();
					result.setID(nextId);
				}
			}
			else {
				Object[] queryResult = (Object[]) query.uniqueResult();
				if (queryResult != null) {
					result = new NotificationFrequency();
					
					// Properties
	 				result.setID((String) queryResult[0]);
					result.setValue((String) queryResult[1]);
		
					// Source Relationships
					Person person = new Person();
					person.setID((String) queryResult[2]);
					result.setPerson(person);
				}
			}
		} catch(Exception e) {
			log.error("Unable to readObjectFromDatabase", e);
			throw new SyncDataException(e);
		} finally {
			s.close();
		}
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<NotificationFrequency> readObjectsFromDatabase(ClassIDPairs classIdPairs,
			String userId) throws SyncException {
		List<NotificationFrequency> results = new ArrayList<NotificationFrequency>();
		
		Set<String> idsSet = new HashSet<String>(classIdPairs.getIds().size());
		idsSet.addAll(classIdPairs.getIds());
		
		boolean isUser = StringUtils.hasText(userId);
		
		String selectQueryString = "SELECT ID, value, person_ID FROM NotificationFrequency WHERE ID IN (:idsSet)";
		
		// Open the database session.
		IActiveStackSqlSession s = null;
		try {
			s = sessionFactory.retrieveOpenSession(DATA_SOURCE_NAME);
			IActiveStackSqlQuery query = null;
			
			query = overlayReadQuery(classIdPairs.getClassName(), userId, isUser,
					selectQueryString, s);
			
			query.setParameterList("idsSet", idsSet);
			List queryResults = query.list();
			
			Iterator itrQueryResults = queryResults.iterator();
			while (itrQueryResults.hasNext()) {
				Object[] nextResult = (Object[]) itrQueryResults.next();
				
				NotificationFrequency nextNotificationFrequency = new NotificationFrequency();
				
				// Properties
				nextNotificationFrequency.setID((String) nextResult[0]);
				nextNotificationFrequency.setValue((String) nextResult[1]);
				
				// Source Relationships
				Person person = new Person();
				person.setID((String) nextResult[2]);
				nextNotificationFrequency.setPerson(person);
				
				results.add(nextNotificationFrequency);
			}
		} catch(Exception e) {
			log.error("Unable to readObjectsFromDatabase", e);
			throw new SyncDataException(e);
		} finally {
			s.close();
		}
		
		return results;
	}

	@Override
	public Boolean insertObjectIntoDatabase(NotificationFrequency perceroObject, String userId)
			throws SyncException {
		if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
			return false;
		}
		
		String createString = "INSERT INTO NotificationFrequency (ID, value, person_ID) VALUES :ID, :value, :person_ID";
		
		IActiveStackSqlSession s = sessionFactory.retrieveOpenSession(DATA_SOURCE_NAME);
		try {
			IActiveStackSqlQuery query = s.createSQLQuery(createString);

			query.setString("ID", perceroObject.getID());
			query.setString("value", perceroObject.getValue());
			query.setString("person_ID", perceroObject.getPerson() != null ? perceroObject.getPerson().getID() : null);
			
			int queryResult = query.executeUpdate();
			return (queryResult > 0);
			
		} catch(Exception e) {
			log.error("Unable to insertObjectIntoDatabase", e);
			throw new SyncDataException(e);
		} finally {
			s.close();
		}
	}

	@Override
	public Boolean updateObjectInDatabase(NotificationFrequency perceroObject,
			Map<ClassIDPair, Collection<MappedField>> changedFields, String userId)
			throws SyncException {
		if (!hasUpdateAccess(BaseDataObject.toClassIdPair(perceroObject), userId)) {
			return false;
		}
		
		// Never update the ID.
		String updateString = "UPDATE NotificationFrequency SET value=:value, person_ID=:person_ID WHERE ID=:ID";
		
		IActiveStackSqlSession s = sessionFactory.retrieveOpenSession(DATA_SOURCE_NAME);
		try {
			IActiveStackSqlQuery query = s.createSQLQuery(updateString);
			query.setString("ID", perceroObject.getID());
			query.setString("value", perceroObject.getValue());
			query.setString("person_ID", perceroObject.getPerson() != null ? perceroObject.getPerson().getID() : null);
			
			int queryResult = query.executeUpdate();
			return (queryResult > 0);
		} catch(Exception e) {
			log.error("Unable to updateObjectInDatabase", e);
			throw new SyncDataException(e);
		} finally {
			s.close();
		}
	}
	
	@Override
	public Boolean deleteObjectFromDatabase(ClassIDPair classIdPair, String userId)
			throws SyncException {
		if ( !hasDeleteAccess(classIdPair, userId) ) {
			return false;
		}
		
		String deleteQueryString = "DELETE FROM NotificationFrequency WHERE ID=:ID";
		
		IActiveStackSqlSession s = sessionFactory.retrieveOpenSession(DATA_SOURCE_NAME);
		IActiveStackSqlQuery query = s.createSQLQuery(deleteQueryString);
		query.setParameter("ID", classIdPair.getID());
		
		query.executeUpdate();
		
		// Even if no rows are deleted, the end result is success (the row no longer exists in the database.
		return true;
	}

	@Override
	public List<NotificationFrequency> findByExample(NotificationFrequency theQueryObject,
			List<String> excludeProperties) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}
}
