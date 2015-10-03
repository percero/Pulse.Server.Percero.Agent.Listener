package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.framework.vo.IPerceroObject;

public interface IHybridSqlDataAccessObject<T extends IPerceroObject> extends IDataAccessObject<T> {
	
	Set<String> getExternalPropertyNames();
	Set<String> getInternalPropertyNames();
	String getExternalConnectionFactoryName();
	String getInternalConnectionFactoryName();
	
	String getInternalSelectStarSQL();
	String getExternalSelectStarSQL();
	String getInternalSelectShellOnlySQL();
	String getExternalSelectShellOnlySQL();
	
	String getInternalSelectInStarSQL();
	String getExternalSelectInStarSQL();
	String getInternalSelectInShellOnlySQL();
	String getExternalSelectInShellOnlySQL();
	
	String getInternalSelectByRelationshipShellOnlySQL(String joinColumnName);
	String getExternalSelectByRelationshipShellOnlySQL(String joinColumnName);
	String getInternalSelectByRelationshipStarSQL(String joinColumnName);
	String getExternalSelectByRelationshipStarSQL(String joinColumnName);
	
	String getInternalFindByExampleSelectShellOnlySQL();
	String getExternalFindByExampleSelectShellOnlySQL();
	String getInternalFindByExampleSelectAllStarSQL();
	String getExternalFindByExampleSelectAllStarSQL();
	String getInternalSelectAllStarSQL();
	String getExternalSelectAllStarSQL();
	String getInternalSelectAllStarWithLimitAndOffsetSQL();
	String getExternalSelectAllStarWithLimitAndOffsetSQL();
	String getInternalSelectAllShellOnlySQL();
	String getExternalSelectAllShellOnlySQL();
	String getInternalSelectAllShellOnlyWithLimitAndOffsetSQL();
	String getExternalSelectAllShellOnlyWithLimitAndOffsetSQL();
	
	String getInternalCountAllSQL();
	String getExternalCountAllSQL();

	abstract T extractObjectFromExternalResultSet(ResultSet rs, Boolean shellOnly, T nextResult) throws SQLException;
	abstract T extractObjectFromInternalResultSet(ResultSet rs, Boolean shellOnly, T nextResult) throws SQLException;

	void setPreparedStatmentInsertParams(T perceroObject, PreparedStatement pstmt) throws SQLException;
	void setPreparedStatmentUpdateParams(T perceroObject, PreparedStatement pstmt) throws SQLException;
	String getInsertInto();
	String getUpdateSet() throws SyncDataException;
	
}