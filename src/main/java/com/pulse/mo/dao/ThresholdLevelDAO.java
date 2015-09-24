
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
import com.pulse.mo.ThresholdLevel;
import com.pulse.mo.ThresholdScale;

*/

@Component
public class ThresholdLevelDAO extends SqlDataAccessObject<ThresholdLevel> implements IDataAccessObject<ThresholdLevel> {

	static final Logger log = Logger.getLogger(ThresholdLevelDAO.class);

	
	public ThresholdLevelDAO() {
		super();
		
		DAORegistry.getInstance().registerDataAccessObject(ThresholdLevel.class.getCanonicalName(), this);
	}

	
	// This is the name of the Data Source that is registered to handle this class type.
	// For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
	public static final String CONNECTION_FACTORY_NAME = "default";
	@Override
	protected String getConnectionFactoryName() {
		return ThresholdLevelDAO.CONNECTION_FACTORY_NAME;
	}

	@Override
	protected String getSelectShellOnlySQL() {
		return "SELECT thresholdlevel.ID FROM ThresholdLevel thresholdlevel WHERE thresholdlevel.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT thresholdlevel.ID,thresholdlevel.externalID,thresholdlevel.startExpression,thresholdlevel.startValue,thresholdlevel.color,thresholdlevel.endExpression,thresholdlevel.endValue,thresholdlevel.expressionOperator,thresholdlevel.thresholdScale_ID FROM ThresholdLevel thresholdlevel WHERE thresholdlevel.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT thresholdlevel.ID FROM ThresholdLevel thresholdlevel ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT thresholdlevel.ID FROM ThresholdLevel thresholdlevel ORDER BY thresholdlevel.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT thresholdlevel.ID,thresholdlevel.externalID,thresholdlevel.startExpression,thresholdlevel.startValue,thresholdlevel.color,thresholdlevel.endExpression,thresholdlevel.endValue,thresholdlevel.expressionOperator,thresholdlevel.thresholdScale_ID FROM ThresholdLevel thresholdlevel ORDER BY thresholdlevel.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT thresholdlevel.ID,thresholdlevel.externalID,thresholdlevel.startExpression,thresholdlevel.startValue,thresholdlevel.color,thresholdlevel.endExpression,thresholdlevel.endValue,thresholdlevel.expressionOperator,thresholdlevel.thresholdScale_ID FROM ThresholdLevel thresholdlevel ORDER BY thresholdlevel.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM ThresholdLevel thresholdlevel";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT thresholdlevel.ID,thresholdlevel.externalID,thresholdlevel.startExpression,thresholdlevel.startValue,thresholdlevel.color,thresholdlevel.endExpression,thresholdlevel.endValue,thresholdlevel.expressionOperator,thresholdlevel.thresholdScale_ID FROM ThresholdLevel thresholdlevel WHERE thresholdlevel.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT thresholdlevel.ID FROM ThresholdLevel thresholdlevel WHERE thresholdlevel.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT thresholdlevel.ID,thresholdlevel.externalID,thresholdlevel.startExpression,thresholdlevel.startValue,thresholdlevel.color,thresholdlevel.endExpression,thresholdlevel.endValue,thresholdlevel.expressionOperator,thresholdlevel.thresholdScale_ID FROM ThresholdLevel thresholdlevel WHERE thresholdlevel." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT thresholdlevel.ID FROM ThresholdLevel thresholdlevel WHERE thresholdlevel." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT thresholdlevel.ID FROM ThresholdLevel thresholdlevel ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT thresholdlevel.ID,thresholdlevel.externalID,thresholdlevel.startExpression,thresholdlevel.startValue,thresholdlevel.color,thresholdlevel.endExpression,thresholdlevel.endValue,thresholdlevel.expressionOperator,thresholdlevel.thresholdScale_ID FROM ThresholdLevel thresholdlevel ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO ThresholdLevel (ID,externalID,startExpression,startValue,color,endExpression,endValue,expressionOperator,thresholdScale_ID) VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE ThresholdLevel SET externalID=?,startExpression=?,startValue=?,color=?,endExpression=?,endValue=?,expressionOperator=?,thresholdScale_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM ThresholdLevel WHERE ID=?";
	}
	
