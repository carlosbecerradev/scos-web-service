package xyz.cablemas.scoswebservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.ConstanciaDeVisita;

public interface ConstanciaDeVisitaRepository extends JpaRepository<ConstanciaDeVisita, Long> {

	Optional<ConstanciaDeVisita> findByOrdenDeServicioOrdenDeServicioId(Long ordenDeServicioId);

}
