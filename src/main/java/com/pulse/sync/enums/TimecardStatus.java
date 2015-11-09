package com.pulse.sync.enums;

public enum TimecardStatus {
	
	NOT_STARTED("Not Started"),
	IN_PROGRESS("In Progress"),
	COMPLETED("Completed"),
	UNKNOWN("Unknown");
	
	private final String value;
	public String getValue() {
		return this.value;
	}
	
	TimecardStatus(String value) {
		this.value = value;
	}

}
