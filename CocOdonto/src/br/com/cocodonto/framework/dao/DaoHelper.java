package br.com.cocodonto.framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {

	/**
	 * Fornecer conexao ao banco de dados
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {

		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/coc", "app", "app");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	public void release(Statement stmt) {
		if (stmt == null)
			return;
		try {
			stmt.close();
		} catch (SQLException e) {
		}
	}

	public void release(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void release(ResultSet rset) {
		if (rset == null)
			return;
		try {
			rset.close();
		} catch (SQLException e) {
		}
	}
	
	public void releaseAll (Connection conn, Statement stmt) {
		release(stmt);
		release(conn);
	}

	public void releaseAll (Connection conn, Statement stmt, ResultSet rset) {
		release(rset);
		releaseAll(conn, stmt);
	}
	
	
}
