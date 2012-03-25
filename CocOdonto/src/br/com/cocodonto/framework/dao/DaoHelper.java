package br.com.cocodonto.framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.derby.client.am.SqlException;

public class DaoHelper {

	private static final ThreadLocal<Connection> context = new ThreadLocal<Connection>();

	/**
	 * Fornecer conexao ao banco de dados
	 * 
	 * @return Connection
	 * @throws SQLExceptione
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

	public void beginTransaction() throws SQLException {
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		context.set(conn);
	}

	public void endTransaction() throws SQLException {
		commit(getConnectionFromContext());
		releaseTransaction();
	}

	public void releaseTransaction() throws SQLException {
		Connection conn = getConnectionFromContext();
		release(conn);
		context.remove();
	}
	
	public void rollbackTransaction() {
		Connection conn;
		try {
			conn = getConnectionFromContext();
			rollback(conn);
			release(conn);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		context.remove();
	}

	public void commit(Connection conn) throws SQLException {
		conn.commit();
	}

	public void rollback (Connection conn) throws SQLException {
		if (conn != null) conn.rollback();
	}
	
	public Connection getConnectionFromContext() throws SQLException {

		Connection conn = context.get();

		if (conn == null)
			throw new SQLException("Transação invalida");

		if (conn.isClosed())
			throw new SQLException(
					"Transação invalida, Conexao esta fechada :Z");

		return conn;

	}

	public long executePreparedUpdateAndReturnGeneratedKeys(Connection conn,
			String query, Object... params) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		long result = 0l;
		try {
			pstmt = conn.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
			int i = 0;
			for (Object param : params) {
				pstmt.setObject(++i, param);
			}

			pstmt.executeUpdate();

			rset = pstmt.getGeneratedKeys();

			if (rset.next())
				result = rset.getLong(1);

		} finally {
			release(pstmt);
			release(rset);
		}
		return result;
	}

	public void executePreparedUpdate(Connection conn,
								    	String query, Object... params) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			int i = 0;
			for (Object param : params) {
				pstmt.setObject(++i, param);
			}
			pstmt.executeUpdate();
		} finally {
			release(pstmt);
		}
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

	public void releaseAll(Connection conn, Statement stmt) {
		release(stmt);
		release(conn);
	}

	public void releaseAll(Connection conn, Statement stmt, ResultSet rset) {
		release(rset);
		releaseAll(conn, stmt);
	}

}
