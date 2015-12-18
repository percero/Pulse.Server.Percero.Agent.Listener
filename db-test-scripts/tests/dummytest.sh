
teamLeaderId='100634748'
agentId='101002986'
timecardDate='14-DEC-2015'
cmsDate='13-DEC-2015'
auxReason='0'
startTime=$cmsDate'12:00:00'
endTime=$cmsDate'14:00:00'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason


