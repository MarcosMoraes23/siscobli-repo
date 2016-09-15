package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Editora;
import app.siscobli.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;

	public Editora salvar(Editora editora) {
		if (!isObjetoVazio(editora)) {
			return repository.save(editora);
		}
		return null;
	}

	public Editora atualizar(Editora editora) {
		if (!isObjetoVazio(editora)) {
			Editora currentEditora = repository.findOne(editora.getId());

			currentEditora.setLivros(editora.getLivros());
			currentEditora.setNomeEditora(editora.getNomeEditora());

			return repository.save(currentEditora);
		}
		return null;
	}

	public void excluir(Long id) {
		Editora currentEditora = repository.findOne(id);
		if (!isObjetoVazio(currentEditora)) {
			repository.delete(currentEditora);
		}
	}

	public Editora buscarPorId(Long id) {
		Editora currentEditora = repository.findOne(id);
		if (!isObjetoVazio(currentEditora)) {
			return currentEditora;
		}
		return null;
	}

	public List<Editora> buscarTodos() {
		List<Editora> currentEditoras = repository.findAll();
		if (!isObjetoVazio(currentEditoras)) {
			return currentEditoras;
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
