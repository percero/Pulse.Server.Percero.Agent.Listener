DECLARE
    teamLeaderId varchar2(12) := '&1';
    agentId      varchar2(12) := '&2';
    timecardDate varchar2(20) := '&3';
    startTime    varchar2(20) := '&4';
    endTime      varchar2(20) := '&5';
    auxReason    varchar2(20) := '&6';
    cmsEntryId    varchar2(20) ;
    duration varchar2(12) := '0.0';
    vLoginId NUMBER;
    vSwiCode varchar2(12);
    vID NUMBER;
    updateTableId NUMBER;
BEGIN



SELECT to_char((to_date(endTime,'DD-MON-yyyyHH24:mi:ss')-to_date(startTime,'DD-MON-yyyyHH24:mi:ss'))*24*60*60, '9999999.99') into duration from DUAL;

--select login_id into vLoginId from CMDCTR.rt_agent_detail rt  where employee_id = agentId ;
--SELECT SWI_CODE INTO vSwiCode from CMDCTR.rt_agent_detail rt  where employee_id = agentId ;

--SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
select max(ID) INTO cmsEntryId from mob_cms_Data_vw where employee_id = agentId
and to_char(start_time,'DD-MON-yyyy')=to_char(to_date(startTime, 'DD-MON-yyyyHH24:mi:ss'),'DD-MON-yyyy' ) ;

UPDATE pulse.MOB_CMS_DATA
   SET
       START_TIME = to_date(startTime,'DD-MON-yyyyHH24:mi:ss'),
       END_TIME = to_date(endTime,'DD-MON-yyyyHH24:mi:ss'),
       EVENT_DURATION = duration
WHERE  ID = cmsEntryId;


select max(ID) into updateTableId FROM mob_update_table_dev;

IF updateTableID is null THEN
  updateTableID := 1;
END IF;

INSERT INTO mob_update_table_dev ( tablename, ROW_ID, type, time_stamp, lock_id, lock_date, id)
values ('MOB_CMS_DATA_VW', cmsEntryId,'UPDATE', SYSDATE, NULL, NULL, updateTableID);

COMMIT;

END;
/

EXIT

