package app.siscobli.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Usuario;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//@Query(value="SELECT u FROM Usuario u WHERE u.login =:login AND u.senha =:senha")
	public Usuario findByLoginAndSenha(String login, String senha);
	
	public Usuario findByLogin(String login);
	
}
