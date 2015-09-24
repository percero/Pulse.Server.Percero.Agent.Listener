package com.pulse.dataprovider;

import java.util.HashMap;
import java.util.Map;

public class PulseDataConnectionRegistry {
	
	private static PulseDataConnectionRegistry instance;
	
	public static PulseDataConnectionRegistry getInstance() {
		if (instance == null) {
			instance = new PulseDataConnectionRegistry();
		}
		return instance;
	}

	public PulseDataConnectionRegistry() {
		instance = this;
		init();
	}

	private static Map<String, IConnectionFactory> connectionFactories;
	
	public void init() {
		// Init the connection factories here.
		connectionFactories = new HashMap<String, IConnectionFactory>();
	}
	
	public void registerConnectionFactory(String name, IConnectionFactory cf) {
		connectionFactories.put(name, cf);
	}
	
	public IConnectionFactory getConnectionFactory(String name) {
		return connectionFactories.get(name);
	}

}
