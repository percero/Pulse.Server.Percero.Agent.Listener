DECLARE

    teamLeaderId varchar2(12) := '&1';
    agentId varchar2(12) :='&2';
    timecardDate varchar2(20) := '&3';
    vLoginId NUMBER;
    vSwiCode varchar2(12);
    vID NUMBER;
    updateTableId NUMBER;
BEGIN

select max(ID) into updateTableId FROM mob_update_table_dev;

IF updateTableID is null THEN
  updateTableID := 1;
END IF;

select login_id into vLoginId from CMDCTR.rt_agent_detail rt  where employee_id = agentId ;
SELECT SWI_CODE INTO vSwiCode from CMDCTR.rt_agent_detail rt  where employee_id = agentId ;

-- SELECT  * FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID=vLoginId and to_char(start_time,'DD-MON-yyyy') = timecardDate;

DELETE FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID=vLoginId and to_char(start_time,'DD-MON-yyyy') = timecardDate;
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'14:04:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'15:07:00','DD-MON-yyyyHH24:mi:ss'), '63.48', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'15:07:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'15:10:00','DD-MON-yyyyHH24:mi:ss'), '2.98', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'15:10:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'15:29:00','DD-MON-yyyyHH24:mi:ss'), '19.3', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'15:29:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'15:52:00','DD-MON-yyyyHH24:mi:ss'), '22.82', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'15:52:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'16:40:00','DD-MON-yyyyHH24:mi:ss'), '47.58', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'16:41:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'16:48:00','DD-MON-yyyyHH24:mi:ss'), '6.5', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'16:48:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'16:48:00','DD-MON-yyyyHH24:mi:ss'), '0.25', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'16:48:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'16:51:00','DD-MON-yyyyHH24:mi:ss'), '3.5', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'16:51:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'17:29:00','DD-MON-yyyyHH24:mi:ss'), '38.07', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'17:29:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'17:39:00','DD-MON-yyyyHH24:mi:ss'), '9.5', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'17:39:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'18:00:00','DD-MON-yyyyHH24:mi:ss'), '21.02', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'18:04:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'18:07:00','DD-MON-yyyyHH24:mi:ss'), '2.77', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'18:07:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'18:29:00','DD-MON-yyyyHH24:mi:ss'), '22.27', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'18:29:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'19:22:00','DD-MON-yyyyHH24:mi:ss'), '52.78', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'19:22:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'20:13:00','DD-MON-yyyyHH24:mi:ss'), '51.17', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'20:13:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'20:33:00','DD-MON-yyyyHH24:mi:ss'), '19.53', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'20:33:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'21:44:00','DD-MON-yyyyHH24:mi:ss'), '71.8', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'21:44:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'22:02:00','DD-MON-yyyyHH24:mi:ss'), '17.82', NULL, vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);
SELECT PULSE.MOB_CMS_DATA_SEQ.nextval INTO vID FROM DUAL;
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(timecardDate||'22:02:00','DD-MON-yyyyHH24:mi:ss'), to_date(timecardDate||'22:30:00','DD-MON-yyyyHH24:mi:ss'), '27.58', '0', vSwiCode,vLoginId, vID);
INSERT INTO mob_update_table_dev ( tablename, row_id, type, time_stamp, lock_id, lock_date, id) values ('MOB_CMS_DATA_VW', vID,'INSERT', SYSDATE, NULL, NULL, updateTableID);

COMMIT;

END;
/

EXIT