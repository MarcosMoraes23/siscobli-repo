package app.siscobli.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.enums.EnumStatusEmprestimo;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Emprestimo;
import app.siscobli.model.Usuario;
import app.siscobli.repository.UsuarioRepository;

@Service
public class UsuarioValidator{

	public UsuarioValidator() {
	}

	@Autowired
	private UsuarioRepository repository;
	
	private void validarLoginExistente(Usuario usuario) {
		if (repository.findByLogin(usuario.getLogin()) == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_LOGIN_EXISTENTE, usuario));
		}
	}
	
	private void validarLoginVazio(Usuario usuario) {
		if (usuario.getLogin() == null || usuario.getLogin().equals("")) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_LOGIN_VAZIO, usuario));
		}
	}
	
	private void validarNomeVazio(Usuario usuario) {
		if (usuario.getNomeCompleto() == null || usuario.getNomeCompleto().equals("")) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_NOME_VAZIO, usuario));
		}
	}
	
	private void validarSenhaVazia(Usuario usuario) {
		if (usuario.getSenha() == null || usuario.getSenha().equals("")) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_SENHA_VAZIA, usuario));
		}
	}
	
	private void validarTipoUsuarioVazio(Usuario usuario) {
		if (usuario.getTipoUsuario() == null || usuario.getTipoUsuario().equals("")) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_TIPO_VAZIO, usuario));
		}
	}
	
	private void validarTamanhoSenha(Usuario usuario) {
		if (usuario.getSenha().length() < 8) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_SENHA_MIN, usuario));
		} else if (usuario.getSenha().length() > 12) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_USUARIO_SENHA_MAX, usuario));
		}
	}
	
	public void validarUsuarioInsercao(Usuario usuario)
	{
		validarLoginExistente(usuario);
		validarLoginVazio(usuario);
		validarNomeVazio(usuario);
		validarSenhaVazia(usuario);
		validarTamanhoSenha(usuario);
		validarTipoUsuarioVazio(usuario);
	}
	
	public void validarUsuarioExclusao(Usuario usuario)
	{
		validarUsuarioEmprestimo(usuario);
	}
	
	private void validarUsuarioEmprestimo(Usuario usuario) {
		for (Emprestimo key : usuario.getEmprestimos()) {
			if (key.getStatusEmprestimo().equals(EnumStatusEmprestimo.A)) {
				throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_EXCLUSAO_USUARIO_EMPRESTIMO_ATIVO, usuario));
			}
		}
	}
}
