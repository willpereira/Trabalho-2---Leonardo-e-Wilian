

<%@include file="../../_header.jsp"%>

<div class="listar">
	<h2>Lista de pesquisadores</h2>
	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>
	<table border=1 class="lista">
		<c:forEach items="${listaPesquisadores}" var="pesquisador">
			<tr>
				<td>Nome: <c:out value="${pesquisador.primeiro_nome} ${pesquisador.nome_do_meio} ${pesquisador.ultimo_nome}" /></td>
				
				
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="../../_footer.jsp" %>