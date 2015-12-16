teamLeaderId='100634748'
agentId='101002986'
timecardDate='14-DEC-2015'
cmsDate='13-DEC-2015'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtst.cmg.convergys.com @../init/Init-001.sql  $teamLeaderId $agentId $timecardDate TRUE

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @001-AddCMSEntry.sql  $teamLeaderId $agentId $cmsDate

