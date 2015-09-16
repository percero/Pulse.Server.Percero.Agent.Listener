package com.pulse.mo.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.metadata.MappedClassManagerFactory;
import com.percero.agents.sync.metadata.MappedField;
import com.percero.agents.sync.metadata.MappedFieldDate;
import com.percero.agents.sync.metadata.MappedFieldDouble;
import com.percero.agents.sync.metadata.MappedFieldFloat;
import com.percero.agents.sync.metadata.MappedFieldInt;
import com.percero.agents.sync.metadata.MappedFieldInteger;
import com.percero.agents.sync.metadata.MappedFieldPerceroObject;
import com.percero.agents.sync.metadata.MappedFieldString;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.agents.sync.vo.ClassIDPairs;
import com.percero.framework.vo.IPerceroObject;
import com.percero.framework.vo.PerceroList;
import com.pulse.dataprovider.IConnectionFactory;
import com.pulse.dataprovider.PulseDataConnectionRegistry;

public abstract class SqlStatementDataAccessObject<T extends IPerceroObject> implements IDataAccessObject<T> {

	static final Logger log = Logger.getLogger(SqlStatementDataAccessObject.class);
	
	public SqlStatementDataAccessObject() {
		super();
	}
	
	@Autowired
	PulseDataConnectionRegistry connectionRegistry;
	public void setConnectionRegistry(PulseDataConnectionRegistry value) {
		connectionRegistry = value;
	}
	
	protected String getConnectionFactoryName() {
		return null;
	}
	
	
	protected String getSelectStatement(Boolean shellOnly) throws SyncException {
		throw new SyncException(SyncException.METHOD_NOT_IMPLEMENTED, SyncException.METHOD_NOT_IMPLEMENTED_CODE);
	}
	
	protected String getSelectInStatement(Boolean shellOnly) throws SyncException {
		throw new SyncException(SyncException.METHOD_NOT_IMPLEMENTED, SyncException.METHOD_NOT_IMPLEMENTED_CODE);
	}
	
	protected String getSelectAllByRelationshipStatement(Boolean shellOnly) throws SyncException {
		throw new SyncException(SyncException.METHOD_NOT_IMPLEMENTED, SyncException.METHOD_NOT_IMPLEMENTED_CODE);
	}
	
	protected String getSelectByExampleStatement(Boolean shellOnly) throws SyncException {
		throw new SyncException(SyncException.METHOD_NOT_IMPLEMENTED, SyncException.METHOD_NOT_IMPLEMENTED_CODE);
	}
	
	protected String getSelectAllStatement(Boolean shellOnly) throws SyncException {
		throw new SyncException(SyncException.METHOD_NOT_IMPLEMENTED, SyncException.METHOD_NOT_IMPLEMENTED_CODE);
	}
	
	protected String getCountAllStatement() throws SyncException {
		throw new SyncException(SyncException.METHOD_NOT_IMPLEMENTED, SyncException.METHOD_NOT_IMPLEMENTED_CODE);
	}
	
	

	public T retrieveObject(ClassIDPair classIdPair, String userId,
			Boolean shellOnly) throws SyncException {
		T result = null;
		
		String selectStatement = getSelectStatement(shellOnly);
		selectStatement = selectStatement.replaceAll(":id", "'" + classIdPair.getID() + "'");

		if (StringUtils.hasText(userId)) {
			selectStatement = selectStatement.replaceAll(":userId", "'" + userId + "'");
		}
		else {
			selectStatement = selectStatement.replaceAll(":userId", "null");
		}
		
		List<T> results = executeSelect(selectStatement, shellOnly);
		if (results != null && !results.isEmpty()) {
			result = results.get(0);
		}

		return result;
	}
	
