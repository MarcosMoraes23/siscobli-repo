package app.siscobli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
