package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Periodico;
import app.siscobli.repository.PeriodicoRepository;

@Service
public class PeriodicoService {
	
	@Autowired
	private PeriodicoRepository repository;
	
	public Periodico salvar(Periodico periodico) {
		if (!isObjetoVazio(periodico)) {
			return repository.save(periodico);
		}
		return null;
	}

	public Periodico atualizar(Periodico periodico) {
		if (!isObjetoVazio(periodico)) {
			Periodico currentPeriodico = repository.findOne(periodico.getId());

			currentPeriodico.setDescricao(periodico.getDescricao());
			currentPeriodico.setDataLancamento(periodico.getDataLancamento());
			currentPeriodico.setCategoria(periodico.getCategoria());
			currentPeriodico.setDisponibilidade(periodico.getDisponibilidade());
			currentPeriodico.setQuantidadeExemplares(periodico.getQuantidadeExemplares());
			currentPeriodico.setQuantidadeReal(periodico.getQuantidadeReal());
			currentPeriodico.setReservas(periodico.getReservas());
			currentPeriodico.setEmprestimos(periodico.getEmprestimos());
			currentPeriodico.setEdicao(periodico.getEdicao());
			
			return repository.save(currentPeriodico);
		}
		return null;
	}

	public void excluir(Long id) {
		Periodico currentPeriodico = repository.findOne(id);
		if (!isObjetoVazio(currentPeriodico)) {
			repository.delete(currentPeriodico);
		}
	}

	public Periodico buscarPorId(Long id) {
		Periodico currentPeriodico = repository.findOne(id);
		if (!isObjetoVazio(currentPeriodico)) {
			return currentPeriodico;
		}
		return null;
	}

	public List<Periodico> buscarTodos() {
		List<Periodico> currentPeriodicos = repository.findAll();
		if (!isObjetoVazio(currentPeriodicos)) {
			return currentPeriodicos;
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
