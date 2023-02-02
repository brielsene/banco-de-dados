package br.com.alura.teste.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PequenoTeste {

	public static void main(String[] args)throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		String sql = "SELECT * FROM PRODUTO";
		
			Connection conn = connectionFactory.iniciaConexao();
			PreparedStatement stm = conn.prepareStatement(sql);
		
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			while(rs.next()) {
				System.out.println("Nome: "+rs.getString("nome"));
				System.out.println("Descricao: "+rs.getString("descricao"));
				System.out.println();
			
			stm.close();
			conn.close();
		

	}
	}		
	}
