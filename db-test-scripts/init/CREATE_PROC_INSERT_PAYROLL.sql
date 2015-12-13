create or replace PROCEDURE TRUTRACK.INSERT_PAYROLL
(
vID OUT NUMBER,
vPAYROLL IN NVARCHAR2,
vPDATE  IN DATE, 
vON_TIME  IN DATE,
vSHIFT  IN NUMBER,
vSCHED_SHIFT  IN NUMBER,
vOFF_TIME  IN DATE,
vCALLOUT  IN NVARCHAR2,
vREQUESTED  IN NVARCHAR2,
vASSUMED_OFF  IN NVARCHAR2,
vCALC_BREAKS  IN NVARCHAR2,
vMANUAL_CALC  IN NVARCHAR2,
vCALC_DEF  IN NVARCHAR2,
vDEPARTMENT  IN NVARCHAR2,
vCREW  IN NVARCHAR2,
vSUPERVISOR  IN NVARCHAR2,
vOT_OFFERED  IN NUMBER, 
vOT_REFUSED  IN NUMBER,
vREG  IN NUMBER,
vOT1  IN NUMBER,
vOT2  IN NUMBER,
vOT3  IN NUMBER,
vOT4  IN NUMBER,
vBNK  IN NUMBER,
vCOLA  IN FLOAT,
vAPPROVED_BY  IN NVARCHAR2,
vAPPROVED  IN NVARCHAR2,
vIS_HOLIDAY  IN NVARCHAR2,
vIS_ABSENCE  IN NVARCHAR2,
vDAY_TYPE  IN   NUMBER,
vAVG_RATE  IN FLOAT,
vREASON  IN NVARCHAR2,
vCODE  IN NVARCHAR2,
vABSENCE  IN NUMBER,
vSRULE  IN NUMBER,
vREG_DLLR  IN NUMBER,
vOT1_DLLR  IN NUMBER,
vOT2_DLLR  IN NUMBER,
vOT3_DLLR  IN NUMBER,
vOT4_DLLR  IN NUMBER,
vAM_PREM  IN NUMBER,
vPM_PREM  IN NUMBER,
vAM_DLLR  IN NUMBER,
vPM_DLLR  IN NUMBER,
vBONUS  IN NUMBER,
vBONUS_DLLR  IN NUMBER,
vSH_RULE  IN NVARCHAR2,
vAUTO_BANK  IN NVARCHAR2,
vOT_CHARGED  IN NUMBER, 
vFLEX_ISON_BO  IN NVARCHAR2,
vFLEX_BALANCE  IN NUMBER,
vFLEX_INFRINGEMENTS  IN NUMBER,
vUDF1  IN NVARCHAR2,
vUDF2  IN NVARCHAR2,
vUDF3  IN NVARCHAR2,
vUDF4  IN NVARCHAR2,
vCLIENT_ID  IN NUMBER,
vEMP_SIGNED  IN NVARCHAR2,
vEMP_SIGNED_DATE  IN DATE,
vDEPT_GROUP  IN NVARCHAR2,
vEVENT_ID  IN NUMBER,
vUDF5  IN NVARCHAR2,
vUDF6  IN NVARCHAR2,
vUDF7  IN NVARCHAR2,
vUDF8  IN NVARCHAR2,
vUDF9  IN NVARCHAR2,
vUDF10  IN NVARCHAR2

) IS 
 
BEGIN

 SELECT LAST_VALUE + 1 INTO vID
 FROM TRUTRACK.SEQUENCE_CLIENT
  WHERE sequence_name ='PAYROLL' and client_id='1';

Insert into trutrack.payroll (ID,PAYROLL,PDATE,ON_TIME,SHIFT,SCHED_SHIFT,OFF_TIME,CALLOUT,REQUESTED,ASSUMED_OFF,CALC_BREAKS,MANUAL_CALC,CALC_DEF,DEPARTMENT,CREW,SUPERVISOR,OT_OFFERED,OT_REFUSED,REG,OT1,OT2,OT3,OT4,BNK,COLA,APPROVED_BY,APPROVED,IS_HOLIDAY,IS_ABSENCE,DAY_TYPE,AVG_RATE,REASON,CODE,ABSENCE,SRULE,REG_DLLR,OT1_DLLR,OT2_DLLR,OT3_DLLR,OT4_DLLR,AM_PREM,PM_PREM,AM_DLLR,PM_DLLR,BONUS,BONUS_DLLR,SH_RULE,AUTO_BANK,OT_CHARGED,FLEX_ISON_BO,FLEX_BALANCE,FLEX_INFRINGEMENTS,UDF1,UDF2,UDF3,UDF4,CLIENT_ID,EMP_SIGNED,EMP_SIGNED_DATE,DEPT_GROUP,EVENT_ID,UDF5,UDF6,UDF7,UDF8,UDF9,UDF10)
 values (vID,vPAYROLL,vPDATE,vON_TIME,vSHIFT,vSCHED_SHIFT,vOFF_TIME,vCALLOUT,vREQUESTED,vASSUMED_OFF,vCALC_BREAKS,vMANUAL_CALC,vCALC_DEF,vDEPARTMENT,vCREW,vSUPERVISOR,vOT_OFFERED,vOT_REFUSED,vREG,vOT1,vOT2,vOT3,vOT4,vBNK,vCOLA,vAPPROVED_BY,vAPPROVED,vIS_HOLIDAY,vIS_ABSENCE,vDAY_TYPE,vAVG_RATE,vREASON,vCODE,vABSENCE,vSRULE,vREG_DLLR,vOT1_DLLR,vOT2_DLLR,vOT3_DLLR,vOT4_DLLR,vAM_PREM,vPM_PREM,vAM_DLLR,vPM_DLLR,vBONUS,vBONUS_DLLR,vSH_RULE,vAUTO_BANK,vOT_CHARGED,vFLEX_ISON_BO,vFLEX_BALANCE,vFLEX_INFRINGEMENTS,vUDF1,vUDF2,vUDF3,vUDF4,vCLIENT_ID,vEMP_SIGNED,vEMP_SIGNED_DATE,vDEPT_GROUP,vEVENT_ID,vUDF5,vUDF6,vUDF7,vUDF8,vUDF9,vUDF10);
 
 UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 where sequence_name ='PAYROLL' and client_id='1';

COMMIT;

END INSERT_PAYROLL;
/