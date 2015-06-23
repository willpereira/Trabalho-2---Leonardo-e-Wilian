<%@include file="../../_header.jsp" %>

<h1 id="title">Detalhes do Pesquisador</h1>
<hr/>
<script>

</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>
	Primeiro Nome: <input type="text"  name="primeiro_nome" readonly="true" value="<c:out value="${pesquisador.primeiro_nome}" />">
	<br /><br />
	Nome do meio: <input type="text" name="nome_do_meio" readonly="true" value="<c:out value="${pesquisador.nome_do_meio}" />">
	<br /><br />
	
	Último Nome: <input type="text" name="ultimo_nome" readonly="true" value="<c:out value="${pesquisador.ultimo_nome}" />">
	<br /><br />
	
	Cidade: <input type="text" name="cidadePesquisador" readonly="true" value="<c:out value="${cidade.nome_cidade}" />">
	<br /><br /> 
	
	Estado: <input type="text" name="estadoPesquisador" readonly="true" value="<c:out value="${cidade.nome_estado}" />">
	<br /><br /> 
	
	Pais: <input type="text" name="paisPesquisador" readonly="true" value="<c:out value="${cidade.nome_pais}" />">
	<br /><br /> 
	
	Tipo de logradouro: <input type="text" name="Tipo_de_Logradouro" readonly="true" value="<c:out value="${pesquisador.tipo_logradouroPesquisador}"/>">
	<br /><br />
	
	Logradouro: <input type="text" name="Logradouro" readonly="true" value="<c:out value="${pesquisador.logradouroPesquisador}" />">
	<br /><br />
	
	Número: <input type="text" name="Numero" readonly="true" value="<c:out value="${pesquisador.numeroPesquisador}" />">
	<br /><br />
	
	Complemento: <input type="text" name="Complemento" readonly="true" value="<c:out value="${pesquisador.complementoPesquisador}" />">
	<br /><br />
	
	 <c:forEach var="afiliacao" items="${afiliacoes}">
	 Afiliacao: <input type="text" name="nome" readonly="true" value="<c:out value="${afiliacao.nome}" />">
	<br /><br />
		Tipo: <input type="text" name="tipo" readonly="true" value="<c:out value="${afiliacao.tipo}" />">	
	<br /><br />
	IDCidade: <input type="text" name="cidadeAF" readonly="true" value="<c:out value="${afiliacao.idCidade}" />">
	<br /><br /> 
	Tipo de logradouro: <input type="text" name="tipo_de_Log" readonly="true" value="<c:out value="${afiliacao.tipo_logradouro}"/>">
	<br /><br />
	Logradouro: <input type="text" name="Log" readonly="true" value="<c:out value="${afiliacao.logradouro}" />">
	<br /><br />
	Número: <input type="text" name="Num" readonly="true" value="<c:out value="${afiliacao.numero}" />">
	<br /><br />
	Complemento: <input type="text" name="Comp" readonly="true" value="<c:out value="${afiliacao.complemento}" />">
	<br /><br />
	</c:forEach>    
 
	

	

<%@include file="../../_footer.jsp" %>