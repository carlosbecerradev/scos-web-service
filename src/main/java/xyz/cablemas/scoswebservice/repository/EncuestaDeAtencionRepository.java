package xyz.cablemas.scoswebservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.EncuestaDeAtencion;

public interface EncuestaDeAtencionRepository extends JpaRepository<EncuestaDeAtencion, Long> {

	Optional<EncuestaDeAtencion> findByOrdenDeServicioOrdenDeServicioId(Long ordenDeServicioId);

}
