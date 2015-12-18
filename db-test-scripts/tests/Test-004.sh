
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

echo 'Step 1'
startTime=$cmsDate'15:07:00'
endTime=$cmsDate'15:15:00'
auxReason='NULL'

sleep 5
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @UpdateSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

echo 'Step 2'
startTime=$cmsDate'15:07:00'
endTime=$cmsDate'15:20:00'
auxReason='NULL'
sleep 5
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @UpdateSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

echo 'Step 3'
startTime=$cmsDate'15:07:00'
endTime=$cmsDate'15:25:00'
auxReason='NULL'
sleep 5
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @UpdateSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

echo 'Step 4'
startTime=$cmsDate'15:07:00'
endTime=$cmsDate'15:30:00'
auxReason='NULL'
sleep 5
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @UpdateSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

echo 'Step 5'
startTime=$cmsDate'15:07:00'
endTime=$cmsDate'15:35:00'
auxReason='NULL'
sleep 5
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @UpdateSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

echo 'Step 6'
startTime=$cmsDate'15:07:00'
endTime=$cmsDate'15:40:00'
auxReason='NULL'
sleep 5
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @UpdateSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  
