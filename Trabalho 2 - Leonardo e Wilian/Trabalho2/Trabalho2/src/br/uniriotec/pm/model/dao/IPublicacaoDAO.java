package br.uniriotec.pm.model.dao;

import java.util.List;

import br.uniriotec.pm.model.entidade.ConsultaPublicacao;
import br.uniriotec.pm.model.entidade.Publicacao;

public interface IPublicacaoDAO {

	List<Publicacao> retornaPublicacao() throws Exception;
	Publicacao consultar(Long id) throws Exception;
	List<Publicacao> listaClassificacaoQualis() throws Exception;
	List<ConsultaPublicacao> relatorio(String titulo, String quantidade,
			String classificacao, String pesquisador) throws Exception;
	Publicacao consultar(String titulo, Integer quantidade, String classificacao,
			String pesquisador) throws Exception;
	List<Publicacao> listar() throws Exception;
	void incluir(Publicacao t) throws Exception;
	void alterar(Publicacao t) throws Exception;
	void excluir(Publicacao t) throws Exception;
}
