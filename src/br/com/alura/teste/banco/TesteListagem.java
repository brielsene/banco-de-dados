package br.com.alura.teste.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.iniciaConexao();
		
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM PRODUTO");
		stm.execute();
		ResultSet rs = stm.getResultSet();
		
		while(rs.next()) {
			System.out.println(rs.getString("nome"));
			System.out.println(rs.getString("descricao"));
		}
		
	
		
		
	}

}
