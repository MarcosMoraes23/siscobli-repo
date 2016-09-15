package app.siscobli.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "LIVRO")
public class Livro extends Publicacao implements Serializable {

	private static final long serialVersionUID = 8302191445624963011L;

	@Column(name = "ANO", length = 4)
	private Integer ano;

	@Column(name = "AUTOR", length = 256, nullable = false)
	private String autor;

	@Column(name = "ISBN", nullable = false, length = 32)
	private String isbn;

	@Column(name = "NUMERO_PAGINAS", nullable = false, length = 4)
	private Integer numeroPaginas;

	@Column(name = "EDICAO", length = 4)
	private Integer edicao;

	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Livro.class)
	@ManyToOne
	@JoinColumn(name = "ID_EDITORA")
	private Editora editora;

	public Livro() {
		super();
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
