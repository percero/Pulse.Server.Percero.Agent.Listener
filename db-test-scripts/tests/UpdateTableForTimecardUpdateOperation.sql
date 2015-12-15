DECLARE

    teamLeaderId varchar2(12) := '&1';
    agentId      varchar2(12) := '&2';
    timecardDate varchar2(20) := '&3';

    vID NUMBER:=0;
    vRowID NUMBER:=0;
BEGIN

    select MAX(ID) INTO vRowID From trutrack.payroll where payroll=agentId and to_char(pdate,'DD-MON-yyyy')=timecardDate;

       select MAX(ID) INTO vID From update_table;

       IF vID is NULL THEN
           vID:=1;
       END IF;

       INSERT INTO UPDATE_TABLE_DEV(ID, TABLENAME, ROW_ID, TIMESTAMP, TYPE)
         VALUES (vID, 'AGENT_TIME_VW', vRowID, sysdate, 'UPDATE');

    COMMIT;
END;
/

EXIT

