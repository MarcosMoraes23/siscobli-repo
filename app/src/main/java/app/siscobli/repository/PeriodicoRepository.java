package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Periodico;

public interface PeriodicoRepository extends JpaRepository<Periodico, Long> {

	public List<Periodico> findByDescricao(String descricao);
}
