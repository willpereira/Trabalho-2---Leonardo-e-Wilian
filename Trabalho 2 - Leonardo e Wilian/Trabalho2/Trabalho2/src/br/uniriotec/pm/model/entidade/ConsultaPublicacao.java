package br.uniriotec.pm.model.entidade;

public class ConsultaPublicacao {
	private static final long serialVersionUID = 5127700948431345787L;
	private String titulo;
	private Integer influencia;
	private String classificacao;
	private Integer qtd_pesquisadores;
	private String nome_pesquisador;
	private String cidade;
	private String nome_citacao;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getInfluencia() {
		return influencia;
	}
	public void setInfluencia(Integer influencia) {
		this.influencia = influencia;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public Integer getQtd_pesquisadores() {
		return qtd_pesquisadores;
	}
	public void setQtd_pesquisadores(Integer qtd_pesquisadores) {
		this.qtd_pesquisadores = qtd_pesquisadores;
	}
	public String getNome_pesquisador() {
		return nome_pesquisador;
	}
	public void setNome_pesquisador(String nome_pesquisador) {
		this.nome_pesquisador = nome_pesquisador;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ConsultaPublicacao)){
			return false;
		}else{
			return true;
		}
		
	}
	public String getNome_citacao() {
		return nome_citacao;
	}
	public void setNome_citacao(String nome_citacao) {
		this.nome_citacao = nome_citacao;
	}
	
}