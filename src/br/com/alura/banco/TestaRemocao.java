package br.com.alura.banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.iniciaConexao();
		Statement stm = conn.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID >2");
		
		//mostra quantidade de linhas modificas
		Integer linhasModificas = stm.getUpdateCount();
		System.out.println(linhasModificas);

	}

}