	public List<T> retrieveObjects(ClassIDPairs classIdPairs,
			String userId, Boolean shellOnly) throws SyncException {
		String idsString = collectionToCsvString(classIdPairs.getIds(), "'");

		String selectStatement = getSelectInStatement(shellOnly);
		selectStatement = selectStatement.replaceAll(":ids", idsString);

		if (StringUtils.hasText(userId)) {
			selectStatement = selectStatement.replaceAll(":userId", "'" + userId + "'");
		}
		else {
			selectStatement = selectStatement.replaceAll(":userId", "null");
		}
		
		List<T> results = executeSelect(selectStatement, shellOnly);

		return results;
	}

	public List<T> retrieveAllByRelationship(MappedField mappedField, ClassIDPair targetClassIdPair, Boolean shellOnly, String userId) throws SyncException {
		String selectStatement = getSelectAllByRelationshipStatement(shellOnly);
		selectStatement = selectStatement.replaceAll(":joinFieldName", mappedField.getJoinColumnName());
		selectStatement = selectStatement.replaceAll(":targetId", "'" + targetClassIdPair.getID() + "'");

		if (StringUtils.hasText(userId)) {
			selectStatement = selectStatement.replaceAll(":userId", "'" + userId + "'");
		}
		else {
			selectStatement = selectStatement.replaceAll(":userId", "null");
		}
		
		List<T> results = executeSelect(selectStatement, shellOnly);
		return results;
	}
	
