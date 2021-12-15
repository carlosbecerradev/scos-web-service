package xyz.cablemas.scoswebservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.cablemas.scoswebservice.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByNombreDeUsuario(String nombreDeUsuario);

}
