package br.com.cocodonto.modelo.entidade;

import java.util.Date;

public class Pagamento {
	
	private int id;

	private Date dataPagamento;
	private Date dataVencimento;
	private double valor;
	private double juros;
	private double valorTotal;

	private String descricao;

	public Pagamento(int id, Date dataPagamento, Date dataVencimento,
			double valor, double juros, double valorTotal, String descricao) {
		super();
		this.id = id;
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.juros = juros;
		this.valorTotal = valorTotal;
		this.descricao = descricao;
	}

	public Pagamento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
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
				+ ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result
				+ ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(juros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTotal);
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
		Pagamento other = (Pagamento) obj;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(juros) != Double
				.doubleToLongBits(other.juros))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double
				.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pagamento [id=").append(id).append(", dataPagamento=")
				.append(dataPagamento).append(", dataVencimento=")
				.append(dataVencimento).append(", valor=").append(valor)
				.append(", juros=").append(juros).append(", valorTotal=")
				.append(valorTotal).append(", descricao=").append(descricao)
				.append("]");
		return builder.toString();
	}

	
	
	
}
