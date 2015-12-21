
teamLeaderId='100634748'
agentId='101002986'
timecardDate='14-DEC-2015'
cmsDate='13-DEC-2015'

echo "Run Init-001"
sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @../init/Init-001.sql  $teamLeaderId $agentId $cmsDate TRUE

echo "Delete CMS Entries for " $agentId  ' - '  $cmsDate
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @CleanCMSData.sql  $teamLeaderId $agentId $cmsDate


auxReason='0'
startTime=$cmsDate'12:00:00'
endTime=$cmsDate'14:00:00'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason


sleep 10

startTime=$cmsDate'14:00:00'
endTime=$cmsDate'15:10:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'15:10:00'
endTime=$cmsDate'15:40:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'15:40:00'
endTime=$cmsDate'15:52:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'15:52:00'
endTime=$cmsDate'16:00:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'16:01:00'
endTime=$cmsDate'16:48:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'16:48:00'
endTime=$cmsDate'16:48:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'16:48:00'
endTime=$cmsDate'16:51:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'16:51:00'
endTime=$cmsDate'17:29:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason  

sleep 10

startTime=$cmsDate'17:29:00'
endTime=$cmsDate'17:39:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason

sleep 10

startTime=$cmsDate'17:39:00'
endTime=$cmsDate'18:00:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason

sleep 10

startTime=$cmsDate'18:07:00'
endTime=$cmsDate'18:29:00'
auxReason='0'
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason

sleep 10

startTime=$cmsDate'18:04:00'
endTime=$cmsDate'18:07:00'
auxReason='NULL'
 
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason
 
sleep 10

startTime=$cmsDate'18:29:00'
endTime=$cmsDate'19:22:00'
auxReason='NULL'
 
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason
 
sleep 10

startTime=$cmsDate'19:22:00'
endTime=$cmsDate'20:00:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason

sleep 10

startTime=$cmsDate'20:00:00'
endTime=$cmsDate'20:33:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason
sleep 10

startTime=$cmsDate'20:33:00'
endTime=$cmsDate'21:44:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason

sleep 10

startTime=$cmsDate'21:44:00'
endTime=$cmsDate'22:02:00'
auxReason='NULL'
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason

sleep 10

startTime=$cmsDate'22:02:00'
endTime=$cmsDate'22:40:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $cmsDate $startTime $endTime $auxReason

sleep 10