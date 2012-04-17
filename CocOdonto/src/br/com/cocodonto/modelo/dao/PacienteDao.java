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

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.framework.dao.QueryMapper;
import br.com.cocodonto.framework.dao.UpdateDaoException;
import br.com.cocodonto.modelo.entidade.Contato;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

/**
 * 
 * @author Bisso
 * @version $
 */
public class PacienteDao {
	
	private DaoHelper daoHelper;
	
	public PacienteDao () {
		daoHelper = new DaoHelper();
	}
	
	
	public void inserir (Paciente paciente) throws CreateDaoException {
		
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
			inserirPacienteContato(paciente);
			
			daoHelper.endTransaction();

		} catch (SQLException e) {
			
			daoHelper.rollbackTransaction();	
			
			throw new CreateDaoException("Não foi possivel realizar a transação", e);
			
		} 
		
	}
	
	private void inserirPacienteEndereco (Paciente paciente) throws SQLException {
		
		if (paciente.getEndereco() == null) return;
		
		EnderecoDao enderecoDao = new EnderecoDao();
		
		enderecoDao.inserir( paciente.getEndereco() );
		
		daoHelper.executePreparedUpdate( daoHelper.getConnectionFromContext()
										 , "insert into paciente_endereco (paciente_id, endereco_id ) values ( ? , ? )"
										 , paciente.getId() 
										 , paciente.getEndereco().getId() );	
		
	}
	
	
	private void inserirPacienteContato ( Paciente paciente ) throws SQLException {
		
		if (paciente.getContato() == null) return;
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.inserir( paciente.getContato() );
		
		daoHelper.executePreparedUpdate( daoHelper.getConnectionFromContext()
				 , "insert into paciente_contato (paciente_id, contato_id ) values ( ? , ? )"
				 , paciente.getId() 
				 , paciente.getContato().getId() );		
		
	}
	
	
	public void atulizar (Paciente paciente) throws UpdateDaoException {
		
		try {
			daoHelper.beginTransaction();

			daoHelper.executePreparedUpdate( 
										"update paciente set nome = ? , rg = ? , cpf = ? , sexo = ?  where id = ?"
										, paciente.getNome()
										, paciente.getRg()
						                , paciente.getCpf()
						                , paciente.getSexo().toString() 
						                , paciente.getId());
			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
			throw new UpdateDaoException("Não foi possivel atualizar paciente " + paciente ,e );
		}
		
	}
	
	public void excluir (Paciente paciente) throws UpdateDaoException {
		
		try {
			daoHelper.beginTransaction();
			daoHelper.executePreparedUpdate( 
										"delete from paciente where id = ?"
						                , paciente.getId());
			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
			throw new UpdateDaoException("Não foi possivel atualizar paciente " + paciente ,e );
		}
		
	}	
	
	
	public List<Paciente> listaTodos() {
		
		final List<Paciente>  pacientes = new ArrayList<Paciente>();
		try {
			daoHelper.executePreparedQuery("select * from app.paciente"
					, new QueryMapper<Paciente>() {

						@Override
						public List<Paciente> mapping(ResultSet rset) throws SQLException {
							while (rset.next()) {
								pacientes.add( new Paciente( rset.getLong("id")
															, rset.getString("nome")
															, rset.getString("rg")
															, rset.getString("cpf")
															, SexoType.valueOf( rset.getString("sexo"))) );
							}
							return pacientes;
						}
			});
			
		} catch (SQLException e) {
		}
		return pacientes;
		
	}

}
