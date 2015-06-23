package br.uniriotec.pm.model.entidade;

public class Publicacao extends BaseEntity{
	private static final long serialVersionUID = 5127709870555345890L;
	private Integer idProdBiblio;
	private Integer idPesquisa;
	private String titulo;
	private String tipo_publicacao;
	private Integer pagina_inicial;
	private Integer pagina_final;
	private Integer volume;
	private Integer ano_prod_biblio;
	private String classificacao_qualis;
	
	
	public Integer getIdProdBiblio() {
		return idProdBiblio;
	}
	public void setIdProdBiblio(Integer idProdBiblio) {
		this.idProdBiblio = idProdBiblio;
	}
	public Integer getIdPesquisa() {
		return idPesquisa;
	}
	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo_publicacao() {
		return tipo_publicacao;
	}
	public void setTipo_publicacao(String tipo_publicacao) {
		this.tipo_publicacao = tipo_publicacao;
	}
	public Integer getPagina_inicial() {
		return pagina_inicial;
	}
	public void setPagina_inicial(Integer pagina_inicial) {
		this.pagina_inicial = pagina_inicial;
	}
	public Integer getPagina_final() {
		return pagina_final;
	}
	public void setPagina_final(Integer pagina_final) {
		this.pagina_final = pagina_final;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getAno_prod_biblio() {
		return ano_prod_biblio;
	}
	public void setAno_prod_biblio(Integer ano_prod_biblio) {
		this.ano_prod_biblio = ano_prod_biblio;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Publicacao))
			return false;
		
		return ((Publicacao)obj).getIdProdBiblio() != null && ((Publicacao)obj).getIdProdBiblio().equals(this.idProdBiblio) ? true : false;
		
		
	}
	public String getClassificacao_qualis() {
		return classificacao_qualis;
	}
	public void setClassificacao_qualis(String classificacao_qualis) {
		this.classificacao_qualis = classificacao_qualis;
	}
	
}
