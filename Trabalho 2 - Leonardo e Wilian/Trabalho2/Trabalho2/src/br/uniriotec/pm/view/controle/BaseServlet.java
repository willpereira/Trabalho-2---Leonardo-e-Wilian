package br.uniriotec.pm.view.controle;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe responsável por processar as requisições da aplicação.
 * Serve como "template" para os servlets da aplicação. 
 * <p>
 * 
 * A definicao de uma classe genérica para os Servelts permite a restrição de 
 * quais processamentos podem ocorrer como resposta a uma requisição feita 
 * pelo cliente (Browser).  
 * 
 * <p>
 * 
 * Esta classe extende a classe {@linkplain HttpServlet}, que define 
 * métodos para tratamento de requisições feitas pelo cliente (Browser) através de métodos 
 * GET (envia parâmetros na prórpia URL) ou 
 * POST (envia parâmetros através do corpo da mensagem HTTP)
 * 
 */

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected abstract void incluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	protected abstract void alterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	protected abstract void excluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	protected abstract void listar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	protected abstract void consultar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	/***
	 * Trata uma requisição do tipo "GET" feita pelo cliente (Browser)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		invocarMetodo(req, resp);
	}
	
	/***
	 * Trata uma requisição do tipo "POST" feita pelo cliente (Browser)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		invocarMetodo(request, response);
	}

	/**
	 * Executa um método na instância do servlet. Por exemplo: método incluir em
	 * ClienteServlet. A varíável comando deve conter o nome do método que será
	 * executado na instância, P.e: incluir
	 * 
	 * @param request requisicao feita pelo cliente (Browser)
	 * @param response resposta que será enviada pelo servidor (Servlet) para o cliente (Browser)
	 */
	private void invocarMetodo(HttpServletRequest request,
			HttpServletResponse response) {
		String comando = request.getParameter("comando");
		System.out.println(
				String.format("Invocando o método '%s' do '%s'...", comando, this.getClass().getSimpleName()));

		try {
			// array que contém os parâmetros do método a ser invocado
			Class<?> partypes[] = new Class[2];
			partypes[0] = HttpServletRequest.class;
			partypes[1] = HttpServletResponse.class;

			// A instância do servlet, p. ex. ClienteServlet
			Class<?> cls = this.getClass();
			
			// Obtem o método (representado por 'comando') a ser invocado 
			Method meth = cls.getDeclaredMethod(comando, partypes);

			// parâmetros que foram recebidos pelo BaseServlet (requisição)
			Object arglist[] = new Object[2];
			arglist[0] = request;
			arglist[1] = response;

			// invoca o método, p. ex. incluir na classe ClienteServlet
			meth.invoke(this, arglist);
		} catch (Exception e) {
			System.out.println(
					"[BaseServlet.invocarMetodo] Houve um problema ao tentar invocar o método "
					+ comando);
			e.printStackTrace();
		}
	}
}