	public List<T> findByExample(T theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException {
		T result = null;
		
		String selectStatement = getSelectByExampleStatement(shellOnly);
		selectStatement = selectStatement.replaceAll(":id", "'" + classIdPair.getID() + "'");

		if (StringUtils.hasText(userId)) {
			selectStatement = selectStatement.replaceAll(":userId", "'" + userId + "'");
		}
		else {
			selectStatement = selectStatement.replaceAll(":userId", "null");
		}
		
		List<T> results = executeSelect(selectStatement, shellOnly);
		if (results != null && !results.isEmpty()) {
			result = results.get(0);
		}

		return result;
	}

	public PerceroList<T> getAll(Integer pageNumber, Integer pageSize, Boolean returnTotal, String userId, Boolean shellOnly) throws Exception {
		
		String selectStatement = getSelectAllStatement(shellOnly);
		
		if (pageNumber != null && pageSize != null && pageSize > 0) {
			selectStatement = selectStatement.replaceAll(":limit", pageSize.toString());
			selectStatement = selectStatement.replaceAll(":offset", pageNumber.toString());
		}
		
		if (StringUtils.hasText(userId)) {
			selectStatement = selectStatement.replaceAll(":userId", "'" + userId + "'");
		}
		else {
			selectStatement = selectStatement.replaceAll(":userId", "null");
		}
		
		List<T> objects = executeSelect(selectStatement, shellOnly);
		
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

		Integer count = null;
		String selectStatement = getCountAllStatement();
		
		if (StringUtils.hasText(userId)) {
			selectStatement = selectStatement.replaceAll(":userId", "'" + userId + "'");
		}
		else {
			selectStatement = selectStatement.replaceAll(":userId", "null");
		}
		
		Long result = executeSelectCount(selectStatement);
		if (result != null) {
			count = result.intValue();
		}
		
		return count;
	}
	
	protected Long executeSelectCount(String sqlStatement)
			throws SyncDataException {
		// Open the database session.
		Connection conn = null;
		Statement stmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			stmt = conn.createStatement();
			
	        ResultSet rs = stmt.executeQuery(sqlStatement);
	        if (rs.next()) {
	        	return rs.getLong(0);
	        }
	        else {
	        	return null;
	        }
		} catch(Exception e) {
			log.error("Unable to executeSelectCount", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
	}
	
	protected int executeUpdate(String sqlStatement) throws SyncDataException {
		Connection conn = null;
		Statement stmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			stmt = conn.createStatement();
			
	        int queryResult = stmt.executeUpdate(sqlStatement);
			return queryResult;
			
		} catch(Exception e) {
			log.error("Unable to executeUpdate", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
	}

	public T createObject(T perceroObject, String userId)
			throws SyncException {
		MappedClass mappedClass = MappedClassManagerFactory.getMappedClassManager().getMappedClassByClassName(perceroObject.getClass().getCanonicalName());
		if (mappedClass == null) {
			log.warn("Missing MappedClass for " + perceroObject.getClass().getCanonicalName());
			throw new SyncException(SyncException.MISSING_MAPPED_CLASS_ERROR, SyncException.MISSING_MAPPED_CLASS_ERROR_CODE );
		}
		
		if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
			return null;
		}

		T result = null;
		
		String createStatement = getCreateStatement();
		createStatement = createStatement.replaceAll(":id", "'" + perceroObject.getID() + "'");

		if (StringUtils.hasText(userId)) {
			createStatement = createStatement.replaceAll(":userId", "'" + userId + "'");
		}
		else {
			createStatement = createStatement.replaceAll(":userId", "null");
		}

		for(MappedField nextMappedField : mappedClass.propertyFields) {
			createStatement = createStatement.replaceAll(":" + nextMappedField.getColumnName() + get;
			valuesString += ":" + nextMappedField.getColumnName();
			i++;
		}
		for(MappedFieldPerceroObject nextMappedField : mappedClass.toOneFields) {
			if (nextMappedField.isSourceEntity()) {
				if (i > 0) {
					createString += ", ";
					valuesString += ", ";
				}
				createString += nextMappedField.getJoinColumnName();
				valuesString += ":" + nextMappedField.getJoinColumnName();
				i++;
			}
		}
		createString += ") VALUES (" + valuesString + ")";
		
		
		
		int createResult = executeUpdate(createStatement);
		if (createResult > 0) {
			return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
		}
		else {
			return null;
		}
		
	}
	
	protected String getDatabaseValueFromMappedField(IPerceroObject perceroObject, MappedField mappedField) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String result = "";
		
		if (perceroObject != null && mappedField != null) {
			if (mappedField instanceof MappedFieldString) {
				String value = (String) mappedField.getValue(perceroObject);
				if (value == null) {
					result = "null";
				}
				else {
					result = "'" + value + "'";
				}
			}
			else if (mappedField instanceof MappedFieldInt || mappedField instanceof MappedFieldInteger) {
				Integer value = (Integer) mappedField.getValue(perceroObject);
				if (value == null) {
					result = "0";
				}
				else {
					result = value.toString();
				}
			}
			else if (mappedField instanceof MappedFieldDouble) {
				Double value = (Double) mappedField.getValue(perceroObject);
				if (value == null) {
					result = "0.0";
				}
				else {
					result = value.toString();
				}
			}
			else if (mappedField instanceof MappedFieldFloat) {
				Float value = (Float) mappedField.getValue(perceroObject);
				if (value == null) {
					result = "0.0";
				}
				else {
					result = value.toString();
				}
			}
			else if (mappedField instanceof MappedFieldDate) {
				Date value = (Date) mappedField.getValue(perceroObject);
				if (value == null || value.getTime() <= 0) {
					result = "null";
				}
				else {
					
					result = value.toString();
				}
			}
		}
		
		return result;
	}
	
	public T updateObject(T perceroObject,
			Map<ClassIDPair, Collection<MappedField>> changedFields, String userId)
			throws SyncException {
		if (!hasUpdateAccess(BaseDataObject.toClassIdPair(perceroObject), userId)) {
			return null;
		}
		
		String updateStatement = buildUpdateStatement(perceroObject).toString();
		
		int queryResult = executeUpdate(updateStatement);
		if (queryResult > 0) {
			return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
		}
		else {
			return null;
		}
	}

	public Boolean deleteObject(ClassIDPair classIdPair, String userId)
			throws SyncException {
		if ( !hasDeleteAccess(classIdPair, userId) ) {
			return false;
		}
		
		StringBuilder sb = new StringBuilder(getDeleteFrom());
		sb.append(" WHERE ").append(getIdColumnName()).append("='").append(classIdPair.getID()).append("'");
		
		return executeStatement(sb.toString());
	}

	/**
	 * @param sb
	 * @return
	 * @throws SyncDataException
	 */
	protected Boolean executeStatement(String sqlStatement)
			throws SyncDataException {
		Connection conn = null;
		Statement stmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			stmt = conn.createStatement();
			
	        stmt.execute(sqlStatement);

	        // Even if no rows are deleted, the end result is success (the row no longer exists in the database.
			return true;
			
		} catch(Exception e) {
			log.error("Unable to deleteObject", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
	}

	protected String getDeleteFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasCreateAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}

	@Override
	public Boolean hasReadAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}

	@Override
	public Boolean hasUpdateAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}

