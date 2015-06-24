<%@include file="../../_header.jsp" %>

	
		<div id="formulario">
			<h2>Buscar Pesquisador</h2>
			<form action="PesquisadorServlet" name="thisform" onSubmit="validate_form_pesquisador(thisform)" method="post">
			<input type="hidden" name="comando" value="antesExcluir"/>
			<!-- <input type="hidden" name="id" value="<c:out value='${pesquisador.codPesquisador}' />"/> <br /> -->
 				Nome: <input type="text" name="primeiro_nome"/> *
				</br>
 				Nome do Meio: <input type="text" name="nome_do_meio"> *<br/> 
 				Ultimo Nome:   <input type="text" name="ultimo_nome"> *<br/> 							
 
				<input type="submit" value="Pesquisar">			
				
			</form>		
		</div>
 
	


<%@include file="../../_footer.jsp" %>



