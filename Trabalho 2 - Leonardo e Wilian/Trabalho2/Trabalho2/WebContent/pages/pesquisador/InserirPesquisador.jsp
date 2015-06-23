<%@include file="../../_header.jsp"%>	
	<script type="text/javascript">
		function validate_form(thisform){
			with (thisform){
				if( (primeiro_nome.value == "" || primeiro_nome.value == null)){
 					alert('Campos Obrigatórios em branco!')
					primeiro_nome.focus();
 					return false;
				}
				if( (ultimo_nome.value == "" || ultimo_nome.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					ultimo_nome.focus();
 					return false;
				}
				if( (Logradouro.value == "" || Logradouro.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Logradouro.focus();
 					return false;
				}
				if( (Tipo_de_Logradouro.value == "" || Tipo_de_Logradouro.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Tipo_de_Logradouro.focus();
 					return false;
				}
				if( (Numero.value == "" || Numero.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Numero.focus();
 					return false;
				}
				if( (Cidade.value == "" || Cidade.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Cidade.focus();
 					return false;
				}
				if( (Estado.value == "" || Estado.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Estado.focus();
 					return false;
				}
				if( (País.value == "" || País.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					País.focus();
 					return false;
				}
				if( (Afiliação.value == "" || Afiliação.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Afiliação.focus();
 					return false;
				}
				if( (Logradouro1.value == "" || Logradouro1.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Logradouro1.focus();
 					return false;
				}
				if( (Tipo_de_Logradouro1.value == "" || Tipo_de_Logradouro1.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Tipo_de_Logradouro1.focus();
 					return false;
				}
				if( (Numero1.value == "" || Numero1.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Numero1.focus();
 					return false;
				}
				if( (Cidade1.value == "" || Cidade1.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Cidade1.focus();
 					return false;
				}
				if( (Estado1.value == "" || Estado1.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					Estado1.focus();
 					return false;
				}
				if( (País1.value == "" || País1.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					País1.focus();
 					return false;
				}
				if( (TipodeAfiliação.value == "" || TipodeAfiliação.value == null) ){
 					alert('Campos Obrigatórios em branco!')
					TipodeAfiliação.focus();
 					return false;
				}
 				return true;
			}
		}
		

	</script>

	<body>

		
		<div id="formulario">
		<h2>Inserir Pesquisador</h2>

		<form action="PesquisadorServlet"  method="post"><input type="hidden" name="comando" value="incluir"/>
 			Primeiro Nome: <input type="text" name="primeiro_nome"> *<br/>
 			Nome do Meio: <input type="text" name="nome_do_meio"> *<br/> 
 			Ultimo Nome: <input type="text" name="ultimo_nome"> *<br/> 
			Logradouro: <input type="text" name="Logradouro"><br/>
 			Tipo de Logradouro: <input type="text" name="Tipo_de_Logradouro"><br/>
 			Numero: <input type="text" name="Numero"><br/>
 			Complemento: <input type="text" name="Complemento"><br/>
 			
 			<label>Cidade:</label>
 			<select name="Cidade">
 			<option value="">   </option>  
 			<c:forEach var="cidade" items="${cidades}">  
            <option  value="<c:out value='${cidade.nome_cidade}'/>"/> <c:out value="${cidade.nome_cidade}"/> 
 			</option>
 			</c:forEach>
 			</select></br>
 			
 			<label>Estado:</label> 
			<select name="Estado"> 
 			<option value="">   </option>  
            <c:forEach var="estado" items="${estados}">  
            <option value="<c:out value='${estado.nome_estado}'/>"/> <c:out value="${estado.nome_estado}"/>  
          
        	</option>  
     		</c:forEach>   
 			</select></br>
 			
 			<label>País:</label>
 			<select name="Pais">
 			<option value="">   </option>  
 			<c:forEach var="pais" items="${paises}">  
            <option value="<c:out value='${pais.nome_pais}'/>"/> <c:out value="${pais.nome_pais}"/>  
 			</option>
 			</c:forEach>
 			</select></br>
 			
 			<label>Afiliaçao:</label>
 			<select name="Afiliacao">
 			<option value="">   </option>  
 			<c:forEach var="afiliacao" items="${afiliacoes}">  
            <option value="<c:out value='${afiliacao.nome}'/>"/> <c:out value="${afiliacao.nome}"/>  
 			</option>
 			</c:forEach>
 			</select></br>
				
			
			<input type="submit" value="Cadastrar">
			
		</form> 
		</div>
	</body>
<%@include file="../../_footer.jsp"%>




