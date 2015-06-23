package br.uniriotec.pm.model.entidade;


public class Pesquisador extends BaseEntity {
	private static final long serialVersionUID = 5127700370555345787L;
	private Integer codPesquisador;
	private String primeiro_nome;
	private String nome_do_meio;
	private String ultimo_nome;
	private String logradouroPesquisador;
	private String tipo_logradouroPesquisador;
	private Integer numeroPesquisador;
	private String complementoPesquisador;
	
	public String getNome_do_meio() {
		return nome_do_meio;
	}
	public void setNome_do_meio(String nome_do_meio) {
		this.nome_do_meio = nome_do_meio;
	}
	public String getUltimo_nome() {
		return ultimo_nome;
	}
	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}
	public String getLogradouroPesquisador() {
		return logradouroPesquisador;
	}
	public void setLogradouroPesquisador(String logradouroPesquisador) {
		this.logradouroPesquisador = logradouroPesquisador;
	}
	public String getTipo_logradouroPesquisador() {
		return tipo_logradouroPesquisador;
	}
	public void setTipo_logradouroPesquisador(String tipo_logradouroPesquisador) {
		this.tipo_logradouroPesquisador = tipo_logradouroPesquisador;
	}
	public Integer getNumeroPesquisador() {
		return numeroPesquisador;
	}
	public void setNumeroPesquisador(Integer numeroPesquisador) {
		this.numeroPesquisador = numeroPesquisador;
	}
	public String getComplementoPesquisador() {
		return complementoPesquisador;
	}
	public void setComplementoPesquisador(String complementoPesquisador) {
		this.complementoPesquisador = complementoPesquisador;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Pesquisador))
			return false;
		return ((Pesquisador)obj).getCodPesquisador() != null && ((Pesquisador)obj).getCodPesquisador().equals(this.codPesquisador) ? true : false;
		
		
	}
	public Integer getCodPesquisador() {
		return codPesquisador;
	}
	public void setCodPesquisador(Integer codPesquisador) {
		this.codPesquisador = codPesquisador;
	}
	public String getPrimeiro_nome() {
		return primeiro_nome;
	}
	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}
}
