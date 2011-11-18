package br.com.cocodonto.modelo.entidade;

import java.util.Date;

public class Consulta {
	
	private int id;
	
	private Dentista dentista;
	
	private Paciente paciente;
	
	private Date dataCriacao;
	
	private double valor;
	
	private Procedimento tratamento;
	
	private Odontograma odontograma;

	public Consulta(int id, Dentista dentista, Paciente paciente,
			Date dataCriacao, double valor, Procedimento tratamento,
			Odontograma odontograma) {
		super();
		this.id = id;
		this.dentista = dentista;
		this.paciente = paciente;
		this.dataCriacao = dataCriacao;
		this.valor = valor;
		this.tratamento = tratamento;
		this.odontograma = odontograma;
	}

	public Consulta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Procedimento getTratamento() {
		return tratamento;
	}

	public void setTratamento(Procedimento tratamento) {
		this.tratamento = tratamento;
	}

	public Odontograma getOdontograma() {
		return odontograma;
	}

	public void setOdontograma(Odontograma odontograma) {
		this.odontograma = odontograma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result
				+ ((dentista == null) ? 0 : dentista.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((odontograma == null) ? 0 : odontograma.hashCode());
		result = prime * result
				+ ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result
				+ ((tratamento == null) ? 0 : tratamento.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dentista == null) {
			if (other.dentista != null)
				return false;
		} else if (!dentista.equals(other.dentista))
			return false;
		if (id != other.id)
			return false;
		if (odontograma == null) {
			if (other.odontograma != null)
				return false;
		} else if (!odontograma.equals(other.odontograma))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (tratamento == null) {
			if (other.tratamento != null)
				return false;
		} else if (!tratamento.equals(other.tratamento))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	
	
	

}
