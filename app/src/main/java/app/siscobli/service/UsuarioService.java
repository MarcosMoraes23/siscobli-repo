package app.siscobli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Usuario;
import app.siscobli.repository.UsuarioRepository;
import app.siscobli.utils.EncryptUtils;
import app.siscobli.validator.UsuarioValidator;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioValidator validator;
	
	public UsuarioService() {

	}

	public Usuario salvar(Usuario usuario) {
		if (!isObjetoVazio(usuario)) {
			validator.validarUsuarioInsercao(usuario);
			usuario.setSenha(EncryptUtils.encriptarMD5(usuario.getSenha()));
			return repository.save(usuario);
		}
		return null;
	}

	public Usuario atualizar(Usuario usuario) {
		if (!isObjetoVazio(usuario)) {

			validator.validarUsuarioInsercao(usuario);

			usuario.setSenha(EncryptUtils.encriptarMD5(usuario.getSenha()));
			usuario.setSenha(usuario.getSenha());

			return repository.save(usuario);
		}
		return null;
	}

	public void excluir(Long id) {
		Usuario currentUsuario = repository.findOne(id);
		if (!isObjetoVazio(currentUsuario)) {
			validator.validarUsuarioExclusao(currentUsuario);
			repository.delete(currentUsuario);
		}
	}

	public Usuario buscarPorId(Long id) {
		Usuario currentUsuario = repository.findOne(id);
		if (!isObjetoVazio(currentUsuario)) {
			return currentUsuario;
		}
		return null;
	}

	public List<Usuario> buscarTodos() {
		List<Usuario> currentUsuarios = repository.findAll();
		if (!isObjetoVazio(currentUsuarios)) {
			removerSenhasListagem(currentUsuarios);
			return currentUsuarios;
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

	private void removerSenhasListagem(List<Usuario> usuarios) {
		for (Usuario key : usuarios) {
			key.setSenha("none");
		}
	}
}
