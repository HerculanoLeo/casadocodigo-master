package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class Pedido{

	private int id;
	private BigDecimal valor;
	private Calendar data;
	
	private List<Produto> produtos;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getTitulos() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(produtos.get(0).getTitulo());
		for (Produto titulo : produtos) {
			if(titulo!=produtos.get(0)) {
				stringBuilder.append(", ");
				stringBuilder.append(titulo.getTitulo());
			}
		}
		stringBuilder.append(".");
		return stringBuilder.toString();
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valor=" + valor + ", data=" + data + ", produtos=" + produtos + "]";
	}

}
