<%@include file="../../_header.jsp" %>

<h1 id="title">Publicacoes</h1>

<p id="text">
	&nbsp;&nbsp;Neste m�dulo � poss�vel visualizar 
	relat�rios de produ��es bibliogr�ficas. Est�
	dispon�vel a op��o: Relat�rio.
</p>

	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>


<a href="PublicacaoServlet?comando=antesRelatar" class="option">Relat�rio</a><br />


<%@include file="../../_footer.jsp" %> 