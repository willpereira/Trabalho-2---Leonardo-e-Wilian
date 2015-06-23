<%@include file="../../_header.jsp" %>

<h1 id="title">Excluir Pesquisador</h1>
<hr/>



<form action="PesquisadorServlet" method="post">
<input type="hidden" name="id" value="<c:out value='${pesquisador.codPesquisador}'/>"/><br />
	<input type="hidden" name="comando" value="excluir" />
	<br /><br />
	
	Primeiro Nome: <c:out value="${pesquisador.primeiro_nome}" />
	<br /><br />
	
	Nome do meio: <c:out value="${pesquisador.nome_do_meio}" />
	<br /><br />
	
	Último Nome: <c:out value="${pesquisador.ultimo_nome}" />
	<br /><br />
	
	
	
	
	<input type="submit" value="excluir" onclick="return confirm('Confirma a exclusão?')"/>

</form>

<%@include file="../../_footer.jsp" %>





