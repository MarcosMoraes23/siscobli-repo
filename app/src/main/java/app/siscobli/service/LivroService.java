package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Livro;
import app.siscobli.repository.LivroRepository;
import app.siscobli.validator.LivroValidator;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private LivroValidator validator;
	
	public LivroService() {

	}

	public Livro salvar(Livro livro) {
		if (!isObjetoVazio(livro)) {
			validator.validarLivroInsercao(livro);
			return repository.save(livro);
		}
		return null;
	}

	public Livro atualizar(Livro livro) {
		if (!isObjetoVazio(livro)) {
			validator.validarLivroInsercao(livro);
			return repository.save(livro);
		}
		return null;
	}

	public void excluir(Long id) {
		Livro currentLivro = repository.findOne(id);
		if (!isObjetoVazio(currentLivro)) {
			repository.delete(currentLivro);
		}
	}

	public Livro buscarPorId(Long id) {
		Livro currentLivro = repository.findOne(id);
		if (!isObjetoVazio(currentLivro)) {
			return currentLivro;
		}
		return null;
	}

	public List<Livro> buscarTodos() {
		List<Livro> currentLivros = repository.findAll();
		if (!isObjetoVazio(currentLivros)) {
			return currentLivros;
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
