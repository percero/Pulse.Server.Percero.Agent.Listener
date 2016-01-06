

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
public class LOBConfigurationNotificationDAO extends SqlDataAccessProcObject<LOBConfigurationNotification> implements IDataAccessObject<LOBConfigurationNotification> {

    static final Logger log = Logger.getLogger(LOBConfigurationNotificationDAO.class);


    public LOBConfigurationNotificationDAO() {
        super();

        DAORegistry.getInstance().registerDataAccessObject(LOBConfigurationNotification.class.getCanonicalName(), this);
    }


    // This is the name of the Data Source that is registered to handle this class type.
    // For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
    public static final String CONNECTION_FACTORY_NAME = "default";

    public static final String SHELL_ONLY_SELECT = "\"LOB_CONFIGURATION_NOTIF\".\"ID\",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\"";
    public static final String SQL_VIEW = ",\"LOB_CONFIGURATION_NOTIF\".\"TYPE\",\"LOB_CONFIGURATION_NOTIF\".\"CREATED_ON\",\"LOB_CONFIGURATION_NOTIF\".\"MESSAGE\",\"LOB_CONFIGURATION_NOTIF\".\"NAME\",\"LOB_CONFIGURATION_NOTIF\".\"AGENT_ID\",\"LOB_CONFIGURATION_NOTIF\".\"LOB_CONFIGURATION_ID\",\"LOB_CONFIGURATION_NOTIF\".\"TEAM_LEADER_ID\",\"LOB_CONFIGURATION_NOTIF\".\"CMS_ENTRY_ID\",\"LOB_CONFIGURATION_NOTIF\".\"WORKED_ID\",\"LOB_CONFIGURATION_NOTIF\".\"IS_READ\"";
    private String selectFromStatementTableName = " FROM \"LOB_CONFIGURATION_NOTIF\" \"LOB_CONFIGURATION_NOTIF\"";
    private String whereClause = "  WHERE \"LOB_CONFIGURATION_NOTIF\".\"ID\"=?";
    private String whereInClause = "  join table(sys.dbms_debug_vc2coll(?)) SQLLIST on \"LOB_CONFIGURATION_NOTIF\".\"ID\"= SQLLIST.column_value";
    private String orderByTableName = "  ORDER BY \"LOB_CONFIGURATION_NOTIF\".\"ID\"";


    @Override
    protected String getConnectionFactoryName() {
        return LOBConfigurationNotificationDAO.CONNECTION_FACTORY_NAME;
    }

