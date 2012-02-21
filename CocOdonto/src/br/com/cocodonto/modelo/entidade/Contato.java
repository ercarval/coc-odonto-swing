package br.com.cocodonto.modelo.entidade;

public class Contato {
	
	private long id;
	private String email;
	private String telfone;
	private String celular;

	public Contato() {
	}

	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelfone() {
		return telfone;
	}

	public void setTelfone(String telfone) {
		this.telfone = telfone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((telfone == null) ? 0 : telfone.hashCode());
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
		Contato other = (Contato) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (telfone == null) {
			if (other.telfone != null)
				return false;
		} else if (!telfone.equals(other.telfone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato [ email= ")
				.append(email)
				.append(", telfone= ")
				.append(telfone)
				.append(", celular= ")
				.append(celular)
				.append(" ]");
		return builder.toString();
	}
	
	
	
	
	
}