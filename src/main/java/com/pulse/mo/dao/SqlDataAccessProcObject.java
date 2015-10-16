package com.pulse.mo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;

import com.percero.agents.sync.connectors.ConnectorException;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.metadata.MappedField;
import com.percero.agents.sync.vo.BaseDataObject;
import com.percero.agents.sync.vo.ClassIDPair;
import com.percero.framework.vo.IPerceroObject;
import com.pulse.dataprovider.IConnectionFactory;
import com.pulse.mo.TeamLeader;

public abstract class SqlDataAccessProcObject<T extends IPerceroObject> extends SqlDataAccessObject<T> {

	static final Logger log = Logger.getLogger(SqlDataAccessObject.class);
	
	public static long LONG_RUNNING_QUERY_TIME = 2500;
	
	public SqlDataAccessProcObject() {
		super();
	}
	
	@Override
	public T createObject(T perceroObject, String userId)
			throws SyncException {
		if ( !hasCreateAccess(BaseDataObject.toClassIdPair(perceroObject), userId) ) {
			return null;
		}
		
		long timeStart = System.currentTimeMillis();
		
		int result = runInsertStoredProcedure(perceroObject);
		
		long timeEnd = System.currentTimeMillis();
		long totalTime = timeEnd - timeStart;
		if (totalTime > LONG_RUNNING_QUERY_TIME) {
			log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + "Insert ThresholdExceededNotification");
		}
		
		if (result > 0) {
			return retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
		}
		else {
			return null;
		}
	}

	protected String getUpdateCallableStatementSql() {
		return "";
	}
	protected String getInsertCallableStatementSql() {
		return "";
	}
	protected String getDeleteCallableStatementSql() {
		return "";
	}

	protected int runInsertStoredProcedure(T perceroObject) throws ConnectorException {
		int result = runStoredProcedure(perceroObject, getInsertCallableStatementSql());
		return result;
	}
	
	protected int runUpdateStoredProcedure(T perceroObject) throws ConnectorException {
		int result = runStoredProcedure(perceroObject, getUpdateCallableStatementSql());
		return result;
	}
	
	protected int runDeleteStoredProcedure(ClassIDPair classIdPair) throws ConnectorException {
		int result = 0;
		IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
		try(Connection conn = connectionFactory.getConnection();
				Statement statement = conn.createStatement())
				{
			CallableStatement cstmt = conn.prepareCall(getDeleteCallableStatementSql());
			cstmt.setString(1, classIdPair.getID());
			result = cstmt.executeUpdate();
				} catch(SQLException e) {
					log.error(e.getMessage(), e);
					throw new ConnectorException(e);
				}
		
		return result;
	}
	
	protected int runStoredProcedure(T perceroObject, String storedProcedureCallSql) throws ConnectorException {
		int result = 0;
		IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
		try(Connection conn = connectionFactory.getConnection();
				Statement statement = conn.createStatement())
				{
			CallableStatement cstmt = conn.prepareCall(storedProcedureCallSql);
			setBaseStatmentInsertParams(perceroObject, cstmt);
			result = cstmt.executeUpdate();
				} catch(SQLException e) {
					log.error(e.getMessage(), e);
					throw new ConnectorException(e);
				}
		
		return result;
	}
	
//	protected void setCallableStatmentParams(T perceroObject, CallableStatement cstmt) throws SQLException {
	protected void setBaseStatmentInsertParams(T perceroObject, PreparedStatement pstmt) throws SQLException {
		// Do nothing
	}
	
	public T updateObject(T perceroObject,
			Map<ClassIDPair, Collection<MappedField>> changedFields, String userId)
			throws SyncException {
		if (!hasUpdateAccess(BaseDataObject.toClassIdPair(perceroObject), userId)) {
			return null;
		}
		
		long timeStart = System.currentTimeMillis();
		
		int updateResult = runUpdateStoredProcedure(perceroObject);
		
		long timeEnd = System.currentTimeMillis();
		long totalTime = timeEnd - timeStart;
		if (totalTime > LONG_RUNNING_QUERY_TIME) {
			log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + "Insert ThresholdExceededNotification");
		}

		T result = null;
		if (updateResult > 0) {
			result = retrieveObject(BaseDataObject.toClassIdPair(perceroObject), userId, false);
		}
		
		return result;
	}

	public Boolean deleteObject(ClassIDPair classIdPair, String userId)
			throws SyncException {
		if ( !hasDeleteAccess(classIdPair, userId) ) {
			return false;
		}
		
		long timeStart = System.currentTimeMillis();
		
		int updateResult = runDeleteStoredProcedure(classIdPair);
		
		long timeEnd = System.currentTimeMillis();
		long totalTime = timeEnd - timeStart;
		if (totalTime > LONG_RUNNING_QUERY_TIME) {
			log.warn("LONG RUNNING QUERY: " + totalTime + "ms\n" + "Insert ThresholdExceededNotification");
		}
		
		return (updateResult > 0);

//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			
//			IConnectionFactory connectionFactory = getConnectionRegistry().getConnectionFactory(getConnectionFactoryName());
//			conn = connectionFactory.getConnection();
//			String sql = getDeleteFromSQL();
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, classIdPair.getID());
//			
//			return pstmt.execute();
//		} catch(Exception e) {
//			log.error("Unable to deleteObject", e);
//			throw new SyncDataException(e);
//		} finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				log.error("Error closing database statement/connection", e);
//			}
//		}
	}

}