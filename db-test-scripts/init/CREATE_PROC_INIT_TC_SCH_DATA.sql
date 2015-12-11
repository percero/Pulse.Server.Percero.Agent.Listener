create or replace PROCEDURE TRUTRACK.INIT_TC_SCH_DATA
(
  vAgentId IN VARCHAR2,
  vEntryDate IN VARCHAR2
) IS 

   vID  INTEGER := 1;
   vWORKED_ID INTEGER := 1;
   
BEGIN

   SELECT LAST_VALUE + 1 INTO vID
     FROM TRUTRACK.SEQUENCE_CLIENT
    WHERE sequence_name ='PAYROLL' and client_id='1';

Insert into trutrack.payroll (ID,PAYROLL,PDATE,ON_TIME,SHIFT,SCHED_SHIFT,OFF_TIME,CALLOUT,REQUESTED,ASSUMED_OFF,CALC_BREAKS,MANUAL_CALC,CALC_DEF,DEPARTMENT,CREW,SUPERVISOR,OT_OFFERED,OT_REFUSED,REG,OT1,OT2,OT3,OT4,BNK,COLA,APPROVED_BY,APPROVED,IS_HOLIDAY,IS_ABSENCE,DAY_TYPE,AVG_RATE,REASON,CODE,ABSENCE,SRULE,REG_DLLR,OT1_DLLR,OT2_DLLR,OT3_DLLR,OT4_DLLR,AM_PREM,PM_PREM,AM_DLLR,PM_DLLR,BONUS,BONUS_DLLR,SH_RULE,AUTO_BANK,OT_CHARGED,FLEX_ISON_BO,FLEX_BALANCE,FLEX_INFRINGEMENTS,UDF1,UDF2,UDF3,UDF4,CLIENT_ID,EMP_SIGNED,EMP_SIGNED_DATE,DEPT_GROUP,EVENT_ID,UDF5,UDF6,UDF7,UDF8,UDF9,UDF10)
   values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),1,1,to_date(vEntryDate,'DD-MON-yyyy'),'F','F','F','T','F','F','10000','CST4',null,0,0,451,0,0,0,0,0,5,'Autopoll','F','F','F',0,0,null,'(W),BRK,LB,LUN,LLU,U',33,24,0,0,0,0,0,0,0,0,0,0,0,'US1','F',0,'T',0,1,null,null,'F','V',1,'F',null,'004',null,null,null,'US1',null,'F',null);
   UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='PAYROLL' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '12:02:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '12:47:00','DD-MON-yyyyHH24:mi:ss'),'LUN',7,6,'U','L580','99-001','No',0,0,45,0,null,0,0,0,'T',null,null,0,null ,to_date(vEntryDate || '12:02:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '12:47:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,'F',null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205130200','20151205134700','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '12:47:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:06:00','DD-MON-yyyyHH24:mi:ss'),'(W)',0,7,'0','L580','01-001','No',0,0,79,0,null,0,0,0,'T',null,null,0,null ,to_date(vEntryDate || '12:47:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:06:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205134700','20151205150600','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '14:06:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:08:00','DD-MON-yyyyHH24:mi:ss'),'(W)',0,8,'0','L580','01-001','No',0,0,2,1,null,0,0,0,'T',null,null,5,null  ,to_date(vEntryDate || '14:06:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:08:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'F',null,null,'20151205150600','20151205150800','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '14:08:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:23:00','DD-MON-yyyyHH24:mi:ss'),'BRK',7,9,'0','L580','26-001','No',0,0,15,1,null,0,0,0,'T',null,null,5,null ,to_date(vEntryDate || '14:08:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:23:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,'F',null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205150800','20151205152300','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '14:23:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '15:45:00','DD-MON-yyyyHH24:mi:ss'),'(W)',0,10,'0','L580','01-001','No',0,0,82,1,null,0,0,0,'T',null,null,5,null,to_date(vEntryDate || '14:23:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '15:45:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205152300','20151205164500','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '06:56:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '07:01:00','DD-MON-yyyyHH24:mi:ss'),'(W)',0,1,'0','L580','30-001','No',0,0,5,0,null,0,0,0,'T',null,null,0,null  ,to_date(vEntryDate || '06:56:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '07:01:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205075600','20151205080100','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '07:01:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '10:02:00','DD-MON-yyyyHH24:mi:ss'),'(W)',0,2,'0','L580','01-001','No',0,0,181,0,null,0,0,0,'T',null,null,0,null,to_date(vEntryDate || '07:01:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '10:02:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205080100','20151205110200','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '10:02:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '10:17:00','DD-MON-yyyyHH24:mi:ss'),'BRK',7,3,'0','L580','26-001','No',0,0,15,0,null,0,0,0,'T',null,null,0,null ,to_date(vEntryDate || '10:02:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '10:17:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,'F',null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205110200','20151205111700','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '10:17:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '10:19:00','DD-MON-yyyyHH24:mi:ss'),'LB',7,4,'0','L580','26-001','No',0,0,2,0,null,0,0,0,'T',null,null,0,null   ,to_date(vEntryDate || '10:17:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '10:19:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205111700','20151205111900','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

SELECT last_value+1 into vWORKED_ID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='WORKED' and client_id='1';
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT) values (vWORKED_ID,VID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),1,to_date(vEntryDate || '10:19:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '12:02:00','DD-MON-yyyyHH24:mi:ss'),'(W)',0,5,'0','L580','01-001','No',0,0,103,0,null,0,0,0,'T',null,null,0,null,to_date(vEntryDate || '10:19:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '12:02:00','DD-MON-yyyyHH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date('05-DEC-15','DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205111900','20151205130200','America/Chicago',null,'F','100500731','00327',1,'004','10000');
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='WORKED' and client_id='1';

COMMIT;

SELECT last_value+1 into vID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='SCHEDULE_ORION' and client_id='1';
Insert into trutrack.job_schedule_orion  (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,CENTRE,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP, CLIENT_ID)
values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),1,'IEX','Open Time',to_date(vEntryDate || '07:45:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '09:45:00','DD-MON-yyyyHH24:mi:ss'),null, 1);
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='SCHEDULE_ORION' and client_id='1';

SELECT last_value+1 into vID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='SCHEDULE_ORION' and client_id='1';
Insert into trutrack.job_schedule_orion  (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,CENTRE,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP, CLIENT_ID) values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),2,'IEX','BreakOffline',to_date(vEntryDate || '09:45:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '10:00:00','DD-MON-yyyyHH24:mi:ss'),null, 1);
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='SCHEDULE_ORION' and client_id='1';

SELECT last_value+1 into vID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='SCHEDULE_ORION' and client_id='1';
Insert into trutrack.job_schedule_orion  (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,CENTRE,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP, CLIENT_ID) values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),3,'IEX','Open Time',to_date(vEntryDate || '10:00:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '12:15:00','DD-MON-yyyyHH24:mi:ss'),null, 1);
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='SCHEDULE_ORION' and client_id='1';

SELECT last_value+1 into vID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='SCHEDULE_ORION' and client_id='1';
Insert into trutrack.job_schedule_orion  (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,CENTRE,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP, CLIENT_ID) values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),4,'IEX','Lunch',to_date(vEntryDate || '12:15:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '13:00:00','DD-MON-yyyyHH24:mi:ss'),null, 1);
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='SCHEDULE_ORION' and client_id='1';

SELECT last_value+1 into vID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='SCHEDULE_ORION' and client_id='1';
Insert into trutrack.job_schedule_orion  (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,CENTRE,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP, CLIENT_ID) values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),5,'IEX','Open Time',to_date(vEntryDate || '13:00:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:30:00','DD-MON-yyyyHH24:mi:ss'),null, 1);
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='SCHEDULE_ORION' and client_id='1';

SELECT last_value+1 into vID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='SCHEDULE_ORION' and client_id='1';
Insert into trutrack.job_schedule_orion  (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,CENTRE,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP, CLIENT_ID) values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),6,'IEX','BreakOffline',to_date(vEntryDate || '14:30:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '14:45:00','DD-MON-yyyyHH24:mi:ss'),null, 1);
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='SCHEDULE_ORION' and client_id='1';

SELECT last_value+1 into vID FROM TRUTRACK.SEQUENCE_CLIENT where sequence_name ='SCHEDULE_ORION' and client_id='1';
Insert into trutrack.job_schedule_orion  (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,CENTRE,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP, CLIENT_ID) values (vID,vAgentId,to_date(vEntryDate,'DD-MON-yyyy'),to_date(vEntryDate,'DD-MON-yyyy'),7,'IEX','Open Time',to_date(vEntryDate || '14:45:00','DD-MON-yyyyHH24:mi:ss'),to_date(vEntryDate || '16:30:00','DD-MON-yyyyHH24:mi:ss'),null, 1);
UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='SCHEDULE_ORION' and client_id='1';

COMMIT;
END INIT_TC_SCH_DATA;
/