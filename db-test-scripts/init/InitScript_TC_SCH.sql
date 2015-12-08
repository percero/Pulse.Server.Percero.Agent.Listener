DEFINE teamLeaderId='100500731';
DEFINE agentId='100866511';
DEFINE timecardDate =  '06-DEC-2015';

DELETE FROM trutrack.PAYROLL  where PAYROLL='&agentId' and PDATE='&timecardDate' ;
DELETE FROM trutrack.worked  where PAYROLL='&agentId' and PDATE='&timecardDate' ;
DELETE From trutrack.job_schedule_orion WHERE PAYROLL='&agentId' AND START_DATE='&timecardDate' ;

Insert into trutrack.payroll (ID,PAYROLL,PDATE,ON_TIME,SHIFT,SCHED_SHIFT,OFF_TIME,CALLOUT,REQUESTED,ASSUMED_OFF,CALC_BREAKS,MANUAL_CALC,CALC_DEF,DEPARTMENT,CREW,SUPERVISOR,OT_OFFERED,OT_REFUSED,REG,OT1,OT2,OT3,OT4,BNK,COLA,APPROVED_BY,APPROVED,IS_HOLIDAY,IS_ABSENCE,DAY_TYPE,AVG_RATE,REASON,CODE,ABSENCE,SRULE,REG_DLLR,OT1_DLLR,OT2_DLLR,OT3_DLLR,OT4_DLLR,AM_PREM,PM_PREM,AM_DLLR,PM_DLLR,BONUS,BONUS_DLLR,SH_RULE,AUTO_BANK,OT_CHARGED,FLEX_ISON_BO,FLEX_BALANCE,FLEX_INFRINGEMENTS,UDF1,UDF2,UDF3,UDF4,CLIENT_ID,EMP_SIGNED,EMP_SIGNED_DATE,DEPT_GROUP,EVENT_ID,UDF5,UDF6,UDF7,UDF8,UDF9,UDF10) 
values (216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),1,1,to_date('&timecardDate','DD-MON-RR'),'F','F','F','T','F','F','10000','CST4',null,0,0,451,0,0,0,0,0,5,'Autopoll','F','F','F',0,0,null,'(W),BRK,LB,LUN,LLU,U',33,24,0,0,0,0,0,0,0,0,0,0,0,'US1','F',0,'T',0,1,null,null,'F','V',1,'F',null,'004',null,null,null,'US1',null,'F',null);


Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835391,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'WRK','(W)','L580','16-002',to_Date('&timecardDate 07:45:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 07:55:00','DD-MON-yyyy HH24:mi:ss'),10,null,0,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835410,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'ABU','UA','L580','30-001',to_Date('&timecardDate 07:55:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 08:03:00','DD-MON-yyyy HH24:mi:ss'),8,null,2,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835392,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'WRK','(W)','L580','01-001',to_Date('&timecardDate 08:03:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 09:31:00','DD-MON-yyyy HH24:mi:ss'),88,null,0,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835394,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'BRK','BRK','L580','26-001',to_Date('&timecardDate 09:31:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 09:46:00','DD-MON-yyyy HH24:mi:ss'),15,null,7,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835396,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'BRK','LB','L580','26-001',to_Date('&timecardDate 09:46:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 09:51:00','DD-MON-yyyy HH24:mi:ss'),5,null,7,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835398,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'WRK','(W)','L580','01-001',to_Date('&timecardDate 09:51:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 11:31:00','DD-MON-yyyy HH24:mi:ss'),100,null,0,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835411,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'ABU','UA','L580','30-001',to_Date('&timecardDate 11:31:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 11:39:00','DD-MON-yyyy HH24:mi:ss'),8,null,2,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835399,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'WRK','(W)','L580','01-001',to_Date('&timecardDate 11:39:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 12:34:00','DD-MON-yyyy HH24:mi:ss'),55,null,0,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835401,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'BRK','LUN','L580','99-001',to_Date('&timecardDate 12:34:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 13:19:00','DD-MON-yyyy HH24:mi:ss'),45,null,7,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835403,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'BRK','LLU','L580','99-001',to_Date('&timecardDate 13:19:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 13:20:00','DD-MON-yyyy HH24:mi:ss'),1,null,7,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835405,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'WRK','(W)','L580','01-001',to_Date('&timecardDate 13:20:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 14:14:00','DD-MON-yyyy HH24:mi:ss'),54,null,0,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835412,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'ABU','UA','L580','30-001',to_Date('&timecardDate 14:14:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 14:31:00','DD-MON-yyyy HH24:mi:ss'),17,null,2,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835406,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'WRK','(W)','L580','01-001',to_Date('&timecardDate 14:31:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 15:46:00','DD-MON-yyyy HH24:mi:ss'),75,null,0,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835407,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'BRK','BRK','L580','26-001',to_Date('&timecardDate 15:46:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 16:01:00','DD-MON-yyyy HH24:mi:ss'),15,null,7,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835408,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'BRK','LB','L580','26-001',to_Date('&timecardDate 16:01:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 16:02:00','DD-MON-yyyy HH24:mi:ss'),1,null,7,null,null);
Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,ACTION,CODE,CENTRE,POS,ON_TIME,OFF_TIME,MINUTES,NOTE,CODE_TYPE,EWA_1,EWA_2) values (647835409,216324316,'&agentId',to_date('&timecardDate','DD-MON-RR'),'WRK','(W)','L580','01-001',to_Date('&timecardDate 16:02:00','DD-MON-yyyy HH24:mi:ss'),to_Date('&timecardDate 16:32:00','DD-MON-yyyy HH24:mi:ss'),30,null,0,null,null);

