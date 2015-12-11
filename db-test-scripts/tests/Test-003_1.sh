sleep 5

teamLeaderId=$1
agentId=$2
timecardDate=$3

echo ================================== params STARTS ================================

echo $teamLeader
echo $agentId
echo $timecardDate
echo ================================== params END ================================

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @CleanTimecardEntries.sql $teamLeaderId $agentId $timecardDate

auxReason='0'
startTime=$timecardDate'14:04:00'
endTime=$timecardDate'15:07:00'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'15:07:00'
endTime=$timecardDate'15:10:00'
auxReason='NULL'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime
 
startTime=$timecardDate'15:10:00'
endTime=$timecardDate'15:29:00'
auxReason='0'

echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime     

startTime=$timecardDate'15:29:00'
endTime=$timecardDate'15:52:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime     

startTime=$timecardDate'15:52:00'
endTime=$timecardDate'16:40:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime   

startTime=$timecardDate'16:41:00'
endTime=$timecardDate'16:48:00'
auxReason='NULL'

echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'16:48:00'
endTime=$timecardDate'16:48:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'16:48:00'
endTime=$timecardDate'16:51:00'
auxReason='NULL'

echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'16:51:00'
endTime=$timecardDate'17:29:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'17:29:00'
endTime=$timecardDate'17:39:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'17:39:00'
endTime=$timecardDate'18:00:00'
auxReason='0'

echo 'debug '$startTime'---'
echo 'debug '$endTime'---'
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime     

startTime=$timecardDate'18:04:00'
endTime=$timecardDate'18:07:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'
 
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'18:07:00'
endTime=$timecardDate'18:29:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'
 
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'18:29:00'
endTime=$timecardDate'19:22:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'
 
 
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'19:22:00'
endTime=$timecardDate'20:13:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

 
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'20:13:00'
endTime=$timecardDate'20:33:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'
 
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'20:33:00'
endTime=$timecardDate'21:44:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'
 
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'21:44:00'
endTime=$timecardDate'22:02:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

 
 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime    

startTime=$timecardDate'22:02:00'
endTime=$timecardDate'22:30:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime 


 sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @UpdateTableForTimecardUpdateOperation.sql $teamLeaderId $agentId $timecardDate $startTime $endTime 
 
sleep 10
