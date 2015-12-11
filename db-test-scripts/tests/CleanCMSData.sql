DEFINE teamLeaderId='&1';
DEFINE agentId='&2';
DEFINE timecardDate = '&3';

DELETE FROM pulse.MOB_CMS_DATA WHERE LOGIN_ID='&agentId' and to_char(start_time,'DD-MON-yyyy') ='&timecardDate';

EXIT



