package br.uniriotec.pm.view.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniriotec.pm.model.dao.AfiliacaoDAO;
import br.uniriotec.pm.model.dao.CidadeDAO;
import br.uniriotec.pm.model.dao.EstadoDAO;
import br.uniriotec.pm.model.dao.IAfiliacaoDAO;
import br.uniriotec.pm.model.dao.ICidadeDAO;
import br.uniriotec.pm.model.dao.IEstadoDAO;
import br.uniriotec.pm.model.dao.IPaisDAO;
import br.uniriotec.pm.model.dao.IPesquisadorDAO;
import br.uniriotec.pm.model.dao.PaisDAO;
import br.uniriotec.pm.model.dao.PesquisadorDAO;
import br.uniriotec.pm.model.entidade.Afiliacao;
import br.uniriotec.pm.model.entidade.Cidade;
import br.uniriotec.pm.model.entidade.Estado;
import br.uniriotec.pm.model.entidade.Pais;
import br.uniriotec.pm.model.entidade.Pesquisador;


/**
 * Servlet para tratamento de requisições relacionadas com objetos do tipo {@linkplain Pesquisador}.
 */
public class PesquisadorServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private IAfiliacaoDAO afiliacaoDAO;
	private ICidadeDAO cidadeDAO;
	private IEstadoDAO estadoDAO;
	private IPaisDAO paisDAO;
	private IPesquisadorDAO pesquisadorDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PesquisadorServlet() {
		super();
	}
	
