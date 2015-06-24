//Valida se os campos dos formulários de busca de Pesquisador estão em branco.

function validate_form_pesquisador(thisform){
		with (thisform){
 			if( (primeiro_nome.value == "" || primeiro_nome.value == null) && (nome_do_meio.value == "" || nome_do_meio.value == null) && (ultimo_nome.value == "" || ultimo_nome.value == null)){
 				alert('Nenhum parâmetro de consulta inserido')
 				return false;
 			} 
 			return true;
		}
}

//Valida se os campos do formulário de busca de Publicação estão em branco.
function validate_form_publicacao(thisform){
	with (thisform){
			if( (titulo.value == "" || titulo.value == null) && (influencia.value == "" || influencia.value == null) && (Evento.value == "" || Evento.value == null) && (pesquisador.value == "" || pesquisador.value == null)){
				alert('Nenhum parâmetro de consulta inserido')
				return false;
			} 
			return true;
	}
}

//Valida se os campos do formulário de Inserir Pesquisador estão em branco.

function validate_form_inserir_pesq(thisform){
	with (thisform){
		if( (primeiro_nome.value == "" || primeiro_nome.value == null)){
				alert('Campos obrigatórios em branco!')
			primeiro_nome.focus();
				return false;
		}
		if( (nome_do_meio.value == "" || nome_do_meio.value == null)){
			alert('Campos obrigatórios em branco!')
			primeiro_nome.focus();
			return false;
	    }
		if( (ultimo_nome.value == "" || ultimo_nome.value == null) ){
				alert('Campos obrigatórios em branco!')
			ultimo_nome.focus();
				return false;
		}
		if( (Logradouro.value == "" || Logradouro.value == null) ){
				alert('Campos obrigatórios em branco!')
			Logradouro.focus();
				return false;
		}
		if( (Tipo_de_Logradouro.value == "" || Tipo_de_Logradouro.value == null) ){
				alert('Campos obrigatórios em branco!')
			Tipo_de_Logradouro.focus();
				return false;
		}
		if( (Numero.value == "" || Numero.value == null) ){
				alert('Campos obrigatórios em branco!')
			Numero.focus();
				return false;
		}
		if( (Cidade.value == "" || Cidade.value == null) ){
				alert('Campos obrigatórios em branco!')
			Cidade.focus();
				return false;
		}
		if( (Estado.value == "" || Estado.value == null) ){
				alert('Campos obrigatórios em branco!')
			Estado.focus();
				return false;
		}
		if( (Pais.value == "" || Pais.value == null) ){
				alert('Campos obrigatórios em branco!')
			Pais.focus();
				return false;
		}
		if( (Afiliacao.value == "" || Afiliacao.value == null) ){
				alert('Campos obrigatórios em branco!')
			Afiliacao.focus();
				return false;
		}
			return true;
	}
}
