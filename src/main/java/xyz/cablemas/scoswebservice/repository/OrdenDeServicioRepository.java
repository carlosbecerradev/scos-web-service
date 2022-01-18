package xyz.cablemas.scoswebservice.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.cablemas.scoswebservice.entity.OrdenDeServicio;

public interface OrdenDeServicioRepository extends JpaRepository<OrdenDeServicio, Long> {

	Collection<OrdenDeServicio> findByClienteUsuarioSedeNombre(String sede);
}
