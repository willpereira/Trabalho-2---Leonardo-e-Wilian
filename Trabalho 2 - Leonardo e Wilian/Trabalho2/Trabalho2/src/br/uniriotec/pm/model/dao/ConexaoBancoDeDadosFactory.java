package br.uniriotec.pm.model.dao;


public class ConexaoBancoDeDadosFactory  {

	
	public  IConexaoBancoDeDados getConexao() {
		return new ConexaoBancoDeDadosOracle();
    }
	
}

