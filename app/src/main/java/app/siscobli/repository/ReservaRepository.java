package app.siscobli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.siscobli.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
