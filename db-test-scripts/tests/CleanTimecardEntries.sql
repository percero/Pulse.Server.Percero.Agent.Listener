DECLARE

    teamLeaderId varchar2(12) := '&1';
    agentId      varchar2(12) := '&2';
    timecardDate varchar2(20) := '&3';

    vID NUMBER:=0;
BEGIN

    select ID INTO vID From trutrack.payroll where payroll=agentId and pdate=to_date(timecardDate,'DD-MON-yyyy');

    DELETE FROM trutrack.worked where ID = vID;

    COMMIT;
END;
/

EXIT
