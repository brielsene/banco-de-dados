package br.com.alura.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.teste.modelo.Categoria;
import br.com.alura.teste.modelo.Produto;

public class CategoriaDAO {
	Categoria ultima = null;
	List<Categoria> listaDeCategoria = new ArrayList<>();
	private Connection conn;
	String sql;

	public CategoriaDAO(Connection conn) {
		this.conn = conn;
	}

	public List<Categoria> listaCategoria() throws SQLException {
		sql = "SELECT ID, NOME FROM CATEGORIA";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {

			stm.execute();
			try (ResultSet rs = stm.getResultSet()) {
				while (rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					listaDeCategoria.add(categoria);
				}
			}

		}
		return listaDeCategoria;

	}

	public List<Categoria> listaCategoriaComProdutos() throws SQLException {
		sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN"
				+ " PRODUTO P ON C.ID = P.CATEGORIA_ID";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {

			stm.execute();
			try (ResultSet rs = stm.getResultSet()) {
				while (rs.next()) {
					if(ultima == null || !ultima.getNome().equals(rs.getString(2))) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					ultima = categoria;
					listaDeCategoria.add(categoria);
					}
					
					Produto produto = new Produto(rs.getInt(3), rs.getString(4), rs.getString(5));
					ultima.adicionar(produto);
				}
			}

		}
		return listaDeCategoria;
	}

}