    @Override
    protected String getSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereClause;
    }

    @Override
    protected String getSelectStarSQL() {
        return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\"" + SQL_VIEW + selectFromStatementTableName + whereClause;
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
        return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName;
    }

    @Override
    protected String getSelectAllStarWithLimitAndOffsetSQL() {
        return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + orderByTableName + " LIMIT ? OFFSET ?";
    }

    @Override
    protected String getCountAllSQL() {
        return "SELECT COUNT(ID) " + selectFromStatementTableName;
    }

    @Override
    protected String getSelectInStarSQL() {
        return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectInShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + whereInClause;
    }

    @Override
    protected String getSelectByRelationshipStarSQL(String joinColumnName) {

        return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_NOTIF\"." + joinColumnName + "=?";
    }

    @Override
    protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {

        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName + " WHERE \"LOB_CONFIGURATION_NOTIF\"." + joinColumnName + "=?";
    }

    @Override
    protected String getFindByExampleSelectShellOnlySQL() {
        return "SELECT " + SHELL_ONLY_SELECT + " " + selectFromStatementTableName;
    }

    @Override
    protected String getFindByExampleSelectAllStarSQL() {
        return "SELECT \"LOB_CONFIGURATION_NOTIF\".\"ID\"" + SQL_VIEW + " " + selectFromStatementTableName;
    }

    @Override
    protected String getInsertIntoSQL() {
        return "INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (\"ID\",\"TYPE\",\"CREATED_ON\",\"MESSAGE\",\"NAME\",\"AGENT_ID\",\"LOB_CONFIGURATION_ID\",\"TEAM_LEADER_ID\") VALUES (?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateSet() {
        return "UPDATE TBL_LOB_CONFIGURATION_NOTIF SET \"TYPE\"=?,\"CREATED_ON\"=?,\"MESSAGE\"=?,\"NAME\"=?,\"AGENT_ID\"=?,\"LOB_CONFIGURATION_ID\"=?,\"TEAM_LEADER_ID\"=? WHERE \"ID\"=?";
    }

    @Override
    protected String getDeleteFromSQL() {
        return "DELETE FROM TBL_LOB_CONFIGURATION_NOTIF WHERE \"ID\"=?";
    }

    @Override
    protected LOBConfigurationNotification extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {


        LOBConfigurationNotification nextResult = null;

        String type = rs.getString("TYPE");

        String className = type;

        if (className.indexOf("com.pulse.mo.") != 0) {
            className = "com.pulse.mo." + className;
        }
        try {
            nextResult = (LOBConfigurationNotification) MappedClass.forName(className).newInstance();
        } catch (Exception e) {
            // Do nothing.
        }

        if (nextResult == null) {
            nextResult = new LOBConfigurationNotification();
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

            int cMSEntryID = rs.getInt("CMS_ENTRY_ID");
            if (cMSEntryID > 0) {
                CMSEntry cMSEntry = new CMSEntry();
                cMSEntry.setID(String.valueOf(cMSEntryID));

                nextResult.setCMSEntry(cMSEntry);
            }

            int timecardID = rs.getInt("WORKED_ID");
            if (timecardID > 0) {
                TimecardEntry timecardEntry = new TimecardEntry();
                timecardEntry.setID(String.valueOf(timecardID));
                nextResult.setTimecardEntry(timecardEntry);
            }

        }


        return nextResult;
    }

    protected void setBaseStatmentInsertParams(LOBConfigurationNotification perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getID());
        pstmt.setString(2, perceroObject.getType());
        pstmt.setDate(3, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
        pstmt.setString(4, perceroObject.getMessage());
        pstmt.setString(5, perceroObject.getName());

        if (perceroObject.getAgent() == null) {
            pstmt.setString(6, null);
        } else {
            pstmt.setString(6, perceroObject.getAgent().getID());
        }


        if (perceroObject.getLOBConfiguration() == null) {
            pstmt.setString(7, null);
        } else {
            pstmt.setString(7, perceroObject.getLOBConfiguration().getID());
        }


        if (perceroObject.getTeamLeader() == null) {
            pstmt.setString(8, null);
        } else {
            pstmt.setString(8, perceroObject.getTeamLeader().getID());
        }

        pstmt.setBoolean(9, perceroObject.getIsRead());

    }

    @Override
    protected void setPreparedStatmentInsertParams(LOBConfigurationNotification perceroObject, PreparedStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);

    }

    @Override
    protected void setCallableStatmentInsertParams(LOBConfigurationNotification perceroObject, CallableStatement pstmt) throws SQLException {

        setBaseStatmentInsertParams(perceroObject, pstmt);


    }

    @Override
    protected void setPreparedStatmentUpdateParams(LOBConfigurationNotification perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getType());
        pstmt.setDate(2, DateUtils.utilDateToSqlDate(perceroObject.getCreatedOn()));
        pstmt.setString(3, perceroObject.getMessage());
        pstmt.setString(4, perceroObject.getName());

        if (perceroObject.getAgent() == null) {
            pstmt.setString(5, null);
        } else {
            pstmt.setString(5, perceroObject.getAgent().getID());
        }


        if (perceroObject.getLOBConfiguration() == null) {
            pstmt.setString(6, null);
        } else {
            pstmt.setString(6, perceroObject.getLOBConfiguration().getID());
        }


        if (perceroObject.getTeamLeader() == null) {
            pstmt.setString(7, null);
        } else {
            pstmt.setString(7, perceroObject.getTeamLeader().getID());
        }

        pstmt.setString(8, perceroObject.getID());

        pstmt.setBoolean(9, perceroObject.getIsRead());

    }


    @Override
    protected void setCallableStatmentUpdateParams(LOBConfigurationNotification perceroObject, CallableStatement pstmt) throws SQLException {

        //must be in same order as insert
        setBaseStatmentInsertParams(perceroObject, pstmt);

    }


    @Override
    public List<LOBConfigurationNotification> findByExample(LOBConfigurationNotification theQueryObject,
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

        boolean useCMSEntryID = theQueryObject.getCMSEntry() != null && (excludeProperties == null || !excludeProperties.contains("cMSEntry"));

        if (useCMSEntryID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"CMS_ENTRY_ID\" =? ";
            paramValues.add(theQueryObject.getCMSEntry().getID());
            propertyCounter++;
        }


        boolean useTimecardEntryID = theQueryObject.getTimecardEntry() != null && (excludeProperties == null || !excludeProperties.contains("timecardEntry"));

        if (useTimecardEntryID) {
            if (propertyCounter > 0) {
                sql += " AND ";
            } else {
                sql += " WHERE ";
            }
            sql += " \"WORKED_ID\" =? ";
            paramValues.add(theQueryObject.getTimecardEntry().getID());
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
        return "{call UPDATE_LOB_CONFIGURATION_NOTIF(?,?,?,?,?,?,?,?,?)}";
    }

    @Override
    protected String getInsertCallableStatementSql() {
        return "{call CREATE_LOB_CONFIGURATION_NOTIF(?,?,?,?,?,?,?,?,?)}";
    }

    @Override
    protected String getDeleteCallableStatementSql() {
        return "{call Delete_LOB_CONFIGURATION_NOTIF(?)}";
    }


}

