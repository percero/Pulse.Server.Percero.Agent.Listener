
teamLeaderId='100634748'
agentId='101002986'
timecardDate='18-DEC-2015'
cmsDate='17-DEC-2015'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtst.cmg.convergys.com @Init-001.sql $teamLeaderId $agentId $timecardDate TRUE

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @InitScript_CMS.sql $teamLeaderId $agentId $cmsDate
