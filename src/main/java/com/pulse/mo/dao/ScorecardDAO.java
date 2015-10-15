
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
import com.pulse.mo.Scorecard;
import com.pulse.mo.AgentScorecard;

*/

@Component
public class ScorecardDAO extends SqlDataAccessObject<Scorecard> implements IDataAccessObject<Scorecard> {

	static final Logger log = Logger.getLogger(ScorecardDAO.class);

	
	public ScorecardDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(Scorecard.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	
	public static final String SQL_VIEW = ",\"SCORECARD\".\"CREATED_ON\",\"SCORECARD\".\"UPDATED_ON\",\"SCORECARD\".\"CREATED_BY\",\"SCORECARD\".\"DESCRIPTION\",\"SCORECARD\".\"ECOACHING_LOB_ID\",\"SCORECARD\".\"GROUP_ID\",\"SCORECARD\".\"LOCK_LEVEL\",\"SCORECARD\".\"NAME\",\"SCORECARD\".\"REGION_ID\",\"SCORECARD\".\"UPDATED_BY\"";
	private String selectFromStatementTableName = " FROM \"SCORECARD\" \"SCORECARD\"";
	private String whereClause = " WHERE \"SCORECARD\".\"ID\"=?";
	private String whereInClause = " join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"SCORECARD\".\"ID\"= SQLLIST.column_value";
	private String orderByTableName = " ORDER BY \"SCORECARD\".\"ID\"";
	
	

	
	@Override
	protected String getConnectionFactoryName() {
		return ScorecardDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT \"SCORECARD\".\"ID\" " + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT \"SCORECARD\".\"ID\"" + SQL_VIEW  + selectFromStatementTableName + whereClause;
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT \"SCORECARD\".\"ID\" " + selectFromStatementTableName +  orderByTableName;
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT \"SCORECARD\".\"ID\" " + selectFromStatementTableName  +  orderByTableName  + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT \"SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName  + orderByTableName;
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT \"SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() 
	{
		return "SELECT COUNT(ID) " + selectFromStatementTableName;
	}
	
	@Override
	protected String getSelectInStarSQL() 
	{
		return "SELECT \"SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT \"SCORECARD\".\"ID\" " + selectFromStatementTableName + whereInClause;
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) 
	{
		
		return "SELECT \"SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"SCORECARD\"." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) 
	{
		
		return "SELECT \"SCORECARD\".\"ID\" " + selectFromStatementTableName + " WHERE \"SCORECARD\"." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT \"SCORECARD\".\"ID\" " + selectFromStatementTableName;
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT \"SCORECARD\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO SCORECARD (\"ID\",\"CREATED_ON\",\"UPDATED_ON\",\"CREATED_BY\",\"DESCRIPTION\",\"ECOACHING_LOB_ID\",\"GROUP_ID\",\"LOCK_LEVEL\",\"NAME\",\"REGION_ID\",\"UPDATED_BY\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE \"SCORECARD\" SET \"CREATED_ON\"=?,\"UPDATED_ON\"=?,\"CREATED_BY\"=?,\"DESCRIPTION\"=?,\"ECOACHING_LOB_ID\"=?,\"GROUP_ID\"=?,\"LOCK_LEVEL\"=?,\"NAME\"=?,\"REGION_ID\"=?,\"UPDATED_BY\"=? WHERE \"ID\"=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM \"SCORECARD\" WHERE \"ID\"=?";
	}
	
	@Override
	protected Scorecard extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	Scorecard nextResult = new Scorecard();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setCreatedOn(rs.getDate("CREATED_ON"));

nextResult.setUpdatedOn(rs.getDate("UPDATED_ON"));

nextResult.setCreatedBy(rs.getString("CREATED_BY"));

nextResult.setDescription(rs.getString("DESCRIPTION"));

nextResult.setECoachingLOBId(rs.getString("ECOACHING_LOB_ID"));

nextResult.setGroupId(rs.getString("GROUP_ID"));

nextResult.setLockLevel(rs.getString("LOCK_LEVEL"));

nextResult.setName(rs.getString("NAME"));

nextResult.setRegionId(rs.getString("REGION_ID"));

nextResult.setUpdatedBy(rs.getString("UPDATED_BY"));


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(Scorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setString(4, perceroObject.getCreatedBy());
pstmt.setString(5, perceroObject.getDescription());
pstmt.setString(6, perceroObject.getECoachingLOBId());
pstmt.setString(7, perceroObject.getGroupId());
pstmt.setString(8, perceroObject.getLockLevel());
pstmt.setString(9, perceroObject.getName());
pstmt.setString(10, perceroObject.getRegionId());
pstmt.setString(11, perceroObject.getUpdatedBy());

		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(Scorecard perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setDate(1, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getUpdatedOn()));
pstmt.setString(3, perceroObject.getCreatedBy());
pstmt.setString(4, perceroObject.getDescription());
pstmt.setString(5, perceroObject.getECoachingLOBId());
pstmt.setString(6, perceroObject.getGroupId());
pstmt.setString(7, perceroObject.getLockLevel());
pstmt.setString(8, perceroObject.getName());
pstmt.setString(9, perceroObject.getRegionId());
pstmt.setString(10, perceroObject.getUpdatedBy());
pstmt.setString(11, perceroObject.getID());

		
	}

	@Override
	public List<Scorecard> findByExample(Scorecard theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

if (useCreatedOn)
{
sql += " WHERE ";
sql += " \"CREATED_ON\" =? ";
paramValues.add(theQueryObject.getCreatedOn());
propertyCounter++;
}

boolean useUpdatedOn = theQueryObject.getUpdatedOn() != null && (excludeProperties == null || !excludeProperties.contains("updatedOn"));

if (useUpdatedOn)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_ON\" =? ";
paramValues.add(theQueryObject.getUpdatedOn());
propertyCounter++;
}

boolean useCreatedBy = StringUtils.hasText(theQueryObject.getCreatedBy()) && (excludeProperties == null || !excludeProperties.contains("createdBy"));

if (useCreatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"CREATED_BY\" =? ";
paramValues.add(theQueryObject.getCreatedBy());
propertyCounter++;
}

boolean useDescription = StringUtils.hasText(theQueryObject.getDescription()) && (excludeProperties == null || !excludeProperties.contains("description"));

if (useDescription)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"DESCRIPTION\" =? ";
paramValues.add(theQueryObject.getDescription());
propertyCounter++;
}

boolean useECoachingLOBId = StringUtils.hasText(theQueryObject.getECoachingLOBId()) && (excludeProperties == null || !excludeProperties.contains("eCoachingLOBId"));

if (useECoachingLOBId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"ECOACHING_LOB_ID\" =? ";
paramValues.add(theQueryObject.getECoachingLOBId());
propertyCounter++;
}

boolean useGroupId = StringUtils.hasText(theQueryObject.getGroupId()) && (excludeProperties == null || !excludeProperties.contains("groupId"));

if (useGroupId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"GROUP_ID\" =? ";
paramValues.add(theQueryObject.getGroupId());
propertyCounter++;
}

boolean useLockLevel = StringUtils.hasText(theQueryObject.getLockLevel()) && (excludeProperties == null || !excludeProperties.contains("lockLevel"));

if (useLockLevel)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"LOCK_LEVEL\" =? ";
paramValues.add(theQueryObject.getLockLevel());
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
sql += " \"NAME\" =? ";
paramValues.add(theQueryObject.getName());
propertyCounter++;
}

boolean useRegionId = StringUtils.hasText(theQueryObject.getRegionId()) && (excludeProperties == null || !excludeProperties.contains("regionId"));

if (useRegionId)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"REGION_ID\" =? ";
paramValues.add(theQueryObject.getRegionId());
propertyCounter++;
}

boolean useUpdatedBy = StringUtils.hasText(theQueryObject.getUpdatedBy()) && (excludeProperties == null || !excludeProperties.contains("updatedBy"));

if (useUpdatedBy)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " \"UPDATED_BY\" =? ";
paramValues.add(theQueryObject.getUpdatedBy());
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
