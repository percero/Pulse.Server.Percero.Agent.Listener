package com.pulse.auth.service;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.percero.agents.auth.services.AuthProviderRegistry;
import com.percero.agents.sync.services.ISyncAgentService;

/**
 * Created by jonnysamps on 8/27/15.
 */
@Component
public class PulseHttpAuthProviderFactory {

    private static Logger logger = Logger.getLogger(PulseHttpAuthProviderFactory.class);

    @Autowired @Value("$pf{pulseHttpAuth.hostPortAndContext}")
    String hostPortAndContext = null;

    @Autowired @Value("$pf{pulseHttpAuth.trustAllCerts:false}")
    Boolean trustAllCerts = false;

    @Autowired @Value("$pf{pulseHttpAuth.insecureMode:true}")
    Boolean insecureMode = false;

    @Autowired
    AuthProviderRegistry authProviderRegistry;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ISyncAgentService syncAgentService;

    @PostConstruct
    public void init(){
        if(hostPortAndContext != null){
            logger.info("Using PulseHttpAuthProvider with endpoint: "+hostPortAndContext + (insecureMode ? " (dev mode)" : ""));
            PulseHttpAuthProvider provider = new PulseHttpAuthProvider(hostPortAndContext, objectMapper,
                    trustAllCerts, syncAgentService, insecureMode);
            authProviderRegistry.addProvider(provider);
        }
    }
}