	@Override
	protected ThresholdLevel extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ThresholdLevel nextResult = new ThresholdLevel();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setExternalID(rs.getString("externalID"));

nextResult.setStartExpression(rs.getString("startExpression"));

nextResult.setStartValue(rs.getString("startValue"));

nextResult.setColor(rs.getString("color"));

nextResult.setEndExpression(rs.getString("endExpression"));

nextResult.setEndValue(rs.getString("endValue"));

nextResult.setExpressionOperator(rs.getString("expressionOperator"));

ThresholdScale thresholdscale = new ThresholdScale();
thresholdscale.setID(rs.getString("thresholdscale_ID"));
nextResult.setThresholdScale(thresholdscale);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ThresholdLevel perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
pstmt.setString(2, perceroObject.getExternalID());
pstmt.setString(3, perceroObject.getStartExpression());
pstmt.setString(4, perceroObject.getStartValue());
pstmt.setString(5, perceroObject.getColor());
pstmt.setString(6, perceroObject.getEndExpression());
pstmt.setString(7, perceroObject.getEndValue());
pstmt.setString(8, perceroObject.getExpressionOperator());

if (perceroObject.getThresholdScale() == null)
{
pstmt.setString(9, null);
}
else
{
		pstmt.setString(9, perceroObject.getThresholdScale().getID());
}


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ThresholdLevel perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getExternalID());
pstmt.setString(2, perceroObject.getStartExpression());
pstmt.setString(3, perceroObject.getStartValue());
pstmt.setString(4, perceroObject.getColor());
pstmt.setString(5, perceroObject.getEndExpression());
pstmt.setString(6, perceroObject.getEndValue());
pstmt.setString(7, perceroObject.getExpressionOperator());

if (perceroObject.getThresholdScale() == null)
{
pstmt.setString(8, null);
}
else
{
		pstmt.setString(8, perceroObject.getThresholdScale().getID());
}

pstmt.setString(9, perceroObject.getID());

		
	}

	@Override
	public List<ThresholdLevel> findByExample(ThresholdLevel theQueryObject,
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

boolean useStartExpression = StringUtils.hasText(theQueryObject.getStartExpression()) && (excludeProperties == null || !excludeProperties.contains("startExpression"));

if (useStartExpression)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " startExpression=? ";
paramValues.add(theQueryObject.getStartExpression());
propertyCounter++;
}

boolean useStartValue = StringUtils.hasText(theQueryObject.getStartValue()) && (excludeProperties == null || !excludeProperties.contains("startValue"));

if (useStartValue)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " startValue=? ";
paramValues.add(theQueryObject.getStartValue());
propertyCounter++;
}

boolean useColor = StringUtils.hasText(theQueryObject.getColor()) && (excludeProperties == null || !excludeProperties.contains("color"));

if (useColor)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " color=? ";
paramValues.add(theQueryObject.getColor());
propertyCounter++;
}

boolean useEndExpression = StringUtils.hasText(theQueryObject.getEndExpression()) && (excludeProperties == null || !excludeProperties.contains("endExpression"));

if (useEndExpression)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " endExpression=? ";
paramValues.add(theQueryObject.getEndExpression());
propertyCounter++;
}

boolean useEndValue = StringUtils.hasText(theQueryObject.getEndValue()) && (excludeProperties == null || !excludeProperties.contains("endValue"));

if (useEndValue)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " endValue=? ";
paramValues.add(theQueryObject.getEndValue());
propertyCounter++;
}

boolean useExpressionOperator = StringUtils.hasText(theQueryObject.getExpressionOperator()) && (excludeProperties == null || !excludeProperties.contains("expressionOperator"));

if (useExpressionOperator)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " expressionOperator=? ";
paramValues.add(theQueryObject.getExpressionOperator());
propertyCounter++;
}

boolean useThresholdScaleID = theQueryObject.getThresholdScale() != null && (excludeProperties == null || !excludeProperties.contains("thresholdScale"));

if (useThresholdScaleID)
{
if (propertyCounter > 0)
{
sql += " AND ";
}
else
{
sql += " WHERE ";
}
sql += " thresholdScaleID=? ";
paramValues.add(theQueryObject.getThresholdScale().getID());
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
