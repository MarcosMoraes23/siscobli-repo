package app.siscobli.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Usuario;
import app.siscobli.repository.UsuarioRepository;
import app.siscobli.utils.EncryptUtils;

@Service
public class LoginValidator {

	@Autowired
	private UsuarioRepository repository;
	
	public LoginValidator() {
	}
	
	private Usuario usuarioRetorno;

	public void validarLogin(Usuario usuario) {
		validarLoginSenhaVazios(usuario);
			usuario.setSenha(EncryptUtils.encriptarMD5(usuario.getSenha()));
			usuarioRetorno = repository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
			usuarioRetorno.setSenha("");
		
		if (usuarioRetorno == null || usuario == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_SENHA_INVALIDOS,usuario));
		}
	}

	private void validarLoginSenhaVazios(Usuario usuario) {
		if ((usuario.getSenha() == null || usuario.getSenha().equals("")) || (usuario.getLogin() == null || usuario.getLogin().equals(""))) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_SENHA_INVALIDOS, usuario));
		}
	}
	
	public Usuario getUsuarioRetorno() {
		return usuarioRetorno;
	}

	public void setUsuarioRetorno(Usuario usuarioRetorno) {
		this.usuarioRetorno = usuarioRetorno;
	}

}
