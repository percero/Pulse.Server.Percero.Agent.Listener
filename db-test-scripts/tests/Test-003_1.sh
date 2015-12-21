

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
startTime=$timecardDate'08:44:00'
endTime=$timecardDate'09:07:00'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'09:07:00'
endTime=$timecardDate'09:10:00'
auxReason='NULL'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'09:10:00'
endTime=$timecardDate'09:29:00'
auxReason='0'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'09:29:00'
endTime=$timecardDate'09:52:00'
auxReason='NULL'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'09:52:00'
endTime=$timecardDate'10:41:00'
auxReason='0'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'10:41:00'
endTime=$timecardDate'10:48:00'
auxReason='NULL'


sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'10:48:00'
endTime=$timecardDate'10:48:00'
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

startTime=$timecardDate'10:51:00'
endTime=$timecardDate'11:29:00'
auxReason='0'


sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'11:29:00'
endTime=$timecardDate'11:39:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'11:39:00'
endTime=$timecardDate'12:00:00'
auxReason='0'



sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'12:04:00'
endTime=$timecardDate'12:07:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'12:07:00'
endTime=$timecardDate'12:29:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'12:29:00'
endTime=$timecardDate'13:22:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'


sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'13:22:00'
endTime=$timecardDate'14:13:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'


sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'14:13:00'
endTime=$timecardDate'14:33:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'14:33:00'
endTime=$timecardDate'15:44:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'15:44:00'
endTime=$timecardDate'16:02:00'
auxReason='NULL'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'


sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

startTime=$timecardDate'16:02:00'
endTime=$timecardDate'16:30:00'
auxReason='0'
echo 'debug '$startTime'---'
echo 'debug '$endTime'---'

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @AddTimecardEntryForCMSEntry.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @UpdateTableForTimecardUpdateOperation.sql $teamLeaderId $agentId $timecardDate $startTime $endTime

