package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.dao.ProdutoDAO;

@Repository
public class Relatorio {

	private Calendar dataGeracao = Calendar.getInstance();
	private int quantidade;
	private List<Produto> produtos;

	@Autowired
	private ProdutoDAO produtoDAO;

	public void setQuantidade() {
		this.quantidade = produtos.size();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setProdutos() {
		this.produtos = produtoDAO.Relatorio();
	}

	public void setProdutos(Calendar calendar) {
		this.produtos = produtoDAO.Relatorio(calendar);
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public Calendar getDataGeracao() {
		return dataGeracao;
	}

}
