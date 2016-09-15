package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	public List<Livro> findByDescricao(String descricao);
	
	public List<Livro> findByIsbnAndDescricao(String descricao, String isbn);
	
}
