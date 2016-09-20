package app.siscobli.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.siscobli.model.Usuario;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByLoginAndSenha(String login, String senha);
	
	public Usuario findByLogin(String login);
	
	@Query("SELECT u FROM Usuario u ORDER BY u.nomeCompleto")
	public List<Usuario> findAll();
	
}
