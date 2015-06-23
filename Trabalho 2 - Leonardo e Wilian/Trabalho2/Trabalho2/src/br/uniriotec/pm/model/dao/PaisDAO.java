package br.uniriotec.pm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uniriotec.pm.model.entidade.Pais;


/**
 * Classe que simula (mock) a classe PaisDAO manipulando o país em memória.
 * Está classe poderá ser substituída sem causar grandes impactos na implementação da aplicação.
 * Basta alterar a chamada ao DAO nas classes servlet.
 *
 */


public class PaisDAO extends BaseDAO<Pais> implements IPaisDAO{
	
		
		private static PaisDAO instancia;
		private static List<Pais> listaPaises = null;
		private IConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDadosFactory().getConexao();
		//private IConexaoBancoDeDados conexaoBancoDeDados;
		
		public static PaisDAO getInstance() {
			if (instancia == null) {
				instancia = new PaisDAO();
				listaPaises = new ArrayList<Pais>();
			}
			return instancia;
		}
		
//		@Inject
//		public void setConexaoBancoDeDados(IConexaoBancoDeDados conexaoBancoDeDados){
//			this.conexaoBancoDeDados = conexaoBancoDeDados;
//		}
		
		public List<Pais> retornaPaises() throws Exception {
			Connection connection = conexaoBancoDeDados.criaConexao();
			String sql = "select * from pais";
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			Pais pais= null;
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
			
				while (resultSet.next()) {
					pais = new Pais();
					setPais(resultSet,pais);
					listaPaises.add(pais);
				}
			} catch (SQLException e) {
				throw e;
			} finally{
				connection.close();
			}
			return listaPaises;
		}
		
		
		

		public void alterar(Pais pais) throws Exception {
			listaPaises.remove(pais);
			listaPaises.add(pais);
		}

		@Override
		public void incluir(Pais t) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void excluir(Pais t) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Pais> listar() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		public void setPais(ResultSet resultSet,Pais pais) throws SQLException{
			pais.setIdPais(resultSet.getInt("id_pais"));
			pais.setNome_pais(resultSet.getString("nome_pais"));
		}
		

	}



