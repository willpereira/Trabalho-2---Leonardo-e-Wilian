package br.uniriotec.pm.model.dao;

import java.util.List;

import br.uniriotec.pm.model.entidade.Cidade;

public interface ICidadeDAO {
	
	List<Cidade> retornaCidades() throws Exception;
	void incluir(Cidade cidade) throws Exception;
	Cidade consultar(Long id) throws Exception;
	Cidade consultarCidadePesq(Long id) throws Exception;
	Integer consultarIDCidade(String cidade,String estado, String pais) throws Exception;
	Cidade consultar(String nome) throws Exception;
	void alterar(Cidade cidade) throws Exception;
	void excluir(Cidade cidade) throws Exception;
	List<Cidade> listar() throws Exception;
		
}
