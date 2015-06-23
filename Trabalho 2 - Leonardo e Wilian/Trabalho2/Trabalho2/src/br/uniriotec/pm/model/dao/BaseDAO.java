package br.uniriotec.pm.model.dao;

import java.util.List;

/**
 * Essa é a classe DAO genérica da aplicação.
 * Todos os DAOs deve estendê-la informando o seu tipo <T>
 * 
 * P.ex.: public class PesquisadorDAO extends BaseDAO<Pesquisador>
 * <p>
 * A definicao de uma classe genérica para os DAOs permite a restrição de quais operações são executadas 
 * junto ao mecanismo de persistência definido. P.ex, somente operações de incluir, alterar, exlcuir e 
 * listar estão disponíveis para esta aplicação.
 * 
 *
 * @param <T>
 */
public abstract class BaseDAO<T> {
	/***
	 * Inclui um novo registro do tipo T no mecanismo de persistencia escolhido.
	 * @param t registro a ser incluido
	 * @throws Exception caso ocorram problemas durante o processamento da inclusão do novo registro
	 */
	public abstract void incluir (T t) throws Exception;
	
	/***
	 * Altera um registro do tipo T do mecanismo de persistência escolhido.
	 * @param t registro a ser alterado
	 * @throws Exception caso ocorram problemas durante o processamento da alteração do registro
	 */
	public abstract void alterar (T t) throws Exception;
	
	/***
	 * Exclui um registro do tipo T do mecanismo de persistência escolhido.
	 * @param t registro a ser excluido
	 * @throws Exception caso ocorram problemas durante o processamento da exclusão do registro
	 */
	public abstract void excluir (T t) throws Exception;
	
	/***
	 * Obtem a lista de todos os registros do tipo T do mecanismo de persistência escolhido.
	 * @return lista de todos os registros do tipo T
	 * @throws Exception caso ocorram problemas durante o processamento da listagem dos registros
	 */
	public abstract List<T> listar() throws Exception;
	
}
