package xyz.cablemas.scoswebservice.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import xyz.cablemas.scoswebservice.entity.Usuario;
import xyz.cablemas.scoswebservice.repository.UsuarioRepository;
import xyz.cablemas.scoswebservice.service.UsuarioService;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
