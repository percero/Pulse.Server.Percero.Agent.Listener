create or replace PROCEDURE CREATE_DISCREPANCY_DETECT_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

  INSERT INTO TBL_DISCREPANCY_DETECTED_NOTIF (ID, AUX_CODE_ENTRY_NAME, TIMECARD_ACTIVITY_ID)
    VALUES (vID, vAUX_CODE_ENTRY_NAME, vTIMECARD_ACTIVITY_ID);

  INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID)
    VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID);

  INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
    VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);

END CREATE_DISCREPANCY_DETECT_NOTI;
/

create or replace PROCEDURE CREATE_DURATION_MISMATCH_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2
) AS
BEGIN
    DECLARE vHashKey NVARCHAR2(25);

    BEGIN
        SELECT ORA_HASH(vType || vTimecard_Entry_ID) INTO vHashKey FROM DUAL;

          INSERT INTO TBL_DURATION_MISMATCH_NOTIF (ID)
            VALUES ( vID );

          INSERT INTO TBL_DISCREPANCY_DETECTED_NOTIF (ID, AUX_CODE_ENTRY_NAME, TIMECARD_ACTIVITY_ID)
            VALUES (vID, vAUX_CODE_ENTRY_NAME, vTIMECARD_ACTIVITY_ID);

          INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID, WORKED_ID, HASH_KEY)
            VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vTimecard_Entry_ID, vHashKey);

          INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
            VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);
    EXCEPTION  -- exception handlers begin

     WHEN OTHERS THEN  -- handles all other errors
           ROLLBACK;
    END;


END CREATE_DURATION_MISMATCH_NOTI;
/

create or replace PROCEDURE CREATE_DURATION_TOLERANCE_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN
      DECLARE vHashKey NVARCHAR2(25);


      BEGIN
          SELECT ORA_HASH(vType || vTimecard_Entry_ID) INTO vHashKey FROM DUAL;



          INSERT INTO TBL_DURATION_TOLERANCE_NOTIF (ID)
            VALUES ( vID );

          INSERT INTO TBL_THRSH_EXCEEDED_NOTIF (ID, LOB_CONFIGURATION_ENTRY_ID)
            VALUES (vID, vLOB_CONFIGURATION_ENTRY_ID);

          INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID, WORKED_ID, HASH_KEY)
            VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vTimecard_Entry_ID, vHashKey);

          INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
            VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);

      EXCEPTION  -- exception handlers begin

      WHEN OTHERS THEN  -- handles all other errors
            ROLLBACK;
      END;

END CREATE_DURATION_TOLERANCE_NOTI;
/

create or replace PROCEDURE CREATE_INV_ACTVTY_CODE_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN
      DECLARE vHashKey NVARCHAR2(25);


      BEGIN
          SELECT ORA_HASH(vType || vTimecard_Entry_ID) INTO vHashKey FROM DUAL;

          INSERT INTO TBL_INV_ACTVTY_CODE_NOTIF (ID)
            VALUES ( vID );

          INSERT INTO TBL_THRSH_EXCEEDED_NOTIF (ID, LOB_CONFIGURATION_ENTRY_ID)
            VALUES (vID, vLOB_CONFIGURATION_ENTRY_ID);


          INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID, WORKED_ID, HASH_KEY)
            VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vTimecard_Entry_ID, vHashKey);

          INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
            VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);
      EXCEPTION  -- exception handlers begin

      WHEN OTHERS THEN  -- handles all other errors
            ROLLBACK;
      END;

END CREATE_INV_ACTVTY_CODE_NOTI;
/

create or replace PROCEDURE CREATE_NON_BILLABLE_ACT_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN
      DECLARE vHashKey NVARCHAR2(25);


      BEGIN
          SELECT ORA_HASH(vType || vTimecard_Entry_ID) INTO vHashKey FROM DUAL;

          INSERT INTO TBL_NON_BILLABLE_ACTVTY_NOTIF (ID)
            VALUES ( vID );

          INSERT INTO TBL_DISCREPANCY_DETECTED_NOTIF (ID, AUX_CODE_ENTRY_NAME, TIMECARD_ACTIVITY_ID)
            VALUES (vID, vAUX_CODE_ENTRY_NAME, vTIMECARD_ACTIVITY_ID);

          INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID, WORKED_ID, HASH_KEY)
            VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vTimecard_Entry_ID, vHashKey);

          INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
            VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);

      EXCEPTION  -- exception handlers begin

      WHEN OTHERS THEN  -- handles all other errors
            ROLLBACK;
      END;


