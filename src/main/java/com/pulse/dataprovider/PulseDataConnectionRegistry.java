package com.pulse.dataprovider;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.percero.agents.sync.dao.DAORegistry;
import com.percero.agents.sync.jobs.UpdateTableRegistry;
import com.percero.agents.sync.services.DAODataProvider;
import com.percero.agents.sync.services.DataProviderManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class PulseDataConnectionRegistry {

	@Autowired
	DataProviderManager dataProviderManager;

	@Autowired
	DAODataProvider daoDataProvider;

	@Autowired(required=false) @Qualifier("daoConnectionFactoryConfigFile")
	String configFile = "connectionFactories.yml";
	
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
	}

	private static Map<String, IConnectionFactory> connectionFactories;

	@PostConstruct
	public void init() throws YamlException {
		dataProviderManager.addDataProvider(daoDataProvider);
		dataProviderManager.setDefaultDataProvider(daoDataProvider);

		// Init the connection factories here.
		connectionFactories = new HashMap<String, IConnectionFactory>();

        try {
        	URL ymlUrl = UpdateTableRegistry.class.getClassLoader().getResource(configFile);
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
