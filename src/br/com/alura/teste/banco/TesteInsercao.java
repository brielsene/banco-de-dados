package br.com.alura.teste.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao  {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.iniciaConexao();
		
		Statement stm = conn.createStatement();
		stm.execute("INSERT INTO PESSOA(NOME, IDADE) VALUES ('Lucas', 16)");
//		ResultSet rs = stm.getResultSet();
	}
	
	
	
		

}
