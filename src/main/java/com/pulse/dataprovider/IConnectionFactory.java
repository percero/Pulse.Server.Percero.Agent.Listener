package com.pulse.dataprovider;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {

	String getName();
	void setName(String name);
	Connection getConnection() throws SQLException;

}