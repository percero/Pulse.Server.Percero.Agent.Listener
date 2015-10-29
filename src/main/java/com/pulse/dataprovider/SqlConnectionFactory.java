package com.pulse.dataprovider;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.percero.agents.sync.services.DAODataProvider;
import com.percero.agents.sync.services.DataProviderManager;

public class SqlConnectionFactory implements IConnectionFactory {

    private static Logger logger = Logger.getLogger(SqlConnectionFactory.class);
    
    private static final long MAX_CONNECT_TIME = 2500;	// 2.5 Seconds.
    
    public SqlConnectionFactory() {
    	
    }

    private String name;
    private String driverClassName;
    private String username;
    private String password;
    private String jdbcUrl;
    private Integer acquireIncrement = 2;
    private Integer minPoolSize = 2;
    private Integer maxPoolSize = 50;
    private Integer fetchSize = 500;
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public Integer getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(Integer acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public Integer getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(Integer minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
    
	public Integer getFetchSize() {
		// Default to 100;
		if (fetchSize == null || fetchSize <= 0) {
			return 100;
		}
		return fetchSize;
	}
	
	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}
	
    private ComboPooledDataSource cpds;

    
    private boolean initialized = false;
    public void init() throws Exception {
    	if (initialized) {
    		return;
    	}
        try {
            logger.info("Initializing connection factory: "+getName());
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driverClassName); //loads the jdbc driver
            cpds.setJdbcUrl(jdbcUrl);
            cpds.setUser(username);
            cpds.setPassword(password);

// the settings below are optional -- c3p0 can work with defaults
            cpds.setMinPoolSize(minPoolSize);
            cpds.setAcquireIncrement(acquireIncrement);
            cpds.setMaxPoolSize(maxPoolSize);
			cpds.setNumHelperThreads(30);
			cpds.setTestConnectionOnCheckout(true);
            
            PulseDataConnectionRegistry.getInstance().registerConnectionFactory(getName(), this);
            DataProviderManager.getInstance().setDefaultDataProvider(DAODataProvider.getInstance());

            initialized = true;
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
    	long timeStart = System.currentTimeMillis();
        try{
        	if (!initialized) {
        		try {
        			init();
        		} catch(Exception e) {
        			logger.error("Error initializing SqlConnectionFactory: " + this.getName(), e);
        		}
        	}
            Connection result = cpds.getConnection();
    		logger.debug("Database Connection Time: " + (System.currentTimeMillis() - timeStart) + "ms [" + this.getName() + ": " + this.getJdbcUrl() + "]");
            return result;
        }catch(SQLException e){
            logger.error(e.getMessage(), e);
            throw e;
        } finally {
        	long timeEnd = System.currentTimeMillis();
        	long totalTime = timeEnd - timeStart;
        	if (totalTime > MAX_CONNECT_TIME) {
        		logger.warn("Long Database Connection: " + totalTime + "ms [" + this.getName() + ": " + this.getJdbcUrl() + "]");
        	}
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
