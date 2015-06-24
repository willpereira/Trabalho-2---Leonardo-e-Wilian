<%@include file="../../_header.jsp"%>

<div class="listar">
	<h2>Lista de publicações</h2>
	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>
	<table border=1 class="lista">
		<c:forEach items="${relatorio}" var="consultapublicacao">
			<tr>
				<td>Titulo: <c:out value="${consultapublicacao.titulo}" /></td>
				<td>Quantidade de produções influenciadas: <c:out value="${consultapublicacao.influencia}" /></td>
				<td>Classificação Qualis: <c:out value="${consultapublicacao.classificacao}" /></td> 
				<td>Quantidade de pesquisadores: <c:out value="${consultapublicacao.qtd_pesquisadores}" /></td> 
				<td>Nome do primeiro pesquisador: <c:out value="${consultapublicacao.nome_pesquisador}" /></td> 
				<td>Cidade da afiliação do pesquisador: <c:out value="${consultapublicacao.cidade}" /></td>
				<td>Nome Citação: <c:out value="${consultapublicacao.nome_citacao }"></c:out>
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="../../_footer.jsp" %>