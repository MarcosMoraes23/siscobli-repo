package app.siscobli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
