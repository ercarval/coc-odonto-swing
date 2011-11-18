package br.com.cocodonto.modelo.entidade;

import java.util.Date;

public class Auditor {

	private Date dataCriacao;
	private Date dataUltimaModificacao;
	private String modificadoPor;
	private String criadoPor;
	
	public Auditor(Date dataCriacao, Date dataUltimaModificacao,
			String modificadoPor, String criadoPor) {
		super();
		this.dataCriacao = dataCriacao;
		this.dataUltimaModificacao = dataUltimaModificacao;
		this.modificadoPor = modificadoPor;
		this.criadoPor = criadoPor;
	}

	public Auditor() {
		super();
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUltimaModificacao() {
		return dataUltimaModificacao;
	}

	public void setDataUltimaModificacao(Date dataUltimaModificacao) {
		this.dataUltimaModificacao = dataUltimaModificacao;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public String getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	
	
}
