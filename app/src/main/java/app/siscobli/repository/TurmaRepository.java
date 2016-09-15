package app.siscobli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

	public List<Turma> findByDescricao(String descricao);
}
