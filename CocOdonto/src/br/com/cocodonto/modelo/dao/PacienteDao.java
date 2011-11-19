package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Paciente;

/**
 * 
 * @author Bisso
 *
 */
public class PacienteDao {
	
	private DaoHelper daoHelper;
	
	public PacienteDao () {
		daoHelper = new DaoHelper();
	}
	
	
	public void inserir (Paciente paciente) throws CreateDaoException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
		
			conn = daoHelper.getConnection();
			int index = 0;
			stmt = conn.prepareStatement("insert int paciente (nome, rg, cpf, sexo) values ( ? , ? , ? , ?  )");
			stmt.setString( ++index, paciente.getNome() );	
			stmt.setString( ++index, paciente.getRg() );	
			stmt.setString( ++index, paciente.getCpf() );	
			stmt.setString( ++index, paciente.getSexo().toString() );	
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new CreateDaoException("Não foi possivel realizar a transação", e);
		} finally {
			daoHelper.releaseAll(conn, stmt);
		}
		
	}

}
