package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Aluno;
import app.siscobli.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public Aluno salvar(Aluno aluno) {
		if (!isObjetoVazio(aluno)) {
			return repository.save(aluno);
		}
		return null;
	}

	public Aluno atualizar(Aluno aluno) {
		if (!isObjetoVazio(aluno)) {
			Aluno currentAluno = repository.findOne(aluno.getId());

			currentAluno.setDataNascimento(aluno.getDataNascimento());
			currentAluno.setTurma(aluno.getTurma());
			currentAluno.setUsuario(aluno.getUsuario());

			return repository.save(currentAluno);
		}
		return null;
	}

	public void excluir(Long id) {
		Aluno currentAluno = repository.findOne(id);
		if (!isObjetoVazio(currentAluno)) {
			repository.delete(currentAluno);
		}
	}

	public Aluno buscarPorId(Long id) {
		Aluno currentAluno = repository.findOne(id);
		if (!isObjetoVazio(currentAluno)) {
			return currentAluno;
		}
		return null;
	}

	public List<Aluno> buscarTodos() {
		List<Aluno> currentAlunos = repository.findAll();
		if (!isObjetoVazio(currentAlunos)) {
			return currentAlunos;
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
