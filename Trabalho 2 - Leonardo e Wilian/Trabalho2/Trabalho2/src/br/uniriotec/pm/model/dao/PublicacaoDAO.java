package br.uniriotec.pm.model.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import br.uniriotec.pm.model.entidade.ConsultaPublicacao;
import br.uniriotec.pm.model.entidade.Publicacao;

/**
 * Classe que simula (mock) a classe PublicacaoDAO manipulando o publicação em memória.
 * Está classe poderá ser substituída sem causar grandes impactos na implementação da aplicação.
 * Basta alterar a chamada ao DAO nas classes servlet.
 *
 */

public class PublicacaoDAO extends BaseDAO<Publicacao> implements IPublicacaoDAO{
	
	private static PublicacaoDAO instancia;
	private static List<Publicacao> ListaPublicacao = null;
	private IConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDadosFactory().getConexao();
	//private IConexaoBancoDeDados conexaoBancoDeDados;
	
	public static PublicacaoDAO getInstance() {
		if (instancia == null) {
			instancia = new PublicacaoDAO();
			ListaPublicacao = new ArrayList<Publicacao>();
		}
		return instancia;
	}
	
//	@Inject
//	public void setConexaoBancoDeDados(IConexaoBancoDeDados conexaoBancoDeDados){
//		this.conexaoBancoDeDados = conexaoBancoDeDados;
//	}
	
