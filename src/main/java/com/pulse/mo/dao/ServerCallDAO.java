
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.percero.util.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;

import com.pulse.mo.*;

/*
import com.pulse.mo.ServerCall;

*/

@Component
public class ServerCallDAO extends SqlDataAccessObject<ServerCall> implements IDataAccessObject<ServerCall> {

	static final Logger log = Logger.getLogger(ServerCallDAO.class);

	
	public ServerCallDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ServerCall.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ServerCallDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT servercall.ID FROM ServerCall servercall WHERE servercall.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT servercall.ID,servercall.externalID,servercall.lengthOfTime FROM ServerCall servercall WHERE servercall.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT servercall.ID FROM ServerCall servercall ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT servercall.ID FROM ServerCall servercall ORDER BY servercall.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT servercall.ID,servercall.externalID,servercall.lengthOfTime FROM ServerCall servercall ORDER BY servercall.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT servercall.ID,servercall.externalID,servercall.lengthOfTime FROM ServerCall servercall ORDER BY servercall.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ServerCall servercall";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT servercall.ID,servercall.externalID,servercall.lengthOfTime FROM ServerCall servercall WHERE servercall.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT servercall.ID FROM ServerCall servercall WHERE servercall.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT servercall.ID,servercall.externalID,servercall.lengthOfTime FROM ServerCall servercall WHERE servercall." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT servercall.ID FROM ServerCall servercall WHERE servercall." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT servercall.ID FROM ServerCall servercall ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT servercall.ID,servercall.externalID,servercall.lengthOfTime FROM ServerCall servercall ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ServerCall (ID,externalID,lengthOfTime) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ServerCall SET externalID=?,lengthOfTime=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ServerCall WHERE ID=?";
	}
	
	@Override
	protected ServerCall extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ServerCall nextResult = new ServerCall();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setLengthOfTime(rs.getString("lengthOfTime"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ServerCall perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getLengthOfTime());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ServerCall perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getLengthOfTime());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<ServerCall> findByExample(ServerCall theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useLengthOfTime = StringUtils.hasText(theQueryObject.getLengthOfTime()) && (excludeProperties == null || !excludeProperties.contains("lengthOfTime"));

if (useLengthOfTime)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " lengthOfTime=? ";
paramValues.add(theQueryObject.getLengthOfTime());
propertyCounter++;
}


		/*
		boolean useValue = StringUtils.hasText(theQueryObject.getValue()) && (excludeProperties == null || !excludeProperties.contains("value"));
		
		if (useValue) {
			sql += " WHERE value=? ";
			paramValues.add(theQueryObject.getValue());
			propertyCounter++;
		}
		
		boolean usePersonId = theQueryObject.getPerson() != null && (excludeProperties == null || !excludeProperties.contains("person"));
		
		if (usePersonId) {
			if (propertyCounter > 0) {
				sql += " AND ";
			}
			else {
				sql += " WHERE ";
			}
			sql += " person_ID=? ";
			paramValues.add(theQueryObject.getPerson().getID());
			propertyCounter++;
		}
		
		*/
		
		return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);		
	}
	
}
