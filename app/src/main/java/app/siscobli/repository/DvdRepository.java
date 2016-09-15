package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Dvd;

public interface DvdRepository extends JpaRepository<Dvd, Long> {

	public List<Dvd> findByDescricao(String descricao);
}
