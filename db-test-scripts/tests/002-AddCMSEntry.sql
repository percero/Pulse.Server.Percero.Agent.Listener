DEFINE teamLeaderId='100500731';
DEFINE agentId='100866511';
DEFINE timecardDate =  '09-DEC-2015';

--SELECT  * FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID='&agentId' and to_char(start_time,'DD-MON-yyyy') ='&timecardDate';

DELETE FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID='&agentId' and to_char(start_time,'DD-MON-yyyy') ='&timecardDate';

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate 14:04:00','DD-MON-yyyy HH24:mi:ss'), to_date('&timecardDate 15:07:00','DD-MON-yyyy HH24:mi:ss'), '63.48', '0', 'SWI84', '&agentId',PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT; DBMS_LOCK.SLEEP(5);

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate 15:07:00','DD-MON-yyyy HH24:mi:ss'), to_date('&timecardDate 15:10:00','DD-MON-yyyy HH24:mi:ss'), '2.98', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT; DBMS_LOCK.SLEEP(5);

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate 15:10:00','DD-MON-yyyy HH24:mi:ss'), to_date('&timecardDate 15:29:00','DD-MON-yyyy HH24:mi:ss'), '19.3', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT; DBMS_LOCK.SLEEP(5);

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate 15:29:00','DD-MON-yyyy HH24:mi:ss'), to_date('&timecardDate 15:52:00','DD-MON-yyyy HH24:mi:ss'), '22.82', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT; DBMS_LOCK.SLEEP(5);

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate 15:52:00','DD-MON-yyyy HH24:mi:ss'), to_date('&timecardDate 16:40:00','DD-MON-yyyy HH24:mi:ss'), '47.58', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT; DBMS_LOCK.SLEEP(5);

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate 16:41:00','DD-MON-yyyy HH24:mi:ss'), to_date('&timecardDate 16:48:00','DD-MON-yyyy HH24:mi:ss'), '6.5', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT; DBMS_LOCK.SLEEP(5);

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate 16:48:00','DD-MON-yyyy HH24:mi:ss'), to_date('&timecardDate 16:48:00','DD-MON-yyyy HH24:mi:ss'), '0.25', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT;

EXIT


