package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Reserva;
import app.siscobli.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository repository;
	
	public Reserva salvar(Reserva reserva) {
		if (!isObjetoVazio(reserva)) {
			return repository.save(reserva);
		}
		return null;
	}

	public Reserva atualizar(Reserva reserva) {
		if (!isObjetoVazio(reserva)) {
			Reserva currentReserva = repository.findOne(reserva.getId());

			currentReserva.setDataLimite(reserva.getDataLimite());
			currentReserva.setDataReserva(reserva.getDataReserva());
			currentReserva.setEmprestimo(reserva.getEmprestimo());
			currentReserva.setPublicacao(reserva.getPublicacao());
			currentReserva.setStatus(reserva.getStatus());
			currentReserva.setUsuario(reserva.getUsuario());
			
			return repository.save(currentReserva);
		}
		return null;
	}

	public void excluir(Long id) {
		Reserva currentReserva = repository.findOne(id);
		if (!isObjetoVazio(currentReserva)) {
			repository.delete(currentReserva);
		}
	}

	public Reserva buscarPorId(Long id) {
		Reserva currentReserva = repository.findOne(id);
		if (!isObjetoVazio(currentReserva)) {
			return currentReserva;
		}
		return null;
	}

	public List<Reserva> buscarTodos() {
		List<Reserva> currentReservas = repository.findAll();
		if (!isObjetoVazio(currentReservas)) {
			return currentReservas;
		}
		return null;
	}

	public boolean isObjetoVazio(Object o) {
		if (null == o) {
			return true;
		} else {
			return false;
		}
	}
}
