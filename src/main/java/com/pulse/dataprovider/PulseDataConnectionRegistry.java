package com.pulse.dataprovider;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.jobs.UpdateTableRegistry;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PulseDataConnectionRegistry {
	
    private static Logger logger = Logger.getLogger(DAORegistry.class);

	private static PulseDataConnectionRegistry instance;
	
	public static PulseDataConnectionRegistry getInstance() {
		if (instance == null) {
			instance = new PulseDataConnectionRegistry();
		}
		return instance;
	}

	public PulseDataConnectionRegistry() {
		instance = this;
		try {
			init();
		} catch(YamlException e) {
			logger.error("Error reading PulseDataConnectionFactory yaml config file connectionFactories.yml", e);
		}
	}

	private static Map<String, IConnectionFactory> connectionFactories;
	
	public void init() throws YamlException {
		// Init the connection factories here.
		connectionFactories = new HashMap<String, IConnectionFactory>();

        try {
        	URL ymlUrl = UpdateTableRegistry.class.getClassLoader().getResource("connectionFactories.yml");
        	if (ymlUrl == null) {
            	logger.warn("No configuration found for Connection Factories (connectionFactories.yml), skipping Connection Factories");
            	return;
        	}
        	File configFile = new File(ymlUrl.getFile());
        	YamlReader reader = new YamlReader(new FileReader(configFile));

        	while (true) {
        		IConnectionFactory connectionFactory = reader.read(IConnectionFactory.class);
        		if (connectionFactory == null) {
        			break;
        		}
        		
        		connectionFactories.put(connectionFactory.getName(), connectionFactory);
        	}
        }
        catch (FileNotFoundException e) {
        	logger.warn("No configuration found for StoredProcedures (storedProcedures.yml), skipping StoredProcedures");
		}
	}
	
	public void registerConnectionFactory(String name, IConnectionFactory cf) {
		connectionFactories.put(name, cf);
	}
	
	public IConnectionFactory getConnectionFactory(String name) {
		return connectionFactories.get(name);
	}

}
