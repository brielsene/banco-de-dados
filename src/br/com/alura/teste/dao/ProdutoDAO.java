package br.com.alura.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.teste.modelo.Produto;

public class ProdutoDAO {

	Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public void inserirProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?, ?)";
		try(PreparedStatement stm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.execute();

	
			

			ResultSet rs = stm.getGeneratedKeys();
			while(rs.next()) {
				produto.setId(rs.getInt(1));
			}
			System.out.println(rs);
			
			
			
			
				
			
		
		
			System.out.println(produto+", inserido");
			
		}
		
			
		
	}
}
