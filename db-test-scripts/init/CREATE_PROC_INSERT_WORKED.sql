create or replace PROCEDURE TRUTRACK.INSERT_WORKED
(
vID IN  NUMBER,
vPAYROLL IN  NVARCHAR2,
vPDATE IN    DATE,
vSHIFT IN    NUMBER,
vON_TIME IN  DATE,
vOFF_TIME IN  DATE,
vCODE IN  NVARCHAR2,
vCODE_TYPE IN NUMBER,
vLINE_NO IN  NUMBER,
vPAY_TYPE IN  NVARCHAR2,
vCENTRE IN    NVARCHAR2,
vPOS IN   NVARCHAR2,
vDOCKET IN    NVARCHAR2,
vQUANTITY IN  FLOAT,
vSTD_RATE IN  FLOAT,
vHOURS IN FLOAT,
vHOUR_TYPE IN NUMBER,
vNO_OT_REC IN NVARCHAR2,
vJOB_PREM IN  FLOAT,
vAM_PREM_HR IN    FLOAT,
vPM_PREM_HR IN    FLOAT,
vCALC_FLAG IN NVARCHAR2,
vSTATUS IN    NVARCHAR2,
vWAS_LL IN    NVARCHAR2,
vOT_TYPE IN   NUMBER,
vNOERASE IN   NVARCHAR2,
vCLK_ON IN    DATE,
vCLK_OFF IN   DATE,
vUDF1 IN  NVARCHAR2,
vUDF2 IN  NVARCHAR2,
vNOTE IN  NVARCHAR2,
vCENTRE1 IN   NVARCHAR2,
vPOS1 IN  NVARCHAR2,
vRDOCKET IN   NVARCHAR2,
vTDEFAULT IN  NVARCHAR2,
vFLAG1 IN NVARCHAR2,
vFLAG2 IN NVARCHAR2,
vFLAG3 IN NVARCHAR2,
vFLAG4 IN NVARCHAR2,
vFLAG5 IN NVARCHAR2,
vRATE IN  NUMBER,
vAM_PREM_RATE IN  NUMBER,
vPM_PREM_RATE IN  NUMBER,
vJOB_ID IN    NUMBER,
vUDF_KEY IN   NVARCHAR2,
vOPERATION IN NVARCHAR2,
vUDF3 IN  NVARCHAR2,
vUDF4 IN  NVARCHAR2,
vPIECE_RATE IN    FLOAT,
vWORK_ORDER_ID IN NVARCHAR2,
vWORK_ITEM_ID IN  NVARCHAR2,
vWOI_CONTROL IN   NVARCHAR2,
vAPPROVED_STATUS IN   NVARCHAR2,
vAPPROVED_BY IN   NVARCHAR2,
vAPPROVED_TIME IN DATE,
vEXT_ATTR_1 IN    NVARCHAR2,
vEXT_ATTR_2 IN    NVARCHAR2,
vEXT_ATTR_3 IN    NVARCHAR2,
vEXT_ATTR_4 IN    NVARCHAR2,
vEXT_ATTR_5 IN    NVARCHAR2,
vEXT_ATTR_6 IN    NVARCHAR2,
vEWA_1 IN NVARCHAR2,
vEWA_2 IN NVARCHAR2,
vEWA_3 IN NVARCHAR2,
vEWA_4 IN NVARCHAR2,
vEWA_5 IN NVARCHAR2,
vEWA_6 IN NVARCHAR2,
vEWA_7 IN NVARCHAR2,
vEWA_8 IN NVARCHAR2,
vEWA_9 IN NVARCHAR2,
vEWA_10 IN    NVARCHAR2,
vEWA_11 IN    NVARCHAR2,
vEWA_12 IN    NVARCHAR2,
vEWA_13 IN    NVARCHAR2,
vEWA_14 IN    NVARCHAR2,
vEWA_15 IN    NVARCHAR2,
vEWA_16 IN    NVARCHAR2,
vEWA_17 IN    NVARCHAR2,
vEWA_18 IN    NVARCHAR2,
vEWA_19 IN    NVARCHAR2,
vEWA_20 IN    NVARCHAR2,
vCLIENT_ID IN    NUMBER,
vDEPT_GROUP IN    NVARCHAR2,
vDEPARTMENT IN    NVARCHAR2

) IS
 vWORKED_ID INTEGER := 1;
