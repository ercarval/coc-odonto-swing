package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		EnderecoDao enderecoDao = new EnderecoDao();
		
		Connection conn = null;
		try {
			
			daoHelper.beginTransaction();
			
			conn = daoHelper.getConnectionFromContext();
			
			long id =  daoHelper.executePreparedUpdateAndReturnGeneratedKeys(conn
					                                      , "insert into paciente (nome, rg, cpf, sexo ,dataCriacao) values ( ? , ? , ? , ? , ? )"
					                                      , paciente.getNome()
					                                      , paciente.getRg()
					                                      , paciente.getCpf()
					                                      , paciente.getSexo().toString() 
					                                      , new Date( paciente.getCriacao().getTime() ) );
			
			paciente.setId( id );
			
			inserirPacienteEndereco(paciente);
			
			daoHelper.endTransaction();

		} catch (SQLException e) {
			
			daoHelper.rollbackTransaction();	
			
			throw new CreateDaoException("Não foi possivel realizar a transação", e);
			
		} 
		
	}
	
	private void inserirPacienteEndereco (Paciente paciente) throws SQLException {
		
		EnderecoDao enderecoDao = new EnderecoDao();
		
		enderecoDao.inserir( paciente.getEndereco() );
		
		String query = "insert into paciente_endereco (paciente_id, endereco_id ) values ( ? , ? )";
		
		daoHelper.executePreparedUpdate( daoHelper.getConnectionFromContext()
										 , query
										 , paciente.getId() 
										 , paciente.getEndereco().getId() );	
		
	}
	
	

}