END CREATE_NON_BILLABLE_ACT_NOTI;
/

create or replace PROCEDURE CREATE_OCCUR_MISMATCH_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2
) AS
BEGIN
      DECLARE vHashKey NVARCHAR2(25);


      BEGIN
          SELECT ORA_HASH(vType || vTimecard_Entry_ID) INTO vHashKey FROM DUAL;

          INSERT INTO TBL_OCCURRENCE_MISMATCH_NOTIF (ID)
            VALUES ( vID );

          INSERT INTO TBL_DISCREPANCY_DETECTED_NOTIF (ID, AUX_CODE_ENTRY_NAME, TIMECARD_ACTIVITY_ID)
            VALUES (vID, vAUX_CODE_ENTRY_NAME, vTIMECARD_ACTIVITY_ID);

          INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID, WORKED_ID, HASH_KEY)
            VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vTimecard_Entry_ID, vHashKey);

          INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
            VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);

      EXCEPTION  -- exception handlers begin

      WHEN OTHERS THEN  -- handles all other errors
            ROLLBACK;
      END;

END CREATE_OCCUR_MISMATCH_NOTI;
/

create or replace PROCEDURE CREATE_OCCUR_TOLERANCE_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

      DECLARE vHashKey NVARCHAR2(25);


      BEGIN
          SELECT ORA_HASH(vType || vTimecard_Entry_ID) INTO vHashKey FROM DUAL;


          INSERT INTO TBL_OCCURRENCE_TOLERANCE_NOTIF (ID)
            VALUES ( vID );

          INSERT INTO TBL_THRSH_EXCEEDED_NOTIF (ID, LOB_CONFIGURATION_ENTRY_ID)
            VALUES (vID, vLOB_CONFIGURATION_ENTRY_ID);

          INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID,WORKED_ID, HASH_KEY)
            VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vTimecard_Entry_ID, vHashKey);

          INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
            VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);

      EXCEPTION  -- exception handlers begin

      WHEN OTHERS THEN  -- handles all other errors
            ROLLBACK;
      END;


END CREATE_OCCUR_TOLERANCE_NOTI;
/

create or replace PROCEDURE CREATE_THRSH_EXCEEDED_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

  INSERT INTO TBL_THRSH_EXCEEDED_NOTIF (ID, LOB_CONFIGURATION_ENTRY_ID)
    VALUES (vID, vLOB_CONFIGURATION_ENTRY_ID);

  INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID)
    VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID);

  INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
    VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);

END CREATE_THRSH_EXCEEDED_NOTI;
/

create or replace PROCEDURE CREATE_WORK_DURATION_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vCMS_ENTRY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2

) AS
BEGIN

      DECLARE vHashKey NVARCHAR2(25); vCnt INT DEFAULT 0; vNewID NVARCHAR2(36);

      BEGIN
          SELECT COUNT(CMS_ENTRY_ID) INTO vCnt  FROM WORK_DURATION_NOTIFICATION WHERE CMS_ENTRY_ID = vCMS_ENTRY_ID;
          IF (vCnt <= 0) THEN

              SELECT ORA_HASH(vType || vCMS_ENTRY_ID) INTO vHashKey FROM DUAL;

              INSERT INTO TBL_WORK_DURATION_NOTIFICATION (ID)
                VALUES ( vID );

              INSERT INTO TBL_THRSH_EXCEEDED_NOTIF (ID, LOB_CONFIGURATION_ENTRY_ID)
                VALUES (vID, vLOB_CONFIGURATION_ENTRY_ID);

              INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID, CMS_ENTRY_ID, HASH_KEY)
                VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vCMS_ENTRY_ID, vHashKey);

              INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
                VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);
          ELSE
              SELECT ID INTO vNewID FROM WORK_DURATION_NOTIFICATION WHERE CMS_ENTRY_ID = vCMS_ENTRY_ID;
              UPDATE_WORK_DURATION_NOTI (vID, vTYPE, vCREATED_ON, vNAME, vTEAM_LEADER_ID, vAGENT_ID, vMESSAGE, vLOB_CONFIGURATION_ID, vLOB_CONFIGURATION_ENTRY_ID, vCMS_ENTRY_ID, vIsRead);

          END IF;
      EXCEPTION  -- exception handlers begin

      WHEN OTHERS THEN  -- handles all other errors
            ROLLBACK;
      END;
