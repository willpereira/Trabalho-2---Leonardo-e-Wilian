package br.uniriotec.pm.model.dao;

import java.util.List;

import br.uniriotec.pm.model.entidade.Pais;

public interface IPaisDAO {

	List<Pais> retornaPaises() throws Exception;
	void alterar(Pais pais) throws Exception;
	void incluir(Pais t) throws Exception;
	void excluir(Pais t) throws Exception;	
	List<Pais> listar() throws Exception;


}
