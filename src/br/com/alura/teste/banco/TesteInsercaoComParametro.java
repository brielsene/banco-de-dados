package br.com.alura.teste.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		Connection conn = new ConnectionFactory().iniciaConexao();
		try(PreparedStatement stm = conn.prepareStatement("INSERT INTO produto (nome, descricao) values (?, ?) ");){
			conn.setAutoCommit(false);
		}
		
		 
		 
		
		 
		
		
			
		}
	
	public void adicionarVariavel (String nome, String descricao, PreparedStatement stm) throws SQLException {
		
		
		stm.setString(1, nome);
		stm.setString(2, descricao);

	}


}