BEGIN

 SELECT LAST_VALUE + 1 INTO vWORKED_ID
 FROM TRUTRACK.SEQUENCE_CLIENT
  WHERE sequence_name ='WORKED' and client_id='1';

Insert into trutrack.worked (WORKED_ID,ID,PAYROLL,PDATE,SHIFT,ON_TIME,OFF_TIME,CODE,CODE_TYPE,LINE_NO,PAY_TYPE,CENTRE,POS,DOCKET,QUANTITY,STD_RATE,HOURS,HOUR_TYPE,NO_OT_REC,JOB_PREM,AM_PREM_HR,PM_PREM_HR,CALC_FLAG,STATUS,WAS_LL,OT_TYPE,NOERASE,CLK_ON,CLK_OFF,UDF1,UDF2,NOTE,CENTRE1,POS1,RDOCKET,TDEFAULT,FLAG1,FLAG2,FLAG3,FLAG4,FLAG5,RATE,AM_PREM_RATE,PM_PREM_RATE,JOB_ID,UDF_KEY,OPERATION,UDF3,UDF4,PIECE_RATE,WORK_ORDER_ID,WORK_ITEM_ID,WOI_CONTROL,APPROVED_STATUS,APPROVED_BY,APPROVED_TIME,EXT_ATTR_1,EXT_ATTR_2,EXT_ATTR_3,EXT_ATTR_4,EXT_ATTR_5,EXT_ATTR_6,EWA_1,EWA_2,EWA_3,EWA_4,EWA_5,EWA_6,EWA_7,EWA_8,EWA_9,EWA_10,EWA_11,EWA_12,EWA_13,EWA_14,EWA_15,EWA_16,EWA_17,EWA_18,EWA_19,EWA_20,CLIENT_ID,DEPT_GROUP,DEPARTMENT)
 values (vWORKED_ID,vID,vPAYROLL,vPDATE,vSHIFT,vON_TIME,vOFF_TIME,vCODE,vCODE_TYPE,vLINE_NO,vPAY_TYPE,vCENTRE,vPOS,vDOCKET,vQUANTITY,vSTD_RATE,vHOURS,vHOUR_TYPE,vNO_OT_REC,vJOB_PREM,vAM_PREM_HR,vPM_PREM_HR,vCALC_FLAG,vSTATUS,vWAS_LL,vOT_TYPE,vNOERASE,vCLK_ON,vCLK_OFF,vUDF1,vUDF2,vNOTE,vCENTRE1,vPOS1,vRDOCKET,vTDEFAULT,vFLAG1,vFLAG2,vFLAG3,vFLAG4,vFLAG5,vRATE,vAM_PREM_RATE,vPM_PREM_RATE,vJOB_ID,vUDF_KEY,vOPERATION,vUDF3,vUDF4,vPIECE_RATE,vWORK_ORDER_ID,vWORK_ITEM_ID,vWOI_CONTROL,vAPPROVED_STATUS,vAPPROVED_BY,vAPPROVED_TIME,vEXT_ATTR_1,vEXT_ATTR_2,vEXT_ATTR_3,vEXT_ATTR_4,vEXT_ATTR_5,vEXT_ATTR_6,vEWA_1,vEWA_2,vEWA_3,vEWA_4,vEWA_5,vEWA_6,vEWA_7,vEWA_8,vEWA_9,vEWA_10,vEWA_11,vEWA_12,vEWA_13,vEWA_14,vEWA_15,vEWA_16,vEWA_17,vEWA_18,vEWA_19,vEWA_20,vCLIENT_ID,vDEPT_GROUP,vDEPARTMENT);

 UPDATE TRUTRACK.SEQUENCE_CLIENT SET LAST_VALUE = LAST_VALUE+1 WHERE sequence_name ='WORKED' and client_id='1';

COMMIT;

END INSERT_WORKED;
/