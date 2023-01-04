package br.com.alura.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.iniciaConexao();
		String nome, descricao;
		int id;
		
		
		 Statement stm = conn.createStatement();
		 stm.execute("SELECT id, NOME, DESCRICAO FROM PRODUTO");
		 ResultSet rs = stm.getResultSet();
		 
		 while(rs.next()) {
			 System.out.println(id = rs.getInt("id"));
			 System.out.println(nome = rs.getString("nome"));
			 System.out.println(descricao = rs.getString("descricao"));
			 
		 }
		 
		 conn.close();

	}

}
