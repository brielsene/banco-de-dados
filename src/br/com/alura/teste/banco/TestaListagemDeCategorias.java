package br.com.alura.teste.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.teste.dao.CategoriaDAO;
import br.com.alura.teste.dao.ProdutoDAO;
import br.com.alura.teste.modelo.Categoria;
import br.com.alura.teste.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
	Connection conn = new ConnectionFactory().iniciaConexao();	
	CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
	List<Categoria>lista = categoriaDAO.listaCategoriaComProdutos();
	lista.stream().forEach(l ->
	{
		System.out.println(l.getNome());
		for(Produto produto : l.getProdutos() ) {
				System.out.println(l.getNome()+"  -  "+produto.getNome());
			}
	
	});
	
	
	
	
	
//	for (Produto produto : new ProdutoDAO(conn).buscar(l)) {
//		
//	}

	}

}
