package com.pulse.dataprovider;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class PulseDataConnectionRegistry {

	public PulseDataConnectionRegistry() {

	}

	private static Map<String, IConnectionFactory> connectionFactories;
	
	@PostConstruct
	public void init() {
		// Init the connection factories here.
		connectionFactories = new HashMap<String, IConnectionFactory>();
	}
	
	public IConnectionFactory getConnectionFactory(String name) {
		return connectionFactories.get(name);
	}

}
