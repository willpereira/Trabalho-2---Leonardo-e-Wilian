<%@include file="../../_header.jsp" %>

<h1 id="title">Alterar Pesquisador</h1>
<hr/>

<form action="PesquisadorServlet" method="post">
	<input type="hidden" name="comando" value="alterar" />
    <input type="hidden" name="id" value="<c:out value='${pesquisador.codPesquisador}'/>"/><br />
	

	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>
	
				Nome: <input type="text" name="primeiro_nome" value="${pesquisador.primeiro_nome}" /> * <br />
				Nome do Meio: <input type="text" name="nome_do_meio" value="${pesquisador.nome_do_meio}"/> *<br/>
				Ultimo Nome : <input type="text" name="ultimo_nome" value="${pesquisador.ultimo_nome}"/> *<br/>
				Tipo de Logradouro: <input type="text" name="Tipo de Logradouro" value="<c:out value='${pesquisador.tipo_logradouroPesquisador}'/>"/> <br/><br/>
				Logradouro: <input type="text" name="Logradouro" value="<c:out value='${pesquisador.logradouroPesquisador}'/>"/><br/><br/>
				Número: <input type="text" name="Numero" value="<c:out value='${pesquisador.numeroPesquisador}'/>"/><br/><br/>
				Complemento: <input type="text" name="Complemento" value="<c:out value='${pesquisador.complementoPesquisador}'/>"/><br/><br/>
				
	       
	
			
	<input type="submit" value="Alterar" />
</form>

<%@include file="../../_footer.jsp" %>

