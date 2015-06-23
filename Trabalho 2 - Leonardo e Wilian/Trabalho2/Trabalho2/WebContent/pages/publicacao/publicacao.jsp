<%@include file="../../_header.jsp" %>

<h1 id="title">Publicacoes</h1>

<p id="text">
	&nbsp;&nbsp;Neste módulo é possível visualizar 
	relatórios de produções bibliográficas. Está
	disponível a opção: Relatório.
</p>

	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>


<a href="PublicacaoServlet?comando=antesRelatar" class="option">Relatório</a><br />


<%@include file="../../_footer.jsp" %> 