

package com.pulse.mo.dao;

import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.dao.IDataAccessObject;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.mo.TeamLeader;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
import com.pulse.mo.TeamLeader;
import com.pulse.mo.Notification;
import com.pulse.mo.Agent;
import com.pulse.mo.Alert;
import com.pulse.mo.AdhocCoachingSession;
import com.pulse.mo.AdhocTask;
import com.pulse.mo.AppAction;
import com.pulse.mo.DevelopmentActivity;
import com.pulse.mo.GeneralComment;
import com.pulse.mo.UserSession;
import com.pulse.mo.TeamLeaderImpersonation;
import com.pulse.mo.TeamLeaderAction;
import com.pulse.mo.Setting;
import com.pulse.mo.Supervisor;

*/

@Component
public class TeamLeaderDAO extends SqlDataAccessObject<TeamLeader> implements IDataAccessObject<TeamLeader> {

    static final Logger log = Logger.getLogger(TeamLeaderDAO.class);


    public TeamLeaderDAO() {
        super();

        DAORegistry.getInstance().registerDataAccessObject(TeamLeader.class.getCanonicalName(), this);
    }


    // This is the name of the Data Source that is registered to handle this class type.
    // For example, this might be "ECoaching" or "Default".
//	public static final String CONNECTION_FACTORY_NAME = "jdbc:mysql://pulse.cta6j6w4rrxw.us-west-2.rds.amazonaws.com:3306/Pulse?autoReconnect=true";
    public static final String CONNECTION_FACTORY_NAME = "default";
    @Override
    protected String getConnectionFactoryName() {
        return TeamLeaderDAO.CONNECTION_FACTORY_NAME;
    }

    @Override
    protected String getSelectShellOnlySQL() {
        return "SELECT TEAM_LEADER.ID FROM TEAM_LEADER TEAM_LEADER WHERE TEAM_LEADER.ID=?";
    }

    @Override
    protected String getSelectStarSQL() {
        return "SELECT TEAM_LEADER.ID,TEAM_LEADER.LAST_NAME,TEAM_LEADER.EMAIL_ADDRESS,TEAM_LEADER.FIRST_NAME,TEAM_LEADER.EMPLOYEE_ID,TEAM_LEADER.NOTIFICATION_COUNT,TEAM_LEADER.PHOTO_URI FROM TEAM_LEADER TEAM_LEADER WHERE TEAM_LEADER.ID=?";
    }

    @Override
    protected String getSelectAllShellOnlySQL() {
        return "SELECT TEAM_LEADER.ID FROM TEAM_LEADER TEAM_LEADER ORDER BY ID";
    }

    @Override
    protected String getSelectAllShellOnlyWithLimitAndOffsetSQL() {
        return "SELECT TEAM_LEADER.ID FROM TEAM_LEADER TEAM_LEADER ORDER BY TEAM_LEADER.ID LIMIT ? OFFSET ?";
    }

    @Override
    protected String getSelectAllStarSQL() {
        return "SELECT TEAM_LEADER.ID,TEAM_LEADER.LAST_NAME,TEAM_LEADER.EMAIL_ADDRESS,TEAM_LEADER.FIRST_NAME,TEAM_LEADER.EMPLOYEE_ID,TEAM_LEADER.NOTIFICATION_COUNT,TEAM_LEADER.PHOTO_URI FROM TEAM_LEADER TEAM_LEADER ORDER BY TEAM_LEADER.ID";
    }

    @Override
    protected String getSelectAllStarWithLimitAndOffsetSQL() {
        return "SELECT TEAM_LEADER.ID,TEAM_LEADER.LAST_NAME,TEAM_LEADER.EMAIL_ADDRESS,TEAM_LEADER.FIRST_NAME,TEAM_LEADER.EMPLOYEE_ID,TEAM_LEADER.NOTIFICATION_COUNT,TEAM_LEADER.PHOTO_URI FROM TEAM_LEADER TEAM_LEADER ORDER BY TEAM_LEADER.ID LIMIT ? OFFSET ?";
    }

