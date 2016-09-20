package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Dvd;
import app.siscobli.repository.DvdRepository;
import app.siscobli.validator.DvdValidator;

@Service
public class DvdService {

	@Autowired
	private DvdRepository repository;
	
	@Autowired
	private DvdValidator validator;

	public Dvd salvar(Dvd dvd) {
		if (!isObjetoVazio(dvd)) {
			validator.validarDvdInsercao(dvd);
			return repository.save(dvd);
		}
		return null;
	}

	public Dvd atualizar(Dvd dvd) {
		if (!isObjetoVazio(dvd)) {
			validator.validarDvdEdicao(dvd);
			return repository.save(dvd);
		}
		return null;
	}

	public void excluir(Long id) {
		Dvd currentDvd = repository.findOne(id);
		if (!isObjetoVazio(currentDvd)) {
			repository.delete(currentDvd);
		}
	}

	public Dvd buscarPorId(Long id) {
		Dvd currentDvd = repository.findOne(id);
		if (!isObjetoVazio(currentDvd)) {
			return currentDvd;
		}
		return null;
	}

	public List<Dvd> buscarTodos() {
		List<Dvd> currentDvds = repository.findAll();
		if (!isObjetoVazio(currentDvds)) {
			return currentDvds;
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
