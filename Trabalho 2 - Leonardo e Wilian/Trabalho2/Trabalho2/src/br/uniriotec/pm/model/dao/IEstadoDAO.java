package br.uniriotec.pm.model.dao;

import java.util.List;

import br.uniriotec.pm.model.entidade.Estado;

public interface IEstadoDAO {

	List<Estado> retornaEstados() throws Exception;
	void alterar(Estado estado) throws Exception;
	void incluir(Estado t) throws Exception;
	void excluir(Estado t) throws Exception; 
	List<Estado> listar() throws Exception;
	
}