    @Override
    protected String getCountAllSQL() {
        return "SELECT COUNT(ID) FROM TEAM_LEADER TEAM_LEADER";
    }

    @Override
    protected String getSelectInStarSQL() {
        return "SELECT TEAM_LEADER.ID,TEAM_LEADER.LAST_NAME,TEAM_LEADER.EMAIL_ADDRESS,TEAM_LEADER.FIRST_NAME,TEAM_LEADER.EMPLOYEE_ID,TEAM_LEADER.NOTIFICATION_COUNT,TEAM_LEADER.PHOTO_URI FROM TEAM_LEADER TEAM_LEADER WHERE TEAM_LEADER.ID IN (?)";
    }

    @Override
    protected String getSelectInShellOnlySQL() {
        return "SELECT TEAM_LEADER.ID FROM TEAM_LEADER TEAM_LEADER WHERE TEAM_LEADER.ID IN (?)";
    }

    @Override
    protected String getSelectByRelationshipStarSQL(String joinColumnName) {
        return "SELECT TEAM_LEADER.ID,TEAM_LEADER.LAST_NAME,TEAM_LEADER.EMAIL_ADDRESS,TEAM_LEADER.FIRST_NAME,TEAM_LEADER.EMPLOYEE_ID,TEAM_LEADER.NOTIFICATION_COUNT,TEAM_LEADER.PHOTO_URI FROM TEAM_LEADER TEAM_LEADER WHERE TEAM_LEADER." + joinColumnName + "=?";
    }

    @Override
    protected String getSelectByRelationshipShellOnlySQL(String joinColumnName) {
        return "SELECT TEAM_LEADER.ID FROM TEAM_LEADER TEAM_LEADER WHERE TEAM_LEADER." + joinColumnName + "=?";
    }

    @Override
    protected String getFindByExampleSelectShellOnlySQL() {
        return "SELECT TEAM_LEADER.ID FROM TEAM_LEADER TEAM_LEADER ";
    }

    @Override
    protected String getFindByExampleSelectAllStarSQL() {
        return "SELECT TEAM_LEADER.ID,TEAM_LEADER.LAST_NAME,TEAM_LEADER.EMAIL_ADDRESS,TEAM_LEADER.FIRST_NAME,TEAM_LEADER.EMPLOYEE_ID,TEAM_LEADER.NOTIFICATION_COUNT,TEAM_LEADER.PHOTO_URI FROM TEAM_LEADER TEAM_LEADER ";
    }

    @Override
    protected String getInsertIntoSQL() {
        return "INSERT INTO TEAM_LEADER (ID,LAST_NAME,EMAIL_ADDRESS,FIRST_NAME,EMPLOYEE_ID,NOTIFICATION_COUNT,PHOTO_URI) VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateSet() {
        return "UPDATE TEAM_LEADER SET LAST_NAME=?,EMAIL_ADDRESS=?,FIRST_NAME=?,EMPLOYEE_ID=?,NOTIFICATION_COUNT=?,PHOTO_URI=? WHERE ID=?";
    }

    @Override
    protected String getDeleteFromSQL() {
        return "DELETE FROM TEAM_LEADER WHERE ID=?";
    }

    @Override
    protected TeamLeader extractObjectFromResultSet(ResultSet rs, Boolean shellOnly) throws SQLException {
        TeamLeader nextResult = new TeamLeader();

        // ID
        nextResult.setID(rs.getString("ID"));

        if (!shellOnly)
        {
            nextResult.setLastName(rs.getString("LAST_NAME"));

            nextResult.setEmailAddress(rs.getString("EMAIL_ADDRESS"));

            nextResult.setFirstName(rs.getString("FIRST_NAME"));

            nextResult.setEmployeeId(rs.getString("EMPLOYEE_ID"));

            nextResult.setNotificationCount(rs.getInt("NOTIFICATION_COUNT"));

            nextResult.setPhotoUri(rs.getString("PHOTO_URI"));

        }

        return nextResult;
    }

