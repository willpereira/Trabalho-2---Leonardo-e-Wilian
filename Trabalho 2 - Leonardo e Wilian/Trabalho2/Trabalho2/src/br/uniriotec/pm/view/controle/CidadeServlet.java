package br.uniriotec.pm.view.controle;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniriotec.pm.model.dao.CidadeDAO;
import br.uniriotec.pm.model.dao.ICidadeDAO;
import br.uniriotec.pm.model.entidade.Cidade;


/**
 * Servlet para tratamento de requisições relacionadas com objetos do tipo {@linkplain Cidade}.
 */


public class CidadeServlet extends BaseServlet{
	
		private static final long serialVersionUID = 4L;
		
		private ICidadeDAO cidadeDAO;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public CidadeServlet() {
			super();
		}
		
//		@Inject
//		public void setCidadeDAO(ICidadeDAO cidadeDAO){
//			this.cidadeDAO = cidadeDAO;
//		}

		protected void incluir(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			String mensagem = null;
			try {
				Integer idCidade=Integer.valueOf(request.getParameter("idCidade"));
				String nome_cidade = (String) request.getParameter("nome_cidade");
				String nome_estado = (String) request.getParameter("nome_estado");
				Integer idEstado=Integer.valueOf(request.getParameter("idEstado"));
				String nome_pais=(String) request.getParameter("nome_pais");
				Integer idPais=Integer.valueOf(request.getParameter("idPais"));
				
				
				Cidade cidade = new Cidade();
				
				cidade.setNome_cidade(nome_cidade);
				cidade.setNome_estado(nome_estado);
				cidade.setNome_pais(nome_pais);
				cidade.setIdCidade(idCidade);
				cidade.setIdEstado(idEstado);
				cidade.setIdPais(idPais);
				
				
				CidadeDAO.getInstance().incluir(cidade);
				request.setAttribute("cidades",cidade);
				
				
			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Incluir Cidade&mensagem=Erro na inclusão da cidade! Detalhe: " + e.getMessage());
			}
		}

		/**
		 * Método executado antes de apresentar a tela de inclusão do cliente.
		 * Recupera a lista de cidades utilizada na inclusão.
		 * 
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void antesIncluir(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			try {
				
				RequestDispatcher rd = request.getRequestDispatcher("InserirCidade.jsp");
				rd.forward(request, response);
				

			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Inserir Cidade&mensagem=Erro na inclusão da cidade! Detalhe: " + e.getMessage());
			}

		}
		
		protected void listar(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			try {
				List<Cidade> listaCidades = CidadeDAO.getInstance().retornaCidades();
				request.setAttribute("cidades",listaCidades );

			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Lista de Cidades&mensagem=Erro na listagem das cidades! Detalhe: " + e.getMessage());
			}
		}
		
		
		protected void antesAlterar(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				RequestDispatcher requestDispatcher = null;
				String nome_cidade = request.getParameter("nome_cidade");
				String comando = request.getParameter("comando");
				
				if (nome_cidade != null) {
					
					Cidade cidade = CidadeDAO.getInstance().consultar(nome_cidade);
					request.setAttribute("cidade", cidade);
					
					requestDispatcher = request.getRequestDispatcher("cidadeAlterar.jsp");
					
				}else {
					request.setAttribute("comando", comando);
					requestDispatcher = request.getRequestDispatcher("BuscarCidade.jsp");
				}
				
				requestDispatcher.forward(request, response);
				
			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Alterar Cidade&mensagem=Erro na alteração da cidade! Detalhe: " + e.getMessage());
			}
			
		}
		
		protected void antesExcluir(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			try {
				RequestDispatcher rd = null;
				String nome_cidade = request.getParameter("nome_cidade");
				String comando = request.getParameter("comando");
				
				if (nome_cidade != null) {
					
					Cidade cidade = CidadeDAO.getInstance().consultar(nome_cidade);
					request.setAttribute("cidade", cidade);
					
					rd = request.getRequestDispatcher("cidadeExcluir.jsp");
					
				} else {
					request.setAttribute("comando", comando);
					rd = request.getRequestDispatcher("BuscarCidade.jsp");
				}
				
				rd.forward(request, response);
				
			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Excluir cidade&mensagem=Erro na exclusão da cidade! Detalhe: " + e.getMessage());
			}
		}

		protected void alterar(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				RequestDispatcher rd = null;
				
				Cidade cidade = new Cidade();

				cidade.setNome_cidade(request.getParameter("nome_cidade"));
	
			
				CidadeDAO.getInstance().alterar(cidade);
				request.setAttribute("cidade", cidade);
				
				String mensagem = "Cidade alterada com sucesso!";
				request.setAttribute("mensagem", mensagem);
				
				rd = request.getRequestDispatcher("cidadeAlterar.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Alterar Cidade&mensagem=Erro na alteração da cidade! Detalhe: " + e.getMessage());
			}
			
		}

		protected void excluir(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				RequestDispatcher rd = null;
				
				Cidade cliente = new Cidade();
				
				CidadeDAO.getInstance().excluir(cliente);
				
				String mensagem = "Cidade excluída com sucesso!";
				request.setAttribute("mensagem", mensagem);
				
				rd = request.getRequestDispatcher("cidade.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Excluir Cidade&mensagem=Erro na exclusão da cidade! Detalhe: " + e.getMessage());
			}
			
			
		}

		protected void consultar(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				RequestDispatcher rd = null;
				String comando= request.getParameter("comando");
				String nome_cidade = request.getParameter("nome_cidade");
				
				
				if ( nome_cidade != null) {
					
					Cidade cidade = CidadeDAO.getInstance().consultar(nome_cidade);
					request.getSession().setAttribute("cidade", cidade);
					
					rd = request.getRequestDispatcher("cidadeExibir.jsp");
					
				} else {
					request.setAttribute("comando", comando);
					rd = request.getRequestDispatcher("BuscarCidade.jsp");
				}
				
				rd.forward(request, response);
				
			} catch (Exception e) {
				response.sendRedirect("cidadeErroGeral.jsp?tituloPagina=Consultar Cidade&mensagem=Erro na consulta da cidade! Detalhe: " + e.getMessage());
			}
		}
}
