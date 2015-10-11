package com.pulse.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.metadata.MappedField;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.agents.sync.vo.ClassIDPairs;
import com.percero.framework.vo.IPerceroObject;
import com.percero.framework.vo.PerceroList;
import com.pulse.dataprovider.IConnectionFactory;
import com.pulse.dataprovider.PulseDataConnectionRegistry;

public abstract class HybridSqlDataAccessObject<T extends IPerceroObject> implements IHybridSqlDataAccessObject<T> {

	static final Logger log = Logger.getLogger(SqlDataAccessObject.class);
	
	public HybridSqlDataAccessObject() {
		super();
	}
	
	PulseDataConnectionRegistry connectionRegistry;
	public PulseDataConnectionRegistry getConnectionRegistry() {
		if (connectionRegistry == null) {
			connectionRegistry = PulseDataConnectionRegistry.getInstance();
		}
		return connectionRegistry;
	}
	
	protected String getIdColumnName() {
		return "ID";
	}

	protected String getInternalSelect(Boolean shellOnly) {
		if (shellOnly) {
			return getInternalSelectShellOnlySQL();
		}
		else {
			return getInternalSelectStarSQL();
		}
	}
	
	protected String getExternalSelect(Boolean shellOnly) {
		if (shellOnly) {
			return getExternalSelectShellOnlySQL();
		}
		else {
			return getExternalSelectStarSQL();
		}
	}
	
	protected String getInternalSelectIn(Boolean shellOnly) {
		if (shellOnly) {
			return getInternalSelectInShellOnlySQL();
		}
		else {
			return getInternalSelectInStarSQL();
		}
	}
	
	protected String getExternalSelectIn(Boolean shellOnly) {
		if (shellOnly) {
			return getExternalSelectInShellOnlySQL();
		}
		else {
			return getExternalSelectInStarSQL();
		}
	}
	
	protected String getInternalSelectByRelationship(String joinColumnName, Boolean shellOnly) {
		if (shellOnly) {
			return getInternalSelectByRelationshipShellOnlySQL(joinColumnName);
		}
		else {
			return getInternalSelectByRelationshipStarSQL(joinColumnName);
		}
	}
	
	protected String getExternalSelectByRelationship(String joinColumnName, Boolean shellOnly) {
		if (shellOnly) {
			return getExternalSelectByRelationshipShellOnlySQL(joinColumnName);
		}
		else {
			return getExternalSelectByRelationshipStarSQL(joinColumnName);
		}
	}
	
	protected String getInternalSelectAllSql(Boolean shellOnly) {
		if (shellOnly) {
			return getInternalSelectAllShellOnlySQL();
		}
		else {
			return getInternalSelectAllStarSQL();
		}
	}

	protected String getExternalSelectAllSql(Boolean shellOnly) {
		if (shellOnly) {
			return getExternalSelectAllShellOnlySQL();
		}
		else {
			return getExternalSelectAllStarSQL();
		}
	}
	
	protected String getInternalFindByExampleSelectSql(Boolean shellOnly) {
		if (shellOnly) {
			return getInternalFindByExampleSelectShellOnlySQL();
		}
		else {
			return getInternalFindByExampleSelectAllStarSQL();
		}
	}
	
	protected String getExternalFindByExampleSelectSql(Boolean shellOnly) {
		if (shellOnly) {
			return getExternalFindByExampleSelectShellOnlySQL();
		}
		else {
			return getExternalFindByExampleSelectAllStarSQL();
		}
	}
	
	
	
	
	@Override
	public T createObject(T perceroObject, String userId)
			throws SyncException {
		throw new SyncDataException(SyncDataException.READ_ONLY_ERROR, SyncDataException.READ_ONLY_ERROR_CODE);
	}

	@Override
	public T retrieveObject(ClassIDPair classIdPair, String userId,
			Boolean shellOnly) throws SyncException {
		T result = null;
		
		String externalSql = getExternalSelect(shellOnly);
		String internalSql = getInternalSelect(shellOnly);
		List<T> results = executeSelectById(externalSql, internalSql, classIdPair.getID(), shellOnly);

		if (results != null && !results.isEmpty()) {
			result = results.get(0);
		}

		return result;
	}
	
