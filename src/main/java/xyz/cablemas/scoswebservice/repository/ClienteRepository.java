package xyz.cablemas.scoswebservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByUsuarioNombreDeUsuario(String nombreDeUsuario);

}
