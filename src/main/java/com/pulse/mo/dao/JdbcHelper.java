package com.pulse.mo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.sf.cglib.asm.Type;

public class JdbcHelper {


	public static void setDouble(PreparedStatement pstmt, int index, Double value) throws SQLException {
		if (value != null) {
			pstmt.setDouble(index, value);
		}
		else {
			pstmt.setNull(index, Type.DOUBLE);
		}
	}
	
	public static void setInt(PreparedStatement pstmt, int index, Integer value) throws SQLException {
		if (value != null) {
			pstmt.setInt(index, value);
		}
		else {
			pstmt.setNull(index, Type.INT);
		}
	}
	
	public static void setBoolean(PreparedStatement pstmt, int index, Boolean value) throws SQLException {
		if (value != null) {
			pstmt.setBoolean(index, value);
		}
		else {
			pstmt.setNull(index, Type.BOOLEAN);
		}
	}
}