	@Override
	public List<T> retrieveObjects(ClassIDPairs classIdPairs,
			String userId, Boolean shellOnly) throws SyncException {
		// We are just selecting all the columns for this object, which map to Properties and Source Relationship ID's.
		// The order of these in the SELECT doesn't matter, it just needs to match the same order that we are retrieving them
		// below when we fill in the actual object.
		List<T> results = new ArrayList<T>();

		String questionMarkString = "";
		for(int i=0; i<classIdPairs.getIds().size(); i++) {
			if (i > 0) {
				questionMarkString += ",";
			}
			questionMarkString += "?";
		}

		// TODO: Build up ?'s for each id in the list and then set the PreparedStatement indexed values.
		
		String externalSql = getExternalSelectIn(shellOnly);
		externalSql = externalSql.replace("?", questionMarkString);
		String internalSql = getInternalSelectIn(shellOnly);
		internalSql = internalSql.replace("?", questionMarkString);
		
		Connection externalConn = null;
		PreparedStatement externalPstmt = null;
		Connection internalConn = null;
		PreparedStatement internalPstmt = null;
        ResultSet externalResultSet = null;
        ResultSet internalResultSet = null;

        try {
			// External
			IConnectionFactory externalConnectionFactory = getConnectionRegistry().getConnectionFactory(getExternalConnectionFactoryName());
			externalConn = externalConnectionFactory.getConnection();
			externalPstmt = externalConn.prepareStatement(externalSql);
			
			// Internal
			IConnectionFactory internalConnectionFactory = getConnectionRegistry().getConnectionFactory(getInternalConnectionFactoryName());
			internalConn = internalConnectionFactory.getConnection();
			internalPstmt = internalConn.prepareStatement(internalSql);

			// Insert ID's into queries.
			int counter = 1;	// PreparedStatement index starts at 1.
			Iterator<String> itrIds = classIdPairs.getIds().iterator();
			while (itrIds.hasNext()) {
				String nextId = itrIds.next();
				externalPstmt.setString(counter, nextId);
				internalPstmt.setString(counter, nextId);
				counter++;
			}
			
			externalResultSet = externalPstmt.executeQuery();
			internalResultSet = internalPstmt.executeQuery();
			
			results = retrieveHybridResults(externalResultSet, internalResultSet, shellOnly);
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
                if (externalResultSet != null) externalResultSet.close();
				if (externalPstmt != null) {
					externalPstmt.close();
				}
				if (externalConn != null) {
					externalConn.close();
				}
                if (internalResultSet != null) internalResultSet.close();
				if (internalPstmt != null) {
					internalPstmt.close();
				}
				if (internalConn != null) {
					internalConn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
		
		return results;
	}

	@Override
	public List<T> retrieveAllByRelationship(MappedField mappedField, ClassIDPair targetClassIdPair, Boolean shellOnly, String userId) throws SyncException {
		
		String externalSql = null;
		String internalSql = null;
		
		// This mapped field is either in External OR Internal.
		if (getExternalPropertyNames().contains(mappedField.getField().getName())) {
			getExternalSelectByRelationship(mappedField.getJoinColumnName(), shellOnly);
		}
		else {
			internalSql = getInternalSelectByRelationship(mappedField.getJoinColumnName(), shellOnly);
		}
		
		List<T> results = executeSelectById(externalSql, internalSql, targetClassIdPair.getID(), shellOnly);
		return results;
	}
	
	public List<T> findByExample(T theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException {
		return null;
	}

	/**
	 * @param results
	 * @param isUser
	 * @param selectQueryString
	 * @return
	 * @throws SyncDataException
	 */
	protected List<T> executeSelect(String selectExternalQueryString, String selectInternalQueryString, Boolean shellOnly)
			throws SyncDataException {
		return executeSelectById(selectExternalQueryString, selectInternalQueryString, null, shellOnly);
	}
	
	protected List<T> executeSelectById(String selectExternalQueryString, String selectInternalQueryString, String id, Boolean shellOnly)
			throws SyncDataException {
		List<T> results = new ArrayList<T>();
		
		// Open the database session.
		Connection externalConnection = null;
		PreparedStatement externalPstmt = null;
		Connection internalConnection = null;
		PreparedStatement internalPstmt = null;
        ResultSet externalResultSet = null;
        ResultSet internalResultSet = null;
		
		try {
			// External

			if (StringUtils.hasText(selectExternalQueryString)) {
				IConnectionFactory externalConnectionFactory = getConnectionRegistry().getConnectionFactory(getExternalConnectionFactoryName());
				externalConnection = externalConnectionFactory.getConnection();
				externalPstmt = externalConnection.prepareStatement(selectExternalQueryString);
				if (StringUtils.hasText(id)) {
					externalPstmt.setString(1, id);
				}
				externalResultSet = externalPstmt.executeQuery();
			}

			// Internal

			if (StringUtils.hasText(selectInternalQueryString)) {
				IConnectionFactory internalConnectionFactory = getConnectionRegistry().getConnectionFactory(getInternalConnectionFactoryName());
				internalConnection = internalConnectionFactory.getConnection();
				internalPstmt = internalConnection.prepareStatement(selectInternalQueryString);
				if (StringUtils.hasText(id)) {
					internalPstmt.setString(1, id);
				}
				internalResultSet = internalPstmt.executeQuery();
			}
			
			results = retrieveHybridResults(externalResultSet, internalResultSet, shellOnly);
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
                if(externalResultSet != null) externalResultSet.close();
				if (externalPstmt != null) {
					externalPstmt.close();
				}
				if (externalConnection != null) {
					externalConnection.close();
				}
                if(internalResultSet != null) internalResultSet.close();
				if (internalPstmt != null) {
					internalPstmt.close();
				}
				if (internalConnection != null) {
					internalConnection.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
		
		return results;
	}
	
	protected List<T> retrieveHybridResults(ResultSet externalResultSet, ResultSet internalResultSet, Boolean shellOnly) throws SQLException {
		List<T> results = new ArrayList<T>();
		
		Map<String, T> mappedResults = new HashMap<String, T>();
		if (externalResultSet != null) {
			while (externalResultSet.next()) {
				T nextResult = extractObjectFromExternalResultSet(externalResultSet, shellOnly, null);
				results.add(nextResult);
				mappedResults.put(nextResult.getID(), nextResult);
			}
		}

		if (internalResultSet != null) {
			while (internalResultSet.next()) {
				T existingResult = mappedResults.get(internalResultSet.getString(getIdColumnName()));
				T nextResult = extractObjectFromInternalResultSet(internalResultSet, shellOnly, existingResult);
				if (existingResult == null) {
					results.add(nextResult);
					mappedResults.put(nextResult.getID(), nextResult);
				}
			}
		}

		return results;
	}
	

	protected List<T> executeSelectWithParams(String selectExternalQueryString,
			Object[] externalParamValues, String selectInternalQueryString,
			Object[] internalParamValues, Boolean shellOnly)
			throws SyncDataException {
		List<T> results = new ArrayList<T>();
		
		// Open the database session.
		Connection externalConn = null;
		PreparedStatement externalPstmt = null;
		Connection internalConn = null;
		PreparedStatement internalPstmt = null;
        ResultSet externalResultSet = null;
        ResultSet internalResultSet = null;

        try {
			// External
			IConnectionFactory externalConnectionFactory = getConnectionRegistry().getConnectionFactory(getExternalConnectionFactoryName());
			externalConn = externalConnectionFactory.getConnection();
			externalPstmt = externalConn.prepareStatement(selectExternalQueryString);
			
			for(int i=0; i<externalParamValues.length; i++) {
				externalPstmt.setObject(i+1, externalParamValues[i]);
			}
			
			externalResultSet = externalPstmt.executeQuery();
			Map<String, T> externalMappedResults = new HashMap<String, T>();
			while (externalResultSet.next()) {
				T nextResult = extractObjectFromExternalResultSet(externalResultSet, shellOnly, null);
				externalMappedResults.put(nextResult.getID(), nextResult);
				results.add(nextResult);
			}
			
			// Internal
			IConnectionFactory internalConnectionFactory = getConnectionRegistry().getConnectionFactory(getInternalConnectionFactoryName());
			internalConn = internalConnectionFactory.getConnection();
			internalPstmt = internalConn.prepareStatement(selectInternalQueryString);
			
			for(int i=0; i<internalParamValues.length; i++) {
				internalPstmt.setObject(i+1, internalParamValues[i]);
			}
			
			internalResultSet = internalPstmt.executeQuery();
			Map<String, T> internalMappedResults = new HashMap<String, T>();
			while (internalResultSet.next()) {
				T existingResult = externalMappedResults.get(internalResultSet.getString(getIdColumnName()));
				T nextResult = extractObjectFromInternalResultSet(internalResultSet, shellOnly, existingResult);
				
				if (existingResult == null) {
					results.add(nextResult);
				}
				internalMappedResults.put(nextResult.getID(), nextResult);
			}
			
			// Now retrieve the corresponding object for results that aren't in both mapped results.
			// Finish loading Internal from found External
			Iterator<Entry<String, T>> itrExternalMappedResults = externalMappedResults.entrySet().iterator();
			while (itrExternalMappedResults.hasNext()) {
				Entry<String, T> nextExternalEntrySet = itrExternalMappedResults.next();
				
				if (!internalMappedResults.containsKey(nextExternalEntrySet.getKey())) {
					// Need to finish loading this object.
					internalPstmt = internalConn.prepareStatement(getInternalSelect(shellOnly));
					internalResultSet = internalPstmt.executeQuery();
					while (internalResultSet.next()) {
						extractObjectFromInternalResultSet(internalResultSet, shellOnly, nextExternalEntrySet.getValue());
					}
				}
			}
			
			// Finish loading External from found Internal
			Iterator<Entry<String, T>> itrInternalMappedResults = internalMappedResults.entrySet().iterator();
			while (itrInternalMappedResults.hasNext()) {
				Entry<String, T> nextInternalEntrySet = itrInternalMappedResults.next();
				
				if (!internalMappedResults.containsKey(nextInternalEntrySet.getKey())) {
					// Need to finish loading this object.
					externalPstmt = externalConn.prepareStatement(getExternalSelect(shellOnly));
					externalResultSet = externalPstmt.executeQuery();
					while (internalResultSet.next()) {
						extractObjectFromExternalResultSet(externalResultSet, shellOnly, nextInternalEntrySet.getValue());
					}
				}
			}
			
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
                if (externalResultSet != null) externalResultSet.close();
				if (externalPstmt != null) {
					externalPstmt.close();
				}
				if (externalConn != null) {
					externalConn.close();
				}
                if(internalResultSet != null) internalResultSet.close();
				if (internalPstmt != null) {
					internalPstmt.close();
				}
				if (internalConn != null) {
					internalConn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
		
		return results;
	}
	
	@Override
	public PerceroList<T> getAll(Integer pageNumber, Integer pageSize, Boolean returnTotal, String userId, Boolean shellOnly) throws Exception {
		
		boolean useLimit = pageNumber != null && pageSize != null && pageSize > 0;
		String externalSql = null;
		String internalSql = null;
		
		if (useLimit) {
			if (shellOnly) {
				externalSql = getExternalSelectAllShellOnlyWithLimitAndOffsetSQL();
				internalSql = getInternalSelectAllShellOnlyWithLimitAndOffsetSQL();
			}
			else {
				externalSql = getExternalSelectAllStarWithLimitAndOffsetSQL();
				internalSql = getInternalSelectAllStarWithLimitAndOffsetSQL();
			}
		}
		else {
			externalSql = getExternalSelectAllSql(shellOnly);
			internalSql = getInternalSelectAllSql(shellOnly);
		}
		List<T> objects = new ArrayList<T>();
		
		// Open the database session.
		Connection externalConnection = null;
		PreparedStatement externalPstmt = null;
		Connection internalConnection = null;
		PreparedStatement internalPstmt = null;
        ResultSet externalResultSet = null;
        ResultSet internalResultSet = null;
        try {
			// TODO: External needs to be the gold standard for COUNT/LIMIT/OFFSET.
			// External
			IConnectionFactory externalConnectionFactory = getConnectionRegistry().getConnectionFactory(getExternalConnectionFactoryName());
			externalConnection = externalConnectionFactory.getConnection();
			externalPstmt = externalConnection.prepareStatement(externalSql);
			if (useLimit) {
				externalPstmt.setInt(1, pageSize);
				externalPstmt.setInt(2, pageNumber);
			}
			externalResultSet = externalPstmt.executeQuery();
			
			// Internal
			IConnectionFactory internalConnectionFactory = getConnectionRegistry().getConnectionFactory(getInternalConnectionFactoryName());
			internalConnection = internalConnectionFactory.getConnection();
			internalPstmt = internalConnection.prepareStatement(internalSql);
			if (useLimit) {
				internalPstmt.setInt(1, pageSize);
				internalPstmt.setInt(2, pageNumber);
			}
			internalResultSet = internalPstmt.executeQuery();
			
			objects = retrieveHybridResults(externalResultSet, internalResultSet, shellOnly);
			
		} catch(Exception e) {
			log.error("Unable to getAll", e);
			throw new SyncDataException(e);
		} finally {
			try {
                if (externalResultSet != null) externalResultSet.close();
				if (externalPstmt != null) {
					externalPstmt.close();
				}
				if (externalConnection != null) {
					externalConnection.close();
				}
                if (internalResultSet != null) internalResultSet.close();
				if (internalPstmt != null) {
					internalPstmt.close();
				}
				if (internalConnection != null) {
					internalConnection.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
		
		PerceroList<T> results = new PerceroList<T>(objects);
		results.setPageNumber(pageNumber);
		results.setPageSize(pageSize);
		
		if (returnTotal) {
			Integer total = countAll(userId);
			results.setTotalLength(total);
		}

		return results;
	}
	
	public Integer countAll(String userId) throws SyncException {

		// External is the gold standard
		String externalSql = getExternalCountAllSQL();
		
		// Open the database session.
		Connection externalConn = null;
		Statement externalStmt = null;
        ResultSet rs = null;
		try {
			IConnectionFactory externalConnectionFactory = getConnectionRegistry().getConnectionFactory(getExternalConnectionFactoryName());
			externalConn = externalConnectionFactory.getConnection();
			externalStmt = externalConn.createStatement();
			
	        rs = externalStmt.executeQuery(externalSql);
	        if (rs.next()) {
	        	return rs.getInt(1);
	        }
	        else {
	        	return null;
	        }
		} catch(Exception e) {
			log.error("Unable to countAll", e);
			throw new SyncDataException(e);
		} finally {
			try {
                if(rs != null)
                    rs.close();
				if (externalStmt != null) {
					externalStmt.close();
				}
				if (externalConn != null) {
					externalConn.close();
				}

			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}

	}
	

	@Override
	public T updateObject(T perceroObject,
			Map<ClassIDPair, Collection<MappedField>> changedFields, String userId)
			throws SyncException {
		if (!hasUpdateAccess(BaseDataObject.toClassIdPair(perceroObject), userId)) {
			return null;
		}
		
		// We can only update INTERNAL properties.
		Connection internalConn = null;
		PreparedStatement internalPstmt = null;
		try {
			IConnectionFactory internalConnectionFactory = getConnectionRegistry().getConnectionFactory(getInternalConnectionFactoryName());
			internalConn = internalConnectionFactory.getConnection();
			
			// First we need to see if this object exists.
			List<T> existingInternalObjects = executeSelectById(null, getInternalSelect(true), perceroObject.getID(), true);

			String sql = null;
			if (existingInternalObjects != null && !existingInternalObjects.isEmpty()) {
				// This is an update.
				sql = getUpdateSet();
				internalPstmt = internalConn.prepareStatement(sql);
				setPreparedStatmentUpdateParams(perceroObject, internalPstmt);
			}
			else {
				// This is a create.
				sql = getInsertInto();
				internalPstmt = internalConn.prepareStatement(sql);
				setPreparedStatmentInsertParams(perceroObject, internalPstmt);
			}
			
			int result = internalPstmt.executeUpdate();

			if (result > 0) {
				return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
			}
			else {
				return null;
			}
		} catch(Exception e) {
			log.error("Unable to updateObject", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (internalPstmt != null) {
					internalPstmt.close();
				}
				if (internalConn != null) {
					internalConn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
	}


	public Boolean deleteObject(ClassIDPair classIdPair, String userId)
			throws SyncException {
		throw new SyncDataException(SyncDataException.READ_ONLY_ERROR, SyncDataException.READ_ONLY_ERROR_CODE);
	}

	/* (non-Javadoc)
	 * @see com.pulse.mo.dao.IHybridSqlDataAccessObject#hasCreateAccess(com.percero.agents.sync.vo.ClassIDPair, java.lang.String)
	 */
	@Override
	public Boolean hasCreateAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}

	/* (non-Javadoc)
	 * @see com.pulse.mo.dao.IHybridSqlDataAccessObject#hasReadAccess(com.percero.agents.sync.vo.ClassIDPair, java.lang.String)
	 */
	@Override
	public Boolean hasReadAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}

	/* (non-Javadoc)
	 * @see com.pulse.mo.dao.IHybridSqlDataAccessObject#hasUpdateAccess(com.percero.agents.sync.vo.ClassIDPair, java.lang.String)
	 */
	@Override
	public Boolean hasUpdateAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}

	/* (non-Javadoc)
	 * @see com.pulse.mo.dao.IHybridSqlDataAccessObject#hasDeleteAccess(com.percero.agents.sync.vo.ClassIDPair, java.lang.String)
	 */
	@Override
	public Boolean hasDeleteAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}


//	protected String getInsertIntoSQL() throws SyncDataException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<Object> runQuery(String queryName, Object[] queryArguments, String userId) throws SyncException {
		return null;
	}

	// TODO: Fill this out
	public 	T cleanObjectForUser(T perceroObject,
			String userId) {
		return perceroObject;
	}
}