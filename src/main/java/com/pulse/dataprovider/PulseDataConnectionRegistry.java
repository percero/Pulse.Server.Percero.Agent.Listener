package com.pulse.dataprovider;

import java.util.HashMap;
import java.util.Map;

public class PulseDataConnectionRegistry {
	
	private static PulseDataConnectionRegistry instance;
	
	public static PulseDataConnectionRegistry getInstance() {
		return instance;
	}

	public PulseDataConnectionRegistry() {
		instance = this;
	}

	private static Map<String, IConnectionFactory> connectionFactories;
	
	public void init() {
		// Init the connection factories here.
		connectionFactories = new HashMap<String, IConnectionFactory>();
	}
	
	public IConnectionFactory getConnectionFactory(String name) {
		return connectionFactories.get(name);
	}

}