Insert into trutrack.job_schedule_orion (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,PROJECT,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP) values (993128188,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),1,'IEX','Open Time',to_date('06-DEC-2015 07:45:00','DD-MON-yyyy HH24:mi:ss'),to_date('06-DEC-2015 09:45:00','DD-MON-yyyy HH24:mi:ss'),null);
Insert into trutrack.job_schedule_orion (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,PROJECT,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP) values (993128189,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),2,'IEX','BreakOffline',to_date('06-DEC-2015 09:45:00','DD-MON-yyyy HH24:mi:ss'),to_date('06-DEC-2015 10:00:00','DD-MON-yyyy HH24:mi:ss'),null);
Insert into trutrack.job_schedule_orion (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,PROJECT,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP) values (993128190,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),3,'IEX','Open Time',to_date('06-DEC-2015 10:00:00','DD-MON-yyyy HH24:mi:ss'),to_date('06-DEC-2015 12:15:00','DD-MON-yyyy HH24:mi:ss'),null);
Insert into trutrack.job_schedule_orion (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,PROJECT,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP) values (993128191,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),4,'IEX','Lunch',to_date('06-DEC-2015 12:15:00','DD-MON-yyyy HH24:mi:ss'),to_date('06-DEC-2015 13:00:00','DD-MON-yyyy HH24:mi:ss'),null);
Insert into trutrack.job_schedule_orion (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,PROJECT,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP) values (993128192,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),5,'IEX','Open Time',to_date('06-DEC-2015 13:00:00','DD-MON-yyyy HH24:mi:ss'),to_date('06-DEC-2015 14:30:00','DD-MON-yyyy HH24:mi:ss'),null);
Insert into trutrack.job_schedule_orion (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,PROJECT,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP) values (993128193,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),6,'IEX','BreakOffline',to_date('06-DEC-2015 14:30:00','DD-MON-yyyy HH24:mi:ss'),to_date('06-DEC-2015 14:45:00','DD-MON-yyyy HH24:mi:ss'),null);
Insert into trutrack.job_schedule_orion (ID,PAYROLL,START_DATE,END_DATE,COST_POS_INDEX,PROJECT,POSITION,START_TIME,END_TIME,MODIFIED_TIMESTAMP) values (993128194,'&agentId',to_date('&timecardDate','DD-MON-RR'),to_date('&timecardDate','DD-MON-RR'),7,'IEX','Open Time',to_date('06-DEC-2015 14:45:00','DD-MON-yyyy HH24:mi:ss'),to_date('06-DEC-2015 16:30:00','DD-MON-yyyy HH24:mi:ss'),null);
