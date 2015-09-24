
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
import com.pulse.mo.Dashboard;
import com.pulse.mo.PulseUser;

*/

@Component
public class DashboardDAO extends SqlDataAccessObject<Dashboard> implements IDataAccessObject<Dashboard> {

	static final Logger log = Logger.getLogger(DashboardDAO.class);

	
	public DashboardDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Dashboard.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return DashboardDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT dashboard.ID FROM Dashboard dashboard WHERE dashboard.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT dashboard.ID,dashboard.name,dashboard.externalID,dashboard.pulseUser_ID FROM Dashboard dashboard WHERE dashboard.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT dashboard.ID FROM Dashboard dashboard ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT dashboard.ID FROM Dashboard dashboard ORDER BY dashboard.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT dashboard.ID,dashboard.name,dashboard.externalID,dashboard.pulseUser_ID FROM Dashboard dashboard ORDER BY dashboard.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT dashboard.ID,dashboard.name,dashboard.externalID,dashboard.pulseUser_ID FROM Dashboard dashboard ORDER BY dashboard.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM Dashboard dashboard";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT dashboard.ID,dashboard.name,dashboard.externalID,dashboard.pulseUser_ID FROM Dashboard dashboard WHERE dashboard.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT dashboard.ID FROM Dashboard dashboard WHERE dashboard.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT dashboard.ID,dashboard.name,dashboard.externalID,dashboard.pulseUser_ID FROM Dashboard dashboard WHERE dashboard." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT dashboard.ID FROM Dashboard dashboard WHERE dashboard." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT dashboard.ID FROM Dashboard dashboard ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT dashboard.ID,dashboard.name,dashboard.externalID,dashboard.pulseUser_ID FROM Dashboard dashboard ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO Dashboard (ID,name,externalID,pulseUser_ID) VALUES (?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE Dashboard SET name=?,externalID=?,pulseUser_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM Dashboard WHERE ID=?";
	}
	
	@Override
	protected Dashboard extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Dashboard nextResult = new Dashboard();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setName(rs.getString("name"));

nextResult.setExternalID(rs.getString("externalID"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("pulseuser_ID"));
nextResult.setPulseUser(pulseuser);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Dashboard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getName());
pstmt.setString(3, perceroObject.getExternalID());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(4, null);
}
else
{
		pstmt.setString(4, perceroObject.getPulseUser().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Dashboard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getName());
pstmt.setString(2, perceroObject.getExternalID());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPulseUser().getID());
}

pstmt.setString(4, perceroObject.getID());

		
	}

	@Override
	public List<Dashboard> findByExample(Dashboard theQueryObject,
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

boolean usePulseUserID = theQueryObject.getPulseUser() != null && (excludeProperties == null || !excludeProperties.contains("pulseUser"));

if (usePulseUserID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " pulseUserID=? ";
paramValues.add(theQueryObject.getPulseUser().getID());
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
