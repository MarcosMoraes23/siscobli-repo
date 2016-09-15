package app.siscobli.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PUBLICACAO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publicacao implements Serializable {

	private static final long serialVersionUID = -7936318888107364391L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRICAO", nullable = false, length = 256)
	private String descricao;

	@Column(name = "QUANTIDADE_REAL", nullable = false)
	private Integer quantidadeReal;

	@Column(name = "QUANTIDADE_EXEMPLARES", nullable = false)
	private Integer quantidadeExemplares;

	@Column(name = "CATEGORIA", length = 128)
	private String categoria;

	@Column(name = "DISPONIBILIDADE")
	private Boolean disponibilidade;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_LANCAMENTO")
	private Date dataLancamento;

	@OneToMany(mappedBy = "publicacao")
	private List<Emprestimo> emprestimos;

	@OneToMany(mappedBy = "publicacao")
	private List<Reserva> reservas;

	public Publicacao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidadeReal() {
		return quantidadeReal;
	}

	public void setQuantidadeReal(Integer quantidadeReal) {
		this.quantidadeReal = quantidadeReal;
	}

	public Integer getQuantidadeExemplares() {
		return quantidadeExemplares;
	}

	public void setQuantidadeExemplares(Integer quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacao other = (Publicacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
