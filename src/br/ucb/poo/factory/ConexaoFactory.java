package br.ucb.poo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoFactory {
	public Connection conectar() {
		try {
			Class .forName( "com.mysql.cj.jdbc.Driver" );
		} catch (ClassNotFoundException el) {
			el.printStackTrace();
		}
			
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/sale_house", "root", "root");
		
		} catch (SQLException e) 	{
			e. printStackTrace();
		
		}
		return null;
	}
}

