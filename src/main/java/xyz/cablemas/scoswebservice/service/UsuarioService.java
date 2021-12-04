package xyz.cablemas.scoswebservice.service;

import java.util.Collection;

import xyz.cablemas.scoswebservice.entity.Usuario;

public interface UsuarioService {

	void save(Usuario usuario);

	Collection<Usuario> findAll();

}