END CREATE_WORK_DURATION_NOTI;
/

create or replace PROCEDURE CREATE_WORK_MODE_OCCUR_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vCMS_ENTRY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN
      DECLARE vHashKey NVARCHAR2(25); vCnt INT DEFAULT 0; vNewID NVARCHAR2(36);

      BEGIN
          SELECT COUNT(CMS_ENTRY_ID) INTO vCnt  FROM WORK_MODE_OCCURRENCE_NOTIF WHERE CMS_ENTRY_ID = vCMS_ENTRY_ID;

          IF (vCnt <= 0) THEN

              SELECT ORA_HASH(vType || vCMS_ENTRY_ID) INTO vHashKey FROM DUAL;

              INSERT INTO TBL_WORK_MODE_OCCURRENCE_NOTIF (ID)
                VALUES ( vID );

              INSERT INTO TBL_THRSH_EXCEEDED_NOTIF (ID, LOB_CONFIGURATION_ENTRY_ID)
                VALUES (vID, vLOB_CONFIGURATION_ENTRY_ID);

              INSERT INTO TBL_LOB_CONFIGURATION_NOTIF (ID, MESSAGE, AGENT_ID, LOB_CONFIGURATION_ID, CMS_ENTRY_ID, HASH_KEY)
                VALUES (vID, vMESSAGE, vAGENT_ID, vLOB_CONFIGURATION_ID, vCMS_ENTRY_ID, vHashKey);

              INSERT INTO TBL_NOTIFICATION (ID, TYPE, NAME, CREATED_ON, TEAM_LEADER_ID, IS_READ)
                VALUES (vID, vTYPE, vNAME, vCREATED_ON, vTEAM_LEADER_ID, vIsRead);

          ELSE
              SELECT ID INTO vNewID FROM WORK_MODE_OCCURRENCE_NOTIF WHERE CMS_ENTRY_ID = vCMS_ENTRY_ID;
              UPDATE_WORK_MODE_OCCUR_NOTI(vID, vTYPE, vCREATED_ON, vNAME, vTEAM_LEADER_ID, vAGENT_ID, vMESSAGE, vLOB_CONFIGURATION_ID, vLOB_CONFIGURATION_ENTRY_ID, vCMS_ENTRY_ID, vIsRead);

          END IF;
      EXCEPTION -- exception handlers begin

      WHEN OTHERS THEN  -- handles all other errors
            ROLLBACK;
      END;

END CREATE_WORK_MODE_OCCUR_NOTI;
/

create or replace PROCEDURE UPDATE_DISCREPANCY_DETECT_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID
    WHERE ID = vID;

    UPDATE TBL_DISCREPANCY_DETECTED_NOTIF
      SET AUX_CODE_ENTRY_NAME = vAUX_CODE_ENTRY_NAME,
          TIMECARD_ACTIVITY_ID = vTIMECARD_ACTIVITY_ID
    WHERE ID = vID;

END UPDATE_DISCREPANCY_DETECT_NOTI;
/

create or replace PROCEDURE UPDATE_DURATION_MISMATCH_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID
    WHERE ID = vID;

    UPDATE TBL_DISCREPANCY_DETECTED_NOTIF
      SET AUX_CODE_ENTRY_NAME = vAUX_CODE_ENTRY_NAME,
          TIMECARD_ACTIVITY_ID = vTIMECARD_ACTIVITY_ID
    WHERE ID = vID;

END UPDATE_DURATION_MISMATCH_NOTI;
/

create or replace PROCEDURE UPDATE_DURATION_TOLERANCE_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID,
           WORKED_ID = vTimecard_Entry_ID
    WHERE ID = vID;

    UPDATE TBL_THRSH_EXCEEDED_NOTIF
      SET LOB_CONFIGURATION_ENTRY_ID = vLOB_CONFIGURATION_ENTRY_ID
    WHERE ID = vID;

END UPDATE_DURATION_TOLERANCE_NOTI;
/

create or replace PROCEDURE UPDATE_INV_ACTVTY_CODE_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID,
           WORKED_ID = vTimecard_Entry_ID
    WHERE ID = vID;

    UPDATE TBL_THRSH_EXCEEDED_NOTIF
      SET LOB_CONFIGURATION_ENTRY_ID = vLOB_CONFIGURATION_ENTRY_ID
    WHERE ID = vID;

