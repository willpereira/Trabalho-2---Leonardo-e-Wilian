package br.uniriotec.pm.model.entidade;



public class Cidade extends BaseEntity{
	private static final long serialVersionUID = 5127700948555345787L;
	
	private Integer idCidade;
	private String nome_cidade;
	private Integer idEstado;
	private String nome_estado;
	private Integer idPais;
	private String nome_pais;
	
	
	
	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNome_pais() {
		return nome_pais;
	}

	public void setNome_pais(String nome_pais) {
		this.nome_pais = nome_pais;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Cidade))
			return false;
		
		return ((Cidade)obj).getIdCidade() != null && ((Cidade)obj).getIdCidade().equals(this.idCidade) ? true : false;
		
		
	}
	
	
	
}

