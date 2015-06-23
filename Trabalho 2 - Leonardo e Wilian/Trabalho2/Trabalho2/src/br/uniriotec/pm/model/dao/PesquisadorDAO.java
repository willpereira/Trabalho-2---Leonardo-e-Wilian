package br.uniriotec.pm.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uniriotec.pm.model.entidade.Pesquisador;


/**
 * Classe que simula (mock) a classe PesquisadorDAO manipulando o pesquisador em memória.
 * Está classe poderá ser substituída sem causar grandes impactos na implementação da aplicação.
 * Basta alterar a chamada ao DAO nas classes servlet.
 *
 */

public class PesquisadorDAO extends BaseDAO<Pesquisador> implements IPesquisadorDAO {
	private static PesquisadorDAO instancia;
	private static List<Pesquisador> ListaPesquisador = null;
	private IConexaoBancoDeDados conexaoBancoDeDados= new ConexaoBancoDeDadosFactory().getConexao();

	//private IConexaoBancoDeDados conexaoBancoDeDados;

	
	
	public static PesquisadorDAO getInstance() {
		if (instancia == null) {
			instancia = new PesquisadorDAO();
			ListaPesquisador = new ArrayList<Pesquisador>();
		}
		return instancia;
	}
	
//	@Inject
//	public void setConexaoBancoDeDados(IConexaoBancoDeDados conexaoBancoDeDados){
//		this.conexaoBancoDeDados = conexaoBancoDeDados;
//	}
//	

	
	public List<Pesquisador> retornaPesquisador() throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		String sql = "select * from pesquisador";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Pesquisador pesquisador= null;
		List<Pesquisador> listaPesquisador = new ArrayList<Pesquisador>();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				pesquisador = new Pesquisador();
				setPesquisador(resultSet,pesquisador);
				listaPesquisador.add(pesquisador);
			}
		} catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		return listaPesquisador;
	}

	public void incluir(Pesquisador pesquisador) throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		
		String sql = "insert into pesquisador(id_pesquisador,primeiro_nome,nome_do_meio,ultimo_nome,numero_end_pesq,logradouro_pesq,tipo_logradouro_pesq,complemento_pesq)  values (seq_pesquisador.nextval,?,?,?,?,?,?,?)"; 
		
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, pesquisador.getPrimeiro_nome());
			statement.setString(2, pesquisador.getNome_do_meio());
			statement.setString(3, pesquisador.getUltimo_nome());
			statement.setInt(4, pesquisador.getNumeroPesquisador());
			statement.setString(5, pesquisador.getLogradouroPesquisador());
			statement.setString(6, pesquisador.getTipo_logradouroPesquisador());
			statement.setString(7, pesquisador.getComplementoPesquisador());
		
			statement.executeUpdate();
		
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				throw e;
		}finally{
			connection.close();
		}
	}
	
	public void incluirCidadePesq(Integer idCidade,Integer idPesquisador) throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		String sql = "insert into pesquisador_cidade_reside values( ? , ? )"; 
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idCidade);
			statement.setInt(2, idPesquisador);		
			statement.executeUpdate();
		
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				throw e;
		}finally{
			connection.close();
		}
	}
	public void incluirAfiliacaoPesq(Integer idAfiliacao,Integer idPesquisador) throws Exception {
			Connection connection = conexaoBancoDeDados.criaConexao();
			String sql = "insert into pesquisador_afiliacao_possui values( ? , ? )"; 
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, idAfiliacao);
				statement.setInt(2, idPesquisador);		
				statement.executeUpdate();
			
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				throw e;
			}finally{
				connection.close();
			}
			
 	}

	public Pesquisador consultar(Long id) throws Exception {
		return ListaPesquisador.get(id.intValue());
	}
	
	public Pesquisador consultar(String primeiro_nome, String nome_do_meio,String ultimo_nome) throws Exception {
		Connection connection=conexaoBancoDeDados.criaConexao();
	
		String sql = "select * from pesquisador p where UPPER(p.primeiro_nome)= UPPER( ? ) and UPPER(p.nome_do_meio)=UPPER( ? ) and UPPER(p.ultimo_nome)=UPPER( ? )";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Pesquisador pesquisador= null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, primeiro_nome);
			statement.setString(2, nome_do_meio);
			statement.setString(3, ultimo_nome);
			resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			pesquisador = new Pesquisador();
			setPesquisador(resultSet,pesquisador);
		}
		} catch (SQLException e) {
			throw e;
		} finally{
			connection.close();
		}
		
		return pesquisador;
	}
		
	public void alterar(Pesquisador pesquisador) throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
        
        String sql = "update pesquisador set primeiro_nome = ?, nome_do_meio = ?, ultimo_nome = ?, numero_end_pesq = ?, logradouro_pesq = ?, tipo_logradouro_pesq = ?, complemento_pesq = ? where id_pesquisador = ?";
        PreparedStatement statement = null;
         
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, pesquisador.getPrimeiro_nome());
            statement.setString(2, pesquisador.getNome_do_meio());
            statement.setString(3, pesquisador.getUltimo_nome());
            statement.setInt(4, pesquisador.getNumeroPesquisador());
            statement.setString(5, pesquisador.getLogradouroPesquisador());
            statement.setString(6, pesquisador.getTipo_logradouroPesquisador());
            statement.setString(7, pesquisador.getComplementoPesquisador());
            statement.setInt(8, pesquisador.getCodPesquisador());
             
            statement.executeUpdate();
            connection.commit();
             
        } catch (SQLException e) {
            connection.rollback();
             
            throw e;
        }
        finally{
            connection.close();
        }
	}


	
	public void excluir(Integer id) throws Exception {
		Connection connection = conexaoBancoDeDados.criaConexao();
		String sql="DELETE FROM PESQUISADOR_CIDADE_RESIDE WHERE ID_PESQUISADOR= ?";
        String sql1="delete from pesquisador_afiliacao_possui where id_pesquisador= ? ";
		String sql2 = "delete from PESQUISADOR where ID_PESQUISADOR = ?";
        
        PreparedStatement statementPesquisadorCidadeReside = null;
        PreparedStatement statementPesquisadorAfiliacao = null;
        PreparedStatement statementPesquisador=null;
         
        try {
        	
            statementPesquisadorCidadeReside = connection.prepareStatement(sql);
            statementPesquisadorCidadeReside.setInt(1, id);
            statementPesquisadorCidadeReside.executeUpdate();
            connection.commit();
            
            statementPesquisador=connection.prepareStatement(sql1);
            statementPesquisador.setInt(1, id);
            statementPesquisador.executeUpdate();
            connection.commit();
            
            statementPesquisadorAfiliacao=connection.prepareStatement(sql2);
            statementPesquisadorAfiliacao.setInt(1, id);
            statementPesquisadorAfiliacao.executeUpdate();
            connection.commit();
            
            
            
        } catch (SQLException e) {
            connection.rollback();
             
            throw e;
        }
        finally{
            try {
                statementPesquisadorCidadeReside.close();
                statementPesquisador.close();
                statementPesquisadorAfiliacao.close();
                connection.close();
                
                } catch (SQLException e) {
                throw e;
                }
        }
	}

	@Override
	public List<Pesquisador> listar() throws Exception {
		return ListaPesquisador;
	}

	@Override
	public void excluir(Pesquisador t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void setPesquisador(ResultSet resultSet, Pesquisador pesquisador) throws SQLException{
		pesquisador.setCodPesquisador(resultSet.getInt("id_pesquisador"));
		pesquisador.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
		pesquisador.setNome_do_meio(resultSet.getString("nome_do_meio"));
		pesquisador.setUltimo_nome(resultSet.getString("ultimo_nome"));
		pesquisador.setLogradouroPesquisador(resultSet.getString("logradouro_pesq"));
		pesquisador.setTipo_logradouroPesquisador(resultSet.getString("tipo_logradouro_pesq"));
		pesquisador.setNumeroPesquisador(resultSet.getInt("numero_end_pesq"));
		pesquisador.setComplementoPesquisador(resultSet.getString("complemento_pesq"));
	}

}
