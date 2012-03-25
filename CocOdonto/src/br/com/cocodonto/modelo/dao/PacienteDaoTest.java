package br.com.cocodonto.modelo.dao;

import java.util.Date;

import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Paciente paciente = new Paciente("Katatau2", "3284973423", "90485098", SexoType.M);
		paciente.setCriacao(new Date());
		Endereco end = new Endereco("End do Katatau2"
									,"Cid do Katatau2"
									,"Bairro do Katatau2"
									,"CepKata"  );
		
		paciente.setEndereco(end);
		
		PacienteDao dao = new PacienteDao();
		dao.inserir(paciente);
		
		
	}

}
