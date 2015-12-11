teamLeaderId='100500731'
agentId='100866511'
timecardDate='09-DEC-2015'

echo "Run Init-001"
sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @../init/Init-001.sql  $teamLeaderId $agentId $timecardDate

echo "Delete CMS Entries for " $agentId  ' - '  $timecardDate
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @CleanCMSData.sql  $teamLeaderId $agentId $timecardDate


auxReason='0'
startTime=$timecardDate'14:04:00'
endTime=$timecardDate'15:07:00'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

startTime=$timecardDate'15:07:00'
endTime=$timecardDate'15:10:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

startTime=$timecardDate'15:10:00'
endTime=$timecardDate'15:29:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

startTime=$timecardDate'15:29:00'
endTime=$timecardDate'15:52:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'15:52:00'
endTime=$timecardDate'16:40:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'16:41:00'
endTime=$timecardDate'16:48:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'16:48:00'
endTime=$timecardDate'16:48:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'16:48:00'
endTime=$timecardDate'16:51:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'16:51:00'
endTime=$timecardDate'17:29:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason  

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'17:29:00'
endTime=$timecardDate'17:39:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'17:39:00'
endTime=$timecardDate'18:00:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'18:07:00'
endTime=$timecardDate'18:29:00'
auxReason='0'
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'18:04:00'
endTime=$timecardDate'18:07:00'
auxReason='NULL'
 
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason
 
sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'18:29:00'
endTime=$timecardDate'19:22:00'
auxReason='NULL'
 
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason
 
sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'19:22:00'
endTime=$timecardDate'20:13:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'19:22:00'
endTime=$timecardDate'20:13:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'20:13:00'
endTime=$timecardDate'20:33:00'
auxReason='NULL'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason
sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'20:33:00'
endTime=$timecardDate'21:44:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'21:44:00'
endTime=$timecardDate'22:02:00'
auxReason='NULL'
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate

startTime=$timecardDate'22:02:00'
endTime=$timecardDate'22:30:00'
auxReason='0'

sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @AddSingleCMSEntry.sql  $teamLeaderId $agentId $timecardDate $startTime $endTime $auxReason

sh Test-003_1.sh $teamLeaderId $agentId $timecardDate