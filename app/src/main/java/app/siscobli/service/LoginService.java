package app.siscobli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.model.Usuario;
import app.siscobli.validator.LoginValidator;

@Service
public class LoginService {

	@Autowired
	private LoginValidator validator;

	public Usuario efetuarLogin(Usuario usuario) {
		if (!isObjetoVazio(usuario)) {
			validator.validarLogin(usuario);
			return validator.getUsuarioRetorno();
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
