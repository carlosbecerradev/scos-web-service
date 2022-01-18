package xyz.cablemas.scoswebservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.TipoDeIncidencia;

public interface TipodeIncidenciaRepository extends JpaRepository<TipoDeIncidencia, Long> {

	Collection<TipoDeIncidencia> findByTipoDeServicioTipoDeServicioId(Long tipoDeServicioId);
}
