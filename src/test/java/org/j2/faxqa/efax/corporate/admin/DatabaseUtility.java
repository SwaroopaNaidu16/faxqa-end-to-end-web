package org.j2.faxqa.efax.corporate.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.j2.faxqa.efax.common.Config;

public class DatabaseUtility {

	public static Connection connection = null;

	public static ArrayList<String> executeSQLQuery(String sqlQuery) throws SQLException {
		ArrayList<String> resultValues = new ArrayList<String>();
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			verifyConnection();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(sqlQuery);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				resultValues.add(rs.getMetaData().getColumnName(i) + ":" + rs.getString(i) + " ");
			}
		}
		return resultValues;
	}

	public static ArrayList<String> dataFromDbResponse(List<String> listOfDBValues, String colName) {
		ArrayList<String> columnValues = new ArrayList<String>();
		for (int i = 0; i < listOfDBValues.size(); i++) {
			if (listOfDBValues.get(i).contains(colName)) {
				columnValues.add(listOfDBValues.get(i).split(":")[1].toString().trim());
			}
		}
		return columnValues;
	}

	public static void verifyConnection() throws SQLException {
			if (connection == null || connection.isClosed() || !connection.isValid(5000)) {
				connection = DriverManager.getConnection(Config.dbConnectionUrl, Config.dbUserName, Config.dbPassword);
			}
	}

	public static void closeConnection() throws SQLException {
		connection.close();
	}

	public static void executeUpdateSQLQuery(String sqlQuery1) throws SQLException, Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			verifyConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sqlQuery1);
			connection.commit();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

	public static int getCurrentTimeIn24FormatFromDatabase() throws SQLException, Exception {
		ResultSet rs;
		int currentTime = 0;
		String sqlQuery = "SELECT to_char(CURRENT_TIMESTAMP,'HH24') from dual";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			verifyConnection();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(sqlQuery);
		while (rs.next()) {
			currentTime = rs.getInt(1);
		}
		return currentTime;
	}
}