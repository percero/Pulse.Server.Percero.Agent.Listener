DECLARE

    teamLeaderId varchar2(12) := '&1';
    agentId      varchar2(12) := '&2';
    timecardDate varchar2(20) := '&3';
    startTime    varchar2(20) := '&4';
    endTime      varchar2(20) := '&5';
    vID NUMBER:=0;
BEGIN

    select ID INTO vID From trutrack.payroll where payroll=agentId and pdate=to_date(timecardDate,'DD-MON-yyyy');

    TRUTRACK.INSERT_WORKED(vID,
    agentId,
    to_date(timecardDate,'DD-MON-yyyy'),1,
    to_date(startTime,'DD-MON-yyyyHH24:mi:ss'),
    to_date(endtime,'DD-MON-yyyyHH24:mi:ss'),'(W)',0,8,'0','L580','01-001','No',0,0,2,1,null,0,0,0,'T',null,null,5,null
    ,to_date(startTime,'DD-MON-yyyyHH24:mi:ss'),to_date(endTime,'DD-MON-yyyyHH24:mi:ss'),
    null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,
    to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'F',null,null,
    '20151205150600','20151205150800','America/Chicago',null,'F','100500731','00327',1,'004','10000');

    COMMIT;
END;
/

EXIT
