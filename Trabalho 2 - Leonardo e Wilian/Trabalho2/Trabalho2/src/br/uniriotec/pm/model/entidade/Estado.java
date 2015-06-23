package br.uniriotec.pm.model.entidade;

public class Estado {
	private static final long serialVersionUID = 5127700749327345787L;
	
	private Integer idEstado;
	private String nome_estado;
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
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Cidade))
			return false;
		return ((Estado)obj).getIdEstado() != null && ((Estado)obj).getIdEstado().equals(this.idEstado) ? true : false;
		
	}
}
