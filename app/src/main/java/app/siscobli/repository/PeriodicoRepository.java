package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.siscobli.model.Periodico;

public interface PeriodicoRepository extends JpaRepository<Periodico, Long> {

	public Periodico findByDescricao(String descricao);
	
	@Query("SELECT p FROM Periodico p ORDER BY p.descricao")
	public List<Periodico> findAll();
}
