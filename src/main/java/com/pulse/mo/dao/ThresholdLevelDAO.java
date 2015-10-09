
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
		return "SELECT THRESHOLD_LEVEL.ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL WHERE THRESHOLD_LEVEL.ID=?";
	}
	
	@Override
	protected String getSelectStarSQL() {
		return "SELECT THRESHOLD_LEVEL.ID,THRESHOLD_LEVEL.START_EXPRESSION,THRESHOLD_LEVEL.START_VALUE,THRESHOLD_LEVEL.COLOR,THRESHOLD_LEVEL.END_EXPRESSION,THRESHOLD_LEVEL.END_VALUE,THRESHOLD_LEVEL.EXPRESSION_OPERATOR,THRESHOLD_LEVEL.THRESHOLD_SCALE_ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL WHERE THRESHOLD_LEVEL.ID=?";
	}
	
	@Override
	protected String getSelectAllShellOnlySQL() {
		return "SELECT THRESHOLD_LEVEL.ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL ORDER BY ID";
	}
	
	@Override
	protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
		return "SELECT THRESHOLD_LEVEL.ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL ORDER BY THRESHOLD_LEVEL.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getSelectAllStarSQL() {
		return "SELECT THRESHOLD_LEVEL.ID,THRESHOLD_LEVEL.START_EXPRESSION,THRESHOLD_LEVEL.START_VALUE,THRESHOLD_LEVEL.COLOR,THRESHOLD_LEVEL.END_EXPRESSION,THRESHOLD_LEVEL.END_VALUE,THRESHOLD_LEVEL.EXPRESSION_OPERATOR,THRESHOLD_LEVEL.THRESHOLD_SCALE_ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL ORDER BY THRESHOLD_LEVEL.ID";
	}
	
	@Override
	protected String getSelectAllStarWithLimitAndOffsetSQL() {
		return "SELECT THRESHOLD_LEVEL.ID,THRESHOLD_LEVEL.START_EXPRESSION,THRESHOLD_LEVEL.START_VALUE,THRESHOLD_LEVEL.COLOR,THRESHOLD_LEVEL.END_EXPRESSION,THRESHOLD_LEVEL.END_VALUE,THRESHOLD_LEVEL.EXPRESSION_OPERATOR,THRESHOLD_LEVEL.THRESHOLD_SCALE_ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL ORDER BY THRESHOLD_LEVEL.ID LIMIT ? OFFSET ?";
	}
	
	@Override
	protected String getCountAllSQL() {
		return "SELECT COUNT(ID) FROM THRESHOLD_LEVEL THRESHOLD_LEVEL";
	}
	
	@Override
	protected String getSelectInStarSQL() {
		return "SELECT THRESHOLD_LEVEL.ID,THRESHOLD_LEVEL.START_EXPRESSION,THRESHOLD_LEVEL.START_VALUE,THRESHOLD_LEVEL.COLOR,THRESHOLD_LEVEL.END_EXPRESSION,THRESHOLD_LEVEL.END_VALUE,THRESHOLD_LEVEL.EXPRESSION_OPERATOR,THRESHOLD_LEVEL.THRESHOLD_SCALE_ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL WHERE THRESHOLD_LEVEL.ID IN (?)";
	}
	
	@Override
	protected String getSelectInShellOnlySQL() {
		return "SELECT THRESHOLD_LEVEL.ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL WHERE THRESHOLD_LEVEL.ID IN (?)";
	}

	@Override
	protected String getSelectByRelationshipStarSQL(String joinColumnName) {
		return "SELECT THRESHOLD_LEVEL.ID,THRESHOLD_LEVEL.START_EXPRESSION,THRESHOLD_LEVEL.START_VALUE,THRESHOLD_LEVEL.COLOR,THRESHOLD_LEVEL.END_EXPRESSION,THRESHOLD_LEVEL.END_VALUE,THRESHOLD_LEVEL.EXPRESSION_OPERATOR,THRESHOLD_LEVEL.THRESHOLD_SCALE_ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL WHERE THRESHOLD_LEVEL." + joinColumnName + "=?";
	}
	
	@Override
	protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
		return "SELECT THRESHOLD_LEVEL.ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL WHERE THRESHOLD_LEVEL." + joinColumnName + "=?";
	}

	@Override
	protected String getFindByExampleSelectShellOnlySQL() {
		return "SELECT THRESHOLD_LEVEL.ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL ";
	}

	@Override
	protected String getFindByExampleSelectAllStarSQL() {
		return "SELECT THRESHOLD_LEVEL.ID,THRESHOLD_LEVEL.START_EXPRESSION,THRESHOLD_LEVEL.START_VALUE,THRESHOLD_LEVEL.COLOR,THRESHOLD_LEVEL.END_EXPRESSION,THRESHOLD_LEVEL.END_VALUE,THRESHOLD_LEVEL.EXPRESSION_OPERATOR,THRESHOLD_LEVEL.THRESHOLD_SCALE_ID FROM THRESHOLD_LEVEL THRESHOLD_LEVEL ";
	}
	
	@Override
	protected String getInsertIntoSQL() {
		return "INSERT INTO THRESHOLD_LEVEL (ID,START_EXPRESSION,START_VALUE,COLOR,END_EXPRESSION,END_VALUE,EXPRESSION_OPERATOR,THRESHOLD_SCALE_ID) VALUES (?,?,?,?,?,?,?,?)";
	}
	
	@Override
	protected String getUpdateSet() {
		return "UPDATE THRESHOLD_LEVEL SET START_EXPRESSION=?,START_VALUE=?,COLOR=?,END_EXPRESSION=?,END_VALUE=?,EXPRESSION_OPERATOR=?,THRESHOLD_SCALE_ID=? WHERE ID=?";
	}
	
	@Override
	protected String getDeleteFromSQL() {
		return "DELETE FROM THRESHOLD_LEVEL WHERE ID=?";
	}
	
	@Override
	protected ThresholdLevel extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
    	ThresholdLevel nextResult = new ThresholdLevel();
    	
    	// ID
    	nextResult.setID(rs.getString("ID"));
    	
    	if (!shellOnly) 
		{
			nextResult.setStartExpression(rs.getString("START_EXPRESSION"));

nextResult.setStartValue(rs.getString("START_VALUE"));

nextResult.setColor(rs.getString("COLOR"));

nextResult.setEndExpression(rs.getString("END_EXPRESSION"));

nextResult.setEndValue(rs.getString("END_VALUE"));

nextResult.setExpressionOperator(rs.getString("EXPRESSION_OPERATOR"));

ThresholdScale thresholdscale = new ThresholdScale();
thresholdscale.setID(rs.getString("THRESHOLD_SCALE_ID"));
nextResult.setThresholdScale(thresholdscale);


			
    	}
    	
    	return nextResult;
	}
	
	@Override
	protected void setPreparedStatmentInsertParams(ThresholdLevel perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getID());
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


		
	}
	
	@Override
	protected void setPreparedStatmentUpdateParams(ThresholdLevel perceroObject, PreparedStatement pstmt) throws SQLException {
		
		pstmt.setString(1, perceroObject.getStartExpression());
pstmt.setString(2, perceroObject.getStartValue());
pstmt.setString(3, perceroObject.getColor());
pstmt.setString(4, perceroObject.getEndExpression());
pstmt.setString(5, perceroObject.getEndValue());
pstmt.setString(6, perceroObject.getExpressionOperator());

if (perceroObject.getThresholdScale() == null)
{
pstmt.setString(7, null);
}
else
{
		pstmt.setString(7, perceroObject.getThresholdScale().getID());
}

pstmt.setString(8, perceroObject.getID());

		
	}

	@Override
	public List<ThresholdLevel> findByExample(ThresholdLevel theQueryObject,
			List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException 
		{
			
			
			
		String sql = getFindByExampleSelectSql(shellOnly);
		
		int propertyCounter = 0;
		List<Object> paramValues = new ArrayList<Object>();
		
		boolean useStartExpression = StringUtils.hasText(theQueryObject.getStartExpression()) && (excludeProperties == null || !excludeProperties.contains("startExpression"));

if (useStartExpression)
{
sql += " WHERE ";
sql += " START_EXPRESSION=? ";
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
sql += " START_VALUE=? ";
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
sql += " COLOR=? ";
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
sql += " END_EXPRESSION=? ";
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
sql += " END_VALUE=? ";
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
sql += " EXPRESSION_OPERATOR=? ";
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
sql += " THRESHOLD_SCALE_ID=? ";
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
