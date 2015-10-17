
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
import com.pulse.mo.Email;
import com.pulse.mo.PulseUser;

*/

@Component
public class EmailDAO extends SqlDataAccessObject<Email> implements IDataAccessObject<Email> {

	static final Logger log = Logger.getLogger(EmailDAO.class);

	
	public EmailDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Email.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"EMAIL\".\"EMAIL_ADDRESS\",\"EMAIL\".\"PULSE_USER_ID\"";
	private String selectFromStatementTableName = " FROM \"EMAIL\" \"EMAIL\"";
	private String whereClause = "  WHERE \"EMAIL\".\"ID\"=?";
	private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"EMAIL\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = "  ORDER BY \"EMAIL\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return EmailDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"EMAIL\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"EMAIL\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"EMAIL\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"EMAIL\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"EMAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"EMAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"EMAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"EMAIL\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"EMAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"EMAIL\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"EMAIL\".\"ID\" " + selectFromStatementTableName + " WHERE \"EMAIL\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"EMAIL\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"EMAIL\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO EMAIL (\"ID\",\"EMAIL_ADDRESS\",\"PULSE_USER_ID\") VALUES (?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"TBL_EMAIL\" SET \"EMAIL_ADDRESS\"=?,\"PULSE_USER_ID\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"TBL_EMAIL\" WHERE \"ID\"=?";
	}
	
	@Override
	protected Email extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Email nextResult = new Email();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));

PulseUser pulseuser = new PulseUser();
pulseuser.setID(rs.getString("PULSE_USER_ID"));
nextResult.setPulseUser(pulseuser);


			
    	}
    	
    	return nextResult;
	}
	
	protected void setBaseStatmentInsertParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getEmailAddress());

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
	protected void setPreparedStatmentInsertParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
		
	}
	
	@Override
	protected void setCallableStatmentInsertParams(Email perceroObject, CallableStatement pstmt) throws SQLException {
		
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	

	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Email perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getEmailAddress());

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
	protected void setCallableStatmentUpdateParams(Email perceroObject, CallableStatement pstmt) throws SQLException 
	{
		
		//must be in same order as insert
		setBaseStatmentInsertParams(perceroObject,pstmt);
			
	}
	
	

	@Override
	public List<Email> findByExample(Email theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useEmailAddress = StringUtils.hasText(theQueryObject.getEmailAddress()) && (excludeProperties == null || !excludeProperties.contains("emailAddress"));

if (useEmailAddress)
{
sql += " WHERE ";
sql += " \"EMAIL_ADDRESS\" =? ";
paramValues.add(theQueryObject.getEmailAddress());
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
		return "{call UPDATE_EMAIL(?,?,?)}";
	}
	@Override
	protected String getInsertCallableStatementSql() {
		return "{call CREATE_EMAIL(?,?,?)}";
	}
	@Override
	protected String getDeleteCallableStatementSql() {
		return "{call Delete_EMAIL(?)}";
	}
	
	
	
	
}
