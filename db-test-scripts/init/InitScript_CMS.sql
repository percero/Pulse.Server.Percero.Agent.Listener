DEFINE teamLeaderId='&1';
DEFINE agentId='&2';
DEFINE timecardDate = '&3';

--SELECT  * FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID='&agentId' and to_char(start_time,'DD-MON-yyyy') ='&timecardDate';

DELETE FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID='&agentId' and to_char(start_time,'DD-MON-yyyy') ='&timecardDate';

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate14:04:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate15:07:00','DD-MON-yyyyHH24:mi:ss'), '63.48', '0', 'SWI84', '&agentId',PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate15:07:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate15:10:00','DD-MON-yyyyHH24:mi:ss'), '2.98', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate15:10:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate15:29:00','DD-MON-yyyyHH24:mi:ss'), '19.3', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate15:29:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate15:52:00','DD-MON-yyyyHH24:mi:ss'), '22.82', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate15:52:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate16:40:00','DD-MON-yyyyHH24:mi:ss'), '47.58', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate16:41:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate16:48:00','DD-MON-yyyyHH24:mi:ss'), '6.5', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate16:48:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate16:48:00','DD-MON-yyyyHH24:mi:ss'), '0.25', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate16:48:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate16:51:00','DD-MON-yyyyHH24:mi:ss'), '3.5', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate16:51:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate17:29:00','DD-MON-yyyyHH24:mi:ss'), '38.07', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate17:29:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate17:39:00','DD-MON-yyyyHH24:mi:ss'), '9.5', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate17:39:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate18:00:00','DD-MON-yyyyHH24:mi:ss'), '21.02', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate18:04:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate18:07:00','DD-MON-yyyyHH24:mi:ss'), '2.77', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate18:07:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate18:29:00','DD-MON-yyyyHH24:mi:ss'), '22.27', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate18:29:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate19:22:00','DD-MON-yyyyHH24:mi:ss'), '52.78', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate19:22:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate20:13:00','DD-MON-yyyyHH24:mi:ss'), '51.17', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate20:13:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate20:33:00','DD-MON-yyyyHH24:mi:ss'), '19.53', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate20:33:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate21:44:00','DD-MON-yyyyHH24:mi:ss'), '71.8', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate21:44:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate22:02:00','DD-MON-yyyyHH24:mi:ss'), '17.82', NULL, 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);
INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date('&timecardDate22:02:00','DD-MON-yyyyHH24:mi:ss'), to_date('&timecardDate22:30:00','DD-MON-yyyyHH24:mi:ss'), '27.58', '0', 'SWI84', '&agentId', PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT;

EXIT

