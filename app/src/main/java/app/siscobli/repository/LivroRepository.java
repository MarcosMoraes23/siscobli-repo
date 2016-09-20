package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.siscobli.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	public List<Livro> findByDescricao(String descricao);
	
	public Livro findByIsbnAndDescricao(String descricao, String isbn);

	public Livro findByIsbn(String isbn);
	
	@Query("SELECT l FROM Livro l ORDER BY l.descricao")
	public List<Livro> findAll();
	
}
