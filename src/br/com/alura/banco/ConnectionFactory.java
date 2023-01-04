package br.com.alura.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection iniciaConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/bancoalura?useTimezone=true&serverTimezone=UTC", "root", "root");
		
	}

}
