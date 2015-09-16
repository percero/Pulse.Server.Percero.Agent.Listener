package com.pulse.mo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.percero.agents.sync.dao.IDataAccessObject;
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

public abstract class SqlDataAccessObject<T extends IPerceroObject> implements IDataAccessObject<T> {

	static final Logger log = Logger.getLogger(SqlDataAccessObject.class);
	
	public SqlDataAccessObject() {
		super();
	}
	
	PulseDataConnectionRegistry connectionRegistry;
	public void setConnectionRegistry(PulseDataConnectionRegistry value) {
		if (connectionRegistry == null) {
			connectionRegistry = PulseDataConnectionRegistry.getInstance();
		}
		connectionRegistry = value;
	}
	
	protected String getConnectionFactoryName() {
		return null;
	}
	
	protected String getIdColumnName() {
		return "ID";
	}

	protected String getSelectStarSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getSelectShellOnlySQL() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getSelect(Boolean shellOnly) {
		if (shellOnly) {
			return getSelectShellOnlySQL();
		}
		else {
			return getSelectStarSQL();
		}
	}
	
	protected String getSelectInStarSQL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getSelectInShellOnlySQL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getSelectIn(Boolean shellOnly) {
		if (shellOnly) {
			return getSelectInShellOnlySQL();
		}
		else {
			return getSelectInStarSQL();
		}
	}
	
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getSelectByRelationship(String joinColumnName, Boolean shellOnly) {
		if (shellOnly) {
			return getSelectByRelationshipShellOnlySQL(joinColumnName);
		}
		else {
			return getSelectByRelationshipStarSQL(joinColumnName);
		}
	}
	
	protected String getSelectAllSql(Boolean shellOnly) {
		if (shellOnly) {
			return getSelectAllShellOnlySQL();
		}
		else {
			return getSelectAllStarSQL();
		}
	}

	protected String getSelectAllStarSQL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getSelectAllShellOnlySQL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getCountAllSQL() {
		return null;
	}
	
	
	
	@Override
	public T createObject(T perceroObject, String userId)
			throws SyncException {
		if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
			return null;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			String sql = getInsertIntoSQL();
			pstmt = conn.prepareStatement(sql);
			
			setPreparedStatmentInsertParams(perceroObject, pstmt);
			
			if (pstmt.execute()) {
				return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
			}
			else {
				return null;
			}
		} catch(Exception e) {
			log.error("Unable to executeUpdate", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
	}

	protected void setPreparedStatmentInsertParams(T perceroObject, PreparedStatement pstmt) throws SQLException {
	}
	
	public T retrieveObject(ClassIDPair classIdPair, String userId,
			Boolean shellOnly) throws SyncException {
		T result = null;
		
		String sql = getSelect(shellOnly);
		List<T> results = executeSelectById(sql, classIdPair.getID(), shellOnly);
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
		List<T> results = new ArrayList<T>();

		String questionMarkString = "";
		for(int i=0; i<classIdPairs.getIds().size(); i++) {
			if (i > 0) {
				questionMarkString += ",";
			}
			questionMarkString += "?";
		}

		// TODO: Build up ?'s for each id in the list and then set the PreparedStatement indexed values.
		
		String sql = getSelectIn(shellOnly);
		sql = sql.replace("?", questionMarkString);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);

			int counter = 1;	// PreparedStatement index starts at 1.
			Iterator<String> itrIds = classIdPairs.getIds().iterator();
			while (itrIds.hasNext()) {
				String nextId = itrIds.next();
				pstmt.setString(counter, nextId);
				counter++;
			}
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				T nextResult = extractObjectFromResultSet(rs, shellOnly);
				results.add(nextResult);
			}
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
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

