package br.com.cocodonto.modelo.entidade;

public class Endereco {
	private long id;
	private String endereco;
	private String cidade;
	private String bairro;
	private String cep;

	public Endereco() {
	}

	
	
	public Endereco(String endereco, String cidade, String bairro, String cep) {
		super();
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}