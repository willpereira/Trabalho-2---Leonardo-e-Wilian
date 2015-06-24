package br.uniriotec.pm.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.uniriotec.pm.model.entidade.Afiliacao;
import br.uniriotec.pm.model.dao.ConexaoBancoDeDadosFactory;




/**
 * Classe que simula (mock) a classe AfiliacaoDAO manipulando a afiliação em memória.
 * Está classe poderá ser substituída sem causar grandes impactos na implementação da aplicação.
 * Basta alterar a chamada ao DAO nas classes servlet.
 *
 *
 */


public class AfiliacaoDAO extends BaseDAO<Afiliacao> implements IAfiliacaoDAO{

		private static AfiliacaoDAO instancia;
		private static List<Afiliacao> ListaAfiliacao = null;
		
		//private IConexaoBancoDeDados conexaoBancoDeDados;
		private IConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDadosFactory().getConexao();
		
		

		public static AfiliacaoDAO getInstance() {
			if (instancia == null) {
				instancia = new AfiliacaoDAO();
				ListaAfiliacao = new ArrayList<Afiliacao>();
			}
			return instancia;
		}
		
//		@Inject
//		public void setConexaoBancoDeDados(IConexaoBancoDeDados conexaoBancoDeDados){
//			this.conexaoBancoDeDados = conexaoBancoDeDados;
//		}

		public void incluir(Afiliacao afiliacao) throws Exception {
			ListaAfiliacao.add(afiliacao);
		}

		public List<Afiliacao> consultarAfiliacaoPesquisador(Long id) throws Exception {
			
			Connection connection = conexaoBancoDeDados.criaConexao();
			
			String sql = "SELECT * FROM AFILIACAO A WHERE ID_AFILIACAO IN (SELECT ID_AFILIACAO FROM PESQUISADOR_AFILIACAO_POSSUI WHERE ID_PESQUISADOR= ? ) ";
			
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			Afiliacao afiliacao = null;
			
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, id.intValue());
			
				resultSet = statement.executeQuery();
		
				while (resultSet.next()) {
					afiliacao = new Afiliacao();
					setAfiliacao(resultSet,afiliacao);
					ListaAfiliacao.add(afiliacao);
				}
			} catch (SQLException e) {
				throw e;
			} finally{
				connection.close();
			}
			
			return ListaAfiliacao;
		}
		
		public Afiliacao consultar(Long id) throws Exception {
			return ListaAfiliacao.get(id.intValue());
		}
		
		public Afiliacao consultar(String nome) throws Exception {
			Connection connection = conexaoBancoDeDados.criaConexao();
			String sql ="select * from AFILIACAO A where upper(A.nome_afiliacao)= upper( ? )";
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			Afiliacao afiliacao= null;
		
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, nome);
				resultSet = statement.executeQuery();
				if (resultSet.next()) {
					afiliacao = new Afiliacao();
					setAfiliacao(resultSet,afiliacao);					
				}
			} catch (SQLException e) {
				throw e;
			}
			return afiliacao;
		}

		public void alterar(Afiliacao afiliacao) throws Exception {
			ListaAfiliacao.remove(afiliacao);
			ListaAfiliacao.add(afiliacao);
		}

		@Override
		public void excluir(Afiliacao afiliacao) throws Exception {
			ListaAfiliacao.remove(afiliacao);
		}

		@Override
		public List<Afiliacao> listar() throws Exception {
			return ListaAfiliacao;
		}
		
		public List<Afiliacao> retornaAfiliacoesGeral() throws Exception {
			Connection connection = conexaoBancoDeDados.criaConexao();
			String sql ="select * from AFILIACAO A";
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			Afiliacao afiliacao= null;

			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					afiliacao = new Afiliacao();
					setAfiliacao(resultSet,afiliacao);
					ListaAfiliacao.add(afiliacao);
				}
			} catch (SQLException e) {
				throw e;
			}
			return ListaAfiliacao;
		}
		
		public List<Afiliacao> retornaAfiliacoes() throws Exception {
			Connection connection = conexaoBancoDeDados.criaConexao();
			String sql ="select A.ID_AFILIACAO, C..ID_CIDADE, A.NOME_AFILIACAO, A.TIPO_AF, A.LOGRADOURO_AF, A.TIPO_LOGRADOURO_AF, A.NUMERO_END_AF, A.COMPLEMENTO_AF from AFILIACAO A, CIDADE C where A.ID_CIDADE = C.ID_CIDADE";
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			Afiliacao afiliacao= null;
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					afiliacao = new Afiliacao();
					setAfiliacao(resultSet, afiliacao);
					ListaAfiliacao.add(afiliacao);
				}
			} catch (SQLException e) {
			throw e;
			}
			return ListaAfiliacao;
			}
		
		public List<Afiliacao> consultarAfiliacaoPesq(Long id) throws Exception {
			Connection connection = conexaoBancoDeDados.criaConexao();
			String sql = "SELECT * FROM AFILIACAO A WHERE ID_AFILIACAO IN (SELECT ID_AFILIACAO FROM PESQUISADOR_AFILIACAO_POSSUI WHERE ID_PESQUISADOR= ? ) ";
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Afiliacao> af= new ArrayList<Afiliacao>();
			try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id.intValue());
			rs = stmt.executeQuery();
			//listaCidades.clear();
			while (rs.next()) {
				Afiliacao afiliacao = new Afiliacao();
				afiliacao.setIdAfiliacao(rs.getInt("id_afiliacao"));
				afiliacao.setNome(rs.getString("nome_afiliacao"));
				afiliacao.setComplemento(rs.getString("complemento_af"));
				afiliacao.setLogradouro(rs.getString("logradouro_af"));
				afiliacao.setIdCidade(rs.getInt("id_cidade"));
				afiliacao.setTipo(rs.getString("tipo_af"));
				afiliacao.setTipo_logradouro(rs.getString("tipo_logradouro_af"));
				afiliacao.setNumero(rs.getInt("numero_end_af"));
				af.add(afiliacao);
			}
			} catch (SQLException e) {
			throw e;
			} finally{
				connection.close();
			}
			return af;
			}
	
		public void setAfiliacao(ResultSet resultSet, Afiliacao afiliacao) throws SQLException{		
			
				afiliacao.setIdAfiliacao(resultSet.getInt("ID_AFILIACAO"));
				afiliacao.setIdCidade(resultSet.getInt("ID_CIDADE"));
				afiliacao.setNome(resultSet.getString("NOME_AFILIACAO"));
				afiliacao.setTipo(resultSet.getString("TIPO_AF"));
				afiliacao.setTipo_logradouro(resultSet.getString("TIPO_LOGRADOURO_AF"));
				afiliacao.setLogradouro(resultSet.getString("LOGRADOURO_AF"));
				afiliacao.setNumero(resultSet.getInt("NUMERO_END_AF"));
				afiliacao.setComplemento(resultSet.getString("COMPLEMENTO_AF"));
		}
}

