package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Emprestimo;
import app.siscobli.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;

	public Emprestimo salvar(Emprestimo emprestimo) {
		if (!isObjetoVazio(emprestimo)) {
			return repository.save(emprestimo);
		}
		return null;
	}

	public Emprestimo atualizar(Emprestimo emprestimo) {
		if (!isObjetoVazio(emprestimo)) {
			Emprestimo currentEmprestimo = repository.findOne(emprestimo.getId());

			currentEmprestimo.setDataEmprestimo(currentEmprestimo.getDataEmprestimo());
			currentEmprestimo.setDataDevolucao(currentEmprestimo.getDataDevolucao());
			currentEmprestimo.setDataPrevisaoDevolucao(currentEmprestimo.getDataPrevisaoDevolucao());
			currentEmprestimo.setPublicacao(currentEmprestimo.getPublicacao());
			currentEmprestimo.setPublicacao(currentEmprestimo.getPublicacao());
			currentEmprestimo.setReserva(currentEmprestimo.getReserva());
			currentEmprestimo.setStatusEmprestimo(currentEmprestimo.getStatusEmprestimo());
			currentEmprestimo.setUsuario(currentEmprestimo.getUsuario());
			currentEmprestimo.setUsuarioResponsavel(currentEmprestimo.getUsuarioResponsavel());

			return repository.save(currentEmprestimo);
		}
		return null;
	}

	public void excluir(Long id) {
		Emprestimo currentEmprestimo = repository.findOne(id);
		if (!isObjetoVazio(currentEmprestimo)) {
			repository.delete(currentEmprestimo);
		}
	}

	public Emprestimo buscarPorId(Long id) {
		Emprestimo currentEmprestimo = repository.findOne(id);
		if (!isObjetoVazio(currentEmprestimo)) {
			return currentEmprestimo;
		}
		return null;
	}

	public List<Emprestimo> buscarTodos() {
		List<Emprestimo> currentEmprestimos = repository.findAll();
		if (!isObjetoVazio(currentEmprestimos)) {
			return currentEmprestimos;
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
