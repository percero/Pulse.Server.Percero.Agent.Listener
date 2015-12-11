DECLARE

    teamLeaderId varchar2(12) := '&1';
    agentId      varchar2(12) := '&2';
    timecardDate varchar2(20) := '&3';
    startTime    varchar2(20) := '&4';
    endTime      varchar2(20) := '&5';
    auxReason    varchar2(20) := '&6';
    duration varchar2(12) := '0.0';

BEGIN

SELECT to_char((to_date(startTime,'DD-MON-yyyyHH24:mi:ss')-to_date(endTime,'DD-MON-yyyyHH24:mi:ss'))*24*60, '99.99') into duration from DUAL;

INSERT INTO pulse.MOB_CMS_DATA(START_TIME, END_TIME, EVENT_DURATION, AUXREASON, SWI_CODE, LOGIN_ID, ID) VALUES( to_date(startTime,'DD-MON-yyyyHH24:mi:ss'), to_date(endTime,'DD-MON-yyyyHH24:mi:ss'), duration, to_number(auxReason), 'SWI84', agentId,PULSE.MOB_CMS_DATA_SEQ.nextval);

COMMIT;

END;
/

EXIT

