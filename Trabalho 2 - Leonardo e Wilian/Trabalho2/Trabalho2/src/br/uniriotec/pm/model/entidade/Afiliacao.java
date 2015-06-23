package br.uniriotec.pm.model.entidade;

public class Afiliacao extends BaseEntity{

	private static final long serialVersionUID = 6072740679881277191L;
	
	private Integer IdAfiliacao;
	private String nome;
	private String tipo;
	private String tipo_logradouro;	
	private String logradouro;
	private Integer numero;
	private String complemento;
	private Integer idCidade;
	
	
	public Integer getIdAfiliacao() {
		return IdAfiliacao;
	}
	public void setIdAfiliacao(Integer IdAfiliacao) {
		this.IdAfiliacao = IdAfiliacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo_logradouro() {
		return tipo_logradouro;
	}
	public void setTipo_logradouro(String tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Afiliacao))
			return false;

		return ((Afiliacao)obj).getIdAfiliacao() != null && ((Afiliacao)obj).getIdAfiliacao().equals(this.IdAfiliacao) ? true : false;
		
		
	}
	
	
}