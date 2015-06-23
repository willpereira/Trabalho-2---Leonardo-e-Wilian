<%@include file="../../_header.jsp" %>


	<script type="text/javascript">
		function validate_form(thisform){
			with (thisform){
 				if( (titulo.value == "" || titulo.value == null) && (influencia.value == "" || influencia.value == null) && (Evento.value == "" || Evento.value == null) && (pesquisador.value == "" || pesquisador.value == null)){
 					alert('Nenhum parâmetro de consulta inserido')
 					return false;
 				} 
 				return true;
			}
		}	</script>

	

		<div id="formulario">
			<h2>Buscar Publicacao</h2>
			<form action="PublicacaoServlet" onsubmit="return validate_form(this)" method="post">
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