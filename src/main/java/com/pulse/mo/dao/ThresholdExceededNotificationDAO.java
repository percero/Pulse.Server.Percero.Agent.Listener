

package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.percero.agents.sync.exceptions.SyncDataException;
import com.percero.util.DateUtils;
import com.pulse.dataprovider.IConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.percero.agents.sync.metadata.MappedClass;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.percero.agents.sync.vo.BaseDataObject;

import java.sql.Connection;
import java.sql.Statement;

import com.pulse.dataprovider.IConnectionFactory;
import com.percero.agents.sync.exceptions.SyncDataException;
import com.pulse.mo.*;

@Component
public class ThresholdExceededNotificationDAO extends SqlDataAccessProcObject<ThresholdExceededNotification> implements IDataAccessObject<ThresholdExceededNotification> {

    static final Logger log = Logger.getLogger(ThresholdExceededNotificationDAO.class);


    public ThresholdExceededNotificationDAO() {
        super();

        DAORegistry.getInstance().registerDataAccessObject(ThresholdExceededNotification.class.getCanonicalName(), this);
    }


    // This is the name of the Data Source that is registered to handle this class type.
    // For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
    public static final String CONNECTION_FACTORY_NAME = "default";

    public static final String SHELL_ONLY_SELECT = "\"THRSH_EXCEEDED_NOTIF\".\"ID\",\"THRSH_EXCEEDED_NOTIF\".\"TYPE\"";
    public static final String SQL_VIEW = ",\"THRSH_EXCEEDED_NOTIF\".\"TYPE\",\"THRSH_EXCEEDED_NOTIF\".\"CREATED_ON\",\"THRSH_EXCEEDED_NOTIF\".\"MESSAGE\",\"THRSH_EXCEEDED_NOTIF\".\"NAME\",\"THRSH_EXCEEDED_NOTIF\".\"AGENT_ID\",\"THRSH_EXCEEDED_NOTIF\".\"LOB_CONFIGURATION_ID\",\"THRSH_EXCEEDED_NOTIF\".\"TEAM_LEADER_ID\",\"THRSH_EXCEEDED_NOTIF\".\"LOB_CONFIGURATION_ENTRY_ID\",\"THRSH_EXCEEDED_NOTIF\".\"IS_READ\"";
    private String selectFromStatementTableName = " FROM \"THRSH_EXCEEDED_NOTIF\" \"THRSH_EXCEEDED_NOTIF\"";
    private String whereClause = "  WHERE \"THRSH_EXCEEDED_NOTIF\".\"ID\"=?";
    private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"THRSH_EXCEEDED_NOTIF\".\"ID\"= SQLLIST.column_value";
    private String orderByTableName = "  ORDER BY \"THRSH_EXCEEDED_NOTIF\".\"ID\"";


    @Override
    protected String getConnectionFactoryName() {
        return ThresholdExceededNotificationDAO.CONNECTION_FACTORY_NAME;
    }

    @Override
    protected String getSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectStarSQL() {
        return "SELECT \"THRSH_EXCEEDED_NOTIF\".\"ID\"" + SQL_VIEW + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectAllShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + orderByTableName;
    }

    @Override
    protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getSelectAllStarSQL() {
        return "SELECT \"THRSH_EXCEEDED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName;
    }

    @Override
    protected String getSelectAllStarWithLimitAndOffsetSQL() {
        return "SELECT \"THRSH_EXCEEDED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getCountAllSQL() {
        return "SELECT COUNT(ID) " + selectFromStatementTableName;
    }

    @Override
    protected String getSelectInStarSQL() {
        return "SELECT \"THRSH_EXCEEDED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectInShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectByRelationshipStarSQL(String joinColumnName) {

        return "SELECT \"THRSH_EXCEEDED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"THRSH_EXCEEDED_NOTIF\"." + joinColumnName + "=?";
    }

    @Override
    protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {

        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"THRSH_EXCEEDED_NOTIF\"." + joinColumnName + "=?";
    }

