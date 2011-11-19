package br.com.cocodonto.modelo.dao;

import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Paciente paciente = new Paciente("Katatau", "3284973423", "90485098", SexoType.M);
		PacienteDao dao = new PacienteDao();
		
		dao.inserir(paciente);
		
	}

}
