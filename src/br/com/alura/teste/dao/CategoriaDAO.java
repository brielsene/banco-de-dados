package br.com.alura.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.teste.modelo.Categoria;

public class CategoriaDAO {
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

}