END UPDATE_INV_ACTVTY_CODE_NOTI;
/

create or replace PROCEDURE UPDATE_NON_BILLABLE_ACT_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID,
           WORKED_ID = vTimecard_Entry_ID
    WHERE ID = vID;

    UPDATE TBL_DISCREPANCY_DETECTED_NOTIF
      SET AUX_CODE_ENTRY_NAME = vAUX_CODE_ENTRY_NAME,
          TIMECARD_ACTIVITY_ID = vTIMECARD_ACTIVITY_ID
    WHERE ID = vID;

END UPDATE_NON_BILLABLE_ACT_NOTI;
/

create or replace PROCEDURE UPDATE_OCCUR_MISMATCH_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vAUX_CODE_ENTRY_NAME IN NVARCHAR2,
  vTIMECARD_ACTIVITY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID
    WHERE ID = vID;

    UPDATE TBL_DISCREPANCY_DETECTED_NOTIF
      SET AUX_CODE_ENTRY_NAME = vAUX_CODE_ENTRY_NAME,
          TIMECARD_ACTIVITY_ID = vTIMECARD_ACTIVITY_ID
    WHERE ID = vID;

END UPDATE_OCCUR_MISMATCH_NOTI;
/


create or replace PROCEDURE UPDATE_OCCUR_TOLERANCE_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vTimecard_Entry_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID,
           WORKED_ID = vTimecard_Entry_ID
    WHERE ID = vID;

    UPDATE TBL_THRSH_EXCEEDED_NOTIF
      SET LOB_CONFIGURATION_ENTRY_ID = vLOB_CONFIGURATION_ENTRY_ID
    WHERE ID = vID;

END UPDATE_OCCUR_TOLERANCE_NOTI;
/

create or replace PROCEDURE UPDATE_THRSH_EXCEEDED_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID
    WHERE ID = vID;

    UPDATE TBL_THRSH_EXCEEDED_NOTIF
      SET LOB_CONFIGURATION_ENTRY_ID = vLOB_CONFIGURATION_ENTRY_ID
    WHERE ID = vID;

END UPDATE_THRSH_EXCEEDED_NOTI;
/

create or replace PROCEDURE UPDATE_WORK_DURATION_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vCMS_ENTRY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID,
           CMS_ENTRY_ID = vCMS_ENTRY_ID
    WHERE ID = vID;

    UPDATE TBL_THRSH_EXCEEDED_NOTIF
      SET LOB_CONFIGURATION_ENTRY_ID = vLOB_CONFIGURATION_ENTRY_ID
    WHERE ID = vID;

END UPDATE_WORK_DURATION_NOTI;
/

create or replace PROCEDURE UPDATE_WORK_MODE_OCCUR_NOTI
(
  vID IN NVARCHAR2,
  vTYPE IN NVARCHAR2,
  vCREATED_ON IN DATE,
  vNAME IN NVARCHAR2,
  vTEAM_LEADER_ID IN NVARCHAR2,
  vAGENT_ID IN NVARCHAR2,
  vMESSAGE IN NVARCHAR2,
  vLOB_CONFIGURATION_ID IN NVARCHAR2,
  vLOB_CONFIGURATION_ENTRY_ID IN NVARCHAR2,
  vCMS_ENTRY_ID IN NVARCHAR2,
  vIsRead IN NVARCHAR2
) AS
BEGIN

    UPDATE TBL_NOTIFICATION
      SET  TYPE = vTYPE,
           NAME = vNAME,
           TEAM_LEADER_ID = vTEAM_LEADER_ID, IS_READ = vIsRead, CREATED_ON=vCREATED_ON
    WHERE ID = vID;

    UPDATE TBL_LOB_CONFIGURATION_NOTIF
      SET  MESSAGE = vMESSAGE,
           AGENT_ID = vAGENT_ID,
           LOB_CONFIGURATION_ID = vLOB_CONFIGURATION_ID,
           CMS_ENTRY_ID = vCMS_ENTRY_ID
    WHERE ID = vID;

    UPDATE TBL_THRSH_EXCEEDED_NOTIF
      SET LOB_CONFIGURATION_ENTRY_ID = vLOB_CONFIGURATION_ENTRY_ID
    WHERE ID = vID;

END UPDATE_WORK_MODE_OCCUR_NOTI;
/