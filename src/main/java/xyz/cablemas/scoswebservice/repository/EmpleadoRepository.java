package xyz.cablemas.scoswebservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.Empleado;
import xyz.cablemas.scoswebservice.entity.Usuario;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	Optional<Empleado> findByUsuario(Usuario usuario);
	Optional<Empleado> findByUsuarioNombreDeUsuario(String nombreDeUsuario);
}
