package br.uniriotec.pm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uniriotec.pm.model.entidade.Estado;


/**
 * Classe que simula (mock) a classe EstadoDAO manipulando o estado em memória.
 * Está classe poderá ser substituída sem causar grandes impactos na implementação da aplicação.
 * Basta alterar a chamada ao DAO nas classes servlet.
 *
 *
 */


public class EstadoDAO extends BaseDAO<Estado> implements IEstadoDAO{

	
	private static EstadoDAO instancia;
	private static List<Estado> listaEstados = null;
	
	private IConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDadosFactory().getConexao();
	//private IConexaoBancoDeDados conexaoBancoDeDados;
	
	public static EstadoDAO getInstance() {
		if (instancia == null) {
			instancia = new EstadoDAO();
			listaEstados = new ArrayList<Estado>();
		}
		return instancia;
	}
	
//	@Inject
//	public void setConexaoBancoDeDados(IConexaoBancoDeDados conexaoBancoDeDados){
//		this.conexaoBancoDeDados = conexaoBancoDeDados;
//	}
	
	
	public List<Estado> retornaEstados() throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		String sql = "select * from estado";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Estado estado= null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
		
			while (resultSet.next()) {
				estado = new Estado();
				setEstado(resultSet, estado);
				listaEstados.add(estado);
		     }
		} catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		return listaEstados;
	}
	
	
	

	public void alterar(Estado estado) throws Exception {
		listaEstados.remove(estado);
		listaEstados.add(estado);
	}

	@Override
	public void incluir(Estado t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Estado t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Estado> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEstado(ResultSet resultSet, Estado estado) throws SQLException{
		estado.setIdEstado(resultSet.getInt("id_estado"));
		estado.setNome_estado(resultSet.getString("nome_estado"));
	}
	

}


