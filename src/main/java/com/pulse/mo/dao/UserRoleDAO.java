
package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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
import com.pulse.mo.UserRole;
import com.pulse.mo.PulseUser;

*/

@Component
public class UserRoleDAO extends SqlDataAccessObject<UserRole> implements IDataAccessObject<UserRole> {

	static final Logger log = Logger.getLogger(UserRoleDAO.class);

	
	public UserRoleDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(UserRole.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"USER_ROLE\".\"ROLE_NAME\",\"USER_ROLE\".\"PULSE_USER_ID\"";
	private String selectFromStatementTableName = " FROM \"USER_ROLE\" \"USER_ROLE\"";
	private String whereClause = "  WHERE \"USER_ROLE\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"USER_ROLE\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"USER_ROLE\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return UserRoleDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"USER_ROLE\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"USER_ROLE\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"USER_ROLE\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"USER_ROLE\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"USER_ROLE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"USER_ROLE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"USER_ROLE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"USER_ROLE\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"USER_ROLE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"USER_ROLE\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"USER_ROLE\".\"ID\" " + selectFromStatementTableName + " WHERE \"USER_ROLE\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"USER_ROLE\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"USER_ROLE\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO USER_ROLE (\"ID\",\"ROLE_NAME\",\"PULSE_USER_ID\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_USER_ROLE\" SET \"ROLE_NAME\"=?,\"PULSE_USER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_USER_ROLE\" WHERE \"ID\"=?";
	}
	
	@Override
	protected UserRole extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	UserRole nextResult = new UserRole();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setRoleName(rs.getString("ROLE_NAME"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("PULSE_USER_ID"));
nextResult.setPulseUser(pulseuser);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(UserRole perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getRoleName());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(3, null);
}
else
{
		pstmt.setString(3, perceroObject.getPulseUser().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(UserRole perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(UserRole perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(UserRole perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getRoleName());

if (perceroObject.getPulseUser() == null)
{
pstmt.setString(2, null);
}
else
{
		pstmt.setString(2, perceroObject.getPulseUser().getID());
}

pstmt.setString(3, perceroObject.getID());

		
	}
	
	
	@Override
	protected void setCallableStatmentUpdateParams(UserRole perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<UserRole> findByExample(UserRole theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useRoleName = StringUtils.hasText(theQueryObject.getRoleName()) && (excludeProperties == null || !excludeProperties.contains("roleName"));

if (useRoleName)
{
sql += " WHERE ";
sql += " \"ROLE_NAME\" =? ";
paramValues.add(theQueryObject.getRoleName());
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
sql += " \"PULSE_USER_ID\" =? ";
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
	
	@Override
	protected String getUpdateCallableStatementSql() {
		return "{call UPDATE_USER_ROLE(?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_USER_ROLE(?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_USER_ROLE(?)}";
	}
	
	
	
	
}
