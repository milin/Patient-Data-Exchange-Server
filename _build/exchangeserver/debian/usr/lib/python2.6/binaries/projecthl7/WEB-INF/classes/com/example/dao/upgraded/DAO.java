package com.example.dao.upgraded;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.example.common.ServiceLocator;
import com.example.common.ServiceLocatorException;
import com.example.dao.DAOException;

public abstract class DAO {
	
	private DataSource datasource;
	
	private static String DATASOURCE_DB_NAME = "java:comp/env/jdbc/FinalProjectDB";	
	
	protected static String LAST_INSERT_ID_SQL = "select last_insert_id()";
	
	public DAO() throws DAOException {
		try {
			datasource = ServiceLocator.getInstance().getDataSource(DATASOURCE_DB_NAME);
		} catch (ServiceLocatorException se) {
			throw new DAOException(se);
		}
	}	
	
	protected Connection getConnection() throws DAOException {
		Connection connection = null;
		try {
			connection = datasource.getConnection();
		} catch (SQLException se) {
			throw new DAOException(se);
		}
		return connection;
	}
	
	public int getLastInsertId(Connection connection) throws DAOException {
		// initialize variables
		int id = 0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(LAST_INSERT_ID_SQL);

			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			// handle exception
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
		return id;
	}	
}
