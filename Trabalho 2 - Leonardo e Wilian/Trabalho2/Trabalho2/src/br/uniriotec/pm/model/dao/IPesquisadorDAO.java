package br.uniriotec.pm.model.dao;

import java.util.List;

import br.uniriotec.pm.model.entidade.Pesquisador;

public interface IPesquisadorDAO {

	 List<Pesquisador> retornaPesquisador() throws Exception;
	 void incluir(Pesquisador pesquisador) throws Exception;
	 void incluirCidadePesq(Integer idCidade,Integer idPesquisador) throws Exception;
	 void incluirAfiliacaoPesq(Integer idAfiliacao,Integer idPesquisador) throws Exception;
	 Pesquisador consultar(Long id) throws Exception;
	 Pesquisador consultar(String primeiro_nome, String nome_do_meio,String ultimo_nome) throws Exception;
	 void alterar(Pesquisador pesquisador) throws Exception;
	 void excluir(Integer id) throws Exception;
	 List<Pesquisador> listar() throws Exception;
	 void excluir(Pesquisador t) throws Exception;
}
