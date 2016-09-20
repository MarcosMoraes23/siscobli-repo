package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.siscobli.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

	public Turma findByDescricao(String descricao);
	
	@Query("SELECT t FROM Turma t ORDER BY t.descricao")
	public List<Turma> findAll();
}
