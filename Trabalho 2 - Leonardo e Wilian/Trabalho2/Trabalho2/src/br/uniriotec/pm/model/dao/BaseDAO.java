package br.uniriotec.pm.model.dao;

import java.util.List;

/**
 * Essa � a classe DAO gen�rica da aplica��o.
 * Todos os DAOs deve estend�-la informando o seu tipo <T>
 * 
 * P.ex.: public class PesquisadorDAO extends BaseDAO<Pesquisador>
 * <p>
 * A definicao de uma classe gen�rica para os DAOs permite a restri��o de quais opera��es s�o executadas 
 * junto ao mecanismo de persist�ncia definido. P.ex, somente opera��es de incluir, alterar, exlcuir e 
 * listar est�o dispon�veis para esta aplica��o.
 * 
 *
 * @param <T>
 */
public abstract class BaseDAO<T> {
	/***
	 * Inclui um novo registro do tipo T no mecanismo de persistencia escolhido.
	 * @param t registro a ser incluido
	 * @throws Exception caso ocorram problemas durante o processamento da inclus�o do novo registro
	 */
	public abstract void incluir (T t) throws Exception;
	
	/***
	 * Altera um registro do tipo T do mecanismo de persist�ncia escolhido.
	 * @param t registro a ser alterado
	 * @throws Exception caso ocorram problemas durante o processamento da altera��o do registro
	 */
	public abstract void alterar (T t) throws Exception;
	
	/***
	 * Exclui um registro do tipo T do mecanismo de persist�ncia escolhido.
	 * @param t registro a ser excluido
	 * @throws Exception caso ocorram problemas durante o processamento da exclus�o do registro
	 */
	public abstract void excluir (T t) throws Exception;
	
	/***
	 * Obtem a lista de todos os registros do tipo T do mecanismo de persist�ncia escolhido.
	 * @return lista de todos os registros do tipo T
	 * @throws Exception caso ocorram problemas durante o processamento da listagem dos registros
	 */
	public abstract List<T> listar() throws Exception;
	
}
