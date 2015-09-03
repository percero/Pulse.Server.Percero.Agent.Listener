package com.pulse.sync.helpers;

import com.percero.agents.sync.exceptions.SyncException;

public class ConnectorException extends SyncException {
	
	public static final String UNKNOWN_CONNECTION = "Unknown Connection Type";
	public static final Integer UNKNOWN_CONNECTION_CODE = 4001;

	public static final String INVALID_URI = "Invalid URI";
	public static final Integer INVALID_URI_CODE = 4002;
	
	public static final String UNABLE_TO_REACH_HOST = "Unable to Reach Host";
	public static final Integer UNABLE_TO_REACH_HOST_CODE = 4003;
	
	public static final String RESPONSE_PROCESS_FAILED = "Unable to process the response";
	public static final Integer RESPONSE_PROCESS_FAILED_CODE = 4004;
	
	public static final String INVALID_METHOD = "Invalid Method";
	public static final Integer INVALID_METHOD_CODE = 4005;
	
	public ConnectorException(String name, Integer code, String desc,
			Throwable t) {
		super(name, code, desc, t);
	}

	public ConnectorException(String name, Integer code, String desc) {
		super(name, code, desc);
	}

	public ConnectorException(String name, Integer code) {
		super(name, code);
	}
	
	public ConnectorException() {
		super();
	}

}
