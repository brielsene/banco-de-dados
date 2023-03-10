package br.com.alura.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.teste.modelo.Categoria;
import br.com.alura.teste.modelo.Produto;

public class ProdutoDAO {
	Produto produto;
	Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserirProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			while (rs.next()) {
				produto.setId(rs.getInt(1));
			}

			System.out.println(produto + ", inserido");

		}

	}

	public List<Produto> listaProdutos() throws SQLException {
		List<Produto> listaDeProduto = new ArrayList<>();
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.execute();

			try (ResultSet rs = stm.getResultSet()) {

				while (rs.next()) {
					Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
					listaDeProduto.add(produto);

				}
			}

		}
		return listaDeProduto;
	}

	public String removeProdutoPeloId(Integer id) throws SQLException {
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE ID = ?";

		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			while (rs.next()) {

				Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println("O produto a ser removido: " + produto);
			}
		}

		sql = "DELETE FROM PRODUTO WHERE ID = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, id);
			stm.execute();
			int i = stm.getUpdateCount();
			if (i == 1) {
				System.out.println("Produto removido com sucesso");
			} else {
				System.out.println("O id de produto digitado, n??o existe!");
			}

		}
		return "Falhar ao remover produto";
	}

	public List<Produto> buscar(Categoria ct) throws SQLException {
		List<Produto> listaDeProduto = new ArrayList<>();
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, ct.getId());
			stm.execute();

			try (ResultSet rs = stm.getResultSet()) {

				while (rs.next()) {
					Produto produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3));
					listaDeProduto.add(produto);

				}
			}

		}
		return listaDeProduto;
	}

}
