package br.com.alura.teste.banco;

import java.sql.SQLException;

import br.com.alura.teste.dao.ProdutoDAO;
import br.com.alura.teste.modelo.Produto;

public class TestaInsercaoProdutoDao {

	public static void main(String[] args) throws SQLException {
		ProdutoDAO produtoDao = new ProdutoDAO(new ConnectionFactory().iniciaConexao());
		Produto pc = new Produto("PC GAMER", "PC GAMER DE 3K");
		produtoDao.inserirProduto(pc);

	}

}