    @Override
    protected String getFindByExampleSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
    }

    @Override
    protected String getFindByExampleSelectAllStarSQL() {
        return "SELECT \"THRSH_EXCEEDED_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
    }

    @Override
    protected String getInsertIntoSQL() {
        return "INSERT INTO TBL_THRSH_EXCEEDED_NOTIF (\"ID\",\"TYPE\",\"CREATED_ON\",\"MESSAGE\",\"NAME\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\",\"LOB_CONFIGURATION_ENTRY_ID\") VALUES (?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateSet() {
        return "UPDATE TBL_THRSH_EXCEEDED_NOTIF SET \"TYPE\"=?,\"CREATED_ON\"=?,\"MESSAGE\"=?,\"NAME\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=?,\"LOB_CONFIGURATION_ENTRY_ID\"=? WHERE \"ID\"=?";
    }

    @Override
    protected String getDeleteFromSQL() {
        return "DELETE FROM TBL_THRSH_EXCEEDED_NOTIF WHERE \"ID\"=?";
    }

    @Override
    protected ThresholdExceededNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {


        ThresholdExceededNotification nextResult = null;

        String type = rs.getString("TYPE");

        String className = type;

        if (className.indexOf("com.pulse.mo.") != 0) {
            className = "com.pulse.mo." + className;
        }
        try {
            nextResult = (ThresholdExceededNotification) MappedClass.forName(className).newInstance();
        } catch (Exception e) {
            // Do nothing.
        }

        if (nextResult == null) {
            nextResult = new ThresholdExceededNotification();
        }


        // ID
        nextResult.setID(rs.getString("ID"));

        if (!shellOnly) {
            nextResult.setType(rs.getString("TYPE"));


            nextResult.setCreatedOn(DateUtils.utilDateFromSqlTimestamp(rs.getTimestamp("CREATED_ON")));


            nextResult.setMessage(rs.getString("MESSAGE"));


            nextResult.setName(rs.getString("NAME"));

            nextResult.setIsRead(rs.getBoolean("IS_READ"));

            String agentID = rs.getString("AGENT_ID");
            if (StringUtils.hasText(agentID) && !"null".equalsIgnoreCase(agentID)) {
                Agent agent = new Agent();
                agent.setID(agentID);
                nextResult.setAgent(agent);
            }


            String lobconfigurationID = rs.getString("LOB_CONFIGURATION_ID");
            if (StringUtils.hasText(lobconfigurationID) && !"null".equalsIgnoreCase(lobconfigurationID)) {
                LOBConfiguration lobconfiguration = new LOBConfiguration();
                lobconfiguration.setID(lobconfigurationID);
                nextResult.setLOBConfiguration(lobconfiguration);
            }


            String teamleaderID = rs.getString("TEAM_LEADER_ID");
            if (StringUtils.hasText(teamleaderID) && !"null".equalsIgnoreCase(teamleaderID)) {
                TeamLeader teamleader = new TeamLeader();
                teamleader.setID(teamleaderID);
                nextResult.setTeamLeader(teamleader);
            }


            String lobconfigurationentryID = rs.getString("LOB_CONFIGURATION_ENTRY_ID");
            if (StringUtils.hasText(lobconfigurationentryID) && !"null".equalsIgnoreCase(lobconfigurationentryID)) {
                LOBConfigurationEntry lobconfigurationentry = new LOBConfigurationEntry();
                lobconfigurationentry.setID(lobconfigurationentryID);
                nextResult.setLOBConfigurationEntry(lobconfigurationentry);
            }


        }


        return nextResult;
    }

    protected void setBaseStatmentInsertParams(ThresholdExceededNotification perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getID());
        pstmt.setString(2, perceroObject.getType());
        pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
        pstmt.setString(4, perceroObject.getName());

        if (perceroObject.getTeamLeader() == null) {
            pstmt.setString(5, null);
        } else {
            pstmt.setString(5, perceroObject.getTeamLeader().getID());
        }

        if (perceroObject.getAgent() == null) {
            pstmt.setString(6, null);
        } else {
            pstmt.setString(6, perceroObject.getAgent().getID());
        }
        pstmt.setString(7, perceroObject.getMessage());

        if (perceroObject.getLOBConfiguration() == null) {
            pstmt.setString(8, null);
        } else {
            pstmt.setString(8, perceroObject.getLOBConfiguration().getID());
        }

        if (perceroObject.getLOBConfigurationEntry() == null) {
            pstmt.setString(9, null);
        } else {
            pstmt.setString(9, perceroObject.getLOBConfigurationEntry().getID());
        }
        pstmt.setBoolean(10, perceroObject.getIsRead());
    }

    @Override
    protected void setPreparedStatmentInsertParams(ThresholdExceededNotification perceroObject, PreparedStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);

    }

    @Override
    protected void setCallableStatmentInsertParams(ThresholdExceededNotification perceroObject, CallableStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);


    }

    @Override
    protected void setPreparedStatmentUpdateParams(ThresholdExceededNotification perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getID());
        pstmt.setString(2, perceroObject.getType());
        pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
        pstmt.setString(4, perceroObject.getName());

        if (perceroObject.getTeamLeader() == null) {
            pstmt.setString(5, null);
        } else {
            pstmt.setString(5, perceroObject.getTeamLeader().getID());
        }

        if (perceroObject.getAgent() == null) {
            pstmt.setString(6, null);
        } else {
            pstmt.setString(6, perceroObject.getAgent().getID());
        }
        pstmt.setString(7, perceroObject.getMessage());

        if (perceroObject.getLOBConfiguration() == null) {
            pstmt.setString(8, null);
        } else {
            pstmt.setString(8, perceroObject.getLOBConfiguration().getID());
        }

        if (perceroObject.getLOBConfigurationEntry() == null) {
            pstmt.setString(9, null);
        } else {
            pstmt.setString(9, perceroObject.getLOBConfigurationEntry().getID());
        }
        pstmt.setBoolean(10, perceroObject.getIsRead());
    }


    @Override
    protected void setCallableStatmentUpdateParams(ThresholdExceededNotification perceroObject, CallableStatement pstmt) throws SQLException {

        //must be in same order as insert
        setBaseStatmentInsertParams(perceroObject, pstmt);

    }


    @Override
    public List<ThresholdExceededNotification> findByExample(ThresholdExceededNotification theQueryObject,
                                                             List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException {


        String sql = getFindByExampleSelectSql(shellOnly);

        int propertyCounter = 0;
        List<Object> paramValues = new ArrayList<Object>();

        boolean useType = StringUtils.hasText(theQueryObject.getType()) && (excludeProperties == null || !excludeProperties.contains("type"));

        if (useType) {
            sql += " WHERE ";
            sql += " \"TYPE\" =? ";
            paramValues.add(theQueryObject.getType());
            propertyCounter++;
        }

        boolean useCreatedOn = theQueryObject.getCreatedOn() != null && (excludeProperties == null || !excludeProperties.contains("createdOn"));

        if (useCreatedOn) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"CREATED_ON\" =? ";
            paramValues.add(theQueryObject.getCreatedOn());
            propertyCounter++;
        }

        boolean useMessage = StringUtils.hasText(theQueryObject.getMessage()) && (excludeProperties == null || !excludeProperties.contains("message"));

        if (useMessage) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"MESSAGE\" =? ";
            paramValues.add(theQueryObject.getMessage());
            propertyCounter++;
        }

        boolean useName = StringUtils.hasText(theQueryObject.getName()) && (excludeProperties == null || !excludeProperties.contains("name"));

        if (useName) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"NAME\" =? ";
            paramValues.add(theQueryObject.getName());
            propertyCounter++;
        }

        boolean useAgentID = theQueryObject.getAgent() != null && (excludeProperties == null || !excludeProperties.contains("agent"));

        if (useAgentID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"AGENT_ID\" =? ";
            paramValues.add(theQueryObject.getAgent().getID());
            propertyCounter++;
        }

        boolean useLOBConfigurationID = theQueryObject.getLOBConfiguration() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfiguration"));

        if (useLOBConfigurationID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"LOB_CONFIGURATION_ID\" =? ";
            paramValues.add(theQueryObject.getLOBConfiguration().getID());
            propertyCounter++;
        }

        boolean useTeamLeaderID = theQueryObject.getTeamLeader() != null && (excludeProperties == null || !excludeProperties.contains("teamLeader"));

        if (useTeamLeaderID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"TEAM_LEADER_ID\" =? ";
            paramValues.add(theQueryObject.getTeamLeader().getID());
            propertyCounter++;
        }

        boolean useLOBConfigurationEntryID = theQueryObject.getLOBConfigurationEntry() != null && (excludeProperties == null || !excludeProperties.contains("lOBConfigurationEntry"));

        if (useLOBConfigurationEntryID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"LOB_CONFIGURATION_ENTRY_ID\" =? ";
            paramValues.add(theQueryObject.getLOBConfigurationEntry().getID());
            propertyCounter++;
        }

        boolean useIsRead = theQueryObject.getIsRead() != null && (excludeProperties == null || !excludeProperties.contains("isRead"));

        if (useIsRead) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"IS_READ\" =? ";
            paramValues.add(theQueryObject.getIsRead());
            propertyCounter++;
        }

        if (propertyCounter == 0) {
            throw new SyncException(SyncException.METHOD_UNSUPPORTED, SyncException.METHOD_UNSUPPORTED_CODE);
        }

        return executeSelectWithParams(sql, paramValues.toArray(), shellOnly);
    }

    @Override
    protected String getUpdateCallableStatementSql() {
        return "{call UPDATE_THRSH_EXCEEDED_NOTI(?,?,?,?,?,?,?,?,?,?)}";
    }

    @Override
    protected String getInsertCallableStatementSql() {
        return "{call CREATE_THRSH_EXCEEDED_NOTI(?,?,?,?,?,?,?,?,?,?)}";
    }

    @Override
    protected String getDeleteCallableStatementSql() {
        return "{call Delete_THRSH_EXCEEDED_NOTI(?)}";
    }


}

