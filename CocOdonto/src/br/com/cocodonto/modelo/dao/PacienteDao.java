package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.client.am.SqlException;
import org.w3c.dom.ls.LSInput;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.framework.dao.QueryMapper;
import br.com.cocodonto.framework.dao.UpdateDaoException;
import br.com.cocodonto.framework.dao.QueryMapper;
import br.com.cocodonto.framework.dao.UpdateDaoException;
import br.com.cocodonto.modelo.entidade.Contato;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

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
		
		try {
			
			daoHelper.beginTransaction();
			
			long id =  daoHelper.executePreparedUpdateAndReturnGeneratedKeys( daoHelper.getConnectionFromContext()
					                                      , "insert into paciente (nome, rg, cpf, sexo ,dataCriacao) values ( ? , ? , ? , ? , ? )"
					                                      , paciente.getNome()
					                                      , paciente.getRg()
					                                      , paciente.getCpf()
					                                      , paciente.getSexo().toString() 
					                                      , new Date( paciente.getCriacao().getTime() ) );
			
			paciente.setId( id );
			
			inserirPacienteEndereco(paciente);
			inserirPacienteContato(paciente);
			daoHelper.endTransaction();

		} catch (SQLException e) {
			
			daoHelper.rollbackTransaction();	
			
			throw new CreateDaoException("N�o foi possivel realizar a transa��o", e);
			
		} 
		
	}
	
	private void inserirPacienteEndereco (Paciente paciente) throws SQLException {
		
		EnderecoDao enderecoDao = new EnderecoDao();
		
		enderecoDao.inserir( paciente.getEndereco() );
		
		final String query = "insert into paciente_endereco (paciente_id, endereco_id ) values ( ? , ? )";
		
		daoHelper.executePreparedUpdate( daoHelper.getConnectionFromContext()
										 , query
										 , paciente.getId() 
										 , paciente.getEndereco().getId() );	
		
	}

	
	private void inserirPacienteContato (Paciente paciente) throws SQLException {
		
		ContatoDao contatoDao = new ContatoDao();
		
		contatoDao.inserir( paciente.getContato() );
		
		final String query = "insert into paciente_contato (paciente_id, contato_id ) values ( ? , ? )";
		
		daoHelper.executePreparedUpdate(  query
                                            , paciente.getId() 
					    , paciente.getContato().getId() );	
		
	}
	
	public void atualizar (Paciente paciente) throws UpdateDaoException {
		
		final String query = "update paciente set nome = ? , rg = ? , cpf = ? , sexo = ? where id = ? ";
		
		try {
			daoHelper.beginTransaction();
			daoHelper.executePreparedUpdate(query
										  , paciente.getNome()
										  , paciente.getRg()
										  , paciente.getCpf()
										  , paciente.getSexo().name()
										  , paciente.getId() );

			atualizarPacienteEndereco(paciente);
			atualizarPacienteContato(paciente);
			
			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();	
			throw new UpdateDaoException("N�o foi poss�vel atualizar Paciente", e);
		}
		
	}
		

	public void atualizarPacienteEndereco(Paciente paciente ) throws SQLException {
		EnderecoDao dao = new EnderecoDao();
		dao.atualizar(paciente.getEndereco());
	}

	public void atualizarPacienteContato (Paciente paciente ) throws SQLException {
		ContatoDao dao = new ContatoDao();
		dao.atualizar(paciente.getContato());
	}
	
	public List<Paciente> listaTodosPacientes() {
		
		final List<Paciente> pacientes = new ArrayList<Paciente>();
		
		try {
		
			daoHelper.executePreparedQuery("select * form paciente", new QueryMapper<Paciente>() {

				@Override
				public List<Paciente> mapping(ResultSet rset) throws SQLException {
					while (rset.next()) {
						Paciente paciente = new Paciente();
						paciente.setId( rset.getInt("id") );
						paciente.setNome( rset.getString("nome") );
						paciente.setCpf( rset.getString("cpf") );
						paciente.setRg( rset.getString("rg") );
						paciente.setSexo( SexoType.valueOf( rset.getString("sexo") ) );
						pacientes.add(paciente);
					}
					return pacientes;
				}
				
			});
		} catch (SQLException e) {
			//ignore exception
		}
		
		return pacientes;
		
	}
	
}