    @Override
    protected void setPreparedStatmentInsertParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getID());
        pstmt.setString(2, perceroObject.getLastName());
        pstmt.setString(3, perceroObject.getEmailAddress());
        pstmt.setString(4, perceroObject.getFirstName());
        pstmt.setString(5, perceroObject.getEmployeeId());
        pstmt.setInt(6, perceroObject.getNotificationCount());
        pstmt.setString(7, perceroObject.getPhotoUri());

    }

    @Override
    protected void setPreparedStatmentUpdateParams(TeamLeader perceroObject, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, perceroObject.getLastName());
        pstmt.setString(2, perceroObject.getEmailAddress());
        pstmt.setString(3, perceroObject.getFirstName());
        pstmt.setString(4, perceroObject.getEmployeeId());
        pstmt.setInt(5, perceroObject.getNotificationCount());
        pstmt.setString(6, perceroObject.getPhotoUri());

        pstmt.setString(7, perceroObject.getID());


    }

    @Override
    public List<TeamLeader> findByExample(TeamLeader theQueryObject,
                                          List<String> excludeProperties, String userId, Boolean shellOnly) throws SyncException
    {



        String sql = getFindByExampleSelectSql(shellOnly);

        int propertyCounter = 0;
        List<Object> paramValues = new ArrayList<Object>();

        boolean useLastName = StringUtils.hasText(theQueryObject.getLastName()) && (excludeProperties == null || !excludeProperties.contains("lastName"));

        if (useLastName)
        {
            sql += " WHERE ";
            sql += " LAST_NAME=? ";
            paramValues.add(theQueryObject.getLastName());
            propertyCounter++;
        }

        boolean useEmailAddress = StringUtils.hasText(theQueryObject.getEmailAddress()) && (excludeProperties == null || !excludeProperties.contains("emailAddress"));

        if (useEmailAddress)
        {
            if (propertyCounter > 0)
            {
                sql += " AND ";
            }
            else
            {
                sql += " WHERE ";
            }
            sql += " EMAIL_ADDRESS=? ";
            paramValues.add(theQueryObject.getEmailAddress());
            propertyCounter++;
        }

        boolean useFirstName = StringUtils.hasText(theQueryObject.getFirstName()) && (excludeProperties == null || !excludeProperties.contains("firstName"));

        if (useFirstName)
        {
            if (propertyCounter > 0)
            {
                sql += " AND ";
            }
            else
            {
                sql += " WHERE ";
            }
            sql += " FIRST_NAME=? ";
            paramValues.add(theQueryObject.getFirstName());
            propertyCounter++;
        }

        boolean useEmployeeId = StringUtils.hasText(theQueryObject.getEmployeeId()) && (excludeProperties == null || !excludeProperties.contains("employeeId"));

        if (useEmployeeId)
        {
            if (propertyCounter > 0)
            {
                sql += " AND ";
            }
            else
            {
                sql += " WHERE ";
            }
            sql += " EMPLOYEE_ID=? ";
            paramValues.add(theQueryObject.getEmployeeId());
            propertyCounter++;
        }

        boolean useNotificationCount = theQueryObject.getNotificationCount() != null && (excludeProperties == null || !excludeProperties.contains("notificationCount"));

        if (useNotificationCount)
        {
            if (propertyCounter > 0)
            {
                sql += " AND ";
            }
            else
            {
                sql += " WHERE ";
            }
            sql += " NOTIFICATION_COUNT=? ";
            paramValues.add(theQueryObject.getNotificationCount());
            propertyCounter++;
        }

        boolean usePhotoUri = StringUtils.hasText(theQueryObject.getPhotoUri()) && (excludeProperties == null || !excludeProperties.contains("photoUri"));

        if (usePhotoUri)
        {
            if (propertyCounter > 0)
            {
                sql += " AND ";
            }
            else
            {
                sql += " WHERE ";
            }
            sql += " PHOTO_URI=? ";
            paramValues.add(theQueryObject.getPhotoUri());
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

