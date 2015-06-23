package br.uniriotec.pm.model.dao;

import java.util.List;

import br.uniriotec.pm.model.entidade.Afiliacao;

public interface IAfiliacaoDAO {
	
	void incluir(Afiliacao afiliacao) throws Exception;
	List<Afiliacao> consultarAfiliacaoPesquisador(Long id) throws Exception;
	Afiliacao consultar(Long id) throws Exception;
	Afiliacao consultar(String nome) throws Exception;
	void alterar(Afiliacao afiliacao) throws Exception;
	void excluir(Afiliacao afiliacao) throws Exception;
	List<Afiliacao> listar() throws Exception;
	List<Afiliacao> retornaAfiliacoesGeral() throws Exception ;
	
}
