DECLARE

    teamLeaderId varchar2(12) := '&1';
    agentId      varchar2(12) := '&2';
    timecardDate varchar2(20) := '&3';

    vID NUMBER:=0;
    vRowID NUMBER:=0;
BEGIN

    select MAX(ID) INTO vRowID From trutrack.payroll where payroll=agentId and pdate=to_date(timecardDate,'DD-MON-yyyy');

    select MAX(ID) INTO vID From update_table;

    INSERT INTO UPDATE_TABLE(ID, TABLENAME, ROW_ID, TIMESTAMP, TYPE)
      VALUES (vID, 'AGENT_TIME_VIEW', vRowID, sysdate, 'UPDATE');

    COMMIT;
END;
/

EXIT
