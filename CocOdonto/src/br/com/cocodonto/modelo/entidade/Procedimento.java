package br.com.cocodonto.modelo.entidade;

public class Procedimento {
	
	
	private int id;
	
	private String nome;
	
	private String descricao;

	public Procedimento(String nome, String descricao) {
		this(0,nome, descricao);
	}
	
	public Procedimento(int id, String nome, String descricao) {
		this();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Procedimento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Procedimento other = (Procedimento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Procedimento [id=").append(id).append(", nome=")
				.append(nome).append(", descricao=").append(descricao)
				.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
