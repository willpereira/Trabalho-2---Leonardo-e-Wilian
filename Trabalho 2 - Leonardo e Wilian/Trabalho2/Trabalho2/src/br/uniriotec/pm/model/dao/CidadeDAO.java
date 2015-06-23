package br.uniriotec.pm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import br.uniriotec.pm.model.entidade.Cidade;


/**
 * Classe que simula (mock) a classe CidadeDAO manipulando o estado em memória.
 * Está classe poderá ser substituída sem causar grandes impactos na implementação da aplicação.
 * Basta alterar a chamada ao DAO nas classes servlet.
 *
 */

public class CidadeDAO extends BaseDAO<Cidade> implements ICidadeDAO{
	
	private static CidadeDAO instancia;
	private static List<Cidade> listaCidades = null;
	
	private IConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDadosFactory().getConexao();
	//private IConexaoBancoDeDados conexaoBancoDeDados;

	
	public static CidadeDAO getInstance() {
		if (instancia == null) {
			instancia = new CidadeDAO();
			listaCidades = new ArrayList<Cidade>();
		}
		return instancia;
	}
	
//	@Inject
//	public void setConexaoBancoDeDados(IConexaoBancoDeDados conexaoBancoDeDados){
//		this.conexaoBancoDeDados = conexaoBancoDeDados;
//	}
	
	public List<Cidade> retornaCidades() throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		
		String sql = "select * from cidade";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Cidade cidade= null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
		
			while (resultSet.next()) {
				cidade = new Cidade();
				setCidade(resultSet,cidade);
				listaCidades.add(cidade);
			}
		} catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		
		return listaCidades;
	}
	
	

	 public void incluir(Cidade cidade) throws Exception {
		listaCidades.add(cidade);
	}
    
	
	public Cidade consultar(Long id) throws Exception {
		return listaCidades.get(id.intValue());
	}
	
	public Cidade consultarCidadePesq(Long id) throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		
		String sql = "select c.id_cidade, e.nome_estado , p.nome_pais, c.nome_cidade from cidade c, estado e,pais p where c.id_cidade=(SELECT a.id_cidade from pesquisador_cidade_reside a where a.id_pesquisador= ? ) and c.id_estado=e.id_estado and c.id_pais=p.id_pais";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Cidade cidade= null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id.intValue());
			resultSet = statement.executeQuery();
	
			if (resultSet.next()) {
				cidade = new Cidade();
				setCidade(resultSet,cidade);
			}
		} catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		return cidade;
	}
	
	public Integer consultarIDCidade(String cidade,String estado, String pais) throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		String sql = "Select c.id_cidade from cidade c, pais p, estado e where c.nome_cidade= ? and c.id_estado=e.id_estado and e.nome_estado= ? and c.id_pais=p.id_pais and p.nome_PAIS= ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Integer id=null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, cidade);
			statement.setString(2, estado);
			statement.setString(3, pais);
			resultSet = statement.executeQuery();
		
			if (resultSet.next()) {
				id=resultSet.getInt("id_cidade");
			}
		}catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		return id;
	}
	
	
	public Cidade consultar(String nome) throws Exception {
		Iterator<Cidade> itr = listaCidades.iterator();
		while(itr.hasNext()){
			Cidade element = (Cidade) itr.next();
			if(nome.toUpperCase().equals(element.getNome_cidade().toUpperCase())){
				return element;
			}
		}

		return null;
	}

	public void alterar(Cidade cidade) throws Exception {
		listaCidades.remove(cidade);
		listaCidades.add(cidade);
	}

	@Override
	public void excluir(Cidade cidade) throws Exception {
		listaCidades.remove(cidade);
	}

	
	@Override
	public List<Cidade> listar() throws Exception {
		return listaCidades;
	}
	
	public void setCidade(ResultSet resultSet,Cidade cidade) throws SQLException{
		cidade.setIdCidade(resultSet.getInt("id_cidade"));
		cidade.setNome_cidade(resultSet.getString("nome_cidade"));
		cidade.setIdEstado(resultSet.getInt("id_estado"));
		cidade.setIdPais(resultSet.getInt("id_pais"));
	}

}

