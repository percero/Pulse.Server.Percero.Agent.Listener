
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
import com.pulse.mo.TraceLog;
import com.pulse.mo.TraceEntry;

*/

@Component
public class TraceLogDAO extends SqlDataAccessObject<TraceLog> implements IDataAccessObject<TraceLog> {

	static final Logger log = Logger.getLogger(TraceLogDAO.class);

	
	public TraceLogDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(TraceLog.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return TraceLogDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT tracelog.ID FROM TraceLog tracelog WHERE tracelog.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT tracelog.ID,tracelog.externalID,tracelog.name FROM TraceLog tracelog WHERE tracelog.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT tracelog.ID FROM TraceLog tracelog ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT tracelog.ID FROM TraceLog tracelog ORDER BY tracelog.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT tracelog.ID,tracelog.externalID,tracelog.name FROM TraceLog tracelog ORDER BY tracelog.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT tracelog.ID,tracelog.externalID,tracelog.name FROM TraceLog tracelog ORDER BY tracelog.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM TraceLog tracelog";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT tracelog.ID,tracelog.externalID,tracelog.name FROM TraceLog tracelog WHERE tracelog.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT tracelog.ID FROM TraceLog tracelog WHERE tracelog.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT tracelog.ID,tracelog.externalID,tracelog.name FROM TraceLog tracelog WHERE tracelog." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT tracelog.ID FROM TraceLog tracelog WHERE tracelog." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT tracelog.ID FROM TraceLog tracelog ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT tracelog.ID,tracelog.externalID,tracelog.name FROM TraceLog tracelog ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO TraceLog (ID,externalID,name) VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE TraceLog SET externalID=?,name=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM TraceLog WHERE ID=?";
	}
	
	@Override
	protected TraceLog extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	TraceLog nextResult = new TraceLog();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setName(rs.getString("name"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(TraceLog perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getName());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(TraceLog perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getID());

		
	}

	@Override
	public List<TraceLog> findByExample(TraceLog theQueryObject,
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

boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " name=? ";
paramValues.add(theQueryObject.getName());
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
