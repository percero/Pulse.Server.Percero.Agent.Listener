package com.pulse.dataprovider;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.percero.agents.sync.services.DAODataProvider;
import com.percero.agents.sync.services.DataProviderManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by jonnysamps on 9/2/15.
 */
@Component
public class SqlConnectionFactory implements IConnectionFactory {

    private static Logger logger = Logger.getLogger(SqlConnectionFactory.class);

    @Autowired
    @Value("$pf{databaseProject.driverClassName:com.mysql.jdbc.Driver}")
    private String driverClassName;

    @Autowired
    @Value("$pf{databaseProject.username}")
    private String username;

    @Autowired
    @Value("$pf{databaseProject.password}")
    private String password;

    @Autowired
    @Value("$pf{databaseProject.host:3306}")
    private String host;
    
    @Autowired
    @Value("$pf{databaseProject.port}")
    private String port;
    
    @Autowired
    @Value("$pf{databaseProject.dbname}")
    private String dbname;

    @Autowired
    @Value("$pf{databaseProject.jdbcUrl}")
    private String jdbcUrl;
    
//    @Autowired
//    @Value("pf{updateTable.jdbcUrl:jdbc:mysql://localhost/db")
    private String getJdbcUrl() {
        if(jdbcUrl == null)
            return "jdbc:mysql://" + host + ":" + port + "/" + dbname;

        return jdbcUrl;
    }

    private ComboPooledDataSource cpds;
    @PostConstruct
    public void init() throws PropertyVetoException{
        try {
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driverClassName); //loads the jdbc driver
            cpds.setJdbcUrl(getJdbcUrl());
            cpds.setUser(username);
            cpds.setPassword(password);

// the settings below are optional -- c3p0 can work with defaults
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
            
            PulseDataConnectionRegistry.getInstance().registerConnectionFactory("default", this);

            DataProviderManager.getInstance().setDefaultDataProvider(DAODataProvider.getInstance());

        }catch(PropertyVetoException pve){
            logger.error(pve.getMessage(), pve);
            throw pve;
        }
    }

    /* (non-Javadoc)
	 * @see com.pulse.dataprovider.IConnectionFactory#getConnection()
	 */
    @Override
	public Connection getConnection() throws SQLException{
        try{
            return cpds.getConnection();
        }catch(SQLException e){
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

//    public static void main(String[] args) throws Exception{
//        UpdateTableConnectionFactory cf = new UpdateTableConnectionFactory();
//        cf.driverClassName = "com.mysql.jdbc.Driver";
//        cf.jdbcUrl = "jdbc:mysql://localhost/test";
//        cf.username = "root";
//        cf.password = "root";
//        cf.init();
//
//        Connection c = cf.getConnection();
//        Statement stmt = c.createStatement();
//
//
//        ResultSet rs = stmt.executeQuery("SELECT * FROM Account");
//        while(rs.next()) {
//            logger.info("ID: " + rs.getInt("ID"));
//            logger.info("markedForRemoval: "+ rs.getDate("markedForRemoval"));
//        }
//    }
}
