
teamLeaderId='100634748'
agentId='101002986'
timecardDate='14-DEC-2015'
cmsDate='13-DEC-2015'


echo "Run Init-001"
sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @../init/Init-001.sql  $teamLeaderId $agentId $timecardDate FALSE

echo "Delete CMS Entries for " $agentId  ' - '  $timecardDate
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @CleanCMSData.sql  $teamLeaderId $agentId $timecardDate


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

startTime=$cmsDate'15:52:00'
endTime=$cmsDate'16:40:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'16:41:00'
endTime=$cmsDate'16:48:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'16:48:00'
endTime=$cmsDate'16:48:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'16:48:00'
endTime=$cmsDate'16:51:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'16:51:00'
endTime=$cmsDate'17:29:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'17:29:00'
endTime=$cmsDate'17:39:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'17:39:00'
endTime=$cmsDate'18:00:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'18:07:00'
endTime=$cmsDate'18:29:00'
auxReason='0'
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'18:04:00'
endTime=$cmsDate'18:07:00'
auxReason='NULL'
 
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason
 
sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'18:29:00'
endTime=$cmsDate'19:22:00'
auxReason='NULL'
 
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason
 
sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'19:22:00'
endTime=$cmsDate'20:13:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'19:22:00'
endTime=$cmsDate'20:13:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'20:13:00'
endTime=$cmsDate'20:33:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason
sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'20:33:00'
endTime=$cmsDate'21:44:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'21:44:00'
endTime=$cmsDate'22:02:00'
auxReason='NULL'
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$cmsDate'22:02:00'
endTime=$cmsDate'22:30:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate