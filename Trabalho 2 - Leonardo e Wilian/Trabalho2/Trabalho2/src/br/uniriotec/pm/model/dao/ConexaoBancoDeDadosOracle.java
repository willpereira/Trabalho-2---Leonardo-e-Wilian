package br.uniriotec.pm.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDeDadosOracle implements IConexaoBancoDeDados {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "sys as sysdba";
	private String password = "123456";
	private String oracleDriver = "oracle.jdbc.driver.OracleDriver";
	private Boolean autocommit = false;
	private Connection connection;
	
	
	@Override
	public  Connection criaConexao() {
		
		try {
			Class.forName(oracleDriver);
		} catch(ClassNotFoundException e) {
			//throw e;
			System.out.println("O driver especificado não foi encontrado!");
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(autocommit);
		} catch (SQLException e ) {
			//throw e;
			System.out.println("Não foi possível conectar ao banco de dados!");
		}
		return connection;
    }


}
