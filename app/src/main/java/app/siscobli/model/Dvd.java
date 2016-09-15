package app.siscobli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DVD")
public class Dvd extends Publicacao implements Serializable {

	private static final long serialVersionUID = -3499156338474049287L;

	@Column(name = "CLASSIFICACAO", length = 2)
	private Integer classificacao;

	public Dvd() {
		super();
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

}
