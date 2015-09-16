package com.pulse.mo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
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
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.agents.sync.vo.ClassIDPairs;
import com.percero.framework.vo.IPerceroObject;
import com.percero.framework.vo.PerceroList;
import com.pulse.dataprovider.IConnectionFactory;
import com.pulse.dataprovider.PulseDataConnectionRegistry;

public abstract class SqlDataAccessObject<T extends IPerceroObject> implements IDataAccessObject<T> {

	static final Logger log = Logger.getLogger(SqlDataAccessObject.class);
	
	public SqlDataAccessObject() {
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
	
	protected String getIdColumnName() {
		return "ID";
	}

	protected String getSelectStar() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getSelectShellOnly() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getSelect(Boolean shellOnly) {
		if (shellOnly) {
			return getSelectShellOnly();
		}
		else {
			return getSelectStar();
		}
	}
	
	protected String getSelectAllSql(Boolean shellOnly) {
		if (shellOnly) {
			return getSelectAllShellOnly();
		}
		else {
			return getSelectAllStar();
		}
	}

	protected String getSelectAllStar() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getSelectAllShellOnly() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getCountAllSql() {
		return null;
	}
	
	protected String getFullTableName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void test() {
//		OracleDataSource ods = new OracleDataSource();
//		String url = "jdbc:oracle:thin:@//myhost:5221/orcl";
//		ods.setURL(url);
//		ods.setUser("HR");
//		ods.setPassword("hr");
//		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//
//	    // Connect to the database
//	    // You can put a database name after the @ sign in the connection URL.
//		String url = "jdbc:oracle:thin:HR/hr@myTNSEntry");
//		ods.setURL(url);
//		Connection conn = ods.getConnection();
//	    
//		conn =
//	      DriverManager.getConnection ("jdbc:oracle:oci8:@", "scott", "tiger");
//	    
//	    // Create a statement
//	    Statement stmt = conn.createStatement ();
//
//	    // Create the stored function
//	    stmt.execute ("create or replace function RAISESAL (name CHAR, raise NUMBER) return NUMBER is begin return raise + 100000; end;");
//
//	    // Close the statement
//	    stmt.close();
//	    
//		CallableStatement cstmt = conn.prepareCall ("{? = call RAISESAL (?, ?)}");
//		
//		// Declare that the first ? is a return value of type Int
//	    cstmt.registerOutParameter (1, Types.INTEGER);
//
//	    // We want to raise LESLIE's salary by 20,000
//	    cstmt.setString (2, "LESLIE");  // The name argument is the second ?
//	    cstmt.setInt (3, 20000);        // The raise argument is the third ?
//	  
//	    // Do the raise
//	    cstmt.execute ();
//
//	    // Get the new salary back
//	    int new_salary = cstmt.getInt (1);
//
//	    System.out.println ("The new salary is: " + new_salary);
//
//	    // Close the statement
//	    cstmt.close();
//
//	    // Close the connection
//	    conn.close();
	}

	public List<T> getAllByRelationship(MappedField mappedField, ClassIDPair targetClassIdPair, Boolean shellOnly, String userId) throws SyncException {

		StringBuilder sb = new StringBuilder(getSelect(shellOnly));
		sb.append(" WHERE ").append(getFullTableName()).append('.').append(mappedField.getJoinColumnName()).append("='").append(targetClassIdPair.getID()).append("'");
		
		String selectQueryString = sb.toString();
		if ( StringUtils.hasText(userId) ) {
			selectQueryString = selectQueryString.replaceAll(":userId", "'" + userId + "'");
		}
		
		List<T> results = executeSelect(selectQueryString, shellOnly);
		return results;
	}
	

	public T retrieveObject(ClassIDPair classIdPair, String userId,
			Boolean shellOnly) throws SyncException {
		T result = null;
		
		StringBuilder sb = new StringBuilder(getSelect(shellOnly));
		sb.append(" WHERE ").append(getFullTableName()).append(".").append(getIdColumnName()).append("='").append(classIdPair.getID()).append("'");
		
		String selectQueryString = sb.toString();
		if ( StringUtils.hasText(userId) ) {
			selectQueryString = selectQueryString.replaceAll(":userId", "'" + userId + "'");
		}
		
		List<T> results = executeSelect(selectQueryString, shellOnly);
		if (results != null && !results.isEmpty()) {
			result = results.get(0);
		}

		return result;
	}
	
	public List<T> retrieveObjects(ClassIDPairs classIdPairs,
			String userId, Boolean shellOnly) throws SyncException {
		// We are just selecting all the columns for this object, which map to Properties and Source Relationship ID's.
		// The order of these in the SELECT doesn't matter, it just needs to match the same order that we are retrieving them
		// below when we fill in the actual object.
		String idsString = collectionToCsvString(classIdPairs.getIds(), "'");

		StringBuilder sb = new StringBuilder(getSelect(shellOnly));
		sb.append(" WHERE ").append(getFullTableName()).append(".").append(getIdColumnName()).append(" IN (").append(idsString).append(")");
		
		String selectQueryString = sb.toString();
		if ( StringUtils.hasText(userId) ) {
			selectQueryString = selectQueryString.replaceAll(":userId", "'" + userId + "'");
		}
		
		List<T> results = executeSelect(selectQueryString, shellOnly);
		
		return results;
	}

	public List<T> retrieveAllByRelationship(MappedField mappedField, ClassIDPair targetClassIdPair, Boolean shellOnly, String userId) throws SyncException {
		
		StringBuilder sb = new StringBuilder(getSelect(shellOnly));
		sb.append(" WHERE ").append(getFullTableName()).append(".").append(mappedField.getJoinColumnName()).append("='").append(targetClassIdPair.getID()).append("'");
		
		String selectQueryString = sb.toString();
		if ( StringUtils.hasText(userId) ) {
			selectQueryString = selectQueryString.replaceAll(":userId", "'" + userId + "'");
		}
		
		List<T> results = executeSelect(selectQueryString, shellOnly);
		return results;
	}
	
	public List<T> findByExample(T theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param results
	 * @param isUser
	 * @param selectQueryString
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
//			String queryString = overlayReadQuery(className, userId,
//					selectQueryString);
			
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

	public PerceroList<T> getAll(Integer pageNumber, Integer pageSize, Boolean returnTotal, String userId, Boolean shellOnly) throws Exception {
		
		StringBuilder sb = new StringBuilder(getSelectAllSql(shellOnly));
		String selectQueryString = sb.toString();
		
		if (pageNumber != null && pageSize != null && pageSize > 0) {
			selectQueryString.replaceAll(":limit", pageSize.toString());
			selectQueryString.replaceAll(":offset", pageNumber.toString());
		}
		
		if ( StringUtils.hasText(userId) ) {
			selectQueryString = selectQueryString.replaceAll(":userId", "'" + userId + "'");
		}
		
		List<T> objects = executeSelect(selectQueryString, shellOnly);
		
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
		StringBuilder sb = new StringBuilder(getCountAllSql());
		String selectQueryString = sb.toString();
		
		if ( StringUtils.hasText(userId) ) {
			selectQueryString = selectQueryString.replaceAll(":userId", "'" + userId + "'");
		}
		
		Long result = executeSelectCount(selectQueryString);
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
//			String queryString = overlayReadQuery(className, userId,
//					selectQueryString);
			
	        ResultSet rs = stmt.executeQuery(sqlStatement);
	        if (rs.next()) {
	        	return rs.getLong(0);
	        }
	        else {
	        	return null;
	        }
		} catch(Exception e) {
			log.error("Unable to executeStatement", e);
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
	
	/**
	 * @param classIdPairs
	 * @param userId
	 * @param selectQueryString
	 * @return
	 * @throws SyncException
	 * @throws Exception
	 */
	protected String overlayReadQuery(String className, String userId,
			String selectQueryString)
					throws SyncException, Exception {
		MappedClass mappedClass = MappedClassManagerFactory
				.getMappedClassManager().getMappedClassByClassName(className);
		if (mappedClass == null) {
			log.warn("Missing MappedClass for "
					+ className);
			throw new SyncException(
					SyncException.MISSING_MAPPED_CLASS_ERROR,
					SyncException.MISSING_MAPPED_CLASS_ERROR_CODE);
		}

		return overlayReadQuery(mappedClass, userId, selectQueryString);
	}

	/**
	 * @param classIdPairs
	 * @param userId
	 * @param selectQueryString
	 * @return
	 * @throws SyncException
	 * @throws Exception
	 */
	protected String overlayReadQuery(MappedClass mappedClass, String userId,
			String selectQueryString)
			throws SyncException, Exception {
		String result = "";
		
		// If the Read Query/Filter uses the ID, then we need to check against
		// each ID here.
		boolean isUser = StringUtils.hasText(userId);
		if (isUser) {
			boolean isValidReadQuery = false;
			if (mappedClass != null) {
				// If no UserID, then no reason to check the ReadQuery.
				if (!StringUtils.hasText(userId)
						&& mappedClass.getReadQuery() != null
						&& StringUtils.hasText(mappedClass.getReadQuery()
								.getQuery())) {
					isValidReadQuery = true;
				}
			}

			if (isValidReadQuery) {
				// TODO: We need to make sure this is direct SQL ready, not JPA.
				String queryFilterString = mappedClass.getReadQuery()
						.getQuery();
				if (mappedClass.getReadQuery().getUseId()) {
					// Need to replace :id with
					queryFilterString = queryFilterString.replaceAll(":id",
							getIdColumnName());
					queryFilterString = queryFilterString.replaceAll(":Id",
							getIdColumnName());
					queryFilterString = queryFilterString.replaceAll(":iD",
							getIdColumnName());
					queryFilterString = queryFilterString.replaceAll(":ID",
							getIdColumnName());
				}
				queryFilterString = selectQueryString + " AND ("
						+ queryFilterString + ") > 0";

				result = mappedClass.getReadQuery().setQueryParameters(queryFilterString, null,
						userId);
			} else {
				result = selectQueryString;
			}
		} else {
			result = selectQueryString;
		}
		
		return result;
	}

	public T createObject(T perceroObject, String userId)
			throws SyncException {
		if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder(getInsertInto());
		buildInsertValues(perceroObject, sb);
		
		int updateResult = executeUpdate(sb.toString());
		if (updateResult > 0) {
			return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
		}
		else {
			return null;
		}
		
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
}