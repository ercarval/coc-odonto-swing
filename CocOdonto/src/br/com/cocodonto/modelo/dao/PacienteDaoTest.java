package br.com.cocodonto.modelo.dao;

import java.util.Date;
import java.util.List;

import br.com.cocodonto.modelo.entidade.Contato;
import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Paciente paciente = new Paciente("Katatau3", "3284973423", "90485098", SexoType.M);
		paciente.setCriacao(new Date());
		Endereco end = new Endereco("End do Katatau3"
									,"Cid do Katatau3"
									,"Bairro do Katatau3"
									,"CepKata"  );
		paciente.setEndereco(end);
		
		Contato contato = new Contato();
		contato.setCelular("1293483983");
		contato.setTelefone("1293483983");
		contato.setEmail("ercarval@gmail.com");
		
		paciente.setContato(contato);
		
		PacienteDao dao = new PacienteDao();
		dao.inserir(paciente);
		
		List<Paciente> list = dao.listaTodos();
		
	}

}