	@Override
	public Boolean hasDeleteAccess(ClassIDPair classIdPair, String userId) {
		// Defaults to true
		return true;
	}

	


	protected String collectionToCsvString(Collection<String> collection, String stringDelimeter) {
		if (collection == null || collection.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		boolean firstPass = true;
		Iterator<String> itrCollection = collection.iterator();
		while (itrCollection.hasNext()) {
			String nextItem = itrCollection.next();
			if (firstPass) {
				firstPass = false;
			}
			else {
				sb.append(',');
			}
			if (stringDelimeter != null) {
				sb.append(stringDelimeter);
			}
			sb.append(nextItem);
			if (stringDelimeter != null) {
				sb.append(stringDelimeter);
			}
		}
		
		return sb.toString();
	}

	protected String getInsertInto() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Responsible for building the VALUES section of the INSERT INTO Sql statement.
	 * @param sb
	 * @return
	 */
	protected StringBuilder buildInsertValues(T perceroObject, StringBuilder sb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String buildStringValue(String value) {
		if (value != null) {
			return "'" + value + "'";
		}
		else {
			return "null";
		}
	}
	
	protected String buildPerceroObjectIdValue(IPerceroObject value) {
		if (value != null) {
			return "'" + value.getID() + "'";
		}
		else {
			return "null";
		}
	}

	protected String getUpdateSet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected StringBuilder buildUpdateStatement(T perceroObject) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getUpdateSet());
		buildUpdateValues(perceroObject, sb);
		sb.append(" WHERE ").append(getIdColumnName()).append("=").append(buildPerceroObjectIdValue(perceroObject));

		return sb;
	}

	protected StringBuilder buildUpdateValues(T perceroObject, StringBuilder sb) {
		// TODO Auto-generated method stub
		return sb;
	}

	public List<Object> runQuery(String queryName, Object[] queryArguments, String userId) throws SyncException {
		return null;
	}

	// TODO: Fill this out
	public 	T cleanObjectForUser(T perceroObject,
			String userId) {
		return perceroObject;
	}


	////////////////////////////////////////
	// EXECUTE
	////////////////////////////////////////

	/**
	 * @param selectQueryString
	 * @param shellOnly
	 * @return
	 * @throws SyncDataException
	 */
	protected List<T> executeSelect(String selectQueryString, Boolean shellOnly)
			throws SyncDataException {
		List<T> results = new ArrayList<T>();
		
		// Open the database session.
		Connection conn = null;
		Statement stmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			stmt = conn.createStatement();
			
	        ResultSet rs = stmt.executeQuery(selectQueryString);
	        while (rs.next()) {
	        	T nextResult = extractObjectFromResultSet(rs, shellOnly);
    			results.add(nextResult);
	        }
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
		
		return results;
	}
	
	protected T extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
		throw new SQLException("Method must be overridden");
	}

	protected List<T> executePreparetStatment(PreparedStatement pstmt, Connection conn, Boolean pleaseCloseConnection)
			throws SyncDataException {
		List<T> results = new ArrayList<T>();
		
		// Open the database session.
		Connection conn = null;
		Statement stmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(selectQueryString);
			while (rs.next()) {
				T nextResult = extractObjectFromResultSet(rs, shellOnly);
				results.add(nextResult);
			}
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
		
		return results;
	}

}