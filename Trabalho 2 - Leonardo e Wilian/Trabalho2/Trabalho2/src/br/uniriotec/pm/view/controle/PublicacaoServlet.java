package br.uniriotec.pm.view.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniriotec.pm.model.dao.IPublicacaoDAO;
import br.uniriotec.pm.model.dao.PublicacaoDAO;
import br.uniriotec.pm.model.entidade.ConsultaPublicacao;
import br.uniriotec.pm.model.entidade.Publicacao;


/**
 * Servlet para tratamento de requisições relacionadas com objetos do tipo {@linkplain Publicacao}.
 */

public class PublicacaoServlet extends BaseServlet{
	private static final long serialVersionUID = 7L;
	private IPublicacaoDAO publicacaoDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublicacaoServlet() {
		super();
	}

//	@Inject
//	public void setPublicacaoDAO(IPublicacaoDAO publicacaoDAO){
//		this.publicacaoDAO = publicacaoDAO;
//	}

	
	protected void listar(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Publicacao> listaPublicacoes = PublicacaoDAO.getInstance().retornaPublicacao();
			request.setAttribute("listaPublicacoes", listaPublicacoes);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarPublicacoes.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("publicacaoErroGeral.jsp?tituloPagina=Lista de Publicacoes&mensagem=Erro na listagem de publicacoes! Detalhe: " + e.getMessage());
		}
	}


	@Override
	protected void incluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void alterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void excluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
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
	
	protected void antesRelatar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<Publicacao> classificacaoQualis = PublicacaoDAO.getInstance().listaClassificacaoQualis(); 
			
			request.getSession().setAttribute("listaclassificacaoQualis", classificacaoQualis);
			RequestDispatcher rd = request.getRequestDispatcher("BuscarPublicacao.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			response.sendRedirect("publicacaoErroGeral.jsp?tituloPagina=Consultar Publicacao&mensagem=Erro na consulta de publicacao! Detalhe: " + e.getMessage());
		
		}
	}


	protected void consultar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher rd = null;
			String comando= request.getParameter("comando");
			
			String titulo=request.getParameter("titulo");
			String influencia=request.getParameter("influencia");
		
			String evento=request.getParameter("Evento");
			
			String	pesquisador=request.getParameter("pesquisador");
					
				List<ConsultaPublicacao> publicacao = new ArrayList<ConsultaPublicacao>();
				publicacao = PublicacaoDAO.getInstance().relatorio(titulo, influencia, evento, pesquisador);
				
				request.getSession().setAttribute("relatorio", publicacao);
				rd = request.getRequestDispatcher("ListarPublicacao.jsp");
				
	
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("publicacaoErroGeral.jsp?tituloPagina=Consultar Publicacao&mensagem=Erro na consulta de publicacao! Detalhe: " + e.getMessage());
		}
	}

}
