<%@include file="../../_header.jsp" %>

<h1 id="title">Pesquisadores</h1>

<p id="text">
	&nbsp;&nbsp;Neste módulo é possível administrar os dados
	dos pesquisadores. Estão disponíveis as opções: incluir,
	excluir, alterar, consultar e listar.
</p>

	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>


<a href="PesquisadorServlet?comando=antesIncluir" class="option">Inserir</a><br />
<a href="PesquisadorServlet?comando=consultarAlterar" class="option">Alterar</a><br />
<a href="PesquisadorServlet?comando=consultarExcluir" class="option">Excluir</a><br />
<a href="PesquisadorServlet?comando=consultar" class="option">Consultar</a><br />
<a href="PesquisadorServlet?comando=listar" class="option">Listar Todos</a><br />

<%@include file="../../_footer.jsp" %> 