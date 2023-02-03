package br.com.alura.teste.banco;

import java.sql.SQLException;
import java.util.List;

import br.com.alura.teste.dao.ProdutoDAO;
import br.com.alura.teste.modelo.Produto;

public class TestaoSelecaoProduto {

	public static void main(String[] args) throws SQLException {
		ProdutoDAO produtoDao = new ProdutoDAO(new ConnectionFactory().iniciaConexao());
//		int id ;
//		for(int i = 1; i<18; i++) {
//			produtoDao.removeProdutoPeloId(i);
//		}
		produtoDao.removeProdutoPeloId(new Integer(23));
		
		List<Produto>listaDeProduto = produtoDao.listaProdutos();
		
		listaDeProduto.stream().forEach(System.out::println);

	}

}
