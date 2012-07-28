package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.framework.dao.DeleteDaoException;
import br.com.cocodonto.framework.dao.UpdateDaoException;
import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;

public class EnderecoDao {

	private DaoHelper daoHelper;

	public EnderecoDao() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Endereco endereco) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			int i = 0;
			conn = daoHelper.getConnectionFromContext();
			pstmt = conn
					.prepareStatement(
							"INSERT INTO ENDERECO (ENDERECO,CIDADE,CEP,BAIRRO) VALUES (?,?,?,?) ",
							PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(++i, endereco.getEndereco());
			pstmt.setString(++i, endereco.getCidade());
			pstmt.setString(++i, endereco.getCep());
			pstmt.setString(++i, endereco.getBairro());
			pstmt.executeUpdate();

			rset = pstmt.getGeneratedKeys();
			if (rset.next()) {
				endereco.setId(rset.getLong(1));
			}

		} catch (SQLException e) {
			throw new CreateDaoException("Nao foi possivel armazenar Endereco "
					+ endereco, e);
		}

	}

	public void atualizar(Endereco endereco) throws SQLException {

		final String query = "update paciente set ENDERECO = ?, CIDADE = ?, CEP = ?, BAIRRO = ? where id = ? ";

		daoHelper.executePreparedUpdate(  query
										, endereco.getEndereco()
										, endereco.getCidade()
										, endereco.getCep()
										, endereco.getBairro()
										, endereco.getId());
	}

	public void excluir (Endereco endereco) throws DeleteDaoException {
		try {
			daoHelper.executePreparedUpdateIntoSingleTransaction( "delete from endereco where id = ? "
																, endereco.getId());
		} catch (SQLException e) {
			throw new DeleteDaoException("Não foi possível excluir Endereco", e);
		}
	}

}
