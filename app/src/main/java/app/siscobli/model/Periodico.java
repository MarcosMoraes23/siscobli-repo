package app.siscobli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERIODICO")
public class Periodico extends Publicacao implements Serializable {

	private static final long serialVersionUID = -7743830232871087325L;

	@Column(name = "EDICAO", length = 4)
	private Integer edicao;

	public Periodico() {
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

}
