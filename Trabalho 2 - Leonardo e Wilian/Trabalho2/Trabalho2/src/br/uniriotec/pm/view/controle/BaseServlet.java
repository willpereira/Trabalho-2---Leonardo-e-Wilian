package br.uniriotec.pm.view.controle;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe respons�vel por processar as requisi��es da aplica��o.
 * Serve como "template" para os servlets da aplica��o. 
 * <p>
 * 
 * A definicao de uma classe gen�rica para os Servelts permite a restri��o de 
 * quais processamentos podem ocorrer como resposta a uma requisi��o feita 
 * pelo cliente (Browser).  
 * 
 * <p>
 * 
 * Esta classe extende a classe {@linkplain HttpServlet}, que define 
 * m�todos para tratamento de requisi��es feitas pelo cliente (Browser) atrav�s de m�todos 
 * GET (envia par�metros na pr�rpia URL) ou 
 * POST (envia par�metros atrav�s do corpo da mensagem HTTP)
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
	 * Trata uma requisi��o do tipo "GET" feita pelo cliente (Browser)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		invocarMetodo(req, resp);
	}
	
	/***
	 * Trata uma requisi��o do tipo "POST" feita pelo cliente (Browser)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		invocarMetodo(request, response);
	}

	/**
	 * Executa um m�todo na inst�ncia do servlet. Por exemplo: m�todo incluir em
	 * ClienteServlet. A var��vel comando deve conter o nome do m�todo que ser�
	 * executado na inst�ncia, P.e: incluir
	 * 
	 * @param request requisicao feita pelo cliente (Browser)
	 * @param response resposta que ser� enviada pelo servidor (Servlet) para o cliente (Browser)
	 */
	private void invocarMetodo(HttpServletRequest request,
			HttpServletResponse response) {
		String comando = request.getParameter("comando");
		System.out.println(
				String.format("Invocando o m�todo '%s' do '%s'...", comando, this.getClass().getSimpleName()));

		try {
			// array que cont�m os par�metros do m�todo a ser invocado
			Class<?> partypes[] = new Class[2];
			partypes[0] = HttpServletRequest.class;
			partypes[1] = HttpServletResponse.class;

			// A inst�ncia do servlet, p. ex. ClienteServlet
			Class<?> cls = this.getClass();
			
			// Obtem o m�todo (representado por 'comando') a ser invocado 
			Method meth = cls.getDeclaredMethod(comando, partypes);

			// par�metros que foram recebidos pelo BaseServlet (requisi��o)
			Object arglist[] = new Object[2];
			arglist[0] = request;
			arglist[1] = response;

			// invoca o m�todo, p. ex. incluir na classe ClienteServlet
			meth.invoke(this, arglist);
		} catch (Exception e) {
			System.out.println(
					"[BaseServlet.invocarMetodo] Houve um problema ao tentar invocar o m�todo "
					+ comando);
			e.printStackTrace();
		}
	}
}
