teamLeaderId='100500731'
agentId='100866511'
timecardDate='09-DEC-2015'
sh sql pulse/pulse@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1524/cybtim.cmg.convergys.com @../init/Init-001.sql  $teamLeaderId $agentId $timecardDate
sh sql PULSEUSER/V2PULSEUSER@ec2-52-10-55-244.us-west-2.compute.amazonaws.com:1523/dasht @001-AddCMSEntry.sql  $teamLeaderId $agentId $timecardDate

