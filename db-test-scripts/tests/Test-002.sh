
teamLeaderId='100634748'
agentId='101002986'
timecardDate='15-DEC-2015'
cmsDate='14-DEC-2015'


echo "Run Init-001"
sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @../init/Init-001.sql  $teamLeaderId $agentId $timecardDate FALSE

echo "Delete CMS Entries for " $agentId  ' - '  $timecardDate
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @CleanCMSData.sql  $teamLeaderId $agentId $cmsDate
