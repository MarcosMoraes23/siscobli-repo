package app.siscobli.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import app.siscobli.enums.EnumStatusEmprestimo;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 415566419188366151L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_EMPRESTIMO", nullable = false)
	private Date dataEmprestimo;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PREVISAO_DEVOLUCAO", nullable = false)
	private Date dataPrevisaoDevolucao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DEVOLUCAO")
	private Date dataDevolucao;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_EMPRESTIMO", nullable = false)
	private EnumStatusEmprestimo statusEmprestimo;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Usuario.class)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ID_PUBLICACAO")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Usuario.class)
	private Publicacao publicacao;

	@OneToOne
	@JoinColumn(name = "ID_RESERVA")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Emprestimo.class)
	private Reserva reserva;

	@OneToOne
	@JoinColumn(name = "ID_USUARIO_RESPONSAVEL")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Emprestimo.class)
	private Usuario usuarioResponsavel;

	public Emprestimo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataPrevisaoDevolucao() {
		return dataPrevisaoDevolucao;
	}

	public void setDataPrevisaoDevolucao(Date dataPrevisaoDevolucao) {
		this.dataPrevisaoDevolucao = dataPrevisaoDevolucao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public EnumStatusEmprestimo getStatusEmprestimo() {
		return statusEmprestimo;
	}

	public void setStatusEmprestimo(EnumStatusEmprestimo status) {
		this.statusEmprestimo = status;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
