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

//Valida se os campos dos formulários de busca de Publicação estão em branco.
function validate_form_publicacao(thisform){
	with (thisform){
			if( (titulo.value == "" || titulo.value == null) && (influencia.value == "" || influencia.value == null) && (Evento.value == "" || Evento.value == null) && (pesquisador.value == "" || pesquisador.value == null)){
				alert('Nenhum parâmetro de consulta inserido')
				return false;
			} 
			return true;
	}
}