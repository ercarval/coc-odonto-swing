package br.com.cocodonto.modelo.dao;

import java.sql.SQLException;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.framework.dao.DeleteDaoException;
import br.com.cocodonto.framework.dao.UpdateDaoException;
import br.com.cocodonto.modelo.entidade.Contato;

public class ContatoDao {

	private DaoHelper daoHelper;

	public ContatoDao() {
		this.daoHelper = new DaoHelper();
	}

	public void inserir(Contato contato) throws CreateDaoException {
		long id = 0l;
		try {
			id = daoHelper
					.executePreparedUpdateAndReturnGeneratedKeys(
							daoHelper.getConnectionFromContext(),
							"insert into contato (CELULAR, EMAIL, TELEFONE) VALUES (?,?,?)",
							contato.getCelular(), contato.getEmail(),
							contato.getTelefone());
			contato.setId(id);

		} catch (SQLException e) {
			throw new CreateDaoException("Nao foi possivel armazenar Contato "
					+ contato, e);
		}
	}

	public void atulizar (Contato contato) throws UpdateDaoException {
		
		try {
			
			daoHelper
					.executePreparedUpdate (
							daoHelper.getConnectionFromContext()
							,"update set contato (CELULAR = ?, EMAIL=?, TELEFONE=?) where ID= ?"
							, contato.getCelular()
							, contato.getEmail()
							, contato.getTelefone()
							, contato.getId());

		} catch (SQLException e) {
			throw new UpdateDaoException("Nao foi possivel atulizar Contato "
					+ contato, e);
		}
	}

	public void excluir (Contato contato) throws DeleteDaoException {
		
		try {
			
			daoHelper
					.executePreparedUpdate (
							daoHelper.getConnectionFromContext()
							, "delete from contato where ID=?"
							, contato.getId());

		} catch (SQLException e) {
			throw new DeleteDaoException("Nao foi possivel excluir Contato "
					+ contato, e);
		}
	}
	

	

}