	public List<Publicacao> retornaPublicacao() throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		String sql = "select * from prod_biblio";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Publicacao publicacao= null;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				publicacao = new Publicacao();
				setPublicacao(resultSet, publicacao);
				ListaPublicacao.add(publicacao);
			}
		} catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		return ListaPublicacao;
	}

		
	public Publicacao consultar(Long id) throws Exception {
		return ListaPublicacao.get(id.intValue());
	}
	public List<Publicacao> listaClassificacaoQualis() throws Exception{
		Connection connection=conexaoBancoDeDados.criaConexao();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		String sql="SELECT DISTINCT(CLASSIFICACAO_QUALIS) FROM EVENTO";
	
		Publicacao publicacao=null;
		try{
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				publicacao=new Publicacao();
				publicacao.setClassificacao_qualis(resultSet.getString("classificacao_qualis"));
				ListaPublicacao.add(publicacao);
				
			}
		}catch (SQLException e){
			throw e;
		}
		finally{
			connection.close();
		}
		return ListaPublicacao;
	}
	
	public List<ConsultaPublicacao> relatorio(String titulo, String quantidade, String classificacao, String pesquisador) throws Exception {
		Connection connection=conexaoBancoDeDados.criaConexao();
		  
		PreparedStatement statement = null;
		CallableStatement callableStatement=null;
		callableStatement=connection.prepareCall("{call nome_citacao(?,?,?)}");
		ResultSet resultSet = null;
		List<ConsultaPublicacao> listaConsulta = new ArrayList<ConsultaPublicacao>();
		ConsultaPublicacao consulta= null;
		
		if(quantidade!="" && classificacao!=""){
			try {
				String sql ="select ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo, ia.QTD_INFLUENCIADAS,c.nome_cidade from info_autor ia,cidade c, afiliacao a, pesquisador p,pesquisador_afiliacao_possui pap where pap.id_afiliacao = a.id_afiliacao and to_char(IA.QTD_INFLUENCIADAS)>= ? and upper(ia.titulo) like  upper(?)  and IA.CLASSIFICACAO_QUALIS= ? AND a.id_cidade = c.id_cidade and p.primeiro_nome||' '||p.nome_do_meio||' '||p.ultimo_nome = ia.NOME_COMPLETO and upper(IA.NOME_COMPLETO) like upper(?)  group by p.id_pesquisador,ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo,ia.QTD_INFLUENCIADAS,c.nome_cidade";
				statement = connection.prepareStatement(sql);
				statement.setString(1, quantidade);
				statement.setString(2,"%"+titulo+"%");
				statement.setString(3, classificacao);
				statement.setString(4,"%"+pesquisador+"%");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					consulta = new ConsultaPublicacao();
					setConsultaPublicacao(resultSet, consulta,callableStatement);
					listaConsulta.add(consulta);
				}
			} catch (SQLException e) {
				throw e;
			} finally{
				connection.close();
			}	
		}
		else{
			if(quantidade=="" && classificacao!=""){
				try {
					String sql ="select ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo, ia.QTD_INFLUENCIADAS,c.nome_cidade from info_autor ia,cidade c, afiliacao a, pesquisador p,pesquisador_afiliacao_possui pap where pap.id_afiliacao = a.id_afiliacao  and upper(ia.titulo) like  upper(?)  and IA.CLASSIFICACAO_QUALIS= ? AND a.id_cidade = c.id_cidade and p.primeiro_nome||' '||p.nome_do_meio||' '||p.ultimo_nome = ia.NOME_COMPLETO and upper(IA.NOME_COMPLETO) like upper(?)  group by p.id_pesquisador,ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo,ia.QTD_INFLUENCIADAS,c.nome_cidade";
					statement = connection.prepareStatement(sql);
					
					statement.setString(1,"%"+titulo+"%");
					statement.setString(2, classificacao);
					statement.setString(3,"%"+pesquisador+"%");
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						consulta = new ConsultaPublicacao();
						setConsultaPublicacao(resultSet, consulta,callableStatement);
						listaConsulta.add(consulta);
					}
				} catch (SQLException e) {
					throw e;
				} finally{
					connection.close();
				}	
			}
			else{
				if(classificacao=="" && quantidade!=""){
					try {
						String sql ="select ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo, ia.QTD_INFLUENCIADAS,c.nome_cidade from info_autor ia,cidade c, afiliacao a, pesquisador p,pesquisador_afiliacao_possui pap where pap.id_afiliacao = a.id_afiliacao and to_char(IA.QTD_INFLUENCIADAS)>= ? and upper(ia.titulo) like  upper(?)   AND a.id_cidade = c.id_cidade and p.primeiro_nome||' '||p.nome_do_meio||' '||p.ultimo_nome = ia.NOME_COMPLETO and upper(IA.NOME_COMPLETO) like upper(?)  group by p.id_pesquisador,ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo,ia.QTD_INFLUENCIADAS,c.nome_cidade";
						statement = connection.prepareStatement(sql);
						statement.setString(1, quantidade);
						statement.setString(2,"%"+titulo+"%");
						statement.setString(3,"%"+pesquisador+"%");
						resultSet = statement.executeQuery();
						while (resultSet.next()) {
							consulta = new ConsultaPublicacao();
							setConsultaPublicacao(resultSet, consulta, callableStatement);
							listaConsulta.add(consulta);
						}
					} catch (SQLException e) {
						throw e;
					} finally{
						connection.close();
					}	
				}
				else{
					try {
						String sql ="select ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo, ia.QTD_INFLUENCIADAS,c.nome_cidade from info_autor ia,cidade c, afiliacao a, pesquisador p,pesquisador_afiliacao_possui pap where pap.id_afiliacao = a.id_afiliacao and upper(ia.titulo) like  upper(?) AND a.id_cidade = c.id_cidade and p.primeiro_nome||' '||p.nome_do_meio||' '||p.ultimo_nome = ia.NOME_COMPLETO and upper(IA.NOME_COMPLETO) like upper(?)  group by p.id_pesquisador,ia.NOME_COMPLETO,ia.QTD_PESQUISADOR,ia.classificacao_qualis, ia.titulo,ia.QTD_INFLUENCIADAS,c.nome_cidade";
						statement = connection.prepareStatement(sql);			
						statement.setString(1,"%"+titulo+"%");
						statement.setString(2,"%"+pesquisador+"%");
						resultSet = statement.executeQuery();
						while (resultSet.next()) {
							consulta = new ConsultaPublicacao();
							setConsultaPublicacao(resultSet, consulta, callableStatement);
							listaConsulta.add(consulta);
						}
					} catch (SQLException e) {
						throw e;
					} finally{
						connection.close();
					}	
				}
			}
		}
		return listaConsulta;
	}
	public Publicacao consultar(String titulo, Integer quantidade, String classificacao, String pesquisador) throws Exception {
		Connection connection=conexaoBancoDeDados.criaConexao();

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Publicacao publicacao= null;
		try {

			statement.setString(1, titulo);
			statement.setInt(2, quantidade);
			statement.setString(3, classificacao);
			statement.setString(4, pesquisador);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				publicacao  = new Publicacao();
				setPublicacao(resultSet,publicacao);
				ListaPublicacao.add(publicacao);
			}
		} catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		
		return publicacao;
	}
		
	
	@Override
	public List<Publicacao> listar() throws Exception {
		return ListaPublicacao;
	}

	@Override
	public void incluir(Publicacao t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Publicacao t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Publicacao t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void setPublicacao(ResultSet resultSet, Publicacao publicacao) throws SQLException{
		publicacao.setIdProdBiblio(resultSet.getInt("idProdBiblio"));
		publicacao.setIdPesquisa(resultSet.getInt("idPesquisa"));
		publicacao.setTitulo(resultSet.getString("titulo"));
		publicacao.setTipo_publicacao(resultSet.getString("tipo_publicacao"));
		publicacao.setPagina_inicial(resultSet.getInt("pagina_inicial"));
		publicacao.setPagina_final(resultSet.getInt("pagina_final"));
		publicacao.setVolume(resultSet.getInt("volume"));
		publicacao.setAno_prod_biblio(resultSet.getInt("ano_prod_biblio"));
	}
	
	public void setConsultaPublicacao(ResultSet resultSet, ConsultaPublicacao consulta,
			CallableStatement callableStatement) throws SQLException{
		consulta.setTitulo(resultSet.getString("titulo"));
		consulta.setInfluencia(resultSet.getInt("qtd_influenciadas"));
		consulta.setClassificacao(resultSet.getString("classificacao_qualis"));
		consulta.setQtd_pesquisadores(resultSet.getInt("qtd_pesquisador"));
		consulta.setNome_pesquisador(resultSet.getString("nome_completo"));
		consulta.setCidade(resultSet.getString("nome_cidade"));
		callableStatement.setInt(1, consulta.getQtd_pesquisadores());
		callableStatement.setString(2, consulta.getTitulo());
		callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
		callableStatement.execute();
	}
}
