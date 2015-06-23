<%@include file="../../_header.jsp" %>


	<script type="text/javascript">
		function validate_form(thisform){
			with (thisform){
 				if( (primeiro_nome.value == "" || primeiro_nome.value == null) && (nome_do_meio.value == "" || nome_do_meio.value == null) && (ultimo_nome.value == "" || ultimo_nome.value == null) && (Logradouro.value == "" || Logradouro.value == null) && (Cidade.value == "" || Cidade.value == null)){
 					alert('Nenhum parâmetro de consulta inserido')
 					return false;
 				} 
 				return true;
			}
		}
	</script>

	

		<div id="formulario">
			<h2>Buscar Pesquisador</h2>
			<form action="PesquisadorServlet" onsubmit="return validate_form(this)" method="post">
			<input type="hidden" name="comando" value="antesExcluir"/>
			<!-- <input type="hidden" name="id" value="<c:out value='${pesquisador.codPesquisador}' />"/> <br /> -->
 				Nome: <input type="text" name="primeiro_nome"/> *
				</br>
 				Nome do Meio: <input type="text" name="nome_do_meio"> *<br/> 
 				Ultimo Nome:   <input type="text" name="ultimo_nome"> *<br/> 							
 				<!-- Logradouro: <input type="text" name="Logradouro"/></br>
				Cidade: <input type="text" name="Cidade"><br/>
  -->
				<input type="submit" value="Pesquisar">			</form>		
		</div>
 
	


<%@include file="../../_footer.jsp" %>



