DECLARE

    teamLeaderId varchar2(12) := '&1';
    agentId varchar2(12) :='&2';
    timecardDate varchar2(20) := '&3';
    runUpdateTableForTimeCard varchar2(20) := '&4';
    vID NUMBER;
    vWorkedID NUMBER;
    vUpdateTblID NUMBER;
BEGIN

    DELETE FROM trutrack.PAYROLL  where PAYROLL=agentId and PDATE=timecardDate ;
    DELETE FROM trutrack.worked  where PAYROLL=agentId and PDATE=timecardDate ;
    DELETE From trutrack.schedule_orion WHERE PAYROLL=agentId AND START_DATE=timecardDate ;
    DELETE From trutrack.job_schedule_orion WHERE PAYROLL=agentId AND START_DATE=timecardDate ;

    --EXEC TRUTRACK.INIT_TC_SCH_DATA(agentId,timecardDate);

    --INSERT PAYROLL RECORD for TIMECARD
    TRUTRACK.INSERT_PAYROLL(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate || ' 06:00:00','DD-MON-yyyy HH24:mi:ss'),1,1,to_date(timecardDate || ' 20:45:00','DD-MON-yyyy HH24:mi:ss'),'F','F','F','T','F','F','10000','CST4',null,0,0,451,0,0,0,0,0,5,'Autopoll','F','F','F',0,0,null,'(W),BRK,LB,LUN,LLU,U',33,24,0,0,0,0,0,0,0,0,0,0,0,'US1','F',0,'T',0,1,null,null,'F','V',1,'F',null,'004',null,null,null,'US1',null,'F',null);

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 06:00:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 07:01:00','DD-MON-yyyy HH24:mi:ss'),'(W)',0,1,'0','L580','30-001','No',0,0,5,0,null,0,0,0,'T',null,null,0,null  ,to_date(timecardDate || ' 06:00:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 07:01:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205075600','20151205080100','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 07:01:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 10:02:00','DD-MON-yyyy HH24:mi:ss'),'(W)',0,2,'0','L580','01-001','No',0,0,181,0,null,0,0,0,'T',null,null,0,null,to_date(timecardDate || ' 07:01:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 10:02:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205080100','20151205110200','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 10:02:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 10:17:00','DD-MON-yyyy HH24:mi:ss'),'BRK',7,3,'0','L580','26-001','No',0,0,15,0,null,0,0,0,'T',null,null,0,null ,to_date(timecardDate || ' 10:02:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 10:17:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,'F',null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205110200','20151205111700','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 10:17:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 10:19:00','DD-MON-yyyy HH24:mi:ss'),'LB',7,4,'0','L580','26-001','No',0,0,2,0,null,0,0,0,'T',null,null,0,null   ,to_date(timecardDate || ' 10:17:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 10:19:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205111700','20151205111900','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 10:19:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 12:02:00','DD-MON-yyyy HH24:mi:ss'),'(W)',0,5,'0','L580','01-001','No',0,0,103,0,null,0,0,0,'T',null,null,0,null,to_date(timecardDate || ' 10:19:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 12:02:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205111900','20151205130200','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 12:06:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 14:08:00','DD-MON-yyyy HH24:mi:ss'),'(W)',0,8,'0','L580','01-001','No',0,0,2,1,null,0,0,0,'T',null,null,5,null  ,to_date(timecardDate || ' 14:06:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 14:08:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'F',null,null,'20151205150600','20151205150800','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 14:08:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 14:23:00','DD-MON-yyyy HH24:mi:ss'),'BRK',7,9,'0','L580','26-001','No',0,0,15,1,null,0,0,0,'T',null,null,5,null ,to_date(timecardDate || ' 14:08:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 14:23:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,'F',null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205150800','20151205152300','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');

    TRUTRACK.INSERT_WORKED(vID,agentId,to_date(timecardDate,'DD-MON-yyyy'),1,to_date(timecardDate || ' 14:23:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 15:45:00','DD-MON-yyyy HH24:mi:ss'),'(W)',0,10,'0','L580','01-001','No',0,0,82,1,null,0,0,0,'T',null,null,5,null,to_date(timecardDate || ' 14:23:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 15:45:00','DD-MON-yyyy HH24:mi:ss'),null,null,null,null,null,null,null,null,null,null,null,null,0,0,0,1,null,null,null,null,null,'AUTO','AUTO',null,null,null,to_date(timecardDate,'DD-MON-yyyy'),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,'20151205152300','20151205164500','America/Chicago',null,'F',teamLeaderId,'00327',1,'004','10000');


    COMMIT;

    INSERT_TO_UPDATE_TABLE('AGENT_TIME_VW',vID ,'INSERT' );

    COMMIT;


    TRUTRACK.INSERT_SCHEDULE(vID, agentId, 1, to_date(timecardDate,'DD-MON-yyyy'), to_date(timecardDate,'DD-MON-yyyy'), to_date(timecardDate || ' 07:45:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 16:30:00','DD-MON-yyyy HH24:mi:ss'), 0, null, 'F', 'IEX', NULL, '1');
    INSERT_TO_UPDATE_TABLE('SCHEDULE_VW',vID ,'INSERT' );

    TRUTRACK.INSERT_SCHEDULE_ENTRY(vID, agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate,'DD-MON-yyyy'),1,'IEX','Open Time',NULL,NULL,NULL,NULL,NULL,NULL,NULL,to_date(timecardDate || ' 07:45:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 09:45:00','DD-MON-yyyy HH24:mi:ss'),null, 1);
    INSERT_TO_UPDATE_TABLE('SCHEDULE_DETAIL_VW',vID ,'INSERT' );

    TRUTRACK.INSERT_SCHEDULE_ENTRY(vID, agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate,'DD-MON-yyyy'),2,'IEX','BreakOffline',NULL,NULL,NULL,NULL,NULL,NULL,NULL,to_date(timecardDate || ' 09:45:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 10:00:00','DD-MON-yyyy HH24:mi:ss'),null, 1);
    INSERT_TO_UPDATE_TABLE('SCHEDULE_DETAIL_VW',vID ,'INSERT' );

    TRUTRACK.INSERT_SCHEDULE_ENTRY(vID, agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate,'DD-MON-yyyy'),3,'IEX','Open Time',NULL,NULL,NULL,NULL,NULL,NULL,NULL,to_date(timecardDate || ' 10:00:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 12:15:00','DD-MON-yyyy HH24:mi:ss'),null, 1);
    INSERT_TO_UPDATE_TABLE('SCHEDULE_DETAIL_VW',vID ,'INSERT' );

    TRUTRACK.INSERT_SCHEDULE_ENTRY(vID, agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate,'DD-MON-yyyy'),4,'IEX','Lunch',NULL,NULL,NULL,NULL,NULL,NULL,NULL,to_date(timecardDate || ' 12:15:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 13:00:00','DD-MON-yyyy HH24:mi:ss'),null, 1);
    INSERT_TO_UPDATE_TABLE('SCHEDULE_DETAIL_VW',vID ,'INSERT' );

    TRUTRACK.INSERT_SCHEDULE_ENTRY(vID, agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate,'DD-MON-yyyy'),5,'IEX','Open Time',NULL,NULL,NULL,NULL,NULL,NULL,NULL,to_date(timecardDate || ' 13:00:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 14:30:00','DD-MON-yyyy HH24:mi:ss'),null, 1);
    INSERT_TO_UPDATE_TABLE('SCHEDULE_DETAIL_VW',vID ,'INSERT' );

    TRUTRACK.INSERT_SCHEDULE_ENTRY(vID, agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate,'DD-MON-yyyy'),6,'IEX','BreakOffline',NULL,NULL,NULL,NULL,NULL,NULL,NULL,to_date(timecardDate || ' 14:30:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 14:45:00','DD-MON-yyyy HH24:mi:ss'),null, 1);
    INSERT_TO_UPDATE_TABLE('SCHEDULE_DETAIL_VW',vID ,'INSERT' );

    TRUTRACK.INSERT_SCHEDULE_ENTRY(vID, agentId,to_date(timecardDate,'DD-MON-yyyy'),to_date(timecardDate,'DD-MON-yyyy'),7,'IEX','Open Time',NULL,NULL,NULL,NULL,NULL,NULL,NULL,to_date(timecardDate || ' 14:45:00','DD-MON-yyyy HH24:mi:ss'),to_date(timecardDate || ' 16:30:00','DD-MON-yyyy HH24:mi:ss'),null, 1);
    INSERT_TO_UPDATE_TABLE('SCHEDULE_DETAIL_VW',vID ,'INSERT' );




    COMMIT;
END;
/
