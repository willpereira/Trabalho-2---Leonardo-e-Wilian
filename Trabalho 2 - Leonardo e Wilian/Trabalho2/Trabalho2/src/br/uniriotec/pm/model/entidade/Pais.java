package br.uniriotec.pm.model.entidade;

public class Pais {
	
		private static final long serialVersionUID = 3027109749327345593L;
		
		private Integer idPais;
		private String nome_pais;
	
		

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
		
			return ((Pais)obj).getIdPais() != null && ((Pais)obj).getIdPais().equals(this.idPais) ? true : false;
			
		}
	}

