<%@include file="../../_header.jsp"%>

	<body>

		
		<div id="formulario">
		<h2>Inserir Pesquisador</h2>

		<form action="PesquisadorServlet"  method="post" name="thisform" onSubmit="validate_form_inserir_pesq(thisform)"><input type="hidden" name="comando" value="incluir"/>
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




