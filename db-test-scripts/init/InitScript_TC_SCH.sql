DEFINE teamLeaderId='100500731';
DEFINE agentId='100866511';
DEFINE timecardDate =  '09-DEC-2015';

DELETE FROM trutrack.PAYROLL  where PAYROLL='&agentId' and PDATE='&timecardDate' ;
DELETE FROM trutrack.worked  where PAYROLL='&agentId' and PDATE='&timecardDate' ;
DELETE From trutrack.job_schedule_orion WHERE PAYROLL='&agentId' AND START_DATE='&timecardDate' ;

EXEC TRUTRACK.INIT_TC_SCH_DATA('&agentId','&timecardDate');

COMMIT;