	public List<T> retrieveAllByRelationship(MappedField mappedField, ClassIDPair targetClassIdPair, Boolean shellOnly, String userId) throws SyncException {
		
		String sql = getSelectByRelationship(mappedField.getJoinColumnName(), shellOnly);
		
		List<T> results = executeSelectById(sql, targetClassIdPair.getID(), shellOnly);
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
	
	protected List<T> executeSelectById(String selectQueryString, String id, Boolean shellOnly)
			throws SyncDataException {
		List<T> results = new ArrayList<T>();
		
		// Open the database session.
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			pstmt = conn.prepareStatement(selectQueryString);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				T nextResult = extractObjectFromResultSet(rs, shellOnly);
				results.add(nextResult);
			}
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
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
		
		String sql = getSelectAllSql(shellOnly);
		List<T> objects = new ArrayList<T>();
		
		// Open the database session.
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageSize);
			pstmt.setInt(2, pageNumber);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				T nextResult = extractObjectFromResultSet(rs, shellOnly);
				objects.add(nextResult);
			}
		} catch(Exception e) {
			log.error("Unable to retrieveObjects", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
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

		String sql = getCountAllSQL();
		
		// Open the database session.
		Connection conn = null;
		Statement stmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			stmt = conn.createStatement();
//			String queryString = overlayReadQuery(className, userId,
//					selectQueryString);
			
	        ResultSet rs = stmt.executeQuery(sql);
	        if (rs.next()) {
	        	return rs.getInt(0);
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
	

	protected void setPreparedStatmentUpdateParams(T perceroObject, PreparedStatement pstmt) throws SQLException {
		
	}
	
	public T updateObject(T perceroObject,
			Map<ClassIDPair, Collection<MappedField>> changedFields, String userId)
			throws SyncException {
		if (!hasUpdateAccess(BaseDataObject.toClassIdPair(perceroObject), userId)) {
			return null;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			String sql = getUpdateSet();
			pstmt = conn.prepareStatement(sql);
			
			setPreparedStatmentUpdateParams(perceroObject, pstmt);
			
			if (pstmt.execute()) {
				return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
			}
			else {
				return null;
			}
		} catch(Exception e) {
			log.error("Unable to executeUpdate", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
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
	
//	/**
//	 * @param classIdPairs
//	 * @param userId
//	 * @param selectQueryString
//	 * @return
//	 * @throws SyncException
//	 * @throws Exception
//	 */
//	protected String overlayReadQuery(String className, String userId,
//			String selectQueryString)
//					throws SyncException, Exception {
//		MappedClass mappedClass = MappedClassManagerFactory
//				.getMappedClassManager().getMappedClassByClassName(className);
//		if (mappedClass == null) {
//			log.warn("Missing MappedClass for "
//					+ className);
//			throw new SyncException(
//					SyncException.MISSING_MAPPED_CLASS_ERROR,
//					SyncException.MISSING_MAPPED_CLASS_ERROR_CODE);
//		}
//
//		return overlayReadQuery(mappedClass, userId, selectQueryString);
//	}
//
//	/**
//	 * @param classIdPairs
//	 * @param userId
//	 * @param selectQueryString
//	 * @return
//	 * @throws SyncException
//	 * @throws Exception
//	 */
//	protected String overlayReadQuery(MappedClass mappedClass, String userId,
//			String selectQueryString)
//			throws SyncException, Exception {
//		String result = "";
//		
//		// If the Read Query/Filter uses the ID, then we need to check against
//		// each ID here.
//		boolean isUser = StringUtils.hasText(userId);
//		if (isUser) {
//			boolean isValidReadQuery = false;
//			if (mappedClass != null) {
//				// If no UserID, then no reason to check the ReadQuery.
//				if (!StringUtils.hasText(userId)
//						&& mappedClass.getReadQuery() != null
//						&& StringUtils.hasText(mappedClass.getReadQuery()
//								.getQuery())) {
//					isValidReadQuery = true;
//				}
//			}
//
//			if (isValidReadQuery) {
//				// TODO: We need to make sure this is direct SQL ready, not JPA.
//				String queryFilterString = mappedClass.getReadQuery()
//						.getQuery();
//				if (mappedClass.getReadQuery().getUseId()) {
//					// Need to replace :id with
//					queryFilterString = queryFilterString.replaceAll(":id",
//							getIdColumnName());
//					queryFilterString = queryFilterString.replaceAll(":Id",
//							getIdColumnName());
//					queryFilterString = queryFilterString.replaceAll(":iD",
//							getIdColumnName());
//					queryFilterString = queryFilterString.replaceAll(":ID",
//							getIdColumnName());
//				}
//				queryFilterString = selectQueryString + " AND ("
//						+ queryFilterString + ") > 0";
//
//				result = mappedClass.getReadQuery().setQueryParameters(queryFilterString, null,
//						userId);
//			} else {
//				result = selectQueryString;
//			}
//		} else {
//			result = selectQueryString;
//		}
//		
//		return result;
//	}


	public Boolean deleteObject(ClassIDPair classIdPair, String userId)
			throws SyncException {
		if ( !hasDeleteAccess(classIdPair, userId) ) {
			return false;
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			IConnectionFactory connectionFactory = connectionRegistry.getConnectionFactory(getConnectionFactoryName());
			conn = connectionFactory.getConnection();
			String sql = getDeleteFromSQL();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, classIdPair.getID());
			
			return pstmt.execute();
		} catch(Exception e) {
			log.error("Unable to deleteObject", e);
			throw new SyncDataException(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("Error closing database statement/connection", e);
			}
		}
	}

	protected String getDeleteFromSQL() {
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


	protected String getInsertIntoSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	protected String getUpdateSet() {
		// TODO Auto-generated method stub
		return null;
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