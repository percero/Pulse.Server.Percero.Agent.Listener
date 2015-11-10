package com.pulse.sync.enums;

public enum TimecardStatus {
	
	NOT_STARTED("NOT STARTED"),
	IN_PROGRESS("IN PROGRESS"),
	COMPLETED("COMPLETED"),
	NO_SHIFT("NO SHIFT"),
	UNKNOWN("UNKNOWN");
	
	private final String value;
	public String getValue() {
		return this.value;
	}
	
	TimecardStatus(String value) {
		this.value = value;
	}

}
