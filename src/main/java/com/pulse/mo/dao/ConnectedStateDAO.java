
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
import com.pulse.mo.ConnectedState;
import com.pulse.mo.UserSession;

*/

@Component
public class ConnectedStateDAO extends SqlDataAccessObject<ConnectedState> implements IDataAccessObject<ConnectedState> {

	static final Logger log = Logger.getLogger(ConnectedStateDAO.class);

	
	public ConnectedStateDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ConnectedState.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ConnectedStateDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT connectedstate.ID FROM ConnectedState connectedstate WHERE connectedstate.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT connectedstate.ID,connectedstate.name,connectedstate.externalID,connectedstate.userSession_ID FROM ConnectedState connectedstate WHERE connectedstate.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT connectedstate.ID FROM ConnectedState connectedstate ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT connectedstate.ID FROM ConnectedState connectedstate ORDER BY connectedstate.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT connectedstate.ID,connectedstate.name,connectedstate.externalID,connectedstate.userSession_ID FROM ConnectedState connectedstate ORDER BY connectedstate.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT connectedstate.ID,connectedstate.name,connectedstate.externalID,connectedstate.userSession_ID FROM ConnectedState connectedstate ORDER BY connectedstate.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ConnectedState connectedstate";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT connectedstate.ID,connectedstate.name,connectedstate.externalID,connectedstate.userSession_ID FROM ConnectedState connectedstate WHERE connectedstate.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT connectedstate.ID FROM ConnectedState connectedstate WHERE connectedstate.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT connectedstate.ID,connectedstate.name,connectedstate.externalID,connectedstate.userSession_ID FROM ConnectedState connectedstate WHERE connectedstate." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT connectedstate.ID FROM ConnectedState connectedstate WHERE connectedstate." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT connectedstate.ID FROM ConnectedState connectedstate ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT connectedstate.ID,connectedstate.name,connectedstate.externalID,connectedstate.userSession_ID FROM ConnectedState connectedstate ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ConnectedState (ID,name,externalID,userSession_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ConnectedState SET name=?,externalID=?,userSession_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ConnectedState WHERE ID=?";
	}
	
	@Override
	protected ConnectedState extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ConnectedState nextResult = new ConnectedState();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("name"));

nextResult.setExternalID(rs.getString("externalID"));

UserSession usersession = new UserSession();
usersession.setID(rs.getString("usersession_ID"));
nextResult.setUserSession(usersession);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ConnectedState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());

if (perceroObject.getUserSession() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getUserSession().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ConnectedState perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());

if (perceroObject.getUserSession() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getUserSession().getID());
}

pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<ConnectedState> findByExample(ConnectedState theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

if (useName)
{
sql += " WHERE ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useExternalID = StringUtils.hasText(theQueryObject.getExternalID()) && (excludeProperties == null || !excludeProperties.contains("externalID"));

if (useExternalID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " externalID=? ";
paramValues.add(theQueryObject.getExternalID());
propertyCounter++;
}

boolean useUserSessionID = theQueryObject.getUserSession() != null && (excludeProperties == null || !excludeProperties.contains("userSession"));

if (useUserSessionID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " userSessionID=? ";
paramValues.add(theQueryObject.getUserSession().getID());
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