//	@Inject
//	public void setAfiliacaoDAO(IAfiliacaoDAO afiliacaoDAO){
//		this.afiliacaoDAO = afiliacaoDAO;
//	}
//	
//	@Inject
//	public void setCidadeDAO(ICidadeDAO cidadeDAO){
//		this.cidadeDAO = cidadeDAO;
//	}
//	
//	@Inject
//	public void setEstadoDAO(IEstadoDAO estadoDAO){
//		this.estadoDAO = estadoDAO;
//	}
//	
//	@Inject
//	public void setPaisDAO(IPaisDAO paisDAO){
//		this.paisDAO = paisDAO;
//	}
//	
//	@Inject
//	public void setPesquisadorDAO(IPesquisadorDAO pesquisadorDAO){
//		this.pesquisadorDAO = pesquisadorDAO;
//	}

	protected void incluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String mensagem = null;
		try {
			RequestDispatcher requestDispatcher = null;
			String primeiro_nome = (String) request.getParameter("primeiro_nome");
			String nome_do_meio = (String) request.getParameter("nome_do_meio");
			String ultimo_nome=(String) request.getParameter("ultimo_nome");			
			String logradouro=(String) request.getParameter("Logradouro");
			String tipo_logradouro=(String) request.getParameter("Tipo_de_Logradouro");
			Integer numero=Integer.valueOf(request.getParameter("Numero"));
			String complemento=(String) request.getParameter("Complemento");			
			String cidade=(String) request.getParameter("Cidade");
			String estado=(String) request.getParameter("Estado");
			String pais=(String) request.getParameter("Pais");
			String afiliacao=(String) request.getParameter("Afiliacao");
			
			Pesquisador pesquisador = new Pesquisador();
			pesquisador.setPrimeiro_nome(primeiro_nome);
			pesquisador.setNome_do_meio(nome_do_meio);
			pesquisador.setUltimo_nome(ultimo_nome);			
			pesquisador.setComplementoPesquisador(complemento);
			pesquisador.setLogradouroPesquisador(logradouro);
			pesquisador.setNumeroPesquisador(numero);
			pesquisador.setTipo_logradouroPesquisador(tipo_logradouro);	
			
			PesquisadorDAO.getInstance().incluir(pesquisador);
			
			Pesquisador pesq=new Pesquisador();
			
			Cidade cid=new Cidade();
			Integer idCidade=null;
			
			Afiliacao af=new Afiliacao();
			af = AfiliacaoDAO.getInstance().consultar(afiliacao);
			
			Integer idAfiliacao=af.getIdAfiliacao();
			pesq = PesquisadorDAO.getInstance().consultar(pesquisador.getPrimeiro_nome(), pesquisador.getNome_do_meio(), pesquisador.getUltimo_nome());
			Integer idPesquisador = pesq.getCodPesquisador();
			
			idCidade = CidadeDAO.getInstance().consultarIDCidade(cidade, estado, pais);
			
			PesquisadorDAO.getInstance().incluirCidadePesq(idCidade, idPesquisador);
			PesquisadorDAO.getInstance().incluirAfiliacaoPesq(idAfiliacao,idPesquisador);
			
			cid.setNome_cidade(cidade);
			cid.setNome_estado(estado);
			cid.setNome_pais(pais);
			
			List<Afiliacao> afiliacoes=new ArrayList<Afiliacao>();
			afiliacoes.add(af);
			
			request.setAttribute("pesquisador", pesquisador);
			request.setAttribute("cidade", cid);
			request.setAttribute("afiliacoes", afiliacoes);
			
			mensagem = "Pesquisador incluído com Sucesso!";
			request.setAttribute("mensagem", mensagem);
			
			requestDispatcher = request.getRequestDispatcher("pesquisadorExibir.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Incluir Pesquisador&mensagem=Erro na inclusão do pesquisador! Detalhe: " + e.getMessage());
		}
	}


	/**
	 * Método executado antes de apresentar a tela de inclusão do Pesquisador.
	 * Recupera a lista de cidades, estados,países e afiliações utilizadas na inclusão.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void antesIncluir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			List<Cidade> listaCidades = CidadeDAO.getInstance().retornaCidades(); 
			List<Estado> listaEstados= EstadoDAO.getInstance().retornaEstados();
			List<Pais> listaPaises=PaisDAO.getInstance().retornaPaises();
			List<Afiliacao> listaAfiliacoes= AfiliacaoDAO.getInstance().retornaAfiliacoesGeral();
			
			request.getSession().setAttribute("afiliacoes", listaAfiliacoes);
			request.getSession().setAttribute("cidades", listaCidades);
			request.getSession().setAttribute("estados", listaEstados);
			request.getSession().setAttribute("paises", listaPaises);
			RequestDispatcher rd = request.getRequestDispatcher("InserirPesquisador.jsp");
			rd.forward(request, response);
			

		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Inserir Pesquisador&mensagem=Erro na inclusão do pesquisador! Detalhe: " + e.getMessage());
		}

	}
	protected void listar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Pesquisador> listaPesquisadores = PesquisadorDAO.getInstance().retornaPesquisador();
			request.setAttribute("listaPesquisadores", listaPesquisadores);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarPesquisadores.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Lista de Pesquisadores&mensagem=Erro na listagem de pesquisadores! Detalhe: " + e.getMessage());
		}
	}
		

	/**
	 * Método que recupera uma cidade da sessão através do seu id.
	 * 
	 * @param request
	 *            - contém o lista de cidades na sessão
	 * @param codCidade
	 *            - código da cidade que será localizada
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	private Cidade recuperaCidade(HttpServletRequest request, Integer idCidade) {
		List<Cidade> listaCidades = (List<Cidade>) request.getSession()
				.getAttribute("cidades");
		for (Cidade cidade : listaCidades) {
			if (cidade.getIdCidade().equals(idCidade))
				return cidade;
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	private Afiliacao recuperaAfiliacao(HttpServletRequest request, Integer codAfiliacao) {
		List<Afiliacao> listaAfiliacoes = (List<Afiliacao>) request.getSession().getAttribute("listaAfiliacoes");
		for (Afiliacao afiliacao : listaAfiliacoes) {
			if (afiliacao.getIdAfiliacao().equals(codAfiliacao))
				return afiliacao;
		}

		return null;
	}
	
	/**
	 * Os métodos com prefixo antes foram utilizados para reutilizar uma única página de consulta para as funcionalidades:
	 * Consultar Pesquisador, Alterar Pesquisador e Excluir Pesquisador.
	 * 
	 * Prepara as informações necessárias para a alteração: Consulta o pesquisador que será alterado.
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void antesAlterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher requestDispatcher = null;
			String nome = request.getParameter("primeiro_nome");
			String sobrenome=request.getParameter("nome_do_meio");
			String ultimo_nome=request.getParameter("ultimo_nome");
			String comando = request.getParameter("comando");
			
			if ((nome != null && nome != "") && (sobrenome != null && sobrenome != "") && (ultimo_nome != null && ultimo_nome != null)) {
				
				Pesquisador pesquisador = PesquisadorDAO.getInstance().consultar(nome,sobrenome,ultimo_nome);
				request.setAttribute("pesquisador", pesquisador);
				
				requestDispatcher = request.getRequestDispatcher("pesquisadorAlterar.jsp");
				
			}else {
				request.setAttribute("comando", comando);
				requestDispatcher = request.getRequestDispatcher("BuscarPesquisadorAlterar.jsp");
			}
			
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Alterar Pesquisador&mensagem=Erro na alteração do pesquisador! Detalhe: " + e.getMessage());
		}
		
	}
	
	/**
	 * Os métodos com prefixo antes foram utilizados para reutilizar uma única página de consulta para as funcionalidades
	 * Consultar Pesquisador, Alterar Pesquisador e Excluir Pesquisador.
	 * 
	 * Prepara as informações necessárias para exclusão do pesquisador: Consulta o Pesquisador.
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void antesExcluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		try {
			RequestDispatcher requestDispatcher = null;
			String nome = request.getParameter("primeiro_nome");
			String sobrenome=request.getParameter("nome_do_meio");
			String ultimo_nome=request.getParameter("ultimo_nome");
			String comando = request.getParameter("comando");
			
			if ((nome != null && nome != "") && (sobrenome != null && sobrenome != "") && (ultimo_nome != null && ultimo_nome != null)) {
				
				Pesquisador pesquisador = PesquisadorDAO.getInstance().consultar(nome,sobrenome,ultimo_nome);
				request.setAttribute("pesquisador", pesquisador);
				
				requestDispatcher = request.getRequestDispatcher("pesquisadorExcluir.jsp");
				
			} else {
				request.setAttribute("comando", comando);
				requestDispatcher = request.getRequestDispatcher("BuscarPesquisadorExcluir.jsp");
			}
			
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Excluir pesquisador&mensagem=Erro na exclusão do pesquisador! Detalhe: " + e.getMessage());
		}
	}

	protected void alterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
            RequestDispatcher requestDispatcher = null;
            
            String id = request.getParameter("id");
             
            Pesquisador pesquisador = new Pesquisador();
            
            pesquisador.setCodPesquisador(Integer.valueOf(id));  
            setPesquisadorAlterar(pesquisador,request);
             
            PesquisadorDAO.getInstance().alterar(pesquisador);
            request.setAttribute("pesquisador", pesquisador);
             
            String mensagem = "Pesquisador alterado com sucesso!";
            request.setAttribute("mensagem", mensagem);
             
            requestDispatcher = request.getRequestDispatcher("pesquisadorAlterar.jsp");
            requestDispatcher.forward(request, response);
             
        } catch (Exception e) {
            response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Alterar Pesquisador&mensagem=Erro na alteração do pesquisador! Detalhe: " + e.getMessage());
        }
		
	}

	public void setPesquisadorAlterar(Pesquisador pesquisador,HttpServletRequest request){  
		
         pesquisador.setPrimeiro_nome(request.getParameter("primeiro_nome"));
         pesquisador.setNome_do_meio(request.getParameter("nome_do_meio"));
         pesquisador.setUltimo_nome(request.getParameter("ultimo_nome"));
         pesquisador.setNumeroPesquisador(Integer.valueOf(request.getParameter("Numero")));
         pesquisador.setLogradouroPesquisador(request.getParameter("Logradouro"));
         pesquisador.setTipo_logradouroPesquisador(request.getParameter("Tipo de Logradouro"));
         pesquisador.setComplementoPesquisador(request.getParameter("Complemento"));
         
	}
	
	protected void excluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher requestDispatcher = null;
			Integer id = Integer.valueOf(request.getParameter("id"));			
			PesquisadorDAO.getInstance().excluir(id);
			
			String mensagem = "Pesquisador excluído com sucesso!";
			request.setAttribute("mensagem", mensagem);
			
			requestDispatcher = request.getRequestDispatcher("pesquisador.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Excluir Pesquisador&mensagem=Erro na exclusão do pesquisador! Detalhe: " + e.getMessage());
		}
		
		
	}
	
	protected void consultarAlterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher requestDispatcher = null;
			requestDispatcher = request.getRequestDispatcher("BuscarPesquisadorAlterar.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {

			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Consultar Pesquisador&mensagem=Erro na consulta de pesquisador! Detalhe:" + e.getMessage());
		}
	}
	protected void consultarExcluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher requestDispatcher = null;
			requestDispatcher = request.getRequestDispatcher("BuscarPesquisadorExcluir.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Consultar Pesquisador&mensagem=Erro na consulta de pesquisador! Detalhe: " + e.getMessage());
		}
	}

	protected void consultar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher requestDispatcher = null;
			String comando= request.getParameter("comando");
			String nome = request.getParameter("primeiro_nome");
			String sobrenome=request.getParameter("nome_do_meio");
			String ultimo_nome=request.getParameter("ultimo_nome");
			
			if ((nome != null && nome != "") && (sobrenome != null && sobrenome != "") && (ultimo_nome != null && ultimo_nome != null)) {
				
				Pesquisador pesquisador = new Pesquisador();
				pesquisador = PesquisadorDAO.getInstance().consultar(nome,sobrenome,ultimo_nome);
		        
				
				request.getSession().setAttribute("pesquisador", pesquisador);
				
				requestDispatcher = request.getRequestDispatcher("pesquisadorExibir.jsp");
				
			} else {
				request.setAttribute("comando", comando);
				requestDispatcher = request.getRequestDispatcher("BuscarPesquisador.jsp");
			}
			
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("pesquisadorErroGeral.jsp?tituloPagina=Consultar Pesquisador&mensagem=Erro na consulta de pesquisador! Detalhe: " + e.getMessage());
		}
	}
	
	
}
