DECLARE
    teamLeaderId varchar2(12) := '&1';
    agentId      varchar2(12) := '&2';
    timecardDate varchar2(20) := '&3';
    startTime    varchar2(20) := '&4';
    endTime      varchar2(20) := '&5';
    auxReason    varchar2(20) := '&6';
    duration varchar2(12) := '0.0';
    vLoginId NUMBER;
    vSwiCode varchar2(12);
    vID NUMBER;
    updateTableId NUMBER;
BEGIN



SELECT to_char((to_date(endTime,'DD-MON-yyyyHH24:mi:ss')-to_date(startTime,'DD-MON-yyyyHH24:mi:ss'))*24*60*60, '9999999.99') into duration from DUAL;

select login_id into vLoginId from CMDCTR.rt_agent_detail rt  where employee_id = agentId ;
SELECT SWI_CODE INTO vSwiCode from CMDCTR.rt_agent_detail rt  where employee_id = agentId ;

SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;

INSERT INTO pulse.MOB_CMS_DATA(START_TIME,END_TIME,EVENT_DURATION,AUXREASON,SWI_CODE,LOGIN_ID,ID)
VALUES( to_date(startTime,'DD-MON-yyyyHH24:mi:ss'),to_date(endTime,'DD-MON-yyyyHH24:mi:ss'),
duration,
0,
vSwiCode,
vLoginId,vID);

select max(ID) into updateTableId FROM mob_update_table_dev;

IF updateTableID is null THEN
  updateTableID := 1;
END IF;
--This is working
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id)
values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);

COMMIT;

END;
/

EXIT

