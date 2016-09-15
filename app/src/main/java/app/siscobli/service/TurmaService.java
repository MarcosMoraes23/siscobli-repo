package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Turma;
import app.siscobli.repository.TurmaRepository;
import app.siscobli.validator.TurmaValidator;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	
	@Autowired
	private TurmaValidator validator;
	
	public Turma salvar(Turma turma) {
		if (!isObjetoVazio(turma)) {
			validator.validarDescricaoTurmaDuplicada(turma);
			return repository.save(turma);
		}
		return null;
	}

	public Turma atualizar(Turma turma) {
		if (!isObjetoVazio(turma)) {
			Turma currentTurma = repository.findOne(turma.getId());

			currentTurma.setDescricao(turma.getDescricao());
			currentTurma.setGrauDeEnsino(turma.getGrauDeEnsino());
			currentTurma.setSerie(turma.getSerie());
			currentTurma.setAlunos(turma.getAlunos());
			
			return repository.save(currentTurma);
		}
		return null;
	}

	public void excluir(Long id) {
		Turma currentTurma = repository.findOne(id);
		if (!isObjetoVazio(currentTurma)) {
			repository.delete(currentTurma);
		}
	}

	public Turma buscarPorId(Long id) {
		Turma currentTurma = repository.findOne(id);
		if (!isObjetoVazio(currentTurma)) {
			return currentTurma;
		}
		return null;
	}

	public List<Turma> buscarTodos() {
		List<Turma> currentTurmas = repository.findAll();
		if (!isObjetoVazio(currentTurmas)) {
			return currentTurmas;
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
