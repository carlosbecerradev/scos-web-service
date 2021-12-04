package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.Usuario;

public interface UsuarioService {

	void save(Usuario usuario);

	void deleteById(Long usuarioId);

	Collection<Usuario> findAll();

	Usuario findById(Long usuarioId);

}
