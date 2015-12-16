DECLARE
    teamLeaderId varchar2(20):='&1';
    agentId varchar2(20):='&2';
    timecardDate varchar2(20):= '&3';
    vLoginId varchar2(20);
BEGIN
select login_id into vLoginId from CMDCTR.rt_agent_detail rt  where employee_id = agentId ;

DELETE FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID=vLoginId and to_char(start_time,'DD-MON-yyyy') =timecardDate;

END;
/

EXIT



