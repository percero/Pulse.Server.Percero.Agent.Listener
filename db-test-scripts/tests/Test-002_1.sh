
teamLeaderId='100634748'
agentId='101002986'
timecardDate='15-DEC-2015'
cmsDate='14-DEC-2015'

auxReason='0'
startTime=$cmsDate'14:04:00'
endTime=$cmsDate'15:07:00'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

startTime=$cmsDate'15:07:00'
endTime=$cmsDate'15:10:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

startTime=$cmsDate'15:10:00'
endTime=$cmsDate'15:29:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

startTime=$cmsDate'15:29:00'
endTime=$cmsDate'15:52:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate