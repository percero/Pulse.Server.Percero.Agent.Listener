package com.pulse.dataprovider;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {

	public abstract Connection getConnection() throws SQLException;

}