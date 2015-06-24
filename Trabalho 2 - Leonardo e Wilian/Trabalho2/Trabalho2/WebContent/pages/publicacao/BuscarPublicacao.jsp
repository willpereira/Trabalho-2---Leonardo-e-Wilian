<%@include file="../../_header.jsp" %>

		<div id="formulario">
			<h2>Buscar Publicacao</h2>
			<form action="PublicacaoServlet" name="thisform" onSubmit="validate_form_publicacao(thisform);" method="post">
			<input type="hidden" name="comando" value="consultar"/>
 				Título: <input type="text" name="titulo"/> *
				</br><br>
 				Quantidade mínima que a produção bibliográfica influencia: <input type="text" name="influencia"> *<br/> 
 				<br><br>
 				<label>Classificação Qualis:</label>
 				<select name="Evento">
 				<option value="">   </option>  
 				<c:forEach var="evento" items="${listaclassificacaoQualis}">  
            	<option  value="<c:out value='${evento.classificacao_qualis}'/>"/> <c:out value="${evento.classificacao_qualis}"/> 
 				</option>
 				</c:forEach>
 				</select>
 				</br><br> 				
 				Pesquisador:   <input type="text" name="pesquisador"> *<br/> 							
 			
				<input type="submit" value="Pesquisar">			</form>		
		</div>
 
	


<%@include file="../../_footer.jsp" %>