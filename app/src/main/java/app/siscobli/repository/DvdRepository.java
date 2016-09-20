package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.siscobli.model.Dvd;

public interface DvdRepository extends JpaRepository<Dvd, Long> {

	public Dvd findByDescricao(String descricao);
	
	@Query("SELECT d FROM Dvd d ORDER BY d.descricao")
	public List<Dvd> findAll();
}
